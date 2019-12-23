package robert.trojan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import robert.trojan.dao.UserDao;
import robert.trojan.entity.DAOUser;

@RestController
@CrossOrigin
@RequestMapping("api/user")
public class UserController {

	@Autowired
	private UserDao userDao;

	@GetMapping({ "/getUserInfo" })
	public DAOUser getUserInfo(@RequestParam String username) {
		return userDao.findByUsername(username);
	}

	@PutMapping({"/updateUserInfo"})
	public int updateUserInfo(@RequestParam String userName, @RequestParam String newName, @RequestParam String newSurname){
		return userDao.updateUserInfo(userName, newName, newSurname);
	}
}
