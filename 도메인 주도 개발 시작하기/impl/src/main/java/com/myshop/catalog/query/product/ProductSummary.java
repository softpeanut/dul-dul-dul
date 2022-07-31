package com.myshop.catalog.query.product;

public class ProductSummary {
    private final String id;
    private final String name;
    private final int price;
    private final String image;

    public ProductSummary(String productId, String name, int price, String image) {
        this.id = productId;
        this.name = name;
        this.price = price;
        this.image = image;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}
