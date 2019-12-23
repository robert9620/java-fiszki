package robert.trojan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import robert.trojan.dao.DefaultWordDao;
import robert.trojan.entity.DAODefaultWord;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api/defaultWord")
public class DefaultWordController {
    @Autowired
    private DefaultWordDao defaultWordDao;

    @GetMapping({ "/getDefaultWordsBySetId" })
    public ArrayList<DAODefaultWord> getWordsBySetId(@RequestParam Integer setId){
        return defaultWordDao.findByDefaultSetId(setId);
    }
}
