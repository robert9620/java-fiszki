package robert.trojan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import robert.trojan.dao.*;
import robert.trojan.entity.DAODefaultSet;
import robert.trojan.entity.DAODefaultWord;
import robert.trojan.entity.DAOSet;
import robert.trojan.entity.DAOWord;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/defaultSet")
public class DefaultSetController {
    @Autowired
    private DefaultSetDao defaultSetDao;

    @Autowired
    private DefaultWordDao defaultWordDao;

    @Autowired
    private SetDao setDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private WordDao wordDao;

    @GetMapping({ "/getAllDefaultSets" })
    public ArrayList<DAODefaultSet> getAllDefaultSets(){
        ArrayList<DAODefaultSet> response = defaultSetDao.findAll();
        for(DAODefaultSet set: response){
            set.setWordsAmount( defaultWordDao.findByDefaultSetId(set.getId()).size() );
        }
        return response;
    }

    @GetMapping({"/copyDefaultSet"})
    public void copyDefaultSet(@RequestParam String userName, @RequestParam Integer defaultSetId){
        DAODefaultSet defaultSet = defaultSetDao.findDAODefaultSetById(defaultSetId);
        ArrayList<DAODefaultWord> allDefaultWords = defaultWordDao.findByDefaultSetId(defaultSetId);

        DAOSet newSet = new DAOSet(defaultSet.getName(), false, userDao.findByUsername(userName));
        setDao.save(newSet).getId();

        for(int i = 0; i<allDefaultWords.size(); i++) {
            DAOWord newWord = new DAOWord(allDefaultWords.get(i).getWord(), allDefaultWords.get(i).getDefinition(), newSet);
            wordDao.save(newWord);
        }
    }
}
