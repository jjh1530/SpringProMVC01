package kr.bit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.bit.entity.Member;
import kr.bit.service.BoardService;

@Controller
@RequestMapping("/login/*")
public class LoginController {

	@Autowired
	BoardService boardService;
	
	@RequestMapping("/loginProcess")
	public String login(Member vo, HttpSession session) {
		System.out.println(vo.getMemID());
		System.out.println(vo.getMemPwd()+"@@@@@@@@@@@@@@@@@");
		Member mvo = boardService.login(vo);
		System.out.println(mvo.getMemID());
		if (mvo!= null) {//로그인 성공
			session.setAttribute("mvo", mvo); // 객체바인딩
		}
		return"redirect:/board/list";
	}
	
	@RequestMapping("/logoutProcess")
	public String logout(HttpSession session) {
		
		session.invalidate();
		
		return"redirect:/board/list";
	}
	 
}
