package edu.training.web.service.impl;


import edu.training.web.bean.Profile;
import edu.training.web.bean.User;
import edu.training.web.bean.UserRegInfo;
import edu.training.web.dao.AuthDao;
import edu.training.web.dao.UserRegDao;
import edu.training.web.dao.DaoException;
import edu.training.web.dao.DaoProvider;
import edu.training.web.service.UserService;
import edu.training.web.service.exception.ServiceAuthException;
import edu.training.web.service.exception.ServiceException;

public class UserServiceImpl implements UserService {
    private final AuthDao authDao = DaoProvider.getInstance().getAuthDao();
    private final UserRegDao regDao = DaoProvider.getInstance().getRegDao();

    @Override
    public User signIn(User authInfo) throws ServiceAuthException, ServiceException {
        try {
            Valid validator = new Valid.Builder(regDao)
                .validateEmail(authInfo.getLogin())
                .validatePassword(authInfo.getPassword())
                .build();

            if (!validator.isValid()) {
                throw new ServiceAuthException("Invalid login or password format");
            }

            User user = authDao.signIn(authInfo);
            if (user != null) {
                return user;
            } else {
                throw new ServiceAuthException("WRONG Login or Password");
            }
        } catch (DaoException e) {
            throw new ServiceException("Failed to sign in", e);
        }
    }

    @Override
    public User rememberMe(String token) throws ServiceException {
        try {
            return authDao.checkToken(token);
        } catch (DaoException e) {
            throw new ServiceException("Failed to remember user by token", e);
        }
    }

    @Override
    public boolean registration(UserRegInfo regInfo) throws ServiceException {
        try {
            Valid validator = new Valid.Builder(regDao)
                .validateEmail(regInfo.getLogin())
                .validatePassword(regInfo.getPassword())
                .validateName(regInfo.getName())
                .validateBirthDate(regInfo.getBirthDate())
                .validateCity(regInfo.getResidence())
                .validateLoginUnique(regInfo.getLogin())
                .build();

            if (!validator.isValid()) {
                throw new ServiceException("Registration data validation failed");
            }

            return regDao.signUp(regInfo);
        } catch (DaoException e) {
            throw new ServiceException("Failed to register user", e);
        }
    }

    @Override
    public boolean blockUser(int id) throws ServiceException {
        throw new UnsupportedOperationException("Method not implemented yet");
    }

    @Override
    public Profile userProfile(int id) throws ServiceException {
        throw new UnsupportedOperationException("Method not implemented yet");
    }
}