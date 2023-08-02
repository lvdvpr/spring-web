package com.sample.utils;

import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

/**
 * HttpSession 객체에 속성을 저장하고, 삭제하는 기능이 제공되는 유틸리티 클래스다.
 * @author lee_e
 *
 */
public class SessionUtils {

	/**
	 * HttpSession객체에 속성을 추가한다.
	 * @param name 속성명
	 * @param value 속성값(객체)
	 */
	public static void setAttribute(String name, Object value) {   // 이름하고 값을 전해주면 Session객체에 해당이름으로 속성을 추가한다.
		getRequestAttributes().setAttribute(name, value, RequestAttributes.SCOPE_SESSION);
	}
	
	/**
	 * HttpSession객체서 지정된 속성을 삭제한다.
	 * @param name 속성명
	 */
	public static void removeAttribute(String name) {
		getRequestAttributes().removeAttribute(name, RequestAttributes.SCOPE_SESSION);
	}
	
	/**
	    * HttpSession 객체에서 지정된 속성을 반환한다.
	    * @param name 속성명
	    * @return 속성값(객체)
	    */
	   public static Object getAttribute(String name) {
	      return getRequestAttributes().getAttribute(name, RequestAttributes.SCOPE_SESSION);
	   }
	
	 // RequestAttribute는 세션객체와 Request객체의 속성을 저장하고 가져오는 등의 기능을 제공해준다.
	private static RequestAttributes getRequestAttributes() {
		return RequestContextHolder.getRequestAttributes();
	}
}
