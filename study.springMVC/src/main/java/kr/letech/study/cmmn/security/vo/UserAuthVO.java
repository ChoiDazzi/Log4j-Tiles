package kr.letech.study.cmmn.security.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@Setter
@ToString
public class UserAuthVO {
	private String userId;
	private String roleId;
    private Timestamp rgstDt;
    private String rgstId;
    private Timestamp updtDt;
    private String updtId;
    private char delYn;
}
