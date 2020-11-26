package spring.tp4.product.seller.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.tp4.product.seller.modele.Seller;
import spring.tp4.product.seller.repository.SellerRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SellerController {

    @Autowired
    private SellerRepository sellerDAO;

    @GetMapping(value = "/sellers")
    public Iterable<Seller> getAllSellers(){return sellerDAO.findAll();}

    @GetMapping(value = "/seller/{id}")
    public Seller getSellerById(@PathVariable int id){
        return sellerDAO.findById(id);
    }

    @PostMapping(value = "/sellers")
    public void addSeller(@RequestBody Seller p){
        sellerDAO.save(p);
    }

}
