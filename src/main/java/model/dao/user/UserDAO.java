package model.dao.user;
import java.util.List;

import java.util.List;
import model.entity.user.User;

public interface UserDAO {

	void insertUser(User user);
	
	void removeUser(User user);
	
	void updateUser(User user);
	
	List<User> listUser();
}
