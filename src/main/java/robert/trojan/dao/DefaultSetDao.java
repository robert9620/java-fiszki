package robert.trojan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import robert.trojan.entity.DAODefaultSet;
import robert.trojan.entity.DAOSet;

import java.util.ArrayList;

@Repository
public interface DefaultSetDao extends CrudRepository<DAODefaultSet, Integer> {
    DAODefaultSet findDAODefaultSetById(Integer id);

    ArrayList<DAODefaultSet> findAll();
}
