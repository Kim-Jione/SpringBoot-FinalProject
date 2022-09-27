package site.metacoding.finalproject.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.finalproject.domain.stadium.Stadium;
import site.metacoding.finalproject.domain.stadium.StadiumDao;
import site.metacoding.finalproject.web.dto.stadium.StadiumInsertReqDto;

// 서비스는 Dao를 조합하고 트랜잭션을 관리한다
@RequiredArgsConstructor
@Service // IoC 등록
public class StadiumService {

	// DI
	private final StadiumDao stadiumDao;

	public List<Stadium> 경기장목록보기(){
		return stadiumDao.findAll();
	}
	// Controller는 DTO로 받고 - 유효성 검사, DAO는 Entity로 넘기자 (Insert, Update) - 유효성 검사 X
	public void 경기장등록(StadiumInsertReqDto stadiumInsertReqDto) { //Dto로 받는 이유는 엔티티로 받을 때 유효성 체크가 힘들어서 Dto로 받는 것이다. Dao한테 넘길 때는 엔티티를 넘겨 주면 된다. 앞에서 밸리데이션 체크 받을것이기 때문
		stadiumDao.insert(stadiumInsertReqDto.toEntity());
	}
}
