package com.techelevator.item;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class UserJdbcDao implements UserDao {

	private JdbcTemplate jdbcTemplate;

	public UserJdbcDao(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	// To insert a date into a prepared statement, wrap the date in
	// `Date.valueOf()`
	// method: `Date.valueOf(myObject.getCreated())`

	@Override
	public void save(User newUser) {
		// Implement this method to save user to database
		String sqlSaveUser = "INSERT INTO users(first_name, last_name, email, role, created)\n" +
				"VALUES(?, ?, ?,? ,?)";
		jdbcTemplate.update(sqlSaveUser, newUser.getFirstName(), newUser.getLastName(),
				newUser.getEmail(), newUser.getRole(), Date.valueOf(newUser.getCreated()));

	}

	@Override
	public List<User> getAllUsers() {
		List<User> userList = new ArrayList<User>();
		String sqlGetAllUsers = "SELECT * FROM users";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetAllUsers);
		while(results.next()){
			User user = mapRowToUser(results);
			userList.add(user);
		}
		return userList;
	}

	private User mapRowToUser(SqlRowSet results) {
		User userRow = new User();
		userRow.setId(results.getLong("id"));
		userRow.setFirstName(results.getString("first_name"));
		userRow.setLastName(results.getString("last_name"));
		userRow.setEmail(results.getString("email"));
		userRow.setRole(results.getString("role"));
		userRow.setCreated(results.getDate("created").toLocalDate());
		return userRow;
	}

}
