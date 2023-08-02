package com.sample.web.controller;

import org.springframework.beans.factory.annotation.Autowired;  
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sample.dto.UserDetailDto;
import com.sample.service.UserService;
import com.sample.utils.SessionUtils;
import com.sample.web.login.LoginUser;
import com.sample.web.login.LoginUserInfo;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/info")
	public String info(@LoginUser LoginUserInfo loginUserInfo, Model model) {
		
		UserDetailDto userDetailDto = userService.getUserDetail(loginUserInfo.getId());
		model.addAttribute("user", userDetailDto);
		
		return "user/detail";
	}
	
	@GetMapping("/delete")
	@LoginUser
	public String deleteform() {
		return "user/delete-form";     // 회원탈퇴화면의 이름을 반환한다. /WEB-INF/views/user/delete-form.jsp
	}
	
	@PostMapping("/delete")
	public String delete(@LoginUser LoginUserInfo loginUserInfo, String password) {
		// 탈퇴처리 업무로직을 호출한다.
		userService.deleteUser(loginUserInfo.getId(), password);
		// 세션에 저장된 로그인정보를 삭제한다.
		SessionUtils.removeAttribute("loginUser");
		
		return "redirect:delete-success";   // 회원탈퇴 성공화면을 재요청하는 URL을 반환한다. URL일 때는 절대경로, 상대경로가 적용되기 때문에 user/가 빠진다.
	}
	
	@GetMapping("/delete-success")
	public String deleteSuccess() {
		return "user/delete-success";    // 회원탈퇴 성공화면의 이름을 반환한다.  /WEB-INF/views/user/delete-success.jsp
	}
	
	@GetMapping("/password")
	@LoginUser
	public String passwordChangeForm() {
		return "user/password-form";
	}
	
	@PostMapping("/password")
	public String changePassword(@LoginUser LoginUserInfo loginUserInfo,
		@RequestParam(name = "oldPassword") String oldPassword,
		@RequestParam(name = "password") String password) {
		
		userService.changePassword(loginUserInfo.getId(), oldPassword, password);
		
		return "redirect:password-success";
	}
	
	@GetMapping("/password-success")
	public String passwordChangeSuccess() {
		return "user/password-success";
	}
	
	@GetMapping("/detail.json")
	@ResponseBody
	public UserDetailDto userDetail(@RequestParam("userId") String userId) {
		UserDetailDto dto = userService.getUserDetail(userId);
		
		return dto;
	}
}
