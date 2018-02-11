package com.spring.data.practice.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.security.Principal;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.spring.data.practice.employee.model.Employee;
import com.spring.data.practice.service.EmployeeServiceImpl;

@Named
@RequestMapping(value = "/employees")
public class EmployeeController {

	private final String UPLOAD_FOLDER = "F:\\IMAGES\\";

	@Inject
	private EmployeeServiceImpl empService;

	private boolean sortById = false;
	private boolean sortByName = false;

	@GetMapping("/upload")
	public String listUploadedFiles(Model model) throws IOException {
		return "uploadimage";
	}

	@PostMapping("/upload")
	public String handleFileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
		byte[] bytes = file.getBytes();
		Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
		Files.write(path, bytes, StandardOpenOption.CREATE);
		model.addAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		return "success";
	}

	@RequestMapping(value = "")
	public String getAllEmployeeDetails(Model model, Principal principal) {
		List<Employee> employees = empService.getAllEmployeeDetails();
		model.addAttribute("empList", employees);
		model.addAttribute("title", "SPRING BOOT VIEW");
		if(principal != null && principal.getName()!= null) {
			model.addAttribute("userName", principal.getName());
		}
		return "index";
	}

	@RequestMapping(value = "/sortById")
	public String getAllEmployeeSortById(Model model) {
		this.sortById = !sortById;
		List<Employee> employees = empService.getAllEmployeesSortById(sortById);
		model.addAttribute("empList", employees);
		model.addAttribute("title", "SPRING BOOT VIEW");
		return "index";
	}

	@RequestMapping(value = "/sortByName")
	public String getAllEmployeeSortByName(Model model) {
		this.sortByName = !sortByName;
		List<Employee> employees = empService.getAllEmployeesSortByName(sortByName);
		model.addAttribute("empList", employees);
		model.addAttribute("title", "SPRING BOOT VIEW");
		return "index";
	}

	@RequestMapping(value = "/{eid}", method = RequestMethod.GET)
	public String getEmployeeById(Model model, @PathVariable int eid) {
		Employee employee = empService.getEmployeeById(eid);
		model.addAttribute("employee", employee);
		model.addAttribute("title", "SPRING BOOT VIEW");
		return "employee";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String addEmployee(Model model) {
		model.addAttribute("title", "SPRING BOOT VIEW");
		return "addEmp";
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String addEmployee(@RequestParam("file") MultipartFile file, @RequestParam String name,
			@RequestParam String designation, Model model) {
		Employee employee = new Employee();
		employee.setName(name);
		employee.setDesignation(designation);
		String status = empService.addEmployee(employee);
		byte[] bytes;
		try {
			bytes = file.getBytes();
			Path path = Paths.get(UPLOAD_FOLDER + file.getOriginalFilename());
			Files.write(path, bytes, StandardOpenOption.CREATE);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		model.addAttribute("message", "You successfully uploaded " + file.getOriginalFilename() + "!");
		if (status.equalsIgnoreCase("SUCCESS")) {
			return "success";
		} else {
			return "error";
		}
	}

}
