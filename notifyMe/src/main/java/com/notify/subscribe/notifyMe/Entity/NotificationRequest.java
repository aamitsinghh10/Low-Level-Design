package com.notify.subscribe.notifyMe.Entity;

import com.notify.subscribe.notifyMe.Enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "notification_requests")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class NotificationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    private Status status;
}

