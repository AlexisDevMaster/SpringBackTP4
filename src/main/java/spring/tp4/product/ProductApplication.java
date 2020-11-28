package spring.tp4.product;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import spring.tp4.product.product.modele.Product;
import spring.tp4.product.product.repository.ProductRepository;
import spring.tp4.product.product_seller.modele.ProductSeller;
import spring.tp4.product.product_seller.repository.ProductSellerRepository;
import spring.tp4.product.seller.modele.Seller;
import spring.tp4.product.seller.repository.SellerRepository;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class ProductApplication {

    private static final Logger log = LoggerFactory.getLogger(ProductApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

    @Bean
    public CommandLineRunner instanceProduct(ProductRepository productRepository, SellerRepository sellerRepository, ProductSellerRepository productSellerRepository) {
        return (args) -> {

            Product product1 = new Product("Bottle");
            Product product2 = new Product("Computer");
            Product product3 = new Product("Lamp");
            Product product4 = new Product("TV");

            productRepository.save(product1);
            productRepository.save(product2);
            productRepository.save(product3);
            productRepository.save(product4);


            Seller seller1 = new Seller("Amazon");
            Seller seller2 = new Seller("CDiscount");
            Seller seller3 = new Seller("Wish");

            sellerRepository.save(seller1);
            sellerRepository.save(seller2);
            sellerRepository.save(seller3);

            productSellerRepository.save(new ProductSeller(product1, seller1, 8.60));
            productSellerRepository.save(new ProductSeller(product2, seller2, 10.0));
            productSellerRepository.save(new ProductSeller(product1, seller3, 5.60));

            productSellerRepository.save(new ProductSeller(product2, seller1, 100.99));
            productSellerRepository.save(new ProductSeller(product2, seller2, 110.20));

            productSellerRepository.save(new ProductSeller(product3 ,seller1, 2.20));
            productSellerRepository.save(new ProductSeller(product3 , seller2, 5.70));
            productSellerRepository.save(new ProductSeller(product3 , seller3, 1.60));
            productSellerRepository.save(new ProductSeller(product3 , seller2, 3.80));

            productSellerRepository.save(new ProductSeller(product4, seller1, 600.99));


            log.info("Affichage de tous les produits ----- (findAll()) -----");
            for (Product p : productRepository.findAll()) {
                log.info(p.toString());
            }

            log.info("Affichage de tous les produits d'Amazon ----- (findBySeller('Amazon')) -----");
            productRepository.findByName("Amazon").forEach(p -> {
                log.info(p.toString());
            });

            log.info("Affichage de toutes les photos ----- (findAll()) -----");
            Product product = productRepository.findById(1);
            log.info(product.toString());

            log.info("Affichage de tous les produits ----- (findAll()) -----");
            for (Seller seller : sellerRepository.findAll()) {
                log.info(seller.toString());
            }
        };
    }


}
