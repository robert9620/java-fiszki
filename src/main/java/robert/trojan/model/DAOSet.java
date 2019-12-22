package robert.trojan.model;

import javax.persistence.*;

@Entity
@Table(name = "set")
public class DAOSet {

    @GeneratedValue(strategy=GenerationType.AUTO)
    @Id
    @Column
    private Integer id;
    @Column
    private String name;
    @Column
    private Boolean isFavourite;

    @ManyToOne
    private DAOUser user;

    public DAOSet(String name, Boolean isFavourite, DAOUser user) {
        this.name = name;
        this.isFavourite = isFavourite;
        this.user = user;
    }

    public DAOSet() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFavourite() {
        return isFavourite;
    }

    public void setFavourite(Boolean favourite) {
        isFavourite = favourite;
    }

    public DAOUser getUser() {
        return user;
    }

    public void setUser(DAOUser user) {
        this.user = user;
    }
}
