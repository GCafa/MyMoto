package it.polimi.mymoto.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NonNull;

@Data
public class ProductModifyRequest {
    @NonNull
    private Long id;

    @NotBlank(message = "Brand is mandatory")
    private final String brand;

    @NotBlank(message = "Name is mandatory")
    private final String name;

    @DecimalMin(value = "0.0", message = "Price must be greater than 0")
    private final double price;

    @DecimalMin(value = "0.0", message = "Weight must be greater than 0")
    private final double weight;

    @NotBlank(message = "Description is mandatory")
    private final String description;
}
