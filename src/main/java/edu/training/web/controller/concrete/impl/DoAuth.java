package edu.training.web.controller.concrete.impl;

import java.io.IOException;

import edu.training.web.bean.AuthInfo;
import edu.training.web.bean.User;
import edu.training.web.controller.concrete.Command;
import edu.training.web.service.ServiceProvider;
import edu.training.web.service.UserService;
import edu.training.web.service.exception.ServiceAuthException;
import edu.training.web.service.exception.ServiceException;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class DoAuth implements Command {
	private final UserService userService = ServiceProvider.getInstance().getUserService();

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		User user;
		try {

			user = userService.signIn(new User(login, password));

			if (user != null) {
				HttpSession session = (HttpSession) request.getSession(true);
				session.setAttribute("user", user);

				String rememberMe = request.getParameter("remember-me");
				if (rememberMe != null) {
					Cookie cookie = new Cookie("remember-me", "user-token123");
					cookie.setHttpOnly(true);
					cookie.setSecure(true);
					response.addCookie(cookie);
				}

				response.sendRedirect("Controller?command=go_to_main_page");

			} else {
				response.sendRedirect("Controller?command=go_to_index_page&authError=Wrong login or password!");

				RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
				dispatcher.forward(request, response);
			}
		} catch (ServiceAuthException | ServiceException e) {
			response.sendRedirect("Controller?command=go_to_index_page&authError=Wrong login or password!");
		}

	}
}