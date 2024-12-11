package Day19_1012_BootMySQLCRUDBasic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Day19_1012_BootMySQLCRUDBasic.dto.EmployeeDto;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	
	@Autowired
	private EmployeeRepository erepo;
	@Override
	public EmployeeDto addNew(EmployeeDto edto) {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public EmployeeDto getEmpById(int eid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeeDto> getAllemp() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeeDto updateEmp(EmployeeDto e) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteByEmpId(int eid) {
		// TODO Auto-generated method stub
		
	}

}
