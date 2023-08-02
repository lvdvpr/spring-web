package com.sample.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sample.service.UserService;
import com.sample.utils.SessionUtils;
import com.sample.vo.User;
import com.sample.web.login.LoginUserInfo;
import com.sample.web.request.UserRegisterForm;

@Controller
public class HomeController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/home")
	public String home() {
		// 내부이동할 뷰페이지 이름을 반환한다. 
		return "home";
	}
	
	@GetMapping("/register")
	public String registerform() {
		return "register-form";
	}
	
	@PostMapping("/register")
	public String register(UserRegisterForm userRegisterForm) {
		userService.registerUser(userRegisterForm);
		return "redirect:success"; 
	}

	/*
	public String register(UserRegisterForm userRegisterForm, Model model) {
		try{
			userService.registerUser(userRegisterForm);
		} catch (RuntimeException e) {
			model.addAttribute("message", e.getMessage());
			return "register-form";           // "redirect:register"로 적어도 됨
		}
		return "redirect:success";
	}
	*/
	
	@GetMapping("/success")
	public String success() {
		return "success";
	}
	
	@GetMapping("/login")
	public String loginform() {
		return "login-form";
	}
	
	/*
	 * 요청핸들러 메소드의 매개변수가 기본자료형 혹은 String형 인 경우
	 * 		매개변수의 이름과 동일한 이름으로 요청파라미터 값을 조회해서 매개변수로 전달한다. (매개변수이름은 .jsp에서 name으로 정해준 이름을 쓴다.)
	 * 		매개변수의 타입이 기본자료형 타입인 경우 해당 타입으로 형변환해서 전달한다. (예를 들어, 문자로 온걸 int로 바꿔준다.)
	 * 		매개변수의 타입이 기본자료형(정수,실수,문자,불린)일 때,
	 * 		요청파라미터값이 존재하지 않으면 오류가 발생한다.
	 * 		요청파라미터값을 해당 타입으로 변환할 수 없을 때 오류가 발생한다.
	 * @RequestParam
	 * 		요청파라미터값을 요청핸들러의 매개변수와 매핑시키는 어노테이션이다.
	 * 		주요 속성
	 * 			name			: 요청파라미터의 이름을 지정한다.
	 * 			required		: 기본값은 true다. false로 지정하면 name에 지정한 요청파라미터값이 없어도 오류가 발생하지 않는다.
	 * 			defaultValue	: name에 지정한 요청파라미터값이 존재하지 않을 때 매개변수로 대입되는 기본값을 설정한다.
	 * 							  defaultValue의 값은 문자열로 설정되지만 매개변수에 대입될 때는 해당 타입으로 형변환된다.
	 * 			public String list(@RequestParam(name="page", required=false, defaultValue="1") int page,
	 * 							   @RequestParam(name="rows", required=false, defaultValue="10") int rows,
	 * 							   @RequestParam(name="sort", required=false, defaultValue="date") String sort,
	 * 								String opt,
	 * 								String keyword) 
	 * 
	 * 요청핸들러 메소드의 매개변수로 가능한 객체 및 어노테이션
	 * 		HttpServletRequest		요청객체
	 * 		HttpServletResponse		응답객체
	 * 		HttpSession				세션객체
	 * 		WebRequest				Spring 제공하는 객체다. 요청객체가 가지고 있는 정보 대부분을 제공하는 객체다.
	 * 		TimeZone				시간정보
	 * 		Locale					지역정보(국가, 언어)
	 * 		InputStream				클라이언트와 연결된 읽기 전용 스트림
	 * 		OutputStream			클라이언트와 연결된 쓰기 전용 스트림
	 * 		Reader					클라이언트와 연결된 텍스트 읽기 전용 스트림
	 * 		Writer					클라이언트와 연결된 텍스트 쓰기 전용 스트림
	 * 		@RequestParam			요청파라미터와 매개변수를 매핑시키는 어노테이션
	 * 		@PathVariable			요청 URL 경로에 포함된 파라미터값과 매개변수를 매핑시키는 어노테이션
	 * 		@ModelAttribute			요청파라미터와 해당값을 저장하는 객체를 매핑시키는 어노테이션
	 * 		@RequestBody			요청메세지의 바디부 정보와 매개변수를 매핑시키는 어노테이션
	 * 		@Valid					요청파라미터값의 유효성 여부를 검증시키는 어노테이션
	 * 		Model					뷰에 전달할 정보를 저장하는 객체
	 * 		Errors					요청파라미터값의 유효성 검증 결과를 저장하는 객체
	 * 		BindingResult			요청파라미터값의 유효성 검증 결과를 저장하는 객체
	 * 		SessionStatus			세션에 저장된 정보를 삭제하는 객체
	 * 		기본자료형					요청파라미터값을 전달받는다.	
	 * 		String					요청파라미터값을 전달받는다.
	 * 		사용자정의 객체				요청파라미터값을 전달받는다.
	 */
	@PostMapping("/login")
	public String login(String id, String password) {
		// 아이디, 비밀번호로 로그인 검증
		User user = userService.login(id, password);
		
		// HttpSession 객체에 로그인 절차가 완료된 사용자 정보를 저장한다.
		LoginUserInfo loginUserInfo = new LoginUserInfo(user.getId(), user.getName());
		SessionUtils.setAttribute("loginUser", loginUserInfo);
		
		return "redirect:home";
	}
	
	/*
	 * 요청 URL 매핑하기
	 * 	요청URL과 요청핸들러 메소드를 매핑시키는 어노테이션
	 * 		@RequestMapping : 요청방식에 상관없이 요청 URL을 기준으로 매핑시킨다.
	 * 		@GetMapping 	: 요청방식에 GET 방식이고 요청 URL이 일치하는 요청핸들러 메소드와 매핑시킨다. 
	 * 		@PostMapping	: 요청방식이 POST 방식이고 요청 URL이 일치하는 요청핸들러 메소드와 매핑시킨다.
	 * 		@PutMapping		: 요청방식이 PUT 방식이고 요청 URL이 일치하는 요청핸들러 메소드와 매핑시킨다.
	 * 		@DeleteMapping	: 요청방식이 DELETE 방식이고 요청 URL이 일치하는 요청핸들러 메소드와 매핑시킨다.
	 * 
	 * 요청방식
	 * 		GET		: 서버에서 정보를 조회하는 요청
	 * 		POST	: 서버에 정보를 추가하는 요청
	 * 		PUT		: 서버의 정보를 변경하는 요청
	 * 		DELETE	: 서버의 정보를 삭제하는 요청
	 * 	* 일반적인 웹 애플리케이션에서는 GET, POST 두가지 방식을 사용한다.
	 * 	* Rest 방식의 웹 애플리케이션에서는 GET, POST, PUT, DELETE 방식을 전부 사용한다.
	 */
	@RequestMapping("/logout")
	public String logout() {
		// HttpSession객체에서 로그인된 사용자 정보를 삭제한다.
		SessionUtils.removeAttribute("loginUser");
		
		return "redirect:home";
	}
}
