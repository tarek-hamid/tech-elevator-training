package com.techelevator.projects.model.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.DepartmentDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCDepartmentDAO implements DepartmentDAO {
	
	private JdbcTemplate jdbcTemplate;

	public JDBCDepartmentDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	private Department mapRowtoDepartment(SqlRowSet results) {
		Department department = new Department();
		department.setId(results.getLong("department_id"));
		department.setName(results.getString("name"));
		return department;
	}

	@Override
	public List<Department> getAllDepartments(){
		List<Department> allDepartments = new ArrayList();
		String sqlFindAllDepartments = "SELECT department_id, name FROM department";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllDepartments);
		while(results.next()){
			Department department = new Department();
			department = mapRowtoDepartment(results);
			allDepartments.add(department);
		}
		return allDepartments;
	}

	@Override
	public List<Department> searchDepartmentsByName(String nameSearch) {
		List<Department> allDepartments = new ArrayList();
		Department department;
		String sqlSearchDepartmentName = "SELECT department_id, name FROM department WHERE name = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlSearchDepartmentName, nameSearch);
		while(result.next()){
			department = mapRowtoDepartment(result);
			allDepartments.add(department);
		}
		return allDepartments;
	}


	@Override
	public void saveDepartment(Department updatedDepartment) {
		String sqlUpdateDepartment = "UPDATE department " +
				"SET name = ? " +
				"WHERE department_id = ?";
		jdbcTemplate.update(sqlUpdateDepartment, updatedDepartment.getName(), updatedDepartment.getId());
	}

	@Override
	public Department createDepartment(Department newDepartment) {
		String sqlInsertDepartment = "INSERT INTO department(department_id, name)" +
				"VALUES(?,?)";
		newDepartment.setId(getNextDepartmentID());
		jdbcTemplate.update(sqlInsertDepartment, newDepartment.getId(), newDepartment.getName());
		return newDepartment;
	}

	@Override
	public Department getDepartmentById(Long id) {
		Department department = new Department();
		String sqlGetDepartment = "SELECT department_id, name FROM department WHERE department_id = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sqlGetDepartment, id);
		while(result.next()) {
			department = mapRowtoDepartment(result);
		}
		return department;
	}

	private long getNextDepartmentID() {
		SqlRowSet nextIDResult = jdbcTemplate.queryForRowSet("SELECT nextval('seq_department_id')");
		if (nextIDResult.next()) {
			return nextIDResult.getLong(1);
		} else {
			throw new RuntimeException(("Something went wrong while getting the id for the new" +
					"department"));
		}
	}
}
