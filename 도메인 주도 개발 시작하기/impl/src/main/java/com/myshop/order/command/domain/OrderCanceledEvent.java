package com.myshop.order.command.domain;

import com.myshop.common.event.Event;

public class OrderCanceledEvent extends Event {
    private final String orderNumber;

    public OrderCanceledEvent(String number) {
        super();
        this.orderNumber = number;
    }

    public String getOrderNumber() {
        return orderNumber;
    }
}
