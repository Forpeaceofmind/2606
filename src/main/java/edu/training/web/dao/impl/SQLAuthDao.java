package edu.training.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.training.web.bean.User;
import edu.training.web.dao.AuthDao;
import edu.training.web.dao.DaoException;
import edu.training.web.jdbc.dao.ConnectionPool;
import edu.training.web.jdbc.dao.ConnectionPoolException;

public class SQLAuthDao implements AuthDao {
	private final ConnectionPool conPool = ConnectionPool.getInstance();
	private static final String checkUser = "SELECT login, password FROM user_access_data WHERE login = ? AND password = ?";

	@Override
	public User signIn(User info) throws DaoException {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		String login = info.getLogin();
		String password = info.getPassword();

		try {
			con = conPool.takeConnection();
			pstmt = con.prepareStatement(checkUser);
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				return new User(login, password);
			} else {
				throw new DaoException("Wrong login or password");
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DaoException(e);
		} finally {
			closeResources(rs, pstmt, con);
		}
	}

	private static final String checkTokenSql = "SELECT u.id,  u.login, u.password " + "FROM tokens t "
			+ "JOIN user_access_data u ON t.user_id = u.id " + "WHERE t.token = ? AND t.expiration_date > NOW()";

	@Override
	public User checkToken(String token) throws DaoException {
		ResultSet rs = null;
		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = conPool.takeConnection();
			pstmt = con.prepareStatement(checkTokenSql);
			pstmt.setString(1, token);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				String login = rs.getString("login");
				String password = rs.getString("password");
				return new User(login, password);
			} else {
				throw new DaoException("Token not found or expired");
			}
		} catch (SQLException | ConnectionPoolException e) {
			throw new DaoException(e);
		} finally {
			closeResources(rs, pstmt, con);
		}
	}

	public void closeResources(ResultSet rs, PreparedStatement pstmt, Connection con) throws DaoException {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				throw new DaoException(e);
			}
		}
	}

}