package com.ecommercescheto.crud.services;

import com.ecommercescheto.crud.entities.Cart;
import com.ecommercescheto.crud.entities.Client;
import com.ecommercescheto.crud.entities.Invoice;
import com.ecommercescheto.crud.repositories.InvoiceRepository;
import com.ecommercescheto.crud.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private CartRepository cartRepository;

    public Invoice saveInvoice(Invoice invoice) {
        return invoiceRepository.save(invoice);
    }

    public Invoice createInvoiceForClient(Long clientId) {
        List<Cart> carts = cartRepository.findByClientIdAndDeliveredFalse(clientId);
        Double total = carts.stream().mapToDouble(cart -> cart.getAmount() * cart.getProduct().getPrice()).sum();

        Invoice invoice = new Invoice();
        invoice.setClient(new Client(clientId));
        invoice.setCreatedAt(new Date());
        invoice.setTotal(total);

        carts.forEach(cart -> {
            cart.setDelivered(true);
            cartRepository.save(cart);
        });

        return saveInvoice(invoice);
    }


    public Optional<Invoice> getLastInvoiceForClient(Long clientId) {
        List<Invoice> invoices = invoiceRepository.findByClientId(clientId);
        if (invoices.isEmpty()) {
            return Optional.empty();
        }
        invoices.sort((i1, i2) -> i2.getCreatedAt().compareTo(i1.getCreatedAt()));
        return Optional.of(invoices.get(0));
    }
    public void deleteInvoiceForClient(Long clientId) {
        List<Invoice> invoices = invoiceRepository.findByClientId(clientId);
        invoices.forEach(invoice -> invoiceRepository.delete(invoice));
    }

}
