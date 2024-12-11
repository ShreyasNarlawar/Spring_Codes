package Day19_1012_BootMySQLCRUDBasic.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Employee {
	@Id
	int eid;
	private String name;
	private String department;
}
