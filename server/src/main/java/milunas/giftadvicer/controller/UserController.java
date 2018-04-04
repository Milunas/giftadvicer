package milunas.giftadvicer.controller;

import milunas.giftadvicer.model.GiftGroup;
import milunas.giftadvicer.model.UserAccount;
import milunas.giftadvicer.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
 class UserController {


    @Autowired
    private UserRepository userRepository;

    @PostMapping
    ResponseEntity<Void> initUser(@RequestBody UserAccount user) {

        UserAccount dbUser = userRepository.findUserByName(user.getName());
        HttpHeaders headers = new HttpHeaders();

        if(dbUser==null){
            UserAccount newUser = new UserAccount();
            newUser.setName(user.getName());
            newUser.setPassword(user.getPassword());
            userRepository.save(newUser);
            headers.add("Localization", newUser.getId() + "");
            return new ResponseEntity(headers, HttpStatus.CREATED);
        }
        else {
            if(!dbUser.getPassword().equals(user.getPassword())){
                throw new RuntimeException("USER WITH THIS NAME ALREADY EXISTING IN OUR DATABASE OR YOU PUTTING WRONG PASSWORD");
            }
            else
            {
                headers.add("Localization", dbUser.getId() + "");
                return new ResponseEntity(headers, HttpStatus.ACCEPTED);
            }
        }
    }

    @GetMapping("/{userId}/group")
    List<GiftGroup> getUserGroups(@PathVariable String userId) {
        return userRepository
                .findById(new Long(userId))
                .get()
                .getUserGroups();
    }

    @PostMapping("/{userId}/group")
    ResponseEntity<Void> addNewGroup(@RequestBody GiftGroup group, @PathVariable String userId) {
        UserAccount dbUser = userRepository.findById(new Long(userId)).get();
        List<GiftGroup> userGroups = dbUser.getUserGroups();

        GiftGroup dbGroup = new GiftGroup();
        dbGroup.setGiftedPersonName(group.getGiftedPersonName());

        userGroups.add(dbGroup);
        dbUser.setUserGroups(userGroups);

        userRepository.save(dbUser);

        HttpHeaders headers = new HttpHeaders();
        headers.add("Localization", group.getGiftedPersonName());

        return new ResponseEntity(HttpStatus.CREATED);
    }
}