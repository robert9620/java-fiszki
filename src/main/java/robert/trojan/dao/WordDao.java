package robert.trojan.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import robert.trojan.model.DAOWord;

import java.util.ArrayList;

@Repository
public interface WordDao extends CrudRepository<DAOWord, Integer> {
    @Query(value = "SELECT * FROM `word` WHERE word.set_id =:setId", nativeQuery = true)
    ArrayList<DAOWord> findBySetId(@Param("setId") Integer setId);
}
