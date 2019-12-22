package robert.trojan.entity;

import javax.persistence.*;

@Entity
@Table(name = "word")
public class DAOWord {
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    @Column
    private Integer id;
    @Column
    private String word;
    @Column
    private String definition;

    @ManyToOne
    private DAOSet set;

    public DAOWord(String word, String definition, DAOSet set) {
        this.word = word;
        this.definition = definition;
        this.set = set;
    }

    public DAOWord() {
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

    public DAOSet getSet() {
        return set;
    }

    public void setSet(DAOSet set) {
        this.set = set;
    }
}
