package spring.tp4.product.product.modele;

import spring.tp4.product.product_seller.modele.ProductSeller;
import spring.tp4.product.seller.modele.Seller;

import javax.persistence.*;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

//    @OneToMany(mappedBy = "product")
//    Set<ProductSeller> productsRegisterd;

    protected Product() { }

    /**
     * Build a painting with no fixed id
     */
    public Product(String name) {
        this.name = name;
    }

    public Product(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Product(String name, ProductSeller... productSellers) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Set<ProductSeller> getProductsRegisterd() {
//        return productsRegisterd;
//    }
//
//    public void setProductsRegisterd(Set<ProductSeller> productsRegisterd) {
//        this.productsRegisterd = productsRegisterd;
//    }
}
