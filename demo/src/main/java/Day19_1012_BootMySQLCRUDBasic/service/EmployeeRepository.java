package Day19_1012_BootMySQLCRUDBasic.service;

import org.springframework.data.jpa.repository.JpaRepository;

import Day19_1012_BootMySQLCRUDBasic.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{

}
