package org.example.aplikacjazaliczeniowa.User;

import lombok.AllArgsConstructor;
import org.example.aplikacjazaliczeniowa.Product.Product;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    UserRepository userRepository;

    public User register(User user){
        return userRepository.save(user);
    }

    public User login(String name, String password){
        return userRepository.findByNameAndPassword(name, password);
    }

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }

    public List<Product> getCart(int userId) {
        User user = userRepository.findById(userId).orElse(null);
        return user != null ? user.getCart() : null;
    }

    public double getCartValue(int userId){
        List<Product> productList = getCart(userId);
        double count = 0;
        for (Product p : productList){
            count+= p.getCount()*p.getValuePerUnit() ;
        }
        return count;
    }
}
