package com.techelevator.projects.model.jdbc;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

import com.techelevator.projects.model.Department;
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

import static org.junit.Assert.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDBCDepartmentDAOTest {

    private static final String TEST_DEPARTMENT = "XYZ";

    /* Using this particular implementation of DataSource so that
     * every database interaction is part of the same database
     * session and hence the same database transaction */
    private static SingleConnectionDataSource dataSource;
    private JDBCDepartmentDAO dao;

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
        dao = new JDBCDepartmentDAO(dataSource);
    }

    @After
    public void rollback() throws SQLException {
        dataSource.getConnection().rollback();
    }

    @Test
    public void GET_DEPARTMENT_BY_ID_TEST() {
        Department department = new Department();
        department.setId((long)1);
        department.setName("Department of Redundancy Department");

        Department department1 = dao.getDepartmentById((long)1);

        assertNotNull(department1);
        assertEquals(department, department1);
    }

    @Test
    public void GET_ALL_DEPARTMENT_TEST() {
        Department department = new Department();
        department.setId((long)3);
        department.setName("Research and Development");


        assertEquals(department, dao.getAllDepartments().get(2));
    }
}