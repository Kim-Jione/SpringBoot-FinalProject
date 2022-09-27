package site.metacoding.finalproject.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;
import site.metacoding.finalproject.domain.stadium.Stadium;
import site.metacoding.finalproject.service.StadiumService;

@RequiredArgsConstructor
@Controller
public class StadiumController {

	private final StadiumService stadiumService;

	@GetMapping("/stadium")
	public String list(Model model) {
		List<Stadium> stadiumList = stadiumService.목록보기();
		model.addAttribute("stadiumList", stadiumList);
		return "stadium/list";
	}
}
