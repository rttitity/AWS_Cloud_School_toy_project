package com.acma.board.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.acma.board.domain.Board;

public interface BoardService {
	Page<Board> findBoardList(Pageable pageable);
	Board findBoardByIdx(Long idx);
}
