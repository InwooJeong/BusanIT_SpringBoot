package com.example.ex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ex01.mapper.BoardMapper;
import com.example.ex01.vo.BoardVO;

@Service
public class BoardServiceimpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Override
	public List<BoardVO> list() {
		// TODO Auto-generated method stub
		return boardMapper.list();
	}

	@Override
	public void insert(BoardVO board) {
		boardMapper.insert(board);
	}

	@Override
	public BoardVO findByNum(int num) {
		// TODO Auto-generated method stub
		return boardMapper.findByNum(num);
	}

	@Override
	public void update(BoardVO board) {
		// TODO Auto-generated method stub
		boardMapper.update(board);
	}

	@Override
	public void delete(int num) {
		// TODO Auto-generated method stub
		boardMapper.delete(num);
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return boardMapper.count();
	}

	@Override
	public void updatehit(int num) {
		boardMapper.updateHit(num);
	}

}
