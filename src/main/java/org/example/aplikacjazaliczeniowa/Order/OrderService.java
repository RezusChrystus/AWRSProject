package org.example.aplikacjazaliczeniowa.Order;

import lombok.RequiredArgsConstructor;
import org.example.aplikacjazaliczeniowa.Product.Product;
import org.example.aplikacjazaliczeniowa.User.User;
import org.example.aplikacjazaliczeniowa.User.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserRepository userRepository;

    public Order placeOrder(Order order) {
        order.setOrderedAt(LocalDateTime.now());
        return orderRepository.save(order);
    }

    public List<Order> getOrdersForUser(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null ? user.getOrders() : List.of();
    }

    public Order orderAllUserProducts(int userId){
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("User not found");
        }

        List<Product> cartProducts = user.getCart();
        if (cartProducts == null || cartProducts.isEmpty()) {
            throw new IllegalStateException("Cart is empty");
        }

        Order order = new Order();
        order.setUser(user);
//        order.setProducts(cartProducts);
        order.setProducts(new ArrayList<>(cartProducts));
        order.setOrderedAt(LocalDateTime.now());

        Order savedOrder = orderRepository.save(order);

        user.getCart().clear();
        userRepository.save(user);

        return savedOrder;
    }

    public List<Order> findAll(){
        return orderRepository.findAll();
    }
}
