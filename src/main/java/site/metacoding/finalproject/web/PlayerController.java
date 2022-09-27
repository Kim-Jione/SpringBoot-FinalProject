package site.metacoding.finalproject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.finalproject.domain.player.Player;
import site.metacoding.finalproject.domain.team.Team;
import site.metacoding.finalproject.service.PlayerService;
import site.metacoding.finalproject.service.TeamService;
import site.metacoding.finalproject.web.dto.CMRespDto;
import site.metacoding.finalproject.web.dto.player.PlayerInsertReqDto;
import site.metacoding.finalproject.web.dto.player.PlayerPositionRespDto;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	private final TeamService teamService;
	
	@GetMapping("/test/player/position")
	public @ResponseBody PlayerPositionRespDto positionTest() {
		return playerService.포지션별팀찾기();
	}
	
	@GetMapping("/player/position")
	public String position(Model model) {		
		PlayerPositionRespDto playerPositionRespDto =  playerService.포지션별팀찾기();
		model.addAttribute("playerPositionRespDto", playerPositionRespDto);
		return "player/positionList";
	}
	
	@GetMapping("/player")
	public String list(Model model) {
		List<Player> playerList = playerService.선수목록보기();
		model.addAttribute("playerList", playerList);
		return "player/list";
	}
	
	@GetMapping("/playerForm")
	public String playerForm(Model model) {
		List<Team> teamList = teamService.팀목록보기();
		model.addAttribute("teamList", teamList);
		return "player/saveForm";
	}
	
	@PostMapping("/player")
	public @ResponseBody CMRespDto<?> insert(@RequestBody PlayerInsertReqDto playerInsertReqDto){
		playerService.선수등록하기(playerInsertReqDto);
		return new CMRespDto<>(1, "선수등록성공", null);
	}
}
