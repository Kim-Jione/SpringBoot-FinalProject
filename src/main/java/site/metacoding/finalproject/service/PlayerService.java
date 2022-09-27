package site.metacoding.finalproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.finalproject.domain.player.Player;
import site.metacoding.finalproject.domain.player.PlayerDao;
import site.metacoding.finalproject.web.dto.player.PlayerInsertReqDto;

// 서비스는 Dao를 조합하고 트랜잭션을 관리한다
@RequiredArgsConstructor
@Service
public class PlayerService {
	
	private final PlayerDao playerDao;

	public List<Player> 선수목록보기(){
		return playerDao.findAll();
	}
	
	public void 선수등록하기(PlayerInsertReqDto playerInertReqDto) {
		playerDao.insert(playerInertReqDto.toEntity());
	}
}