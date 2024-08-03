package com.ecommercescheto.crud.entities;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

@Entity
@Table(name = "clients")
@Data @NoArgsConstructor
@Schema(description = "client")
public class Client {
    @Schema(description = "Client id", example = "1")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Schema(description = "Client name", example = "Tomas")
    private String name;
    @Schema(description = "Client lastname", example = "Scheto")
    private String lastname;
    @Schema(description = "Client document number", example = "4111111")
    private Integer docnumber;

    @OneToMany(mappedBy = "client")
    private Set<Invoice> invoices;

    @OneToMany(mappedBy = "client")
    private Set<Cart> carts;
    public Client(Long id) {
        this.id = id;
    }
}
