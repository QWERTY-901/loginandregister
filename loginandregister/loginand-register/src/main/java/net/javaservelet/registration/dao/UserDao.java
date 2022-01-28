package net.javaservelet.registration.dao;
	
	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.SQLException;

	import net.javaservelet.registration.model.User;

	public class UserDao {

	    public int register(User employee)throws ClassNotFoundException {
	        String INSERT_USERS_SQL = "INSERT INTO user" +
	            "  (id, name, username, mobile_no, city, email, password) VALUES " +
	            " (?, ?, ?, ?, ?,?,?);";

	        int result = 0;

	        Class.forName("com.mysql.jdbc.Driver");

	        try (Connection connection = DriverManager
	            .getConnection("jdbc:mysql://localhost:3306/register?useSSL=false", "root", "Mysql1234#");

	            // Step 2:Create a statement using connection object
	            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL)) {
	            preparedStatement.setInt(1, 1);
	            preparedStatement.setString(2, employee.getName());
	            preparedStatement.setString(3, employee.getUsername());
	            preparedStatement.setString(4, employee.getMobile_no());
	            preparedStatement.setString(5, employee.getCity());
	            
	            
	            preparedStatement.setString(6, employee.getEmail());
	            preparedStatement.setString(7, employee.getPassword());
	            
	            System.out.println(preparedStatement);
	            // Step 3: Execute the query or update query
	            
	        
	            result = preparedStatement.executeUpdate();

	        } catch (SQLException e) {
	            // process sql exception
	            printSQLException(e);
	        }
	        return result;
	    }

	    private void printSQLException(SQLException ex) {
	        for (Throwable e: ex) {
	            if (e instanceof SQLException) {
	                e.printStackTrace(System.err);
	                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
	                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
	                System.err.println("Message: " + e.getMessage());
	                Throwable t = ex.getCause();
	                while (t != null) {
	                    System.out.println("Cause: " + t);
	                    t = t.getCause();
	                }
	            }
	        }
	    }
	}











