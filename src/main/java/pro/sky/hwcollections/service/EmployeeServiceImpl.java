package pro.sky.hwcollections.service;

import org.springframework.stereotype.Service;
import pro.sky.hwcollections.Employee;
import pro.sky.hwcollections.exception.EmployeeAlreadyAddedException;
import pro.sky.hwcollections.exception.EmployeeNotFoundException;
import pro.sky.hwcollections.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final int CAPACITY = 5;
    private final List<Employee> employeeList = new ArrayList<>(CAPACITY);

    @Override
    public Employee addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employeeList.size() == CAPACITY) {
            throw new EmployeeStorageIsFullException();
        } else if (employeeList.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        } else {
            employeeList.add(employee);
            return employee;
        }
    }

    @Override
    public Employee deleteEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employeeList.remove(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }

    @Override
    public Employee searchEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);

        if (employeeList.contains(employee)) {
            return employee;
        }
        throw new EmployeeNotFoundException();
    }
}
