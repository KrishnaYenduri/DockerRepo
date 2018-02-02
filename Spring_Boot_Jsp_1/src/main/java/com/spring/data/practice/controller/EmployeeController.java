package com.spring.data.practice.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

	static List<Employee> employees = new ArrayList<Employee>();

	@RequestMapping(value = "")
	public String getAllEmployeeDetails(Model model) {
		model.addAttribute("empList", employees);
		model.addAttribute("title", "SPRING BOOT VIEW");
		return "index";
	}

	@RequestMapping(value = "/getEmpById/{eid}", method = RequestMethod.GET)
	public String getEmployeeById(Model model, @PathVariable int eid) {
		for (Employee e : employees) {
			if (e.getEid() == eid) {
				model.addAttribute("employee", e);
			}
		}
		model.addAttribute("title", "SPRING BOOT VIEW");
		return "employee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("title", "SPRING BOOT VIEW");
		return "addEmp";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@RequestParam int eid, @RequestParam String name, @RequestParam String designation) {
		Employee employee = new Employee(eid, name, designation);
		employees.add(employee);
		return "redirect:";
	}

}
