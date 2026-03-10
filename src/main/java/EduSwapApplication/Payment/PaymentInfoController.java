package EduSwapApplication.Payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import EduSwapApplication.Users.User;
import EduSwapApplication.Users.UserRepository;

@RestController
public class PaymentInfoController {
    
    @Autowired
    PaymentInfoRepository paymentInfoRepository;
    
    @Autowired
    UserRepository userRepository;
    
    @PostMapping("/payment-info/users/{username}")
    String addPaymentInfo(@RequestBody PaymentInfo paymentInfo, @PathVariable String username) {
        User user = userRepository.findByUsername(username);
        if (user == null) return "{\"message\":\"failure\"}";
        
        paymentInfo.setUser(user);
        paymentInfoRepository.save(paymentInfo);
        return "{\"message\":\"success\"}";
    }
    
    @GetMapping("/payment-info/users/{username}")
    PaymentInfo getPaymentInfo(@PathVariable String username) {
        User user = userRepository.findByUsername(username);
        return paymentInfoRepository.findByUser(user);
    }
}
