package kr.bit.entity;

import lombok.Data;

@Data
public class Board {
		
		private int idx;
		private String memID;
		private String title;
		private String content;
		private String writer;
		private String indate;
		private int count;
		private int boardGroup;
		private int boardSequence;
		private int boardLevel;
		private int boardAvailable;
		
		public int getIdx() {
			return idx;
		}
		public void setIdx(int idx) {
			this.idx = idx;
		}
		public String getMemID() {
			return memID;
		}
		public void setMemID(String memID) {
			this.memID = memID;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getWriter() {
			return writer;
		}
		public void setWriter(String writer) {
			this.writer = writer;
		}
		public String getIndate() {
			return indate;
		}
		public void setIndate(String indate) {
			this.indate = indate;
		}
		public int getCount() {
			return count;
		}
		public void setCount(int count) {
			this.count = count;
		}
		public int getBoardGroup() {
			return boardGroup;
		}
		public void setBoardGroup(int boardGroup) {
			this.boardGroup = boardGroup;
		}
		public int getBoardSequence() {
			return boardSequence;
		}
		public void setBoardSequence(int boardSequence) {
			this.boardSequence = boardSequence;
		}
		public int getBoardLevel() {
			return boardLevel;
		}
		public void setBoardLevel(int boardLevel) {
			this.boardLevel = boardLevel;
		}
		public int getBoardAvailable() {
			return boardAvailable;
		}
		public void setBoardAvailable(int boardAvailable) {
			this.boardAvailable = boardAvailable;
		}
		@Override
		public String toString() {
			return "Board [idx=" + idx + ", memID=" + memID + ", title=" + title + ", content=" + content + ", writer="
					+ writer + ", indate=" + indate + ", count=" + count + ", boardGroup=" + boardGroup
					+ ", boardSequence=" + boardSequence + ", boardLevel=" + boardLevel + ", boardAvailable="
					+ boardAvailable + "]";
		}
		
		
		
}
