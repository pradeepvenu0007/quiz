package com.quizz.controller;

import com.quizz.dto.HistoryDto;
import com.quizz.manager.HistoryManager;
import com.quizz.model.History;
import com.quizz.servce.HistoryService;
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
public class HistoryController {

    @Autowired
    private HistoryManager historyManager;

    @PostMapping("/addHistory")
    History addHistory(@RequestBody History historyDto) {
        return historyManager.addHistory(historyDto);
    }
    @PutMapping("/editHistory/{username}")
    History editHistory(@RequestBody History historyDto, @PathVariable("username") String username) {
        return historyManager.editHistory(historyDto, username);
    }
    @GetMapping("/getHistories")
    List<History> getHistories() {
        return historyManager.getHistories();
    }
    @GetMapping("/findHistoryBySore/{score}")
    History findHistoryBySore(@PathVariable("score") int score) {
        return historyManager.findHistoryBySore(score);
    }
    @GetMapping("/findHistoryByUsername/{username}")
    History findHistoryByUsername(@PathVariable("username") String username) {
        return historyManager.findHistoryByUsername(username);
    }
}
