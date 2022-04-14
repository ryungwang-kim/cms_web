package com.cms.app.board.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cms.app.board.service.BoardService;

@Controller
@RequestMapping("/board") // URL 경로 
public class boardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/boardList.do")
	public String boardList(Model model) {
		
		List<Map<String, Object>> list = boardService.getBoardList();
		
		System.out.println(list);
		model.addAttribute("list", list);
		
		return "/board/boardList"; // 파일 경로
	}

	@RequestMapping("/write.do")
	public String Write(Model model, HttpSession session) {
		
		return "/board/write"; // 파일 경로
	}

	@RequestMapping(value="/writeIns.do", method=RequestMethod.POST)
	public String writeIns(@RequestParam Map<String, Object> map,  HttpSession write) {
		boardService.boardIns(map);	
		return "rediret:/board/boardList";
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public String update(@RequestParam Map<String, Object> map, Model model) {
		
		return "/board/update";
	}
	

	@RequestMapping(value="/delete.do", method=RequestMethod.POST)
	public String delete(int bid) {
		
		return "/board/delete";

	}
	

}

