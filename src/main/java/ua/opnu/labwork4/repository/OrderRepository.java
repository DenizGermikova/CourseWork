package ua.opnu.labwork4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.opnu.labwork4.model.Order;
import ua.opnu.labwork4.model.OrderStatus;

import java.util.List;

public interface OrderRepository
        extends JpaRepository<Order, Long> {

    List<Order> findByUserId(Long userId);

    List<Order> findByStatus(OrderStatus status);
}