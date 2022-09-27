package site.metacoding.finalproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.finalproject.domain.team.Team;
import site.metacoding.finalproject.domain.team.TeamDao;
import site.metacoding.finalproject.web.dto.team.TeamInsertReqDto;

@RequiredArgsConstructor
@Service
public class TeamService {

	private final TeamDao teamDao;

	public List<Team> 팀목록보기() {
		return teamDao.findAll();
	}
	public void 팀등록하기(TeamInsertReqDto teamInertReqDto) {
		teamDao.insert(teamInertReqDto.toEntity());
	}
}
