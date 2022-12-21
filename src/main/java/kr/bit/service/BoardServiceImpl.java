package kr.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.entity.Board;
import kr.bit.entity.Criteria;
import kr.bit.entity.Member;
import kr.bit.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<Board> getList(Criteria cri) {
		return boardMapper.getList(cri);
	}
	
	@Override
	public Member login(Member vo) {
		return boardMapper.login(vo);
	}
	
	@Override
	public void insert(Board vo) {
		boardMapper.insert(vo);
	}
	
	@Override
	public void insertSelectKey(Board vo) {
		boardMapper.insertSelectKey(vo);
	}
	
	@Override
	public Board read(int idx) {
		return boardMapper.read(idx);
	}
	
	@Override
	public void modify(Board vo) {
		boardMapper.update(vo);
	}
	
	@Override
	public void remove(int idx) {
		boardMapper.delete(idx);
	}
	
	@Override
	public void reply(Board vo) {
		// 답글
		// 1. 원글의 정보 가져오기
		Board parent = boardMapper.read(vo.getIdx());
		// 2. 부모글의 boardGroup의 값 -> 답글(vo)에 저장
		vo.setBoardGroup(parent.getBoardGroup());
		// 3.부모글의 boardSequence의 값 1을 더해서 답글에 저장
		vo.setBoardSequence(parent.getBoardSequence() +1);
		// 4.부모글의 boardLevel 값 1을 더해서 답글에 저장
		vo.setBoardLevel(parent.getBoardLevel() +1);
		// 5. 같은 boardGroup에 있는 글중에서 부모글의 boardSequence 보다 큰 값들을 모두 1씩 증가
		boardMapper.replySeqUpdate(parent);
		//6. 답글 insert
		boardMapper.replyInsert(vo);
	}
	
	@Override
	public int totalCount(Criteria cri) {
		return boardMapper.totalCount(cri);
	}
}
