package com.acma.board.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table
public class Board implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1258199655423991197L;

	/*
	 * @GeneratedValue(strategy = GenerationType.IDENTITY)
	 * - 기본 키가 자동으로 할당되도록 설정하는 어노테이션이다.
	 * - 기본 키 할당 전략을 선택할 수 있는데, 키 생성을 데이터베이스에 위임하는 IDENTITY 전략을 사용한다.
	 */
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idx;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column
	private LocalDateTime createdDate;
	
	@Column
	private LocalDateTime updatedDate;
	
	@Builder
	public Board(Long idx, String title, String content, LocalDateTime createdDate, LocalDateTime updatedDate) {
		this.idx = idx;
		this.title = title;
		this.content = content;
		this.createdDate = createdDate;
		this.updatedDate = updatedDate;
	}
}
