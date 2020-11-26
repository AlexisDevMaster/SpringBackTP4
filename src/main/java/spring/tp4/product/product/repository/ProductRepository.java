package spring.tp4.product.product.repository;

import org.springframework.data.repository.CrudRepository;
import spring.tp4.product.product.modele.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    Iterable<Product> findByName(String productName);

    Product findById(int id);

    void deleteById(int id);

}
