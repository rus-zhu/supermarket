package ru.ruszhu.supermarket.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {

    private static final Product TOOTHBRUSH = new Product("Toothbrush", 1);
    private static final Product TOOTHPASTE = new Product("Toothpaste", 2);

    @Test
    void emptyCartHasTotalPriceOfZero() {
        Cart cart = new Cart();

        assertThat(cart.totalPrice())
                .isZero();
    }

    @Test
    public void addToothbrushProductThenTotalPriceIsOneDollar() throws Exception {
        Cart cart = new Cart();

        cart.add(TOOTHBRUSH);

        assertThat(cart.totalPrice())
                .isEqualTo(1);
    }

    @Test
    public void addTwoToothbrushesThenTotalPriceIsTwoDollars() throws Exception {
        Cart cart = new Cart();

        cart.add(TOOTHBRUSH);
        cart.add(TOOTHBRUSH);

        assertThat(cart.totalPrice())
                .isEqualTo(2);
    }

    @Test
    public void addTwoDifferentItemsThenTotalPriceIsSum() throws Exception {
        Cart cart = new Cart();

        cart.add(TOOTHBRUSH);
        cart.add(TOOTHPASTE);

        assertThat(cart.totalPrice())
                .isEqualTo(3);
    }
    
    @Test
    public void addMultipleItemsThenContentsReturnsMultipleItems() throws Exception {
        Cart cart = new Cart();
        cart.add(TOOTHBRUSH);
        cart.add(TOOTHPASTE);

        assertThat(cart.contents())
                .containsExactly(TOOTHBRUSH,
                                 TOOTHPASTE);

    }
}
