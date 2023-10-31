package pro.sky.hwcollections.controller;

import org.springframework.web.bind.annotation.*;
import pro.sky.hwcollections.Employee;
import pro.sky.hwcollections.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee addEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping("/remove")
    public Employee deleteEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.deleteEmployee(firstName, lastName);
    }

    @GetMapping("/find")
    public Employee searchEmployee(@RequestParam String firstName, @RequestParam String lastName) {
        return employeeService.searchEmployee(firstName, lastName);
    }
}
