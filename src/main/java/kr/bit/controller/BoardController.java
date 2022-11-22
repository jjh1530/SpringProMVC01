package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.bit.entity.Board;
import kr.bit.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {


	@Autowired
	BoardService boardService;
	
	@GetMapping(value="/list")
	public String list(Model model) throws Exception {
		
		List<Board> list = boardService.getList();
		model.addAttribute("list", list);
		
		return "board/list";
	}
	
	@GetMapping(value="/register")
	public String register() {
		
		return "board/register";
	}
}
