package com.acma.board.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.acma.board.domain.Board;
import com.acma.board.repository.BoardRepository;
import com.acma.board.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@Autowired
	private BoardRepository boardRepository;
	
	/*
	 * 게시글 목록
	 */
	@GetMapping("/list")
	public String list(@PageableDefault Pageable pageable, Model model) {
		model.addAttribute("boardList", boardService.findBoardList(pageable));
		return "/board/list";
	}
	
	/*
	 * 게시글 상세 및 등록 폼 호출
	 */
	@GetMapping({"", "/"})
	public String board(@RequestParam(value = "idx", defaultValue = "0") Long idx, Model model) {
		model.addAttribute("board", boardService.findBoardByIdx(idx));
		return "/board/form";
	}
	
	/*
	 * 게시글 생성
	 */
	@PostMapping
	public ResponseEntity<?> postBoard(@RequestBody Board board) {
		board.setCreatedDate(LocalDateTime.now());
		board.setUpdatedDate(LocalDateTime.now());
		boardRepository.save(board);
		
		return new ResponseEntity<>("{}", HttpStatus.CREATED);
	}
	
	/*
	 * 게시글 수정
	 */
	@PutMapping("/{idx}")
	public ResponseEntity<?> putBoard(@PathVariable("idx") Long idx, @RequestBody Board board) {
		Board updateBoard = boardRepository.getOne(idx);
		updateBoard.setTitle(board.getTitle());
		updateBoard.setContent(board.getContent());
		updateBoard.setUpdatedDate(LocalDateTime.now());
		boardRepository.save(updateBoard);
		
		return new ResponseEntity<>("{}", HttpStatus.OK);
	}
	
	/*
	 * 게시글 삭제
	 */
	@DeleteMapping("/{idx}")
	public ResponseEntity<?> deleteBoard(@PathVariable("idx") Long idx) {
		boardRepository.deleteById(idx);
		return new ResponseEntity<>("{}", HttpStatus.OK);
	}
}
