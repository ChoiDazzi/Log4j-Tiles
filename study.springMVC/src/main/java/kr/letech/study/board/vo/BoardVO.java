package kr.letech.study.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class BoardVO {
    private String boardId;		// 게시판 아이디
    private String boardNm;		// 게시판 이름
    private String rgstDt;		// 등록 일시
    private String rgstId;		// 등록 아이디
    private String updtDt;		// 수정 일시
    private String updtId;		// 수정 아이디
    private char delYn;			// 삭제 여부
}
