package site.metacoding.finalproject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import site.metacoding.finalproject.domain.stadium.Stadium;
import site.metacoding.finalproject.service.StadiumService;
import site.metacoding.finalproject.web.dto.CMRespDto;
import site.metacoding.finalproject.web.dto.stadium.StadiumInsertReqDto;

@RequiredArgsConstructor
@Controller
public class StadiumController {

	private final StadiumService stadiumService;

	@GetMapping({ "/", "/stadium" })
	public String list(Model model) {
		List<Stadium> stadiumList = stadiumService.경기장목록보기();
		model.addAttribute("stadiumList", stadiumList);
		return "stadium/list";
	}
	
	@DeleteMapping("/stadium/{id}")
	public @ResponseBody CMRespDto<?> delete(@PathVariable Integer id){
		stadiumService.경기장삭제하기(id);
		return new CMRespDto<>(1, "경기장삭제성공", null);
	}

	@GetMapping("/stadiumForm")
	public String stadiumForm() {
		return "stadium/saveForm";
	}

	@PostMapping("/stadium")
	public @ResponseBody CMRespDto<?> insert(@RequestBody StadiumInsertReqDto stadiumInsertReqDto) {
		stadiumService.경기장등록하기(stadiumInsertReqDto);
		return new CMRespDto<>(1, "경기장등록성공", null);
	}
}
