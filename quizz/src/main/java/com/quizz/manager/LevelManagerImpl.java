package com.quizz.manager;

import com.quizz.dao.LevelDao;
import com.quizz.dao.ThemeDao;
import com.quizz.dto.LevelDto;
import com.quizz.model.Level;
import com.quizz.model.OrikaBeanMapper;
import com.quizz.model.Theme;
import com.quizz.servce.LevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class LevelManagerImpl implements LevelManager {
	 @Autowired
    private LevelService levelService;
	 @Autowired
    private LevelDao levelDao;
	
   
	 @Autowired
    private ThemeDao themeDao;

//    @Autowired
//    public LevelManagerImpl(LevelService levelService, LevelDao levelDao, OrikaBeanMapper orikaBeanMapper,
//                            ThemeDao themeDao) {
//        this.levelService = levelService;
//        this.levelDao = levelDao;
//        this.orikaBeanMapper = orikaBeanMapper;
//        this.themeDao = themeDao;
//    }

    @Override
    public Level addLevel(Level levelDto, Long idTheme) {
    	 Theme theme = themeDao.getOne(idTheme);
       // Level level = orikaBeanMapper.map(levelDto, Level.class);
        //return orikaBeanMapper.convertDTO(levelService.addLevel(level, theme), LevelDto.class);
    	 return levelService.addLevel(levelDto, theme);
    }

    @Override
    public List<Level> getLevels(Long idTheme) {
        Theme theme = themeDao.getOne(idTheme);
       // List<Level> levels = theme.getLevels();
        //return orikaBeanMapper.convertListDTO(levels, LevelDto.class);
        return theme.getLevels();
    }

    @Override
    public Level getLevel(Long idTheme) {
        //return orikaBeanMapper.convertDTO(levelDao.getOne(idTheme), LevelDto.class);
    	return levelDao.findById(idTheme).get();
    }
}
