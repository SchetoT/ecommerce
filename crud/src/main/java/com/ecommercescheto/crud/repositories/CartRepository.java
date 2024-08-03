package com.ecommercescheto.crud.repositories;

import com.ecommercescheto.crud.entities.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByClientIdAndDeliveredFalse(Long clientId);
    List<Cart> findByClientIdAndProductId(Long clientId, Long productId);
    Optional<Cart> findByClientIdAndProductIdAndDeliveredFalse(Long clientId, Long productId);
}
