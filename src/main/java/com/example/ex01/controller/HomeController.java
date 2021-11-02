package com.example.ex01.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.ex01.service.BoardService;
import com.example.ex01.vo.BoardVO;

@Controller
public class HomeController {
	
	@Autowired
	private BoardService boardService;
	
	@GetMapping("/home")
	public String home() {
		return "/home";
	}
	
	@GetMapping("/insert")
	public String insertForm() {
		return "insert";
	}
	
	/*
	 * @GetMapping("/insert1") public String insert1() { BoardVO board = new
	 * BoardVO(); board.setTitle("title1"); board.setWriter("user00");
	 * board.setContent("content1!!!!!!!!!!!!"); boardService.insert(board);
	 * 
	 * return "redirect:list"; }
	 */
	
	@PostMapping("/insert")
	public String insert(BoardVO board) {
		boardService.insert(board);
		return "redirect:list";
	}
	
	/*
	 * @ResponseBody
	 * 
	 * @GetMapping({"","/list"}) public List<BoardVO> list(Model model) {
	 * //model.addAttribute("list", boardService.list());
	 * //model.addAttribute("count", boardService.count()); List<BoardVO> list =
	 * boardService.list(); return list; }
	 */
	
	@GetMapping({"","/list"})
	public String list(Model model) {
		model.addAttribute("lists", boardService.list());
		model.addAttribute("count", boardService.count());
		//List<BoardVO> list = boardService.list();
		return "list";
	}
	
	@GetMapping("view/{num}")
	public String view(Model model, @PathVariable int num) {
		boardService.updatehit(num);
		model.addAttribute("board", boardService.findByNum(num));
		return "view";
	}
	
	@GetMapping("update/{num}")
	public String update(Model model, @PathVariable int num) {
		model.addAttribute("board", boardService.findByNum(num));
		return "update";
	}
	
	@PutMapping("update")
	@ResponseBody
	public String update(@RequestBody BoardVO board) {
		boardService.update(board);
		return "success";
	}
	
	@DeleteMapping("delete/{num}")
	@ResponseBody
	public String delete(@PathVariable int num) {
		boardService.delete(num);
		return "success";
	}

}
