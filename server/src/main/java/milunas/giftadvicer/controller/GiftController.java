package milunas.giftadvicer.controller;

import milunas.giftadvicer.model.UserAccount;
import milunas.giftadvicer.repository.GiftRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gift")
public class GiftController {

    @Autowired
    GiftRepository giftRepository;

    @PutMapping("/{giftId}")
     void changeReservation(@PathVariable String giftId, @RequestBody UserAccount user){

    }

    @DeleteMapping("/{giftId}")
    void deleteGift(@PathVariable final String giftId){
    }

}
