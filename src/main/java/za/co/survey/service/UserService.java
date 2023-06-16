package za.co.survey.service;

import java.util.List;
import za.co.survey.model.User;

public interface UserService {

    public List<User> getAllUsers();

    public boolean addUser(User user);
}
