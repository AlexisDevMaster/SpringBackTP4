package spring.tp4.product.seller.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import spring.tp4.product.seller.modele.Seller;

public interface SellerRepository extends JpaRepository<Seller, Integer> {

    Iterable<Seller> findByName(String seller);

    Seller findById(int id);

    void deleteById(int id);

}
