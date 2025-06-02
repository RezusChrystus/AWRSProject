package org.example.aplikacjazaliczeniowa.Product;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.aplikacjazaliczeniowa.User.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String name;
    int count;
    String unit;
    double valuePerUnit;

    @ManyToOne
    @JsonBackReference
    User owner;
}