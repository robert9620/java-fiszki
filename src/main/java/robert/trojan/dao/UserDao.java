package robert.trojan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import robert.trojan.entity.DAOUser;

@Repository
public interface UserDao extends CrudRepository<DAOUser, String> {
	
	DAOUser findByUsername(String username);
	
}
