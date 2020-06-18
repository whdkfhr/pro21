package com.spring.ex02;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

//MVC�� C

// action-servlet2.xml����������  userMethodNameResolver������Ƽ�� ����Ϸ���
// �ݵ��~ MultiActionControllerŬ������ ��� �޴� ���·� UserControllerŬ������ ������ �� 
public class UserController extends MultiActionController {

	public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

		String userID = "";
		String passwd = "";

		// getViewName() �޼ҵ带 ȣ���� ��û�ּ��߿���... Ȯ���ڸ� .do�� ������ �� �̸� ���Ϲޱ�
		// ex) URL��û���� /test/login.do ��� -> "login"�� �����´�.
		String viewName = getViewName(request);
		
		ModelAndView mav = new ModelAndView();

		// �ѱ�ó��
		request.setCharacterEncoding("UTF-8");
		// ��û�� �� ���
		userID = request.getParameter("userID");
		passwd = request.getParameter("passwd");

		// ���������� �Է��� ������ ���� �ϱ� ���� �ӽ÷� ~ ModelAndView��ü�� ����
		mav.addObject("userID", userID);
		mav.addObject("passwd", passwd);
		// Ȯ���ڸ��� ������ ���̸� ����
		mav.setViewName(viewName);

		// ����ó �������� ��ȯ�� action-servlet2.xml�� InternalResourceViewResovler����
		// result�� ������ ��... /test/result.jsp ���θ� ����
		// ����ó �������� �ּҸ� ������ ��� �̵�~�Ͽ� ���
		return mav;
	}

	// ȸ������â���� ���۵� ȸ�������� ������ �� ModelAndView��ü�� �̿��� ȸ�������� ���ε��Ͽ�
	// memberInfo.jsp�� �������ϴ� �޼ҵ�
	public ModelAndView memberInfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// �ѱ�ó��
		request.setCharacterEncoding("UTF-8");

		// ȸ������â���� ���۵� ȸ�������� request�������� ����
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String name = request.getParameter("name");
		String email = request.getParameter("email");

		// View�������� ������ �����͸� �����ϱ� ����..
		// �ӽ÷� ������ ���� ModelAndView��ü�� ����
		ModelAndView mav = new ModelAndView();
		mav.addObject("id", id);
		mav.addObject("pwd", pwd);
		mav.addObject("name", name);
		mav.addObject("email", email);

		// ����~ View�������� �̸��� ModelAndView��ü�� ����
		mav.setViewName("memberInfo");

		return mav;
	}

	
	public ModelAndView memberForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		// �ѱ�ó��
		request.setCharacterEncoding("UTF-8");
		ModelAndView mav = new ModelAndView();
		String viewName = getViewName(request);
		mav.setViewName(viewName);

		return mav;
	}
	
	
	// request��ü���� URL ��û���� ������ .do�� ������ ��û���� ���ؼ� �����ϴ� �޼ҵ�
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
