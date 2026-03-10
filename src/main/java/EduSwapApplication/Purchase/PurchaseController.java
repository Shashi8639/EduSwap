package EduSwapApplication.Purchase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import EduSwapApplication.Users.User;
import EduSwapApplication.Users.UserRepository;
import EduSwapApplication.Listings.Listing;
import EduSwapApplication.Listings.ListingRepository;
import java.util.List;

@RestController
public class PurchaseController {
    
    @Autowired
    PurchaseRepository purchaseRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    ListingRepository listingRepository;
    
    @PostMapping("/purchases")
    String createPurchase(@RequestBody Purchase purchase) {
        purchase.setPaymentStatus("PENDING");
        purchase.setAccessGranted(false);
        purchase.setPurchaseDate(java.time.LocalDateTime.now().toString());
        purchaseRepository.save(purchase);
        return "{\"message\":\"success\"}";
    }
    
    @GetMapping("/purchases/buyer/{username}")
    List<Purchase> getPurchasesByBuyer(@PathVariable String username) {
        User buyer = userRepository.findByUsername(username);
        return purchaseRepository.findByBuyer(buyer);
    }
    
    @PutMapping("/purchases/{id}/grant-access")
    String grantAccess(@PathVariable int id) {
        Purchase purchase = purchaseRepository.findById(id);
        if (purchase == null) return "{\"message\":\"failure\"}";
        purchase.setAccessGranted(true);
        purchase.setPaymentStatus("COMPLETED");
        purchaseRepository.save(purchase);
        return "{\"message\":\"success\"}";
    }
}
