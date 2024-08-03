package com.ecommercescheto.crud.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor
@ToString
@EqualsAndHashCode
public class ProductQuantity {
    private long productId;
    private Double quantity;
}
