package com.prabin.springproject.controller;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.prabin.springproject.dao.EmployeeDao;
import com.prabin.springproject.model.Employee;

@Controller // request procession garchhha
public class EmployeeController {

	@Autowired
	private EmployeeDao edao;

	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String getEmployeeForm(Model model, HttpSession session) {

		if (StringUtils.isEmpty(session.getAttribute("active"))) {

			return "login";
		}

		model.addAttribute("emodel", new Employee());

		return "employeeForm";
	}

	@RequestMapping(value = "/employee", method = RequestMethod.POST)
	public String saveEmployee(@ModelAttribute Employee emp, Model model, HttpSession session) {

		if (StringUtils.isEmpty(session.getAttribute("active"))) {

			return "login";
		}

		edao.addEmp(emp);
		model.addAttribute("elist", edao.getAllEmp());

		return "home";
	}

	@RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
	public String delete(@PathVariable("id") int id, Model model, HttpSession session) {
		if (StringUtils.isEmpty(session.getAttribute("active"))) {

			return "login";
		}
		edao.deleteEmp(id);
		model.addAttribute("elist", edao.getAllEmp());

		return "home";
	}

	@RequestMapping(value = "/{id}/edit", method = RequestMethod.GET)
	public String edit(@PathVariable("id") int id, Model model, HttpSession session) {
		if (StringUtils.isEmpty(session.getAttribute("active"))) {

			return "login";
		}
		model.addAttribute("emodel", edao.getById(id));

		return "editForm";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String update(@ModelAttribute Employee emp, Model model, HttpSession session) {
		if (StringUtils.isEmpty(session.getAttribute("active"))) {

			return "login";
		}
		edao.updateEmp(emp);
		model.addAttribute("elist", edao.getAllEmp());

		return "home";
	}

	@RequestMapping(value = "/home")
	public String home(Model model, HttpSession session) {
		if (StringUtils.isEmpty(session.getAttribute("active"))) {

			return "login";
		}
		model.addAttribute("elist", edao.getAllEmp());
		return "home";
	}

}
