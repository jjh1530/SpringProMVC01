package kr.bit.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.bit.entity.Board;
import kr.bit.entity.Criteria;
import lombok.extern.log4j.Log4j;

@Log4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class BoardServiceTest {

	@Autowired
	BoardService boardService;
	
	@Test
	public void testGetList() {
		Criteria cri = new Criteria();
		List<Board> list = boardService.getList(cri);
		for(Board vo : list) {
			System.out.println(vo);
		}
	}
}
