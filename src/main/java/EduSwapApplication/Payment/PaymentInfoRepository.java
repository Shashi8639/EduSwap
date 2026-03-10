package EduSwapApplication.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import EduSwapApplication.Users.User;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, Long> {
    PaymentInfo findById(int id);
    PaymentInfo findByUser(User user);
}
