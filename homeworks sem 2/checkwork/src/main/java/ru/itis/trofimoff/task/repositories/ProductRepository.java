package ru.itis.trofimoff.task.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.itis.trofimoff.task.models.Category;
import ru.itis.trofimoff.task.models.Product;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    List<Product> findAll();
    Product save(Product product);
    List<Product> findAllByCategory(Category category);
}
