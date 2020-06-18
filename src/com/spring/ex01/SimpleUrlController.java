package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//action-servlet.xml설정 파일의 요청주소 /test/index.do를 처리 하기 위해 
//반드시~ Controller인터페이스를 구현 해야 하며,
//SimpleUrlController클래스로 요청시.. 
//ModelAndView객체를 생성해 응답할 JSP이름인? index.jsp로 설정하여 
//디스팩처 서블릿으로 반환한다.
public class SimpleUrlController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
									  HttpServletResponse response) throws Exception {
		//작업을 마친 후 뷰이름을 ModelAndView에 index.jsp로 설정하여 디스팩처 서블릿으로 반환한다.
		return new ModelAndView("index.jsp");
	}

	
}




