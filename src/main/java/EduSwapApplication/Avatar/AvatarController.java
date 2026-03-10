package EduSwapApplication.Avatar;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AvatarController {
    
    @Autowired
    AvatarRepository avatarRepository;
    
    @GetMapping("/avatars")
    List<Avatar> getAllAvatars() {
        return avatarRepository.findAll();
    }
    
    @PostMapping("/avatars")
    Avatar createAvatar(@RequestBody Avatar avatar) {
        return avatarRepository.save(avatar);
    }
}
