package kr.letech.study.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class PostVO {
    private String postId;
    private String boardId;
    private String userId;
    private String userNm;
    private String postTtl;
    private String postCnt;
    private Timestamp rgstDt;
    private String rgstId;
    private Timestamp updtDt;
    private String updtId;
    private char delYn;
}
