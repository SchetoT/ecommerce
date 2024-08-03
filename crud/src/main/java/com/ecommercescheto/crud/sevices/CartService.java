package com.ecommercescheto.crud.services;
import com.ecommercescheto.crud.dto.ProductQuantity;
import com.ecommercescheto.crud.entities.Cart;
import com.ecommercescheto.crud.entities.Client;
import com.ecommercescheto.crud.entities.Product;
import com.ecommercescheto.crud.repositories.CartRepository;
import com.ecommercescheto.crud.repositories.ClientRepository;
import com.ecommercescheto.crud.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private ProductRepository productRepository;

    public List<Cart> addProductsToCart(Long clientId, List<ProductQuantity> products, Boolean delivered) {
        Client client = clientRepository.findById(clientId)
                .orElseThrow(() -> new RuntimeException("Client not found"));

        List<Cart> carts = new ArrayList<>();
        for (ProductQuantity dto : products) {
            Product product = productRepository.findById(dto.getProductId())
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            Cart cart = new Cart();
            cart.setClient(client);
            cart.setProduct(product);
            cart.setAmount(dto.getQuantity());
            cart.setDelivered(delivered);

            carts.add(cartRepository.save(cart));
        }

        return carts;
    }

    public void removeCartFromClient(Long cartId) {
        cartRepository.deleteById(cartId);
    }

    public List<Cart> getClientCarts(Long clientId) {
        return cartRepository.findByClientIdAndDeliveredFalse(clientId);
    }

    public void removeProductFromCart(Long clientId, Long productId) {
        List<Cart> carts = cartRepository.findByClientIdAndProductId(clientId, productId);

        if (carts.isEmpty()) {
            throw new RuntimeException("Product not found in the client's cart");
        }
        for (Cart cart : carts) {
            cartRepository.delete(cart);
        }

    }
}