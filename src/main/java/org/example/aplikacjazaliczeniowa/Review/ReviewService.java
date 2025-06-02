package org.example.aplikacjazaliczeniowa.Review;

import lombok.RequiredArgsConstructor;
import org.example.aplikacjazaliczeniowa.Product.Product;
import org.example.aplikacjazaliczeniowa.Product.ProductRepository;
import org.example.aplikacjazaliczeniowa.User.User;
import org.example.aplikacjazaliczeniowa.User.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final ProductRepository productRepository;
    private final UserRepository userRepository;

    public Review addReview(Review review) {
        return reviewRepository.save(review);
    }

    public List<Review> getReviewsForProduct(int productId) {
        Product product = productRepository.findById(productId).orElse(null);
        return product != null ? product.getReviews() : List.of();
    }
    public List<Review> getAll(){
        return reviewRepository.findAll();
    }


}
