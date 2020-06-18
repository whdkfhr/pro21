package com.spring.ex01;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


//action-servlet.xml���� ������ ��û�ּ� /test/index.do�� ó�� �ϱ� ���� 
//�ݵ��~ Controller�������̽��� ���� �ؾ� �ϸ�,
//SimpleUrlControllerŬ������ ��û��.. 
//ModelAndView��ü�� ������ ������ JSP�̸���? index.jsp�� �����Ͽ� 
//����ó �������� ��ȯ�Ѵ�.
public class SimpleUrlController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, 
									  HttpServletResponse response) throws Exception {
		//�۾��� ��ģ �� ���̸��� ModelAndView�� index.jsp�� �����Ͽ� ����ó �������� ��ȯ�Ѵ�.
		return new ModelAndView("index.jsp");
	}

	
}




