package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import kr.bit.entity.Board;
import kr.bit.entity.Criteria;
import kr.bit.entity.PageMaker;
import kr.bit.service.BoardService;

@Controller
@RequestMapping("/board/*")
public class BoardController {


	@Autowired
	BoardService boardService;
	
	@GetMapping(value="/list")
	public String list(Criteria cri, Model model) throws Exception {
		
		List<Board> list = boardService.getList(cri);
		model.addAttribute("list", list);
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.totalCount());
		model.addAttribute("pageMaker", pageMaker);
		return "board/list";
	}
	
	@GetMapping(value="/register")
	public String register() {
		
		return "board/register";
	}
	
	@PostMapping(value="/register")
	public String register(Board vo, RedirectAttributes rttr) {
		boardService.insertSelectKey(vo);
		rttr.addFlashAttribute("result", vo.getIdx());
		return "redirect:/board/list";
	}
	
	@GetMapping(value="/get")
	public String get(int idx, Model model) {
		
		Board vo = boardService.read(idx);
		model.addAttribute("vo", vo);
		return "board/get";
	}
	
	@GetMapping(value="/modify")
	public String modify(int idx, Model model) {
		
		Board vo = boardService.read(idx);
		model.addAttribute("vo", vo);
		
		return "board/modify";
	}
	
	@PostMapping(value="/modify")
	public String modeify(Board vo) {
		
		boardService.modify(vo);
		
		return"redirect:/board/list";
	}
	
	@GetMapping(value="/remove")
	public String remove(int idx) {
		boardService.remove(idx);
		return "redirect:/board/list";
	}
	
	@GetMapping(value="/reply")
	public String reply(int idx, Model model) {
		Board vo = boardService.read(idx);
		model.addAttribute("vo", vo);
		return "board/reply";
	}
	
	@PostMapping(value="/reply")
	public String reply(Board vo) {
		
		boardService.reply(vo);
		return "redirect:/board/list";
	}
	
}
