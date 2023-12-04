package kr.letech.study.board.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class FileVO {
    private String fileId;
    private String postId;
    private String fileOrgNm;
    private String fileSaveNm;
    private long fileSize;
    private String filePath;
    private Timestamp rgstDt;
    private String rgstId;
    private Timestamp updtDt;
    private String updtId;
    private char delYn;
}
