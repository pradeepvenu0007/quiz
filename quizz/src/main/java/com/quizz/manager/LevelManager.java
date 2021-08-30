package com.quizz.manager;

import com.quizz.dto.LevelDto;
import com.quizz.model.Level;

import java.util.List;

public interface LevelManager {
     Level addLevel(Level levelDto, Long idTheme);

    List<Level> getLevels(Long idTheme);

    Level getLevel(Long idTheme);
}
