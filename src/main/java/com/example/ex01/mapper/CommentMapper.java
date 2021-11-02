package com.example.ex01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.ex01.vo.CommentVO;

@Mapper
public interface CommentMapper {
	public List<CommentVO> getList(int bnum);
	public void insert(CommentVO comment);
	public CommentVO findByNum(int num);
	public void delete(int cnum);
}
