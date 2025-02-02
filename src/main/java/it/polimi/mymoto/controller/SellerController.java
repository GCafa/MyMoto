package it.polimi.mymoto.controller;

import it.polimi.mymoto.dto.request.ProductAddRequest;
import it.polimi.mymoto.dto.request.ProductModifyRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.dto.response.ProductResponse;
import it.polimi.mymoto.service.definition.ProductService;
import it.polimi.mymoto.util.ApiPathUtil;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPathUtil.SELLER_PATH + "/product")
@AllArgsConstructor
public class SellerController {
    final ProductController productController;
    final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAllByCurrentSeller() {
        final List<ProductResponse> response = productService.getAllByCurrentSeller();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<CustomResponse> deleteProduct(@NonNull @PathVariable Long id) {
        return productController.delete(id);
    }

    @PostMapping("/modify")
    public ResponseEntity<CustomResponse> modifyProduct(@Valid @RequestBody ProductModifyRequest productModifyRequest) {
        return productController.modify(productModifyRequest);
    }

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> addProduct(@Valid @RequestBody ProductAddRequest productAddRequest) {
        return productController.add(productAddRequest);
    }
}
