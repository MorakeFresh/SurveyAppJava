package za.co.survey.dao;

import java.util.List;
import za.co.survey.model.User;

public interface UserDao {

    public List<User> getAllUsers();

    public boolean addUser(User user);
}
