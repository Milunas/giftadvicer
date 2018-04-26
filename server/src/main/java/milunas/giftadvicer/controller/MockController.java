package milunas.giftadvicer.controller;

import milunas.giftadvicer.model.GiftGroup;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/mock")
public class MockController {

    @GetMapping("/user")
    List<GiftGroup> getUserGroups(@PathVariable String userId) {
        List<GiftGroup> groups = new ArrayList();
        groups.add(new GiftGroup());
        groups.add(new GiftGroup());
        return groups;

    }

}
