package it.polimi.mymoto.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductResponse {
    private final Long id;
    private final String brand;
    private final String name;
    private final double price;
    private final double weight;
    private final String description;
    private final String status;
}
