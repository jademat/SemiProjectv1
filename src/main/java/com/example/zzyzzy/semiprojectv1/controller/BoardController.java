package com.example.zzyzzy.semiprojectv1.controller;

import com.example.zzyzzy.semiprojectv1.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
@Slf4j
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list")
    public String list(Model m,@RequestParam(defaultValue = "1") int cpg) {
        // RequestParam에 defaultValue 를 이용하면 cpg 매개변수가 전달되지 않을 경우 기본 값을 1 전달
        log.info("board/list 호출");
        m.addAttribute("bds", boardService.readBoard(cpg));
        m.addAttribute("cpg", cpg);
        m.addAttribute("stblk", ((cpg -1) /10)*10 +1);
        return "views/board/list";
    }


}
