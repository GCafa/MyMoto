package it.polimi.mymoto.controller;

import it.polimi.mymoto.dto.request.ProductAddRequest;
import it.polimi.mymoto.dto.request.ProductModifyRequest;
import it.polimi.mymoto.dto.response.CustomResponse;
import it.polimi.mymoto.dto.response.ProductResponse;
import it.polimi.mymoto.service.definition.ProductService;
import it.polimi.mymoto.util.ApiPathUtil;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPathUtil.REST_PATH + "/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<ProductResponse>> getAll() {
        final List<ProductResponse> response = productService.getAll();

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getById(@NonNull @PathVariable Long id) {
        final ProductResponse response = productService.getById(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<CustomResponse> add(ProductAddRequest productAddRequest) {
        final CustomResponse response = productService.add(productAddRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    public ResponseEntity<CustomResponse> delete(Long id) {
        final CustomResponse response = productService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    public ResponseEntity<CustomResponse> modify(ProductModifyRequest productModifyRequest) {
        final CustomResponse response = productService.modify(productModifyRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }
}
