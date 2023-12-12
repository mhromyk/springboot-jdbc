package mh.springboot.restapi.jdbc.model;

import java.math.BigDecimal;

public class Purchase {
    private final int id;
    private final String product;
    private final BigDecimal price;

    public Purchase(int id, String product, BigDecimal price) {
        this.id = id;
        this.product = product;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public BigDecimal getPrice() {
        return price;
    }
}
