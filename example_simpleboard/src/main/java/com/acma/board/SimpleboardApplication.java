package com.acma.board;

import java.time.LocalDateTime;
import java.util.stream.IntStream;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.acma.board.domain.Board;
import com.acma.board.repository.BoardRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SimpleboardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleboardApplication.class, args);
		log.info("============ start =============");
	}
	
	@Bean
	public CommandLineRunner runner(BoardRepository boardRepository) throws Exception {
		return (args) -> {
			IntStream.rangeClosed(1, 100).forEach(index ->
				boardRepository.save(Board.builder()
						.title("게시글" + index)
						.content("내용" + index)
						.createdDate(LocalDateTime.now())
						.updatedDate(LocalDateTime.now()).build()));
		};
	}
}
