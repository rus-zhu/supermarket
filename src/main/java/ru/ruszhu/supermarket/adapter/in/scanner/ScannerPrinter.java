package ru.ruszhu.supermarket.adapter.in.scanner;

import ru.ruszhu.supermarket.domain.Cart;
import ru.ruszhu.supermarket.domain.Product;

import java.util.stream.Collectors;

public class ScannerPrinter {
    private final Cart cart;

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

    private String receiptForNonEmptyCart() {
        String productRows = cart.contents()
                                 .map(this::productToReceiptEntry)
                                 .collect(Collectors.joining());
        return """
                %s
                Total Price: $%s
                """.formatted(productRows,
                              cart.totalPrice());
    }

    private String productToReceiptEntry(Product product) {
        return """
                %s $%s
                """
                .formatted(product.name(),
                           product.price());
    }
}
