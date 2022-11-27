package ru.ruszhu.supermarket.adapter.in.scanner;

import org.junit.jupiter.api.Test;
import ru.ruszhu.supermarket.domain.Cart;

import static org.assertj.core.api.Assertions.assertThat;

class ScannerPrinterTest {

    @Test
    public void receiptShowsZeroPriceWhenNoItemsScanned() throws Exception {
        Cart cart = new Cart();
        ScannerPrinter scannerPrinter = new ScannerPrinter(cart);

        assertThat(scannerPrinter.receipt())
                .isEqualTo(""" 
                        Total Price: $0
                        """);
    }

    @Test
    public void receiptShowsItemAndPriceForOneItemScanned() throws Exception {
        Cart cart = new Cart();
        ScannerPrinter scannerPrinter = new ScannerPrinter(cart);

        cart.add("Toothbrush", 1);

        assertThat(scannerPrinter.receipt())
                .isEqualTo("""
                            Toothbrush $1
                            
                            Total Price: $1
                            """);
    }

    @Test
    public void receiptShowsMultipleItemNamesAndPricesAndTotal() throws Exception {
        Cart cart = new Cart();
        ScannerPrinter scannerPrinter = new ScannerPrinter(cart);

        cart.add("Toothpaste", 2);

        assertThat(scannerPrinter.receipt())
                .isEqualTo("""
                            Toothpaste $2
                            
                            Total Price: $2
                            """);
    }

}