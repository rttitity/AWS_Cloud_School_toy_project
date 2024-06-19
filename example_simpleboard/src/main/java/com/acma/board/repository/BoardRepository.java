package com.acma.board.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.acma.board.domain.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
}