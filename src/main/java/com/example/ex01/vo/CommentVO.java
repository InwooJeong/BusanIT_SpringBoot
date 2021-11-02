package com.example.ex01.vo;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentVO {
	private int cnum;
	private String userid;
	private String content;
	@JsonFormat(shape = Shape.STRING, pattern="yyyy-MM-dd", timezone="Asia/Seoul")
	private Date regdate;
	private int bnum;
	
}
