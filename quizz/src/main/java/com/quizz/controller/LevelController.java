package com.quizz.controller;

import com.quizz.dto.LevelDto;
import com.quizz.manager.LevelManager;
import com.quizz.model.Level;
import com.quizz.servce.LevelService;
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
public class LevelController {

    private LevelManager levelManager;

    @Autowired
    public LevelController(LevelManager levelManager) {
        this.levelManager = levelManager;
    }

    @PostMapping("/addLevel/{idTheme}")
    public Level addLevel(@RequestBody Level level, @PathVariable("idTheme") Long idTheme) {
        return levelManager.addLevel(level, idTheme);
    }

    @GetMapping("/getLevels/{idTheme}")
    public List<Level> getLevels(@PathVariable("idTheme") Long idTheme) {
        return levelManager.getLevels(idTheme);
    }

    @GetMapping("/getLevel/{idTheme}")
    public Level getLevel(@PathVariable("idTheme") Long idTheme) {
        return levelManager.getLevel(idTheme);
    }
}
