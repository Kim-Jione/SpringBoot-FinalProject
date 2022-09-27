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
import site.metacoding.finalproject.service.PlayerService;
import site.metacoding.finalproject.web.dto.CMRespDto;
import site.metacoding.finalproject.web.dto.player.PlayerInsertReqDto;

@RequiredArgsConstructor
@Controller
public class PlayerController {
	
	private final PlayerService playerService;
	
	@GetMapping("/player")
	public String list(Model model) {
		List<Player> playerList = playerService.선수목록보기();
		model.addAttribute("playerList", playerList);
		return "player/list";
	}
	
	@GetMapping("/playerForm")
	public String playerForm(Model model) {
		return "player/saveForm";
	}
	
}