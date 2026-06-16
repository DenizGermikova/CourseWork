package ua.opnu.labwork4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.opnu.labwork4.model.OrderStatus;
import ua.opnu.labwork4.repository.BrandRepository;
import ua.opnu.labwork4.repository.OrderRepository;
import ua.opnu.labwork4.repository.ProductRepository;
import ua.opnu.labwork4.repository.UserRepository;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/analytics")
public class AnalyticsController {

    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final BrandRepository brandRepository;

    public AnalyticsController(
            ProductRepository productRepository,
            UserRepository userRepository,
            OrderRepository orderRepository,
            BrandRepository brandRepository
    ) {
        this.productRepository = productRepository;
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
        this.brandRepository = brandRepository;
    }

    @GetMapping("/products/count")
    public Map<String, Long> getProductsCount() {

        Map<String, Long> result = new HashMap<>();
        result.put("count", productRepository.count());

        return result;
    }

    @GetMapping("/users/count")
    public Map<String, Long> getUsersCount() {

        Map<String, Long> result = new HashMap<>();
        result.put("count", userRepository.count());

        return result;
    }

    @GetMapping("/orders/active")
    public Map<String, Integer> getActiveOrders() {

        Map<String, Integer> result = new HashMap<>();

        int activeOrders =
                orderRepository.findByStatus(OrderStatus.NEW).size()
                        + orderRepository.findByStatus(OrderStatus.PROCESSING).size();

        result.put("activeOrders", activeOrders);

        return result;
    }

    @GetMapping("/brands/popular")
    public Map<String, Long> getBrandsCount() {

        Map<String, Long> result = new HashMap<>();
        result.put("brands", brandRepository.count());

        return result;
    }
}