package com.myshop.order.query.application;

public class ListRequest {
    private final int page;
    private final int size;

    public ListRequest(int page, int size) {
        this.page = page;
        this.size = size;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }
}
