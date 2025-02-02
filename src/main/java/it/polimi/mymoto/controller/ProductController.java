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
@RequestMapping(ApiPathUtil.REST_PATH + "/product")
@AllArgsConstructor
public class ProductController {
    private final ProductService productService;

    @PostMapping("/add")
    public ResponseEntity<CustomResponse> add(@Valid @RequestBody ProductAddRequest productAddRequest) {
        final CustomResponse response = productService.add(productAddRequest);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PostMapping("/modify")
    public ResponseEntity<CustomResponse> modify(@Valid @RequestBody ProductModifyRequest productModifyRequest) {
        final CustomResponse response = productService.modify(productModifyRequest);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CustomResponse> delete(@NonNull @PathVariable Long id) {
        final CustomResponse response = productService.delete(id);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(response);
    }

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
}
