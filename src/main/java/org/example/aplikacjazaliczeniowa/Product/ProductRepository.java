package org.example.aplikacjazaliczeniowa.Product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    List<Product> findByNameIgnoreCase(String name);

}
