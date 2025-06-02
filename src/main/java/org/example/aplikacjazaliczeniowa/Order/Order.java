package org.example.aplikacjazaliczeniowa.Order;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.aplikacjazaliczeniowa.Product.Product;
import org.example.aplikacjazaliczeniowa.User.User;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "app_order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @ManyToOne
    @JsonBackReference
    User user;

    @OneToMany(cascade = CascadeType.ALL)
    List<Product> products;

    LocalDateTime orderedAt;
}