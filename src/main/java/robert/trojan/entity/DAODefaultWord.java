package robert.trojan.entity;

import javax.persistence.*;

@Entity
@Table(name = "defaultWord")
public class DAODefaultWord {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column
    private Integer id;
    @Column
    private String word;
    @Column
    private String definition;

    @ManyToOne
    private DAODefaultSet defaultSet;

    public DAODefaultWord(String word, String definition, DAODefaultSet defaultSet) {
        this.word = word;
        this.definition = definition;
        this.defaultSet = defaultSet;
    }

    public DAODefaultWord() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }

    public DAODefaultSet getDefualtSet() {
        return defaultSet;
    }

    public void setDefualtSet(DAODefaultSet defaultSet) {
        this.defaultSet = defaultSet;
    }
}
