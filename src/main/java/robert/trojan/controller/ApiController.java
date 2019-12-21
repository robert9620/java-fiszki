package robert.trojan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import robert.trojan.dao.SetDao;
import robert.trojan.dao.UserDao;
import robert.trojan.model.DAOSet;
import robert.trojan.model.DAOUser;
import robert.trojan.model.SetDTO;

import java.util.ArrayList;

@RestController
@CrossOrigin
@RequestMapping("api")
public class ApiController {

	@Autowired
	private UserDao userDao;

	@Autowired
	private SetDao setDao;

	@GetMapping({ "/hello" })
	public ResponseEntity firstPage() {
		return ResponseEntity.ok("hello there");
	}

	@GetMapping({ "/userInfo" })
	public DAOUser getUserInfo(@RequestParam String username) {
		return userDao.findByUsername(username);
	}

	@PostMapping({ "/createSet" })
	public ResponseEntity<?> createSet(@RequestBody SetDTO set) {
		DAOSet newSet = new DAOSet(set.getName(), false, userDao.findByUsername(set.getUser()));
		setDao.save(newSet);
		return ResponseEntity.ok(newSet);
	}

	@GetMapping({ "/userSets" })
	public ArrayList<DAOSet> getUserSets(@RequestParam String username){
		return setDao.findByUser(username);
	}

	@GetMapping({ "/userFavouriteSets" })
	public ArrayList<DAOSet> getUserFavouriteSets(@RequestParam String username){
		return setDao.findFavouriteByUser(username);
	}

	@DeleteMapping({ "/deleteUserSet" })
	public void deleteSet(@RequestParam Integer setId) {
		setDao.deleteById(setId);
	}
}
