package robert.trojan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import robert.trojan.dao.SetDao;
import robert.trojan.dao.WordDao;
import robert.trojan.dto.WordDTO;
import robert.trojan.entity.DAOWord;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/word")
public class WordController {
    @Autowired
    private WordDao wordDao;

    @Autowired
    private SetDao setDao;

    @PostMapping({ "/createWords" })
    public void createWords(@RequestBody WordDTO[] word) {
        for(int i = 0; i<word.length; i++) {
            DAOWord newWord = new DAOWord(word[i].getWord(), word[i].getDefinition(), setDao.findDAOSetById(word[i].getSetId()));
            wordDao.save(newWord);
        }
    }

    @GetMapping({ "/getWordsBySetId" })
    public ArrayList<DAOWord> getWordsBySetId(@RequestParam Integer setId){
        return wordDao.findBySetId(setId);
    }
}
