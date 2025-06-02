package org.example.aplikacjazaliczeniowa.Review;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.example.aplikacjazaliczeniowa.Product.Product;
import org.example.aplikacjazaliczeniowa.User.User;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    int rating;
    String comment;

    @ManyToOne
    @JsonBackReference
    Product product;

    @ManyToOne
    User author;
}
