package com.kami.app.key.controller;

import com.kami.app.key.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * Servlet implementation class UserControler
 */
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Map<String, String[]> params = request.getParameterMap();
		String[] userName = params.get("userName");
		String[] userPw = params.get("userPw");
//		response.setCharacterEncoding("utf-8");
		if (userName==null && userPw==null) {
			response.getWriter().append("用户信息不完整！");
		}
		else{
			UserService userService = new UserService();
			boolean result = userService.checkUserAuth(userName[0], userPw[0]);
			if (result) {
				response.getWriter().append("用户信息验证成功！");
			}
			else response.getWriter().append("用户信息验证失败，请重新尝试！");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
