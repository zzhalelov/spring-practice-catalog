package kz.runtime.spring_practice_catalog.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Status status;

    @Column(name = "delivery_address")
    private String deliveryAddress;

    @Column(name = "date_of_order")
    private LocalDateTime dateOfOrder;

    @ManyToMany
    @JoinTable(
            name = "orders_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> productList;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}