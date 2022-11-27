package ru.ruszhu.supermarket.adapter.in.scanner;

import ru.ruszhu.supermarket.domain.Cart;

public class Scanner {
    private Cart cart;

    public Scanner(Cart cart) {
        this.cart = cart;
    }

    public String receipt() {
        return receiptForEmptyCart();
    }

    private String receiptForEmptyCart() {
        return """
                Total Price: $0
                """;
    }
}
