package model.dao.login;

import java.util.List;

import model.entity.user.User;

public interface LoginDAO {

	List<User> validateUser(User user);

}
