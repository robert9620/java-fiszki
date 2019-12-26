package robert.trojan.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import robert.trojan.entity.DAOSetting;

import javax.transaction.Transactional;

public interface SettingDao extends CrudRepository<DAOSetting, Integer> {
    @Query(value = "SELECT * FROM `setting` WHERE setting.user_username =:login", nativeQuery = true)
    DAOSetting findByUser(@Param("login") String login);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `setting` SET `changed_order` =:setting WHERE setting.user_username =:login", nativeQuery = true)
    int setChangedOrder(@Param("login") String login, @Param("setting") Boolean setting);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `setting` SET `counter` =:setting WHERE setting.user_username =:login", nativeQuery = true)
    int setCounter(@Param("login") String login, @Param("setting") Boolean setting);

    @Modifying
    @Transactional
    @Query(value = "UPDATE `setting` SET `styled_font` =:setting WHERE setting.user_username =:login", nativeQuery = true)
    int setStyledFont(@Param("login") String login, @Param("setting") Boolean setting);
}
