package it.polimi.mymoto.service.implementation;

import com.fasterxml.jackson.databind.ObjectMapper;
import it.polimi.mymoto.builder.implementation.ProductBuilderImplementation;
import it.polimi.mymoto.dto.request.ProductAddRequest;
import it.polimi.mymoto.dto.request.ProductModifyRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.dto.response.ProductResponse;
import it.polimi.mymoto.exception.custom.EntityDeleteException;
import it.polimi.mymoto.exception.custom.EntityModifyException;
import it.polimi.mymoto.exception.custom.EntityNotFoundException;
import it.polimi.mymoto.exception.custom.EntityRegistrationException;
import it.polimi.mymoto.model.Product;
import it.polimi.mymoto.repository.ProductRepository;
import it.polimi.mymoto.service.definition.ProductService;
import it.polimi.mymoto.service.definition.UserService;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;
    private final ObjectMapper objectMapper;
    private final UserService userService;

    @Override
    public CustomResponse add(@NonNull ProductAddRequest productAddRequest) {
        try {
            productRepository.save(
                new ProductBuilderImplementation()
                    .brand(productAddRequest.getBrand())
                    .name(productAddRequest.getName())
                    .description(productAddRequest.getDescription())
                    .price(productAddRequest.getPrice())
                    .seller(userService.getCurrentUser())
                    .build()
            );

            return new CustomResponse("Product added successfully");
        } catch (Exception e) {
            throw new EntityRegistrationException(Product.class);
        }
    }

    @Override
    public CustomResponse modify(@NonNull ProductModifyRequest productModifyRequest) {
        Optional<Product> product = productRepository.findById(productModifyRequest.getId());

        if (product.isEmpty()) {
            throw new EntityNotFoundException(Product.class);
        }

        try {
            objectMapper.updateValue(product.get(), productModifyRequest);
        } catch (Exception e) {
            throw new EntityModifyException(Product.class);
        }

        productRepository.save(product.get());

        return new CustomResponse("Product modified successfully");
    }

    @Override
    public CustomResponse delete(@NonNull Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new EntityNotFoundException(Product.class);
        }

        try {
            productRepository.delete(product.get());
        } catch (Exception e) {
            throw new EntityDeleteException(Product.class);
        }

        return new CustomResponse("Product deleted successfully");
    }

    @Override
    public List<ProductResponse> getAllBySeller() {
        List<Product> products = productRepository.findAllBySeller(userService.getCurrentUser());

        return products.stream()
                .map(product -> objectMapper.convertValue(product, ProductResponse.class))
                .toList();
    }

    @Override
    public ProductResponse getById(@NonNull Long id) {
        Optional<Product> product = productRepository.findById(id);

        if (product.isEmpty()) {
            throw new EntityNotFoundException(Product.class);
        }

        return objectMapper.convertValue(product.get(), ProductResponse.class);
    }
}
