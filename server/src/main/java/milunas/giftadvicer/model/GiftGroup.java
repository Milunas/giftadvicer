package milunas.giftadvicer.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class GiftGroup {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String giftedPersonName;
    @OneToMany
    private List<Gift> giftIdeas;
    @ManyToOne
    private UserAccount administrator;
    @ManyToMany
    private List<UserAccount> inventersUsers;

    public List<Gift> getGiftIdeas(){
        return this.giftIdeas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGiftedPersonName() {
        return giftedPersonName;
    }

    public void setGiftedPersonName(String giftedPersonName) {
        this.giftedPersonName = giftedPersonName;
    }

    public void setGiftIdeas(List<Gift> giftIdeas) {
        this.giftIdeas = giftIdeas;
    }

    public UserAccount getAdministrator() {
        return administrator;
    }

    public void setAdministrator(UserAccount administrator) {
        this.administrator = administrator;
    }

    public List<UserAccount> getInventersUsers() {
        return inventersUsers;
    }

    public void setInventersUsers(List<UserAccount> inventersUsers) {
        this.inventersUsers = inventersUsers;
    }
}
