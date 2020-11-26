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
    public CommandLineRunner instanceProduct(ProductRepository productRepository, SellerRepository sellerRepository, ProductSellerRepository productSellerRepository){
        return (args)-> {
            productRepository.save(new Product("Bottle"));
            productRepository.save(new Product("Computer"));
            productRepository.save(new Product("Lamp"));
            productRepository.save(new Product("TV"));



            log.info("Affichage de tous les produits ----- (findAll()) -----");
            for (Product product : productRepository.findAll()) {
                log.info(product.toString());
            }

//            log.info("Affichage de tous les produits d'Amazon ----- (findBySeller('Amazon')) -----");
//            productRepository.findByName("Amazon").forEach(p -> {
//                log.info(p.toString());
//            });

            log.info("Affichage de toutes les photos ----- (findAll()) -----");
            Product product = productRepository.findById(1);
            log.info(product.toString());


            //----------------------------------------------------------------------------------------
            //--------------------------------------- SELLER -----------------------------------------
            //----------------------------------------------------------------------------------------



            sellerRepository.save(new Seller("Amazon"));
            sellerRepository.save(new Seller("CDiscount"));
            sellerRepository.save(new Seller("Wish"));

            log.info("Affichage de tous les produits ----- (findAll()) -----");
            for (Seller seller : sellerRepository.findAll()) {
                log.info(seller.toString());
            }


            Product product1 = productRepository.findById(1);///Bottle
            Product product2 = productRepository.findById(2);//Computer
            Product product3 = productRepository.findById(3);//Lamp
            Product product4 = productRepository.findById(4);//TV

            Seller seller1 = sellerRepository.findById(1);//Amazon
            Seller seller2 = sellerRepository.findById(2);//CDiscount
            Seller seller3 = sellerRepository.findById(3);//Wish

            productSellerRepository.save(new ProductSeller(product1, seller1, 8.60));
            productSellerRepository.save(new ProductSeller(product1, seller2, 10.0));
            productSellerRepository.save(new ProductSeller(product1, seller3, 5.60));

            productSellerRepository.save(new ProductSeller(product2, seller1, 100.99));
            productSellerRepository.save(new ProductSeller(product2, seller2, 110.20));

            productSellerRepository.save(new ProductSeller(product3, seller1, 2.20));
            productSellerRepository.save(new ProductSeller(product3, seller2, 5.70));
            productSellerRepository.save(new ProductSeller(product3, seller3, 1.60));
            productSellerRepository.save(new ProductSeller(product3, seller2, 3.80));

            productSellerRepository.save(new ProductSeller(product4, seller1, 600.99));


        };
    }



}
