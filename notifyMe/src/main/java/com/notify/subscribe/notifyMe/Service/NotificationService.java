package com.notify.subscribe.notifyMe.Service;

import com.notify.subscribe.notifyMe.Entity.NotificationRequest;
import com.notify.subscribe.notifyMe.Entity.Product;
import com.notify.subscribe.notifyMe.Enums.Status;
import com.notify.subscribe.notifyMe.Repository.NotificationRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NotificationService {

    @Autowired
    private NotificationRequestRepository notificationRequestRepository;
    @Autowired
    private JavaMailSender javaMailSender;

    public void notifyUsers(Product product) {
        List<NotificationRequest> requests = notificationRequestRepository.findByProductAndStatus(product, Status.PENDING);
        for (NotificationRequest request : requests) {
            sendEmail(request.getUser().getEmail(), product.getName());
            request.setStatus(Status.NOTIFIED);
            notificationRequestRepository.save(request);
        }
    }
    private void sendEmail(String to, String productName) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject("Product Available: " + productName);
        message.setText("The product you requested is back in stock. Visit our website to purchase.");
        javaMailSender.send(message);
    }
}
