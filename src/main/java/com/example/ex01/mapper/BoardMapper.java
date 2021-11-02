package com.example.ex01.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.example.ex01.vo.BoardVO;

@Mapper
public interface BoardMapper {
	public List<BoardVO> list();
	public void insert(BoardVO board);
	public int count();
	public BoardVO findByNum(int num);
	public void update(BoardVO board);
	public void delete(int num);
	public void updateHit(int num);
	public void updateReplyCnt(@Param("bnum") int bnum, @Param("amount") int amount);
}
