package com.myshop.order.command.domain;

public class Canceller {
    private final String memberId;

    public Canceller(String memberId) {
        this.memberId = memberId;
    }

    public static Canceller of(String memberId) {
        return new Canceller(memberId);
    }

    public String getMemberId() {
        return memberId;
    }
}
