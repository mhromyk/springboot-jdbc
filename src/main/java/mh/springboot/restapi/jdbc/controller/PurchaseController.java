package mh.springboot.restapi.jdbc.controller;

import mh.springboot.restapi.jdbc.model.Purchase;
import mh.springboot.restapi.jdbc.repository.PurchaseRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("/purchase")
public class PurchaseController {

    private final Logger logger = Logger.getLogger(PurchaseController.class.getName());

    private final PurchaseRepository purchaseRepository;

    public PurchaseController(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }

    @PostMapping
    public void makePurchase(@RequestBody Purchase purchase) {
        logger.info("Received purchase request: " + purchase);
        purchaseRepository.storePurchase(purchase);
    }

    @GetMapping
    public List<Purchase> readPurchase() {
        return purchaseRepository.findAllPurchases();
    }

}
