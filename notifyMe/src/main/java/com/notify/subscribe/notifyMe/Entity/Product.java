package com.notify.subscribe.notifyMe.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "products")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private int stock;
}

