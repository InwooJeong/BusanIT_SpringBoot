package com.example.ex01.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.ex01.mapper.BoardMapper;
import com.example.ex01.mapper.CommentMapper;
import com.example.ex01.vo.CommentVO;

@Service
//@RequiredArgsConstructor
public class CommentServiceimpl implements CommentService {

	@Autowired
	private CommentMapper cmapper;
	@Autowired
	private BoardMapper bmapper;
	
	@Override
	@Transactional
	public void insert(CommentVO comment) {
		// TODO Auto-generated method stub
		comment.setUserid("userid");
		cmapper.insert(comment);
		bmapper.updateReplyCnt(comment.getBnum(), 1);
	}

	@Override
	public List<CommentVO> getList(int bnum) {
		// TODO Auto-generated method stub
		return cmapper.getList(bnum);
	}

	@Override
	public void delete(int cnum) {
		// TODO Auto-generated method stub
		CommentVO comment = cmapper.findByNum(cnum);
		bmapper.updateReplyCnt(comment.getBnum(), -1);
		cmapper.delete(cnum);
	}

}
