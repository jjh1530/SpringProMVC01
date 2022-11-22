package kr.bit.mapper;

import java.util.List;

import kr.bit.entity.Board;
import kr.bit.entity.Member;

public interface BoardMapper {
	
	public List<Board> getList();
	
	public void insert(Board vo);

	public Member login(Member vo);
}
