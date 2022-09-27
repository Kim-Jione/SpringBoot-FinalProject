package site.metacoding.finalproject.domain.player;

import java.sql.Timestamp;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Player {
	private Integer id;
	private String name;
	private String position;
	private Integer teamId;
	private boolean isOuter; // 참, 거짓으로 퇴출선수를 가려냄으로 따로 테이블을 만들지 않아도 된다
	private Timestamp createdAt;
	
	// 엔티티가 아닌 필드(trasient)
	private Integer no;
	private String teamName;
}
