package com.ecommercescheto.crud.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Schema(description = "Cart")
public class Cart {
    @Schema(description = "Cart id", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Schema(description = "product identifier", example = "2")
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Schema(description = "Amount", example = "2")
    private Double amount;

    @Schema(description = "Delivered - True or False", example = "true")
    private Boolean delivered;
}
