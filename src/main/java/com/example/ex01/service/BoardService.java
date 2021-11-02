package com.example.ex01.service;

import java.util.List;

import com.example.ex01.vo.BoardVO;

public interface BoardService {
	public List<BoardVO> list();
	public void insert(BoardVO board);
	public BoardVO findByNum(int num);
	public void update(BoardVO board);
	public void delete(int num);
	public void updatehit(int num);
	public int count();
}
