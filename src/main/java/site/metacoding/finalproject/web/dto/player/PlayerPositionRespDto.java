package site.metacoding.finalproject.web.dto.player;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class PlayerPositionRespDto {
	private List<String> colList; // vector (1차원)
	private List<List<String>> rowList; // matrix (2차원)
}