package org.spring.controller;


import org.spring.domain.BoardVO;
import org.spring.service.BoardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor  // 기본생성자 자동호출 -> boardService주입
@Log4j
public class BoardController {
	// 의존성 주입
	// Spring에서 인터페이스 주입시
	// 해당 인터페이스를 구현한 객체를 주입
	private final BoardService boardService;
	
	
	@GetMapping("/list")
	public void listAll(Model model) {
		log.info("전체회원 목록");
		model.addAttribute("boardList", boardService.listAll());
	}
	
	@GetMapping("/register")
	public void registerGet() {}
	
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		boardService.register(board);
		rttr.addFlashAttribute("alert", board.getBno());
//		rttr.addFlashAttribute(board);
		// redirect : 클라이언트의 브라우저에게 다른 URL으로 이동하라는 명령
		// 			  새로고침으로 인한 중복 요청 방지
		return "redirect:/board/list";
	}
	
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") int bno) {
		boardService.remove(bno);
		log.info(bno);
		return "redirect:/board/list";
	}
	
	@GetMapping("/modify")
	public void modify(Model model, @RequestParam("bno") int bno) {		
		model.addAttribute("vo", boardService.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board) {
		log.info(boardService.modify(board));
		return "redirect:/board/list";
	}
	
}
