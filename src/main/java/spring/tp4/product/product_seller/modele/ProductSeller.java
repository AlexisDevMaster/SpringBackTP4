package spring.tp4.product.product_seller.modele;


import spring.tp4.product.product.modele.Product;
import spring.tp4.product.seller.modele.Seller;

import javax.persistence.*;

@Entity(name="products_sellers")
public class ProductSeller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_product")
    Product product;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_seller")
    Seller seller;

    double price;

    protected ProductSeller() { }

    /**
     * Build a painting with no fixed id
     */
    public ProductSeller(Product product, Seller seller, double price) {
        this.product= product;
        this.seller = seller;
        this.price = price;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


}
