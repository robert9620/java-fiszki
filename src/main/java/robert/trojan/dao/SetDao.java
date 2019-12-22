package robert.trojan.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import robert.trojan.entity.DAOSet;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface SetDao extends CrudRepository<DAOSet, Integer> {

    DAOSet findDAOSetById(Integer id);

    @Query(value = "SELECT * FROM `set` WHERE set.user_username =:login", nativeQuery = true)
    ArrayList<DAOSet> findByUser(@Param("login") String login);

    @Query(value = "SELECT * FROM `set` WHERE set.user_username =:login AND set.is_favourite = 1;", nativeQuery = true)
    ArrayList<DAOSet> findFavouriteByUser(@Param("login") String login);

    void deleteById(Integer id);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `set` SET set.is_favourite = b'1' WHERE set.id =:setId", nativeQuery = true)
    int setFavouriteById(@Param("setId") Integer setId);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `set` SET set.is_favourite = b'0' WHERE set.id =:setId", nativeQuery = true)
    int deleteFromFavouriteById(@Param("setId") Integer setId);

}
