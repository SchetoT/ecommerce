package com.ecommercescheto.crud.controllers;

import com.ecommercescheto.crud.dto.ProductQuantity;
import com.ecommercescheto.crud.entities.Cart;
import com.ecommercescheto.crud.services.CartService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
@Tag(name = "Cart controller", description = "Here you can add a new cart, see all carts, edit a cart or delete a cart.")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/{clientId}")
    @Operation(summary = "Add multiple products to a client's cart", description = "Add multiple products to the cart for a client. Delivered status will be set to false.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Products added to cart successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request. Invalid client ID or product data"),
            @ApiResponse(responseCode = "404", description = "Client or product not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<Cart>> addProductsToCart(@PathVariable Long clientId, @RequestBody List<ProductQuantity> products) {
        try {
            List<Cart> carts = cartService.addProductsToCart(clientId, products, false);
            return ResponseEntity.status(HttpStatus.CREATED).body(carts);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @DeleteMapping("/{clientId}")
    @Operation(summary = "Remove all carts for a client", description = "Remove all carts associated with a specific client.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "All carts removed successfully"),
            @ApiResponse(responseCode = "404", description = "Client not found or no carts to remove"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Void> removeCartFromClient(@PathVariable Long clientId) {
        try {
            cartService.removeCartFromClient(clientId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @GetMapping("/{clientId}")
    @Operation(summary = "Get client's carts with delivered status false", description = "Retrieve all carts for a client where delivered status is false.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client carts retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Client not found"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<List<Cart>> getClientCarts(@PathVariable Long clientId) {
        List<Cart> carts = cartService.getClientCarts(clientId);
        if (carts.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(carts);
    }

    @DeleteMapping("/clients/{clientId}/products/{productId}")
    @Operation(summary = "Remove a specific product from a client's cart", description = "Remove a specific product from the client's cart by the client's ID and the product's ID.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Product removed from cart successfully"),
            @ApiResponse(responseCode = "404", description = "Client or product not found or product not in cart"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Void> removeProductFromCart(@PathVariable Long clientId, @PathVariable Long productId) {
        try {
            cartService.removeProductFromCart(clientId, productId);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
