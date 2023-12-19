package curd.SpringBootBackend;

import curd.SpringBootBackend.model.Employee;
import curd.SpringBootBackend.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootBackendApplication.class, args);

	}
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public void run(String... args) throws Exception {
		Employee employee=new Employee();
		employee.setFirstName("Vishal");
		employee.setLastName("Chhoker");
		employee.setEmailId("vishalchhoker1517@gmail.com");
		employeeRepository.save(employee);

		Employee employee1=new Employee();
		employee1.setFirstName("Ravi");
		employee1.setLastName("Raman");
		employee1.setEmailId("raviraman5@gmail.com");
		employeeRepository.save(employee1);

	}
}
