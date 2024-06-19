package com.acma.board;

import java.time.LocalDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.acma.board.domain.Board;
import com.acma.board.repository.BoardRepository;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)
@DataJpaTest
public class JpaMappingTest {
	
	private final String title = "테스트";
	private final String content = "내용";
	
	@Autowired
	private BoardRepository boardRepository;
	
	@Before
	public void init() {
		boardRepository.save(Board.builder()
				.title(title)
				.content(content)
				.createdDate(LocalDateTime.now())
				.updatedDate(LocalDateTime.now()).build());
	}
	
	@Test
	public void test() {
		Board board = boardRepository.getOne((long) 1);
		assertThat(board.getTitle(), is(title));
		assertThat(board.getContent(), is(content));
	}
}
