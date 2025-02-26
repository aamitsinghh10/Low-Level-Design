package com.notify.subscribe.notifyMe.Repository;

import com.notify.subscribe.notifyMe.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}

