package com.quizz.manager;

import com.quizz.dao.HistoryDao;
import com.quizz.dto.HistoryDto;
import com.quizz.model.History;
import com.quizz.model.OrikaBeanMapper;
import com.quizz.servce.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Transactional
@Service
public class HistoryManagerImpl implements HistoryManager {
	
   
	@Autowired
    private HistoryDao historyDao;
	@Autowired
    private HistoryService historyService;

//    @Autowired
//    public HistoryManagerImpl(OrikaBeanMapper orikaBeanMapper, HistoryDao historyDao,
//                              HistoryService historyService) {
//        this.orikaBeanMapper = orikaBeanMapper;
//        this.historyDao = historyDao;
//        this.historyService = historyService;
//    }

    @Override
    public History addHistory(History historyDto) {
        //History history = orikaBeanMapper.map(historyDto, History.class);
      //  return orikaBeanMapper.convertDTO(historyService.addHistory(history), HistoryDto.class);
    	return historyService.addHistory(historyDto);
    }

    @Override
    public List<History> getHistories() {
        List<History> histories = historyDao.findAll();
        histories.sort((f1, f2) -> Long.compare(f2.getSore(), f1.getSore()));

        return histories;       //orikaBeanMapper.convertListDTO(histories, HistoryDto.class);
    }

    @Override
    public History findHistoryBySore(int score) {
        return historyDao.findHistoryBySore(score);  //orikaBeanMapper.convertDTO(historyDao.findHistoryBySore(score), HistoryDto.class);
    }

    @Override
    public History findHistoryByUsername(String username) {
        return historyDao.findHistoryByUsername(username);
        		//orikaBeanMapper.convertDTO(historyDao.findHistoryByUsername(username), HistoryDto.class);
    }

    @Override
    public History editHistory(History historyDto, String username) {
       // History history = orikaBeanMapper.map(historyDto, History.class);
        History history1 = historyDao.findHistoryByUsername(username);
        return historyService.editHistory(historyDto, history1);
        		//orikaBeanMapper.convertDTO(historyService.editHistory(history, history1), HistoryDto.class);
    }
}
