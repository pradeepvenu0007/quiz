package com.quizz.manager;

import com.quizz.dto.ThemeDto;
import com.quizz.model.Theme;

import java.util.List;

public interface ThemeManager {
    Theme addTheme(Theme themeDto);

    List<Theme> getThemes();

    Theme getTheme(Long idTheme);
}
