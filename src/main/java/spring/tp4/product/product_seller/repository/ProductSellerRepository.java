package spring.tp4.product.product_seller.repository;

import org.springframework.data.repository.CrudRepository;
import spring.tp4.product.product.modele.Product;
import spring.tp4.product.product_seller.modele.ProductSeller;

public interface ProductSellerRepository extends CrudRepository<ProductSeller, Integer> {

}
