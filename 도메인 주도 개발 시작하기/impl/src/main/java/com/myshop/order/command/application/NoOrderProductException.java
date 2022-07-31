package com.myshop.order.command.application;

public class NoOrderProductException extends RuntimeException {
    private final String productId;

    public NoOrderProductException(String productId) {
        this.productId = productId;
    }

    public String getProductId() {
        return productId;
    }
}
