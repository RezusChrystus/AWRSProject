package org.example.aplikacjazaliczeniowa.Order;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestBody Order order) {
        return orderService.placeOrder(order);
    }

    @GetMapping("/user/{userId}")
    public List<Order> getOrdersForUser(@PathVariable int userId) {
        return orderService.getOrdersForUser(userId);
    }
    @PostMapping("/user/{userId}")
    public Order placeUserOrder(@PathVariable int userId) {
        return orderService.orderAllUserProducts(userId);
    }
    @GetMapping()
    public List<Order> findAll(){
        return orderService.findAll();
    }


}