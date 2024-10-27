package com.employee.EmployeeApplication.service;

import com.employee.EmployeeApplication.entity.Address;
import com.employee.EmployeeApplication.entity.Employee;
import com.employee.EmployeeApplication.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {


    @Autowired
    private EmployeeRepository employeeRepository;
    List<Employee>  employeeList= new ArrayList<>(Arrays.asList(new Employee(1,"first employee","washington")
            ,new Employee(2,"second employee","new York")));


    public List<Employee> getAllEmployee(){
//        List<Employee> employees =employeeRepository.findAll();
        return employeeRepository.findAll()     ;

    }

    public Employee getEmployee(int id){
//        return employeeList.stream().filter(e ->(e.getEmployeeId()== id)).findFirst().get();

        return employeeRepository.findById(id).orElseThrow(() -> new RuntimeException("Not Found"));
    }

    public void  createEmployee(Employee employee){

        ArrayList<Address> addressArrayList = new ArrayList<>();

        for (Address address : employee.getAddresses()){
            addressArrayList.add(new Address(address.getLine1(),address.getLine2(),address.getCity(),address.getZipcode(),
                    address.getCountry(),address.getState(),employee));
        }
        employee.setAddresses(addressArrayList);


        employeeRepository.save(employee);

//        employeeList.add(employee);
    }

    public void  updateEmployee(Employee employee){
//                List<Employee> tempEmployee =new ArrayList<>();
//                for (Employee emp : employeeList){
//                    if (emp.getEmployeeId()== employee.getEmployeeId()){
//                        emp.setEmployeeName(employee.getEmployeeName());
//                        emp.setEmployeeCity(employee.getEmployeeCity());
//
//                    }
//                    tempEmployee.add(emp);
//                }
//                this.employeeList= tempEmployee;
        employeeRepository.save(employee);

    }

    public void deleteEmployee(int id){
//       ArrayList<Employee> tempEmployee = new ArrayList<>();
//        for (Employee emp : employeeList){
//            if (emp.getEmployeeId()== id)
//                continue;
//                tempEmployee.add(emp);
//        }
//        this.employeeList=tempEmployee;

        employeeRepository.deleteById(id);


    }

}
