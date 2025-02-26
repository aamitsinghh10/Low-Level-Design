package com.notify.subscribe.notifyMe.Repository;

import com.notify.subscribe.notifyMe.Entity.NotificationRequest;
import com.notify.subscribe.notifyMe.Entity.Product;
import com.notify.subscribe.notifyMe.Enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NotificationRequestRepository extends JpaRepository<NotificationRequest, Long> {
    List<NotificationRequest> findByProductAndStatus(Product product, Status status);
}

