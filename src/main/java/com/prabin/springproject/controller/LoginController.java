package com.prabin.springproject.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prabin.springproject.HomeController;
import com.prabin.springproject.dao.EmployeeDao;
import com.prabin.springproject.dao.UserDao;
import com.prabin.springproject.model.User;

@Controller
public class LoginController {
	
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

	@Autowired // creates object
	private UserDao udao; // UserDao udao = new UserDaoImpl();

	@Autowired
	private EmployeeDao edao;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String getLoginForm() {
		
		logger.info("inside login form method");

		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String checkUser(@ModelAttribute User user, Model model, HttpSession session) {

		user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));
		User u = udao.login(user.getUsername(), user.getPassword());

		if (u != null) {

			logger.info("login success");
			session.setAttribute("active", u.getFname());
			session.setMaxInactiveInterval(200);

			model.addAttribute("un", user.getUsername());
			model.addAttribute("elist", edao.getAllEmp());

			return "home";
		}

		logger.info("login failed");
		model.addAttribute("error", "user does not exist!!");

		return "login";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) {
		logger.info("user logout success");
		session.invalidate();

		return "login";
	}

	@RequestMapping(value = "/facebook", method = RequestMethod.GET)
	public String fbLogin() {

		return "redirect:https://www.facebook.com/dialog/oauth?client_id=181835896449197&redirect_uri=http://localhost:8080/springproject/authorize/facebook&response_type=code&scope=email";
	}

	@RequestMapping(value = "/authorize/facebook", method = RequestMethod.GET)
	public String saveFbUser(String code, Model model, HttpServletRequest request) {

		model.addAttribute("elist", edao.getAllEmp());

		return "home";

	}

}
