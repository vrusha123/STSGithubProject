package com.app.controller;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.app.pojos.Employee;
import com.app.service.IEmployeeServiceImpl;

@CrossOrigin(origins = "*",allowedHeaders="*")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
	@Autowired
	public IEmployeeServiceImpl service;
	
	@GetMapping
	public ResponseEntity<?> getEmployeeList()
	{
		System.out.println("in getemployeelist");
		List<Employee> list=service.findAll();
		if(list == null)
			return new ResponseEntity<String>("Invalid list",HttpStatus.NOT_FOUND);
		return new ResponseEntity<List<Employee>>(list,HttpStatus.OK);
	}
	@PostMapping
	public String addEmployee(@RequestBody Employee emp) {
		System.out.println("rest server : add employee"+emp);
		service.addEmployee(emp);
		return "employee Added";
	}
	@PostMapping("/upload")
	public ResponseEntity<String> addEmployee(@RequestParam String firstName,@RequestParam String lastName,
			@RequestParam String address,@RequestParam Date dob,
			@RequestParam String mobile,@RequestParam String city)
	{
		System.out.println("Employee with FirstName"+firstName);
		Employee m=new Employee(null, firstName, lastName, address, dob, mobile, city);
		return new ResponseEntity<>(service.addEmployee(m),HttpStatus.OK);
			
	}
	@DeleteMapping("/{empId}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int empId)
	{
		System.out.println("in delete employee "+empId);
		return new ResponseEntity<String>(service.deleteEmployee(empId),HttpStatus.OK);
	}
	@GetMapping("/update")
	public String showUpdateForm(@RequestParam int eid,Model map)
	{
			System.out.println("in show update form "+eid);
			map.addAttribute("employee",service.findAll());
			System.out.println(map);
			return "employee/update";
	}
	//request handling method for processing employee updation form
			@PostMapping("/update")
			public String processUpdateForm(Employee e,RedirectAttributes attrs)
			{
					System.out.println("in process update form "+e);
					attrs.addFlashAttribute("status", service.updateEmployeeDetail(e));
					return "redirect:/employee/list";
			}


}
