package robert.trojan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import robert.trojan.dao.DefaultSetDao;
import robert.trojan.dao.DefaultWordDao;
import robert.trojan.entity.DAODefaultSet;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/defaultSet")
public class DefaultSetController {
    @Autowired
    private DefaultSetDao defaultSetDao;

    @Autowired
    private DefaultWordDao defaultWordDao;

    @GetMapping({ "/getAllDefaultSets" })
    public ArrayList<DAODefaultSet> getAllDefaultSets(){
        ArrayList<DAODefaultSet> response = defaultSetDao.findAll();
        for(DAODefaultSet set: response){
            set.setWordsAmount( defaultWordDao.findByDefaultSetId(set.getId()).size() );
        }
        return response;
    }
}
