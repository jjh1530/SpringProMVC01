package kr.bit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.bit.entity.Board;
import kr.bit.entity.Member;
import kr.bit.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper boardMapper;
	
	@Override
	public List<Board> getList() {
		return boardMapper.getList();
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
}
