package kz.runtime.spring_practice_catalog.model;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Category {
    long id;
    String name;
    List<Product> products;

    public void addProduct(Product product) {
        products.add(product);
    }
}