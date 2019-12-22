package robert.trojan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import robert.trojan.entity.DAODefaultSet;

import java.util.ArrayList;

@Repository
public interface DefaultSetDao extends CrudRepository<DAODefaultSet, Integer> {
    ArrayList<DAODefaultSet> findAll();
}
