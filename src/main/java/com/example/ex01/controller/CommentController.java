package com.example.ex01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ex01.service.CommentService;
import com.example.ex01.vo.CommentVO;

@RestController
@RequestMapping("/reply/*")
public class CommentController {
	@Autowired
	private CommentService cservice;
	
	@PostMapping("commentInsert")
	public String insert(@RequestBody CommentVO comment) {
		cservice.insert(comment);
		return "success";
	}
	
	@GetMapping("commentList")
	public List<CommentVO> getList(int bnum){
		return cservice.getList(bnum);
	}
	
	@DeleteMapping("del/{cnum}")
	public int delete(@PathVariable int cnum) {
		cservice.delete(cnum);
		return cnum;
	}
	
}
