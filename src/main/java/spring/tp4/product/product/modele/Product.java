package spring.tp4.product.product.modele;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonMerge;
import spring.tp4.product.product_seller.modele.ProductSeller;
import spring.tp4.product.seller.modele.Seller;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Product {

    @Id
    @JsonIgnore
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    @OneToMany(mappedBy = "product", cascade = CascadeType.MERGE)
    @JsonIgnore
    private Set<ProductSeller> sellers = new HashSet<>();

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

    public Set<ProductSeller> getSellers() {
        return sellers;
    }

    public void setSellers(Set<ProductSeller> sellers) {
        this.sellers = sellers;
    }
}

