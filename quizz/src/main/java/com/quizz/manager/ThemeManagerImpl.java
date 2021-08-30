
package com.quizz.manager;

import com.quizz.dao.ThemeDao;
import com.quizz.dto.ThemeDto;
import com.quizz.model.Theme;
import com.quizz.servce.ThemeService;
import com.quizz.model.OrikaBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Transactional
@Service
public class ThemeManagerImpl implements ThemeManager {

 
 
 @Autowired
 private ThemeService themeService;
 
 @Autowired
 private ThemeDao themeDao;

 @Override
 public Theme addTheme(Theme themeDto) {
//   Theme theme = orikaBeanMapper.map(themeDto, Theme.class);
//    return orikaBeanMapper.convertDTO(themeService.addTheme(theme), ThemeDto.class);
	 return themeService.addTheme(themeDto);
 }
    
 @Override
 public List<Theme> getThemes() {
	 return  themeDao.findAll();
   // return orikaBeanMapper.convertListDTO(themes, ThemeDto.class);
 }
    
 @Override
 public Theme getTheme(Long idTheme) {
   // return orikaBeanMapper.convertDTO(themeDao.findById(idTheme).get(), ThemeDto.class);
	 return themeDao.findById(idTheme).get();
 }
}
    