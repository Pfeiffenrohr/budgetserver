package de.lechner.cbudgetserver.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SettingsService {

    @Autowired
    private SettingsRepository settingsRepository;

    public List<Settings> getAllSettings() {
        List<Settings> t = new ArrayList<Settings>();
        settingsRepository.findAll().forEach(t::add);
        return t;
        //return Categories;
    }
    public String getSetting(String parameter) {

        return  settingsRepository.findSettingsByParameter((parameter));
    }
}
