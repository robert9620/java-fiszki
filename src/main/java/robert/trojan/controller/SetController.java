package robert.trojan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import robert.trojan.dao.SetDao;
import robert.trojan.dao.UserDao;
import robert.trojan.dao.WordDao;
import robert.trojan.entity.DAOSet;
import robert.trojan.dto.SetDTO;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/set")
public class SetController {
    @Autowired
    private UserDao userDao;

    @Autowired
    private SetDao setDao;

    @Autowired
    private WordDao wordDao;

    @PostMapping({ "/createSet" })
    public ResponseEntity<?> createSet(@RequestBody SetDTO set) {
        DAOSet newSet = new DAOSet(set.getName(), false, userDao.findByUsername(set.getUser()));
        setDao.save(newSet);
        return ResponseEntity.ok(newSet);
    }

    @GetMapping({ "/getUserSets" })
    public ArrayList<DAOSet> getUserSets(@RequestParam String username){
        ArrayList<DAOSet> response = setDao.findByUser(username);
        for(DAOSet set: response){
            set.setWordsAmount( wordDao.findBySetId(set.getId()).size() );
        }
        return response;
    }

    @GetMapping({ "/getUserFavouriteSets" })
    public ArrayList<DAOSet> getUserFavouriteSets(@RequestParam String username){
        ArrayList<DAOSet> response = setDao.findFavouriteByUser(username);
        for(DAOSet set: response){
            set.setWordsAmount( wordDao.findBySetId(set.getId()).size() );
        }
        return response;
    }

    @DeleteMapping({ "/deleteUserSet" })
    public void deleteSet(@RequestParam Integer setId) {
        wordDao.deleteWordFromSet(setId);
        setDao.deleteById(setId);
    }

    @PutMapping({"/addSetToFavourite"})
    public void addSetToFavourite(@RequestParam Integer setId) {
        setDao.setFavouriteById(setId);
    }

    @PutMapping({"/deleteSetFromFavourite"})
    public void deleteSetFromFavourite(@RequestParam Integer setId) {
        setDao.deleteFromFavouriteById(setId);
    }
}
