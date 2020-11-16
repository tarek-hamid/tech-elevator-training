package com.techelevator.projects.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.techelevator.projects.model.Department;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.jdbc.core.JdbcTemplate;

import com.techelevator.projects.model.Project;
import com.techelevator.projects.model.ProjectDAO;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCProjectDAO implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;

	public JDBCProjectDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Project> getAllActiveProjects() {
		List<Project> allProjects = new ArrayList();
		String sqlFindAllProjects = "SELECT project_id, name, from_date, to_date FROM project";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlFindAllProjects);
		while(results.next()){
			Project project = new Project();
			project = mapRowToProject(results);
			allProjects.add(project);
		}
		return allProjects;
	}

	@Override
	public void removeEmployeeFromProject(Long projectId, Long employeeId) {
		String sqlRemoveEmployee = "DELETE FROM project_employee WHERE (project_id = ? AND employee_id = ?)";
		jdbcTemplate.update(sqlRemoveEmployee, projectId, employeeId);
	}

	@Override
	public void addEmployeeToProject(Long projectId, Long employeeId) {
		String sqlAddEmployee = "INSERT INTO project_employee (project_id, employee_id) VALUES(?, ?)";
		jdbcTemplate.update(sqlAddEmployee, projectId, employeeId);
	}

	private Project mapRowToProject(SqlRowSet results) {
		Project project = new Project();
		project.setId(results.getLong("project_id"));
		project.setName(results.getString("name"));
		try {
			project.setStartDate(results.getDate("from_date").toLocalDate());
		} catch (NullPointerException exception) {
			project.setStartDate(null);
		}
		try {
			project.setEndDate(results.getDate("to_date").toLocalDate());
		} catch (NullPointerException exception) {
			project.setEndDate(null);
		}
		return project;
	}



}
