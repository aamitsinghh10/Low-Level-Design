package com.notify.subscribe.notifyMe.Controller;

import com.notify.subscribe.notifyMe.Entity.Product;
import com.notify.subscribe.notifyMe.Repository.ProductRepository;
import com.notify.subscribe.notifyMe.Service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/restock/{productId}")
    public ResponseEntity<String> restockProduct(@PathVariable Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        product.setStock(product.getStock() + 10);
        productRepository.save(product);

        notificationService.notifyUsers(product);

        return ResponseEntity.ok("Product restocked and users notified.");
    }
}

