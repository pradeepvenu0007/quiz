package com.quizz.manager;

import com.quizz.dto.HistoryDto;
import com.quizz.model.History;

import java.util.List;

public interface HistoryManager {
    History addHistory(History historyDto);

    List<History> getHistories();

    History findHistoryBySore(int score);

    History findHistoryByUsername(String username);

    History editHistory(History historyDto, String username);
}
