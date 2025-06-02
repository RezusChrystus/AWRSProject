package org.example.aplikacjazaliczeniowa.User;

import lombok.AllArgsConstructor;
import org.example.aplikacjazaliczeniowa.Product.Product;
import org.example.aplikacjazaliczeniowa.Product.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserService userService;



    @PostMapping("/register")
    public User register(@RequestBody User user){
        return userService.register(user);
    }

    @PostMapping("/login")
    public User login(@RequestParam String name, @RequestParam String password){
        return userService.login(name, password);
    }

    @GetMapping()
    public List<User> getAllUsers(){
        return userService.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id){
        userService.deleteUser(id);
    }
    @GetMapping("/{userId}/cart")
    public List<Product> getCart(@PathVariable int userId) {
        return userService.getCart(userId);
    }

    @GetMapping("/{userId}/cart/value")
    public double getCartValue(@PathVariable int userId) {
        return userService.getCartValue(userId);
    }


}