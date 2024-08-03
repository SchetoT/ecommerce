package com.ecommercescheto.crud.entities;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@Data @NoArgsConstructor
@Schema(description="Product")
public class Product {
    @Schema(description="Product ID", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description="Product title", example = "Motorola Edge 30 ultra")
    private String title;

    @Schema(description="Product description", example = "128GB, 5G, 6.0-inch Super AMOLED display, 108Hz refresh rate, 16MP+12MP+8MP+2MP ultra-wide sensor, 100% OLED display, 13MP AI camera, 12MP AI camera, 8MP AI camera, 120Hz refresh rate, 4")
    private String description;

    @Schema(description="Product stock", example = "50")
    private Integer stock;

    @Schema(description="Product price", example = "899.99")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart carts;

    public Product(Long id) {
        this.id = id;
    }
}
