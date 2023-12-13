package de.lechner.cbudgetserver.settings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SettingsController {
    @Autowired
    private SettingsService settingsService;

    @GetMapping(value = "/settings")
    public List<Settings> getAll() {
        return settingsService.getAllSettings();

    }

    @RequestMapping("/settings/{parameter}")
    public String getSettinng(@PathVariable("parameter") String parameter) {
        if (settingsService==null) {
            return ("");
        }
        if (parameter.equals("password")) {
            return"forbitten!";
        }
        return settingsService.getSetting(parameter);
    }
}
