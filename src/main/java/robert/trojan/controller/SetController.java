package robert.trojan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import robert.trojan.dao.SetDao;
import robert.trojan.dao.UserDao;
import robert.trojan.model.DAOSet;
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

    @PostMapping({ "/createSet" })
    public ResponseEntity<?> createSet(@RequestBody SetDTO set) {
        DAOSet newSet = new DAOSet(set.getName(), false, userDao.findByUsername(set.getUser()));
        setDao.save(newSet);
        return ResponseEntity.ok(newSet);
    }

    @GetMapping({ "/getUserSets" })
    public ArrayList<DAOSet> getUserSets(@RequestParam String username){
        return setDao.findByUser(username);
    }

    @GetMapping({ "/getUserFavouriteSets" })
    public ArrayList<DAOSet> getUserFavouriteSets(@RequestParam String username){
        return setDao.findFavouriteByUser(username);
    }

    @DeleteMapping({ "/deleteUserSet" })
    public void deleteSet(@RequestParam Integer setId) {
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
