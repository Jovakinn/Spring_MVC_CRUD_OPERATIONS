package com.jovakinn.spring.mvc_hibernate.Controllers;

import com.jovakinn.spring.mvc_hibernate.DAO.Interfaces.EmployeeDAO;
import com.jovakinn.spring.mvc_hibernate.Service.interfaces.EmployeeService;
import com.jovakinn.spring.mvc_hibernate.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;

@Controller
public class MainController {
    private static final Logger log = Logger.getLogger(MainController.class.getName());

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping("/")
    public String showAllEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("allEmps", allEmployees);
        return "all-employees";
    }

    @RequestMapping("/addNewEmployee")
    public String addNewEmployee(Model model) {
        Employee employee = new Employee();
        model.addAttribute("employee", employee);
        return "employee-info";
    }

    @RequestMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute("employee") Employee employee) {
        employeeService.saveEmployee(employee);
        return "redirect:/";
    }

    @RequestMapping("/updateInfo")
    public String updateEmployee(@RequestParam("empId") Integer id, Model model) {

        Employee employee = employeeService.getEmployee(id);
        model.addAttribute("employee", employee);

        return "employee-info";
    }

    @RequestMapping("deleteEmployee")
    public String deleteEmployee(@RequestParam("empId") Integer id) {
        employeeService.deleteEmployee(id);
        return "redirect:/";
    }
}
