package ru.ruszhu.supermarket.adapter.in.scanner;

import org.junit.jupiter.api.Test;
import ru.ruszhu.supermarket.domain.Cart;

import static org.assertj.core.api.Assertions.assertThat;

class ScannerTest {

    @Test
    public void receiptShowsZeroPriceWhenNoItemsScanned() throws Exception {
        Cart cart = new Cart();
        Scanner scanner = new Scanner(cart);

        assertThat(scanner.receipt())
                .isEqualTo(""" 
                        Total Price: $0
                        """);
    }

}
