package com.ecommercescheto.crud.controllers;

import com.ecommercescheto.crud.entities.Invoice;
import com.ecommercescheto.crud.services.InvoiceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/invoices")
@Tag(name = "Invoice controller", description = "Here you can add a new invoice, see all invoices, edit an invoice or delete an invoice.")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    @PostMapping("/{clientId}")
    @Operation(summary = "Create a new invoice", description = "Create an invoice for a client based on their cart items.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Invoice created successfully"),
            @ApiResponse(responseCode = "400", description = "Bad request. Invalid client ID or cart items"),
            @ApiResponse(responseCode = "404", description = "Client not found or cart is empty"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Invoice> createInvoiceForClient(@PathVariable Long clientId) {
        try {
            Invoice invoice = invoiceService.createInvoiceForClient(clientId);
            return ResponseEntity.status(HttpStatus.CREATED).body(invoice);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping("/{clid}")
    @Operation(summary = "Get the last invoice for a specific client", description = "Retrieve the most recent invoice issued for a specific client.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Invoice retrieved successfully"),
            @ApiResponse(responseCode = "404", description = "Invoice not found for the given client"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Invoice> getLastInvoiceForClient(@PathVariable Long clid) {
        Optional<Invoice> invoice = invoiceService.getLastInvoiceForClient(clid);
        return invoice.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{clid}")
    @Operation(summary = "Delete invoice for a specific client", description = "Delete all invoices associated with a specific client.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "Invoices deleted successfully"),
            @ApiResponse(responseCode = "404", description = "Client not found or no invoices to delete"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<Void> deleteInvoiceForClient(@PathVariable Long clid) {
        try {
            invoiceService.deleteInvoiceForClient(clid);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
