package EduSwapApplication.Purchase;

import org.springframework.data.jpa.repository.JpaRepository;
import EduSwapApplication.Users.User;
import java.util.List;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
    Purchase findById(int id);
    List<Purchase> findByBuyer(User buyer);
}
