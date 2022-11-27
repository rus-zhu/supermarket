package ru.ruszhu.supermarket.adapter.in.scanner;

import ru.ruszhu.supermarket.domain.Cart;
import ru.ruszhu.supermarket.domain.Product;

public class ScannerPrinter {
    private Cart cart;

    public ScannerPrinter(Cart cart) {
        this.cart = cart;
    }

    public String receipt() {
        if (cart.totalPrice() == 0) {
            return receiptForEmptyCart();
        }
        return receiptForNonEmptyCart();
    }

    private String receiptForEmptyCart() {
        return """
                Total Price: $0
                """;
    }

    public String receiptForNonEmptyCart() {
        Product product = cart.contents()
                              .findFirst()
                              .get();
        String productRow = productToReceiptEntry(product);
        return """
                %s
                                    
                Total Price: $%s
                """.formatted(productRow,
                              cart.totalPrice());
    }

    private String productToReceiptEntry(Product product) {
        return """
                %s $%s"""
                .formatted(product.name(),
                           product.price());
    }
}
