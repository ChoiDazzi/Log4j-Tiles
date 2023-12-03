package kr.letech.study.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class CommentVO {
    private String commentId;
    private String postId;
    private String userId;
    private String commentDtl;
    private Timestamp rgstDt;
    private String rgstId;
    private Timestamp updtDt;
    private String updtId;
    private char delYn;
}
