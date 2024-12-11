package Day19_1012_BootMySQLCRUDBasic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import Day19_1012_BootMySQLCRUDBasic.dto.EmployeeDto;
import Day19_1012_BootMySQLCRUDBasic.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService eserv;
	
	@GetMapping("/employees")
	public ResponseEntity<List<EmployeeDto>> getAllEmp(){
		List<EmployeeDto> elist = eserv.getAllemp();
		return new ResponseEntity<>(elist,HttpStatus.OK);
	}
	
	@GetMapping("/employee/{eid}")
	public ResponseEntity<EmployeeDto> getByEmpId(@PathVariable int eid){
		try {
			EmployeeDto emp = eserv.getEmpById(eid);
			return new ResponseEntity<>(emp,HttpStatus.OK);
		}catch(Exception e) {
			throw e;
		}
	}
	
	@PutMapping("/emmployee/{eid}")
	public ResponseEntity<EmployeeDto> updateEmp(@RequestBody EmployeeDto e){
		EmployeeDto emp = eserv.updateEmp(e);
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeDto> addNewEmployee(@RequestBody EmployeeDto edto){
		EmployeeDto addnewEmp = eserv.addNew(edto);
		return new ResponseEntity<>(addnewEmp,HttpStatus.CREATED);
	}
	
	@DeleteMapping("/employee/{eid}")
	public ResponseEntity<EmployeeDto> deleteEmployee(@PathVariable int eid){
		eserv.deleteByEmpId(eid);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
