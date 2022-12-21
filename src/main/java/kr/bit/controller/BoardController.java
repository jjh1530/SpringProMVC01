package kr.bit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@RequestMapping("/list")
	public String getList(Criteria cri, Model model) { // type, keyword
		List<Board> list=boardService.getList(cri);
		// 객체바인딩
		model.addAttribute("list", list); // Model
		// 페이징 처리에 필요한 부분
		PageMaker pageMaker=new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(boardService.totalCount(cri));
		model.addAttribute("pageMaker", pageMaker);		
		return "board/list"; // View
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
	public String get(int idx, Model model, @ModelAttribute("cri") Criteria cri) {
		
		Board vo = boardService.read(idx);
		model.addAttribute("vo", vo);
		return "board/get";
	}
	
	@GetMapping(value="/modify")
	public String modify(int idx, Model model, @ModelAttribute("cri") Criteria cri) {
		
		Board vo = boardService.read(idx);
		model.addAttribute("vo", vo);
		
		return "board/modify";
	}
	
	@PostMapping(value="/modify")
	public String modeify(Board vo, Criteria cri, RedirectAttributes rttr) {
		
		boardService.modify(vo);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("getPerPageNum", cri.getPerPageNum());
		return"redirect:/board/list";
	}
	
	@GetMapping(value="/remove")
	public String remove(int idx,Criteria cri, RedirectAttributes rttr) {
		boardService.remove(idx);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("getPerPageNum", cri.getPerPageNum());
		return "redirect:/board/list";
	}
	
	@GetMapping(value="/reply")
	public String reply(int idx, Model model,@ModelAttribute("cri") Criteria cri) {
		Board vo = boardService.read(idx);
		model.addAttribute("vo", vo);
		
		return "board/reply";
	}
	
	@PostMapping(value="/reply")
	public String reply(Board vo, Criteria cri, RedirectAttributes rttr) {
		
		boardService.reply(vo);
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("getPerPageNum", cri.getPerPageNum());
		return "redirect:/board/list";
	}
	
}
