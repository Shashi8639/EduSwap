package EduSwapApplication.Messages;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import EduSwapApplication.Users.User;

public interface MessageRepository extends JpaRepository<Message, Long> {
    Message findById(int id);

    List<Message> findBySender(User sender);

    List<Message> findByReceiver(User receiver);
    @Query("SELECT m FROM Message m WHERE (m.sender = ?1 AND m.receiver = ?2) OR (m.sender = ?2 AND m.receiver = ?1) ORDER BY m.timestamp")
    List<Message> findConversation(User user1, User user2);

}
