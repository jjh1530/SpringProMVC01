package kr.bit.service;

import java.util.List;

import kr.bit.entity.Board;
import kr.bit.entity.Member;

public interface BoardService {

	public List<Board> getList();
	
	public Member login(Member vo);
	
	public void insert(Board vo);

	public void insertSelectKey(Board vo);
	
	public Board read(int idx);
	
	public void modify(Board vo);
	
	public void remove(int idx);
}
