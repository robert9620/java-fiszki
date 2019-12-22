package robert.trojan.dto;

public class WordDTO {
    private String word;
    private String definition;
    private Integer setId;

    public WordDTO(String word, String definition, Integer setid) {
        this.word = word;
        this.definition = definition;
        this.setId = setid;
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

    public Integer getSetId() {
        return setId;
    }

    public void setSetId(Integer setId) {
        this.setId = setId;
    }
}
