package curd.SpringBootBackend.controller;

import curd.SpringBootBackend.exception.ResourceNotFoundException;
import curd.SpringBootBackend.model.Employee;
import curd.SpringBootBackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employees")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

        @GetMapping
        public List<Employee> getAllEmployees(){
        return employeeRepository.findAll();
    }

        // build create Employee Rest Api
        @PostMapping
            public  Employee createEmployee(@RequestBody Employee employee){
            return employeeRepository.save(employee);
        }

        // build get employee by id Rest Api
            @GetMapping("{id}")
            public ResponseEntity<Employee> getEmployeeId( @PathVariable long id){
            Employee employee=employeeRepository.findById(id)
                    .orElseThrow(()-> new  ResourceNotFoundException("Employee not exist with id:" + id));
            return ResponseEntity.ok(employee);
            }

            // build update employee Rest Api
                @PutMapping("{id}")
                public ResponseEntity<Employee> updateEmployee(@PathVariable long id,@RequestBody Employee employeeDetails){
                    Employee updateEmployee=employeeRepository.findById(id)
                            .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:" +id));
                    updateEmployee.setFirstName(employeeDetails.getFirstName());
                    updateEmployee.setLastName(employeeDetails.getLastName());
                    updateEmployee.setEmailId(employeeDetails.getEmailId());

                    employeeRepository.save(updateEmployee);
                    return ResponseEntity.ok(updateEmployee);
                }

                // build delete employee Rest Api
                    @DeleteMapping("{id}")
                        public ResponseEntity<HttpStatus> deleteEmployee(@PathVariable long id){
                            Employee employee=employeeRepository.findById(id)
                                    .orElseThrow(()->new ResourceNotFoundException("Employee not exist with id:" +id));

                            employeeRepository.delete(employee);
                            return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
                    }
}
