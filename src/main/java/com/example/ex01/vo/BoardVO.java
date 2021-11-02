package com.example.ex01.vo;


import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BoardVO {
	private int num;
	private String title;
	private String writer;
	private String content;
	private Date regdate;
	private int hitcount;
	private int replycnt;
}
