package com.myshop.catalog.query.product;

import com.myshop.catalog.query.category.CategoryData;

import java.util.List;

public class CategoryProduct {
    private final CategoryData category;

    private final List<ProductSummary> items;
    private final int page;
    private final int size;
    private final long totalCount;
    private final int totalPages;

    public CategoryProduct(CategoryData category,
                           List<ProductSummary> items,
                           int page,
                           int size,
                           long totalCount,
                           int totalPages) {
        this.category = category;
        this.items = items;
        this.page = page;
        this.size = size;
        this.totalCount = totalCount;
        this.totalPages = totalPages;
    }

    public CategoryData getCategory() {
        return category;
    }

    public List<ProductSummary> getItems() {
        return items;
    }

    public int getPage() {
        return page;
    }

    public int getSize() {
        return size;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public int getTotalPages() {
        return totalPages;
    }
}
