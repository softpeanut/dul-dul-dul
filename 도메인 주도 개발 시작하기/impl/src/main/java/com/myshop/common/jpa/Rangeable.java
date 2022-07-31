package com.myshop.common.jpa;

import org.springframework.data.domain.Sort;

public class Rangeable {
    private final int start;
    private final int limit;
    private final Sort sort;

    public Rangeable(int start, int limit, Sort sort) {
        this.start = start;
        this.limit = limit;
        this.sort = sort;
    }

    public static Rangeable of(int start, int limit) {
        return new Rangeable(start, limit, Sort.unsorted());
    }

    public int getStart() {
        return start;
    }

    public int getLimit() {
        return limit;
    }

    public Sort getSort() {
        return sort;
    }
}