package org.example.aplikacjazaliczeniowa.Product;

import lombok.AllArgsConstructor;
import org.example.aplikacjazaliczeniowa.User.User;
import org.example.aplikacjazaliczeniowa.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final UserRepository userRepository;
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    public void delete(int id) {
        productRepository.deleteById(id);
    }
    public Product addProductToUser(int userId, Product product) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) return null;
        product.setOwner(user);
        return productRepository.save(product);
    }
}
