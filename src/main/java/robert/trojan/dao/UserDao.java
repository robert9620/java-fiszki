package robert.trojan.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import robert.trojan.entity.DAOUser;

import javax.transaction.Transactional;

@Repository
public interface UserDao extends CrudRepository<DAOUser, String> {
	
	DAOUser findByUsername(String username);

	@Modifying
	@Transactional
	@Query(value = "UPDATE `user` SET `name`=:newName, `surname` =:newSurname WHERE `user`.`username` =:userName", nativeQuery = true)
	int updateUserInfo(@Param("userName") String userName, @Param("newName") String newName, @Param("newSurname") String newSurname);

	@Modifying
	@Transactional
	@Query(value = "UPDATE `user` SET `password`=:newPassword WHERE `user`.`username`=:userName", nativeQuery = true)
	int changeUserPassword(@Param("userName") String userName, @Param("newPassword") String newPassword);

	@Modifying
	@Transactional
	@Query(value = "UPDATE `user` SET `points`=`points`+1  WHERE `user`.`username`=:userName", nativeQuery = true)
	int addPoint(@Param("userName") String userName);

	@Modifying
	@Transactional
	@Query(value = "UPDATE `user` SET `mistakes`=`mistakes`+1  WHERE `user`.`username`=:userName", nativeQuery = true)
	int addMistake(@Param("userName") String userName);
}
