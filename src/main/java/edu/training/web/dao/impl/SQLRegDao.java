package edu.training.web.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import edu.training.web.bean.UserRegInfo;
import edu.training.web.dao.DaoException;
import edu.training.web.dao.UserRegDao;
import edu.training.web.jdbc.dao.ConnectionPool;
import edu.training.web.jdbc.dao.ConnectionPoolException;

public class SQLRegDao implements UserRegDao {
    private final ConnectionPool conPool = ConnectionPool.getInstance();

    private static final String CHECK_LOGIN_EXISTS = "SELECT COUNT(*) FROM user_access_data WHERE login = ?";
    private static final String USER_REG = "INSERT INTO user_full_info (login, password, name, birth, city) VALUES (?, ?, ?, ?, ?)";
    private static final String ACCESS_REG = "INSERT INTO user_access_data (login, password) VALUES (?, ?)";

    @Override
    public boolean signUp(UserRegInfo info) throws DaoException {
        Connection con = null;
        PreparedStatement pstmtUser = null;
        PreparedStatement pstmtAccess = null;
        ResultSet generatedKeysUser = null;
        ResultSet generatedKeysAccess = null;

        String login = info.getLogin();
        String password = info.getPassword();
        String name = info.getName();
        String birthDate = info.getBirthDate();
        String city = info.getResidence();

        try {
            con = conPool.takeConnection();

            pstmtUser = con.prepareStatement(USER_REG, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmtUser.setString(1, login);
            pstmtUser.setString(2, password);
            pstmtUser.setString(3, name);
            pstmtUser.setString(4, birthDate);
            pstmtUser.setString(5, city);

            int affectedRowsUser = pstmtUser.executeUpdate();
            if (affectedRowsUser == 0) {
                throw new DaoException("Creating user failed, no rows affected in user_full_info.");
            }

            generatedKeysUser = pstmtUser.getGeneratedKeys();
            long userId = -1;
            if (generatedKeysUser.next()) {
                userId = generatedKeysUser.getLong(1);
                info.setId(userId);
            } else {
                throw new DaoException("Creating user failed, no ID obtained in user_full_info.");
            }

            pstmtAccess = con.prepareStatement(ACCESS_REG, PreparedStatement.RETURN_GENERATED_KEYS);
            pstmtAccess.setString(1, login);
            pstmtAccess.setString(2, password);

            int affectedRowsAccess = pstmtAccess.executeUpdate();
            if (affectedRowsAccess == 0) {
                throw new DaoException("Creating user failed, no rows affected in user_access_data.");
            }

            generatedKeysAccess = pstmtAccess.getGeneratedKeys();
            if (generatedKeysAccess.next()) {
                long accessId = generatedKeysAccess.getLong(1);
            } else {
                throw new DaoException("Creating user failed, no ID obtained in user_access_data.");
            }

            con.commit();
            return true;

        } catch (SQLException | ConnectionPoolException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException ex) {
                throw new DaoException(ex);
            }
            throw new DaoException(e);
        } finally {
            closeResources(generatedKeysUser, pstmtUser, con);
            closeResources(generatedKeysAccess, pstmtAccess, null);
        }
    }

    @Override
    public boolean isLoginExists(String login) throws DaoException {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            con = conPool.takeConnection();
            pstmt = con.prepareStatement(CHECK_LOGIN_EXISTS);
            pstmt.setString(1, login);
            rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1) > 0;
            } else {
                return false;
            }
        } catch (SQLException | ConnectionPoolException e) {
            throw new DaoException(e);
        } finally {
            closeResources(rs, pstmt, con);
        }
    }

    private void closeResources(ResultSet rs, PreparedStatement pstmt, Connection con) throws DaoException {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                throw new DaoException("Failed to close ResultSet", e);
            }
        }
        if (pstmt != null) {
            try {
                pstmt.close();
            } catch (SQLException e) {
                throw new DaoException("Failed to close PreparedStatement", e);
            }
        }
        if (con != null) {
            try {
                con.setAutoCommit(true);
                con.close();
            } catch (SQLException e) {
                throw new DaoException("Failed to close Connection", e);
            }
        }
    }
}