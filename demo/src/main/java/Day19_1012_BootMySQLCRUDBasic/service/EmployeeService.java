package Day19_1012_BootMySQLCRUDBasic.service;

import java.util.List;

import Day19_1012_BootMySQLCRUDBasic.dto.EmployeeDto;

public interface EmployeeService {

	EmployeeDto addNew(EmployeeDto edto);

	EmployeeDto getEmpById(int eid);

	List<EmployeeDto> getAllemp();

	EmployeeDto updateEmp(EmployeeDto e);

	void deleteByEmpId(int eid);

}
