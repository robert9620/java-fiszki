package robert.trojan.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import robert.trojan.dao.SettingDao;
import robert.trojan.dao.UserDao;
import robert.trojan.entity.DAOSetting;
import robert.trojan.entity.DAOUser;
import robert.trojan.dto.UserDTO;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private SettingDao settingDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		DAOUser user = userDao.findByUsername(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				new ArrayList<>());
	}
	
	public boolean save(UserDTO user) {
		if(! userDao.existsById(user.getUsername())) {
			DAOUser newUser = new DAOUser();
			newUser.setUsername(user.getUsername());
			newUser.setName(user.getName());
			newUser.setSurname(user.getSurname());
			newUser.setPassword(bcryptEncoder.encode(user.getPassword()));
			newUser.setPoints(0);
			newUser.setMistakes(0);
			userDao.save(newUser);

			DAOSetting newSetting = new DAOSetting();
			newSetting.setChangedOrder(false);
			newSetting.setCounter(true);
			newSetting.setStyledFont(true);
			newSetting.setUser(newUser);
			settingDao.save(newSetting);

			return true;
		} else {
			return false;
		}
	}
}
