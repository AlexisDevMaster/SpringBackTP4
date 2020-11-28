package spring.tp4.product.product_seller.key;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ProductSellerPK implements Serializable {

    @Column(name = "id_product")
    private Long id_product;

    @Column(name = "id_seller")
    private Long id_seller;


}