package edu.training.web.dao;

import edu.training.web.bean.UserRegInfo;

public interface UserRegDao {
	boolean signUp(UserRegInfo info) throws DaoException;

	boolean isLoginExists(String login) throws DaoException;

}

