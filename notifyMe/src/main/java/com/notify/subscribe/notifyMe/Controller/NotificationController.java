package com.notify.subscribe.notifyMe.Controller;

import com.notify.subscribe.notifyMe.DTO.NotificationRequestDTO;
import com.notify.subscribe.notifyMe.Entity.NotificationRequest;
import com.notify.subscribe.notifyMe.Entity.Product;
import com.notify.subscribe.notifyMe.Entity.User;
import com.notify.subscribe.notifyMe.Enums.Status;
import com.notify.subscribe.notifyMe.Repository.NotificationRequestRepository;
import com.notify.subscribe.notifyMe.Repository.ProductRepository;
import com.notify.subscribe.notifyMe.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/notifications")
public class NotificationController {

    @Autowired
    private NotificationRequestRepository notificationRequestRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProductRepository productRepository;

    @PostMapping("/subscribe")
    public ResponseEntity<String> subscribeToNotification(@RequestBody NotificationRequestDTO requestDTO) {
        User user = userRepository.findById(requestDTO.getUserId()).orElseThrow(() -> new RuntimeException("User not found"));
        Product product = productRepository.findById(requestDTO.getProductId()).orElseThrow(() -> new RuntimeException("Product not " +
                "found"));
        NotificationRequest request = new NotificationRequest();
        request.setUser(user);
        request.setProduct(product);
        request.setStatus(Status.PENDING);

        notificationRequestRepository.save(request);
        return ResponseEntity.ok("Subscribed successfully!");
    }
}

