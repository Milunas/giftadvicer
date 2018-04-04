package milunas.giftadvicer.controller;
import milunas.giftadvicer.model.Gift;
import milunas.giftadvicer.model.GiftGroup;
import milunas.giftadvicer.repository.GroupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    @Autowired
    GroupRepository groupRepository;

    @DeleteMapping("/{groupId}")
    void deleteGroup(@PathVariable final String groupId){
    }

    @GetMapping("/{groupId}/gift")
    void getGifts(@PathVariable final String groupId){
    }

    @PostMapping("/{groupId}/gift")
     void addNewGift(@RequestBody final Gift newGift, @PathVariable String groupId){
        GiftGroup group = groupRepository.findById(new Long(groupId)).get();
        List giftList = group.getGiftIdeas();

        Gift dbGift = new Gift();
        dbGift.setName(newGift.getName());
        dbGift.setLink(newGift.getLink());
        dbGift.setTargetGroup(group);

        giftList.add(newGift);
        group.setGiftIdeas(giftList);

        groupRepository.save(group);
    }

}
