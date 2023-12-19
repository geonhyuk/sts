package org.spring.controller;

import java.util.List;

import org.spring.domain.BoardVO;
import org.spring.service.BoardService;
import org.spring.service.BoardServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/board/*")
@AllArgsConstructor // 기본생성자 자동 호출 -> boardService주입
@Log4j
public class BoardController {
	// 의존성 주입
	// Spring에서 인터페이스 주입시 
	// 해당 인터페이스를 구현한 객체를 주입
	private final BoardService boardService;
	
	@GetMapping("/list")
	public void listAll() {
		log.info("전체 회원 목록");
	}
	
	// Ajax가 호출하는 메서드, 반환 타입은 json으로 설정하라는 어노테이션
	@ResponseBody
	@RequestMapping(value = "/getList", method = RequestMethod.POST)
	public List<BoardVO> getList(){
		log.info("Ajax");		
		return boardService.listAll();
	}
	// board/register.jsp 로 화면 이동
	@GetMapping("/register")
	public void registerGet() {}
	
	// Ajax, Form으로 controller접근 : 데이터 이동
	@PostMapping("/register")
	public String regiter(BoardVO board, RedirectAttributes rttr) {
		log.info("board: "+board);
		Integer bno =  boardService.registerKey(board);
//		boardService.register(board);
//		int MaxBno = boardService.getMax();
//		log.info(MaxBno);
		
		rttr.addFlashAttribute("result", bno);
		
		//이건 안됨(글이 등록된 후에 bno생성)
//		rttr.addFlashAttribute("result", board.getBno()+"글 등록 완료!!");
		
		// redirect: 클라이언트의 브라우저에게 다른 URL이동하라는 명령
		//           새로고침으로 인한 중복 요청 방지
		return "redirect:/board/list";
	}
	
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno") Integer bno, Model model) {
		model.addAttribute("vo", boardService.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, RedirectAttributes rttr) {
		int count = boardService.modify(board);
		// 수정된 튜플이 1개라면 "result"라는 name에 
		// 메세지를 바인딩시켜서 화면으로 전달
		if(count==1) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}
	
	@GetMapping("/remove")
	public String remove(@RequestParam("bno") Integer bno, RedirectAttributes rttr) {
		int count = boardService.remove(bno);
		if(count==1) {
			rttr.addFlashAttribute("result", "success");
		}
		return "redirect:/board/list";
	}

	
}
