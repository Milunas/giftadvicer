package milunas.giftadvicer.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserAccount {

    @Id
    @GeneratedValue
    private long id;
    private String name;
    private String password;
    @OneToMany
    private List<GiftGroup> userAdministratedGroups;
    @ManyToMany
    private List<GiftGroup> userGroups;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<GiftGroup> getUserAdministratedGroups() {
        return userAdministratedGroups;
    }

    public void setUserAdministratedGroups(List<GiftGroup> userAdministratedGroups) {
        this.userAdministratedGroups = userAdministratedGroups;
    }

    public List<GiftGroup> getUserGroups() {
        return userGroups;
    }

    public void setUserGroups(List<GiftGroup> userGroups) {
        this.userGroups = userGroups;
    }
}
