package ru.ruszhu.supermarket.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CartTest {

    @Test
    void emptyCartHasTotalPriceOfZero() {
        Cart cart = new Cart();

        assertThat(cart.totalPrice())
                .isZero();
    }

    @Test
    public void addToothbrushProductThenTotalPriceIsOneDollar() throws Exception {
        Cart cart = new Cart();

        cart.add(new Product("Toothbrush", 1));

        assertThat(cart.totalPrice())
                .isEqualTo(1);
    }

    @Test
    public void addTwoToothbrushesThenTotalPriceIsTwoDollars() throws Exception {
        Cart cart = new Cart();

        cart.add(new Product("Toothbrush", 1));
        cart.add(new Product("Toothbrush", 1));

        assertThat(cart.totalPrice())
                .isEqualTo(2);
    }

    @Test
    public void addTwoDifferentItemsThenTotalPriceIsSum() throws Exception {
        Cart cart = new Cart();

        cart.add(new Product("Toothbrush", 1));
        cart.add(new Product("Toothpaste", 2));

        assertThat(cart.totalPrice())
                .isEqualTo(3);
    }
    
    @Test
    public void addMultipleItemsThenContentsReturnsMultipleItems() throws Exception {
        Cart cart = new Cart();
        cart.add(new Product("Toothbrush", 1));
        cart.add(new Product("Toothpaste", 2));

        assertThat(cart.contents())
                .containsExactly(new Product("Toothbrush", 1),
                                 new Product("Toothpaste", 2));

    }
}
