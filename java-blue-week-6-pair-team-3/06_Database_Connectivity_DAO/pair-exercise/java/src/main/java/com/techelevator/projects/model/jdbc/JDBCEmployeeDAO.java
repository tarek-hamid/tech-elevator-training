package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Employee;
import com.techelevator.projects.model.EmployeeDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCEmployeeDAO implements EmployeeDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCEmployeeDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> allEmployees = new ArrayList();
		String sqlFindAllEmployees = "SELECT employee_id, department_id, first_name," +
				"last_name, birth_date, gender, hire_date FROM employee";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllEmployees);
		while(results.next()){
			Employee employee = new Employee();
			employee = mapRowToEmployee(results);
			allEmployees.add(employee);
		}
		return allEmployees;
	}

	@Override
	public List<Employee> searchEmployeesByName(String firstNameSearch, String lastNameSearch) {
		List<Employee> employeeSearch = new ArrayList();
		String sqlSearchEmployee = "SELECT employee_id, department_id, first_name," +
				"last_name, birth_date, gender, hire_date FROM employee WHERE first_name = ? AND last_name = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSearchEmployee, firstNameSearch, lastNameSearch);
		Employee employee = new Employee();
		while(result.next()) {
			employee = mapRowToEmployee(result);
			employeeSearch.add(employee);
		}
		return employeeSearch;
	}

	@Override
	public List<Employee> getEmployeesByDepartmentId(long id) {
		List<Employee> employeeSearch = new ArrayList();
		Employee employee = new Employee();
		String sqlGetEmployee = "SELECT employee_id, department_id, first_name," +
		"last_name, birth_date, gender, hire_date FROM employee WHERE department_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetEmployee, id);
		while(result.next()) {
			employee = mapRowToEmployee(result);
			employeeSearch.add(employee);
		}
		return employeeSearch;
	}

	@Override
	public List<Employee> getEmployeesWithoutProjects() {
		List<Employee> employeeSearch = new ArrayList();
		Employee employee = new Employee();
		String sqlGetEmployee = "SELECT employee.employee_id, employee.department_id, employee.first_name, employee.last_name, employee.birth_date, employee.gender, employee.hire_date " +
				"FROM employee FULL JOIN project_employee ON employee.employee_id = project_employee.employee_id " +
				"WHERE project_id IS NULL";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetEmployee);
		while(result.next()) {
			employee = mapRowToEmployee(result);
			employeeSearch.add(employee);
		}
		return employeeSearch;
	}

	@Override
	public List<Employee> getEmployeesByProjectId(Long projectId) {
		List<Employee> employeeSearch = new ArrayList();
		Employee employee = new Employee();
		String sqlGetEmployee = "SELECT employee.employee_id, employee.department_id, employee.first_name, employee.last_name, employee.birth_date, employee.gender, employee.hire_date\n" +
				"FROM employee\n" +
				"FULL JOIN project_employee ON employee.employee_id = project_employee.employee_id\n" +
				"WHERE project_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetEmployee, projectId);
		while(result.next()) {
			employee = mapRowToEmployee(result);
			employeeSearch.add(employee);
		}
		return employeeSearch;
	}

	@Override
	public void changeEmployeeDepartment(Long employeeId, Long departmentId) {
		String sqlUpdateEmployeeDepartment = "UPDATE employee " +
				"SET department_id = ? " +
				"WHERE employee_id = ?";
		jdbcTemplate.update(sqlUpdateEmployeeDepartment, departmentId, employeeId);
	}

	private Employee mapRowToEmployee(SqlRowSet results) {
		Employee employee = new Employee();
		employee.setId(results.getLong("employee_id"));
		try {
			employee.setDepartmentId(results.getLong("department_id"));
		} catch(NullPointerException exception) {
			employee.setDepartmentId(null);
		}
		employee.setFirstName(results.getString("first_name"));
		employee.setLastName(results.getString("last_name"));
		employee.setBirthDay(results.getDate("birth_date").toLocalDate());
		employee.setGender(results.getString("gender").charAt(0));
		employee.setHireDate(results.getDate("hire_date").toLocalDate());
		return employee;
	}

}
