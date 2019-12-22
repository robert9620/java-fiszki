package robert.trojan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import robert.trojan.entity.DAODefaultWord;
import robert.trojan.entity.DAOWord;

import java.util.ArrayList;

@Repository
public interface DefaultWordDao extends CrudRepository<DAODefaultWord, Integer> {
    @Query(value = "SELECT * FROM `default_word` WHERE default_word.default_set_id =:setId", nativeQuery = true)
    ArrayList<DAODefaultWord> findByDefaultSetId(@Param("setId") Integer setId);
}
