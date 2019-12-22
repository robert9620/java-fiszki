package robert.trojan.entity;

import javax.persistence.*;

@Entity
@Table(name = "defaultSet")
public class DAODefaultSet {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column
    private Integer id;
    @Column
    private String name;

    private Integer wordsAmount;

    public DAODefaultSet(String name) {
        this.name = name;
    }

    public DAODefaultSet() {
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

    public Integer getWordsAmount() {
        return wordsAmount;
    }

    public void setWordsAmount(Integer wordsAmount) {
        this.wordsAmount = wordsAmount;
    }
}
