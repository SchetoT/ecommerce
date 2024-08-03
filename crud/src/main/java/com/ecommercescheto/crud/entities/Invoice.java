package com.ecommercescheto.crud.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import jakarta.persistence.JoinColumn;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
@Schema(description = "Invoie")
public class Invoice {

    @Schema(description = "Invoice ID", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Schema(description = "client identifier", example = "1")
    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @Schema(description = "Date of creation", example = "2022-01-01")
    private Date createdAt;

    @Schema(description = "Total price of the invoice", example = "100.0")
    private Double total;

}
