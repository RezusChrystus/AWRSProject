package org.example.aplikacjazaliczeniowa.Review;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    @PostMapping
    public Review addReview(@RequestBody Review review) {
        return reviewService.addReview(review);
    }

    @GetMapping("/product/{productId}")
    public List<Review> getReviewsForProduct(@PathVariable int productId) {
        return reviewService.getReviewsForProduct(productId);
    }
    @GetMapping()
    public List<Review> getAllReviews(){
        return reviewService.getAll();
    }
}