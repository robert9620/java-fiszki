package robert.trojan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import robert.trojan.model.DAOSet;
import robert.trojan.model.DAOUser;

import java.util.ArrayList;

@Repository
public interface SetDao extends CrudRepository<DAOSet, Integer> {

    @Query(value = "SELECT * FROM `set` WHERE set.user_username =:login", nativeQuery = true)
    public ArrayList<DAOSet> findByUser(@Param("login") String login);

    @Query(value = "SELECT * FROM `set` WHERE set.user_username =:login AND set.is_favourite = 1;", nativeQuery = true)
    public ArrayList<DAOSet> findFavouriteByUser(@Param("login") String login);

//    @Query(value = "DELETE FROM `set` WHERE set.id =:setId", nativeQuery = true)
//    public void deleteById(@Param("setId") Integer setId);

    void deleteById(Integer id);

}
