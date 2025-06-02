package org.example.aplikacjazaliczeniowa.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAll(){
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id){
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        productService.delete(id);
    }
    @PostMapping("/addToUser/{userId}")
    public Product addToUser(@PathVariable int userId, @RequestBody Product product) {
        return productService.addProductToUser(userId, product);
    }
}
