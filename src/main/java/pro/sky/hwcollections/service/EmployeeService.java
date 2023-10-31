package pro.sky.hwcollections.service;

import pro.sky.hwcollections.Employee;

public interface EmployeeService {
    Employee addEmployee(String firstName, String lastName);

    Employee deleteEmployee(String firstName, String lastName);

    Employee searchEmployee(String firstName, String lastName);
}
