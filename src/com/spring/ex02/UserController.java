package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

//MVC중 C

// action-servlet2.xml설정파일의  userMethodNameResolver프로퍼티를 사용하려면
// 반드시~ MultiActionController클래스를 상속 받는 형태로 UserController클래스를 만들어야 함 
public class UserController extends MultiActionController {

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userID = "";
		String passwd = "";

		// getViewName() 메소드를 호출해 요청주소중에서... 확장자면 .do를 제외한 뷰 이름 리턴받기
		// ex) URL요청명이 /test/login.do 라면 -> "login"을 가져온다.
		String viewName = getViewName(request);
		
		ModelAndView mav = new ModelAndView();

		// 한글처리
		request.setCharacterEncoding("UTF-8");
		// 요청한 값 얻기
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");

		// 뷰페이지로 입력한 정보를 전달 하기 위해 임시로 ~ ModelAndView객체에 저장
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		// 확장자명을 제외한 뷰이름 저장
		mav.setViewName(viewName);

		// 디스팩처 서블릿으로 반환후 action-servlet2.xml의 InternalResourceViewResovler에게
		// result를 전달해 서... /test/result.jsp 뷰경로를 만들어서
		// 디스팩처 서블릿으로 주소를 전달후 뷰로 이동~하여 출력
		return mav;
	}

	// 회원가입창에서 전송된 회원정보를 가져온 후 ModelAndView객체를 이용해 회원정보를 바인딩하여
	// memberInfo.jsp로 저낟ㄹ하는 메소드
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글처리
		request.setCharacterEncoding("UTF-8");

		// 회원가입창에서 전송된 회원정보를 request영역에서 얻자
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		// View페이지로 응답할 데이터를 전달하기 전에..
		// 임시로 저장해 놓는 ModelAndView객체에 저장
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);

		// 또한~ View페이지의 이름을 ModelAndView객체에 저장
		mav.setViewName("memberInfo");

		return mav;
	}

	
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// 한글처리
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		String viewName = getViewName(request);
		mav.setViewName(viewName);

		return mav;
	}
	
	
	// request객체에서 URL 요청명을 가져와 .do를 제외한 요청명을 구해서 리턴하는 메소드
	private String getViewName(HttpServletRequest request) throws Exception {
		String contextPath = request.getContextPath();
		String uri = (String) request.getAttribute("javax.servlet.include.request_uri");
		if (uri == null || uri.trim().equals("")) {
			uri = request.getRequestURI();
		}

		int begin = 0;
		if (!((contextPath == null) || ("".equals(contextPath)))) {
			begin = contextPath.length();
		}

		int end;
		if (uri.indexOf(";") != -1) {
			end = uri.indexOf(";");
		} else if (uri.indexOf("?") != -1) {
			end = uri.indexOf("?");
		} else {
			end = uri.length();
		}

		String fileName = uri.substring(begin, end);
		if (fileName.indexOf(".") != -1) {
			fileName = fileName.substring(0, fileName.lastIndexOf("."));
		}
		if (fileName.lastIndexOf("/") != -1) {
			fileName = fileName.substring(fileName.lastIndexOf("/"), fileName.length());
		}
		return fileName;
	}

}
