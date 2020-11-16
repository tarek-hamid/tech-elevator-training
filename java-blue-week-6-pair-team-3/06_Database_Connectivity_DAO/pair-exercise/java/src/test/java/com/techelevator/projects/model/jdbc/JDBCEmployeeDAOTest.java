package com.techelevator.projects.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.techelevator.projects.model.Department;
import com.techelevator.projects.model.Employee;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.sql.SQLException;
import java.time.LocalDate;

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCEmployeeDAOTest {

    private static SingleConnectionDataSource dataSource;
    private JDBCEmployeeDAO dao;

    @BeforeClass
    public static void setupDataSource() {
        dataSource = new SingleConnectionDataSource();
        dataSource.setUrl("jdbc:postgresql://localhost:5432/pairday1database");
        dataSource.setUsername("postgres");
        dataSource.setPassword("postgres1");
        dataSource.setAutoCommit(false);
    }

    @AfterClass
    public static void closeDataSource() throws SQLException {
        dataSource.destroy();
    }

    @Before
    public void setUp() {
        String sqlInsertCountry = "INSERT INTO employee (department_id, first_name, last_name, birth_date, gender, hire_date) VALUES (1, 'John', 'Smith', '1988-08-17', 'M', '2012-05-01')";
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sqlInsertCountry);
        dao = new JDBCEmployeeDAO(dataSource);
    }

    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    @Test
    public void CHANGE_EMPLOYEE_DEPARTMENT_TEST() {
        Employee employee = new Employee();
        employee.setId((long)2);
        employee.setDepartmentId((long)2);
        employee.setFirstName("Flo");
        employee.setLastName("Henderson");
        LocalDate date = null;
        employee.setBirthDay(date.of(1990, 12 , 28 ));
        employee.setGender('F');
        employee.setHireDate(date.of(2011, 8, 1));
        dao.changeEmployeeDepartment((long)2, (long)2);
        assertEquals(employee, dao.getEmployeesByDepartmentId((long)2).get(3));
    }
}