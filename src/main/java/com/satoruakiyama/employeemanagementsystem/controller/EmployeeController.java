// package com.satoruakiyama.employeemanagementsystem.controller;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.satoruakiyama.employeemanagementsystem.domain.Employee;
// import com.satoruakiyama.employeemanagementsystem.service.EmployeeService;

// @Controller // This means that this class is a Controller
// public class EmployeeController {

// 	@Autowired
// 	// This means to get the bean which is auto-generated by Spring
// 	// We will use an employeeService for each
// 	EmployeeService employeeService;

// 	//	display list of employees
// 	@GetMapping("/")
// 	// This means that this method will be executed when user sends GET Requests to "/"
// 	// In our case, "http://localhost:8080/"
// 	public String viewHomePage(Model model) {

// 		//	We can use this attribute "listEmployees" to perform server-side rendering of the HTML with using Thymeleaf.
// 		//	We set all employees data as "listEmployees"
// 		model.addAttribute("listEmployees", employeeService.getAllEmployees());

// 		//		shows the index.html template:
// 		return "index";
// 	}

// 	//	showNewEmployeeForm
// 	@GetMapping("/showNewEmployeeForm")
// 	// This means that this method will be executed when user sends GET Requests to "/showNewEmployeeForm"
// 	// In our case,  "http://localhost:8080/showNewEmployeeForm"
// 	public String showNewEmployeeForm(Model model) {
// 		Employee employee = new Employee();

// 		// We can use this attribute "employee" to perform server-side rendering of the HTML with using Thymeleaf.
// 		// We set employee object as "employee"
// 		model.addAttribute("employee", employee);

// 		//	shows the new_employee.html template:
// 		return "new_employee";
// 	}

// 	//	add an employee
// 	@PostMapping("/saveEmployee")
// 	// This means that this method will be executed when user sends POST Requests to "/saveEmployee"
// 	// In our case, "http://localhost:8080/saveEmployee"
// 	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
// 		//	@ModelAttribute  binds the object called "employee" of request body from the POST request into the employee parameter of the saveEmployee() method.

// 		employeeService.saveEmployee(employee);

// 		// after save the employee data to database, redirect to "/"
// 		return "redirect:/";
// 	}

// 	//	show update form
// 	@GetMapping("/showFormForUpdate/{id}")
// 	// This means that this method will be executed when user sends GET Requests to "/showFormForUpdate/{employee's id}"
// 	// In our case, "http://localhost:8080/showFormForUpdate/{employee's id}"
// 	public String showUpdateForm(@PathVariable Long id, Model model) {
// 		// @PathVariable binds the {id} which the path of GET request contains into the id parameter of showUpdateForm() method.

// 		Employee employee = employeeService.getEmployeeById(id);

// 		//	We can use this attribute "employee" to perform server-side rendering of the HTML with using Thymeleaf.
// 		//	We set employee data as "employee"
// 		model.addAttribute("employee", employee);

// 		//	shows the update_employee.html template:
// 		return "update_employee";
// 	}

// 	//	delete the employee by id
// 	@GetMapping("/delete/{id}")
// 	// This means that this method will be executed when user sends GET Requests to "/delete/{employee's id}"
// 	//	In our case, "http://localhost:8080/delete/{employee's id}"
// 	public String deleteEmployeeById(@PathVariable Long id, Model model) {
// 		employeeService.deleteEmployeeById(id);

// 	//	after delete the employee data from database, redirect to "/"
// 		return "redirect:/";
// 	}
// }


package com.satoruakiyama.employeemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.satoruakiyama.employeemanagementsystem.domain.Employee;
import com.satoruakiyama.employeemanagementsystem.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/")
	public String showLoginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password, Model model) {
		// Here you would check the username and password against a database or other source of truth to verify the user's credentials
		// If the username and password are valid, you could set a session variable or JWT token to indicate that the user is authenticated
		// For this example, we will assume that any non-empty username and password combination is valid
		if ("admin".equals(username)  && "admin".equals(password)) {
			return "redirect:/adminhome";
		} 
		if ("user".equals(username)  && "123".equals(password)) {
			return "redirect:/userhome";
		}
		else {
			model.addAttribute("errorMessage", "Invalid username or password");
			return "login";
		}
		 
	}
	// @GetMapping("/")
	// public String showLoginPage2() {
	// 	return "login";
	// }
	// @PostMapping("/loginadmin")
	// public String login2(@RequestParam String username, @RequestParam String password, Model model) {
	// 	// Here you would check the username and password against a database or other source of truth to verify the user's credentials
	// 	// If the username and password are valid, you could set a session variable or JWT token to indicate that the user is authenticated
	// 	// For this example, we will assume that any non-empty username and password combination is valid
	// 	if (username != null && !username.isEmpty() && password != null && !password.isEmpty()) {
	// 		return "redirect:/home";
	// 	} else {
	// 		model.addAttribute("errorMessage", "Invalid username or password");
	// 		return "login";
	// 	}
	// }

	@GetMapping("/adminhome")
	public String viewAdminHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "adminindex";
	}
	@GetMapping("/userhome")
	public String viewUserHomePage(Model model) {
		model.addAttribute("listEmployees", employeeService.getAllEmployees());
		return "userindex";
	}

	// @GetMapping("/showNewEmployeeForm")
	// public String showNewEmployeeForm(Model model) {
	// 	Employee employee = new Employee();
	// 	model.addAttribute("employee", employee);
	// 	return "new_employee";
	// }
	@GetMapping("/showNewEmployeeForm")
public String showNewEmployeeForm(Model model) {
    Employee employee = Employee.getInstance();
    model.addAttribute("employee", employee);
    return "new_employee";
}

// 	@GetMapping("/showNewEmployeeForm")
// public String showNewEmployeeForm(Model model) {
//     Employee employee = Employee.getInstance();
//     model.addAttribute("employee", employee);
//     return "new_employee";
// }


	@PostMapping("/saveEmployee")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		employeeService.saveEmployee(employee);
		return "redirect:/adminhome";
	}

	// @GetMapping("/showFormForUpdate/{id}")
	// public String showUpdateForm(@PathVariable Long id, Model model) {
	// 	Employee employee = employeeService.getEmployeeById(id);
	// 	model.addAttribute("employee", employee);
	// 	return "update_employee";
	// }

	// @GetMapping("/delete/{id}")
	// public String deleteEmployeeById(@PathVariable Long id, Model model) {
	// 	employeeService.deleteEmployeeById(id);
	// 	return "redirect:/adminhome";
	// }

// 	@GetMapping("/showFormForUpdate/{id}")
// public String showUpdateForm(@PathVariable Long id, Model model) {
//     Employee employee = Employee.getInstance().getEmployeeById(id);
//     model.addAttribute("employee", employee);
//     return "update_employee";
// }
@GetMapping("/showFormForUpdate/{id}")
public String showUpdateForm(@PathVariable Long id, Model model) {
    Employee employee = employeeService.getEmployeeById(id);
    model.addAttribute("employee", employee);
    return "update_employee";
}


// @GetMapping("/delete/{id}")
// public String deleteEmployeeById(@PathVariable Long id, Model model) {
//     Employee.getInstance().deleteEmployeeById(id);
//     return "redirect:/adminhome";
// }
@GetMapping("/delete/{id}")
public String deleteEmployeeById(@PathVariable Long id, Model model) {
    employeeService.deleteEmployeeById(id);
    return "redirect:/adminhome";
}


}
