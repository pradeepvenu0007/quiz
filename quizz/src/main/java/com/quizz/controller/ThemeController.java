package com.quizz.controller;

import com.quizz.dto.ThemeDto;
import com.quizz.manager.ThemeManager;
import com.quizz.model.Theme;
import com.quizz.servce.ThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api")
@ResponseBody
@CrossOrigin(origins = "http://localhost:4200")
@Controller
@Scope("prototype")
public class ThemeController {

    @Autowired
    private ThemeManager themeManager;

    @PostMapping("/addTheme")
    public Theme addTheme(@RequestBody Theme theme) {
        return themeManager.addTheme(theme);
    }

    @GetMapping("/getThemes")
    public List<Theme> getThemes() {
        return themeManager.getThemes();
    }
    @GetMapping("/getTheme/{idTheme}")
    public Theme getTheme(@PathVariable("idTheme") Long idTheme) {
        return themeManager.getTheme(idTheme);
    }
}
