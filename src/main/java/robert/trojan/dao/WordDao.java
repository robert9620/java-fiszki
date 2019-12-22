package robert.trojan.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import robert.trojan.entity.DAOWord;

import javax.transaction.Transactional;
import java.util.ArrayList;

@Repository
public interface WordDao extends CrudRepository<DAOWord, Integer> {
    @Query(value = "SELECT * FROM `word` WHERE word.set_id =:setId", nativeQuery = true)
    ArrayList<DAOWord> findBySetId(@Param("setId") Integer setId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM word WHERE word.set_id =:setId", nativeQuery = true)
    int deleteWordFromSet(@Param("setId") Integer setId);
}
