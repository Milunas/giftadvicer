package milunas.giftadvicer.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Gift {

    @Id
    @GeneratedValue
    private long id;
    @NotNull
    @ManyToOne
    private GiftGroup targetGroup;
    private String name;
    private String link;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GiftGroup getTargetGroup() {
        return targetGroup;
    }

    public void setTargetGroup(GiftGroup targetGroup) {
        this.targetGroup = targetGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
