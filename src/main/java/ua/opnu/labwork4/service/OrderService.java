package ua.opnu.labwork4.service;

import org.springframework.stereotype.Service;
import ua.opnu.labwork4.exception.ResourceNotFoundException;
import ua.opnu.labwork4.model.Order;
import ua.opnu.labwork4.model.OrderStatus;
import ua.opnu.labwork4.repository.OrderRepository;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(
            OrderRepository orderRepository
    ) {
        this.orderRepository = orderRepository;
    }

    public Order create(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Order getById(Long id) {

        return orderRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Order not found"
                        )
                );
    }

    public Order update(Long id, Order order) {

        Order existingOrder = getById(id);

        existingOrder.setStatus(
                order.getStatus()
        );

        return orderRepository.save(
                existingOrder
        );
    }

    public void delete(Long id) {

        Order order = getById(id);

        orderRepository.delete(order);
    }

    public List<Order> getByUserId(
            Long userId
    ) {

        return orderRepository.findByUserId(
                userId
        );
    }

    public List<Order> getActiveOrders() {

        List<Order> newOrders = orderRepository.findByStatus(
                OrderStatus.NEW
        );

        List<Order> processingOrders = orderRepository.findByStatus(
                OrderStatus.PROCESSING
        );

        newOrders.addAll(processingOrders);

        return newOrders;
    }
}