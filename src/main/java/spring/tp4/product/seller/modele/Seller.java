package spring.tp4.product.seller.modele;


import spring.tp4.product.product_seller.modele.ProductSeller;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Seller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

//    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY)
//    Set<ProductSeller> products = new HashSet<>();


    protected Seller() { }

    /**
     * Build a painting with no fixed id
     */
    public Seller(String name) {
        this.name = name;
    }

    public Seller(Integer id, String name) {
        this.id = id;
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

//    public Set<ProductSeller> getProducts() {
//        return products;
//    }
//
//    public void setProducts(Set<ProductSeller> products) {
//        this.products = products;
//    }
}
