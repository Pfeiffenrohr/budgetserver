package de.lechner.cbudgetserver.settings;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface SettingsRepository extends CrudRepository<Settings, Integer>  {
    @Query(value= "select wert from settings where parameter=:parameter limit 1",nativeQuery = true)
    String findSettingsByParameter(@Param("parameter") String parameter);

}