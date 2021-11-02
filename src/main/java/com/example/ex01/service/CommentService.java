package com.example.ex01.service;

import java.util.List;

import com.example.ex01.vo.CommentVO;

public interface CommentService {
	public void insert(CommentVO comment);
	public List<CommentVO> getList(int bnum);
	public void delete(int cnum);

}
