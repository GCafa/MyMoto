package it.polimi.mymoto.service.definition;

import it.polimi.mymoto.dto.request.ProductAddRequest;
import it.polimi.mymoto.dto.request.ProductModifyRequest;
import it.polimi.mymoto.dto.response.CustomResponse;

import it.polimi.mymoto.dto.response.ProductResponse;
import lombok.NonNull;

import java.util.List;

public interface ProductService {
    CustomResponse add(@NonNull ProductAddRequest newProductRequest);

    CustomResponse modify(@NonNull ProductModifyRequest newProductRequest);

    CustomResponse delete(@NonNull Long id);

    List<ProductResponse> getAllByCurrentSeller();

    ProductResponse getById(@NonNull Long id);

    List<ProductResponse> getAll();
}
