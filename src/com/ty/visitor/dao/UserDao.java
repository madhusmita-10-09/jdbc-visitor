package com.ty.visitor.dao;

import java.sql.Connection;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.visitor.dto.User;
import com.ty.visitor.util.AES;
import com.ty.visitor.util.ConnectionObject;
import static com.ty.visitor.util.AppConstatnts.*;

public class UserDao {
	
	public int saveUser(User user) {

		String sql = "INSERT INTO user1 VALUES (?,?,?,?,?,?)";
		Connection connection = ConnectionObject.getConnection();
		String enc = AES.encrypt(user.getPassword(), SCERECET_KEY);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, user.getId());
			preparedStatement.setString(2, user.getName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, enc);
			preparedStatement.setInt(5, user.getPhone());
			preparedStatement.setString(6, user.getRole());

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (connection != null)
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return 0;
	}

//	public User getUserById(int id) {
//		String query = "SELECT * FROM user WHERE id = ?";
//		Connection connection = ConnectionObject.getConnection();
//		try {
//
//			PreparedStatement preparedStatement = connection.prepareStatement(query);
//			preparedStatement.setInt(1, id);
//
//			ResultSet resultSet = preparedStatement.executeQuery();
//			if (resultSet.next()) {
//				User user = new User();
//				user.setId(resultSet.getInt(1));
//				user.setName(resultSet.getString(2));
//				user.setEmail(resultSet.getString(3));
//				user.setPhone(resultSet.getInt(5));
//				return user;
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (connection != null)
//				try {
//					connection.close();
//
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//		}
//		return null;
//	}
//
//	public List<User> getAllUser() {
//		String query = "SELECT * FROM user";
//		List<User> list = new ArrayList<User>();
//		Connection connection = ConnectionObject.getConnection();
//		try {
//			PreparedStatement preparedStatement = connection.prepareStatement(query);
//			ResultSet resultSet = preparedStatement.executeQuery();
//			while (resultSet.next()) {
//				User user = new User();
//				user.setId(resultSet.getInt(1));
//				user.setName(resultSet.getString(2));
//				user.setEmail(resultSet.getString(3));
//				user.setPhone(resultSet.getInt(5));
//				list.add(user);
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			if (connection != null)
//				try {
//					connection.close();
//
//				} catch (SQLException e) {
//					e.printStackTrace();
//				}
//		}
//		return list;
//	}

	public int updateUser(int id, User user) {
		String query = "UPDATE user1 SET name = ?, email = ?,password = ?, phone = ?, role = ? where id = ?";
		Connection connection = ConnectionObject.getConnection();
		String enc = AES.encrypt(user.getPassword(), SCERECET_KEY);
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, user.getName());
			preparedStatement.setString(2, user.getEmail());
			preparedStatement.setString(3, enc);
			preparedStatement.setInt(4, user.getPhone());
			preparedStatement.setString(5, user.getRole());
			preparedStatement.setInt(6, user.getId());

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();

		} finally {
			if (connection != null)
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return 0;
	}

	public int deleteUser(int id) {
		String sql = "DELETE TABLE user1 WHERE id = ?";
		Connection connection = ConnectionObject.getConnection();
		try {

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, id);

			return preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (connection != null)
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return 0;
	}

	public User validateUser(String email, String password) {
		String sql = "SELECT * FROM user1 WHERE email = ? AND password = ?";
		String enc = AES.encrypt(password, SCERECET_KEY);
		Connection connection = ConnectionObject.getConnection();
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, email);
			preparedStatement.setString(2, enc);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				User user = new User();
				user.setId(resultSet.getInt(1));
				user.setName(resultSet.getString(2));
				user.setEmail(resultSet.getString(3));
				user.setPhone(resultSet.getInt(5));
				preparedStatement.setString(6, user.getRole());
				return user;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			if (connection != null)
				try {
					connection.close();

				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
		return null;
	}
}



