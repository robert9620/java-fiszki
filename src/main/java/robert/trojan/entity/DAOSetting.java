package robert.trojan.entity;

import javax.persistence.*;

@Entity
@Table(name = "setting")
public class DAOSetting {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column
    private Integer id;
    @Column
    private boolean changedOrder;
    @Column
    private boolean counter;
    @Column
    private boolean styledFont;

    @OneToOne
    private DAOUser user;

    public DAOSetting() {
    }

    public DAOSetting(boolean changedOrder, boolean counter, boolean styledFont, DAOUser user) {
        this.changedOrder = changedOrder;
        this.counter = counter;
        this.styledFont = styledFont;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public boolean isChangedOrder() {
        return changedOrder;
    }

    public void setChangedOrder(boolean changedOrder) {
        this.changedOrder = changedOrder;
    }

    public boolean isCounter() {
        return counter;
    }

    public void setCounter(boolean counter) {
        this.counter = counter;
    }

    public boolean isStyledFont() {
        return styledFont;
    }

    public void setStyledFont(boolean styledFont) {
        this.styledFont = styledFont;
    }

    public DAOUser getUser() {
        return user;
    }

    public void setUser(DAOUser user) {
        this.user = user;
    }
}
