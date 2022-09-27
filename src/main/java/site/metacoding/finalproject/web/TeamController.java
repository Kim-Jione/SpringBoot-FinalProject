package site.metacoding.finalproject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.finalproject.domain.stadium.Stadium;
import site.metacoding.finalproject.domain.team.Team;
import site.metacoding.finalproject.service.StadiumService;
import site.metacoding.finalproject.service.TeamService;
import site.metacoding.finalproject.web.dto.CMRespDto;
import site.metacoding.finalproject.web.dto.team.TeamInsertReqDto;

@RequiredArgsConstructor
@Controller
public class TeamController {

	private final TeamService teamService;
	private final StadiumService stadiumService;

	@GetMapping("/team")
	public String list(Model model) {
		List<Team> teamList = teamService.팀목록보기();
		model.addAttribute("teamList", teamList);
		return "team/list";
	}

	@GetMapping("/teamForm")
	public String teamForm(Model model) {
		List<Stadium> stadiumList = stadiumService.경기장목록보기();
		model.addAttribute("stadiumList", stadiumList);
		return "team/saveForm";
	}

	@PostMapping("/team")
	public @ResponseBody CMRespDto<?> insert(@RequestBody TeamInsertReqDto teamInsertReqDto) {
		teamService.팀등록하기(teamInsertReqDto);
		return new CMRespDto<>(1, "팀등록성공", null);
	}
}