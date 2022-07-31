package com.myshop.order.command.application;

import com.myshop.order.NoOrderException;
import com.myshop.order.command.domain.CancelPolicy;
import com.myshop.order.command.domain.Canceller;
import com.myshop.order.command.domain.Order;
import com.myshop.order.command.domain.OrderNo;
import com.myshop.order.command.domain.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CancelOrderService {
    private final OrderRepository orderRepository;
    private final CancelPolicy cancelPolicy;

    public CancelOrderService(OrderRepository orderRepository,
                              CancelPolicy cancelPolicy) {
        this.orderRepository = orderRepository;
        this.cancelPolicy = cancelPolicy;
    }

    @Transactional
    public void cancel(OrderNo orderNo, Canceller canceller) {
        Order order = orderRepository.findById(orderNo)
                .orElseThrow(NoOrderException::new);
        if (!cancelPolicy.hasCancellationPermission(order, canceller)) {
            throw new NoCancellablePermission();
        }
        order.cancel();
    }

}
