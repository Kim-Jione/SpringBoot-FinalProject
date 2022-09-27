package site.metacoding.finalproject.web.dto.player;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.finalproject.domain.player.Player;
import site.metacoding.finalproject.domain.stadium.Stadium;

@Setter
@Getter
public class PlayerInsertReqDto {
	private String name;
	
	public Player toEntity() {
		Player player = new Player();
		player.setName(this.name);
		return player;
	}
}
