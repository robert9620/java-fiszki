package robert.trojan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import robert.trojan.dao.SettingDao;
import robert.trojan.entity.DAOSetting;

@RestController
@CrossOrigin
@RequestMapping("api/setting")
public class SettingController {
    @Autowired
    private SettingDao settingDao;

    @GetMapping({ "/getUserSetting" })
    public DAOSetting getUserSetting(@RequestParam String userName){
        return settingDao.findByUser(userName);
    }

    @PutMapping({"/setChangedOrder"})
    public int setChangedOrder(@RequestParam String userName, @RequestParam Boolean setting){
        return settingDao.setChangedOrder(userName, setting);
    }

    @PutMapping({"/setCounter"})
    public int setCounter(@RequestParam String userName, @RequestParam Boolean setting){
        return settingDao.setCounter(userName, setting);
    }

    @PutMapping({"/setStyledFont"})
    public int setStyledFont(@RequestParam String userName, @RequestParam Boolean setting){
        return settingDao.setStyledFont(userName, setting);
    }
}
