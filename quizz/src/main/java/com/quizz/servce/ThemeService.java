package com.quizz.servce;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.quizz.model.Theme;

import java.util.List;

@Service
@Scope("prototype")

public interface ThemeService {

    Theme addTheme(Theme theme);


}
