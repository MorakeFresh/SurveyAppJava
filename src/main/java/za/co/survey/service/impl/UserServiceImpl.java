package za.co.survey.service.impl;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import za.co.survey.controller.ProcessRequest;
import za.co.survey.dao.UserDao;
import za.co.survey.model.User;
import za.co.survey.service.UserService;

public class UserServiceImpl implements UserService, ProcessRequest {

    private UserDao userDao;
    private String userView;
    
    public UserServiceImpl() {
        this.userDao = userDao;
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getAllUsers() {
        return userDao != null ? userDao.getAllUsers() : null;
    }

    @Override
    public boolean addUser(User user) {
        return userDao != null ? userDao.addUser(user) : null;
    }

    @Override
    public void processTheRequest(HttpServletRequest request, HttpServletResponse response) {

        String action = request.getParameter("act");
        System.out.println(action);

        User user = null;
        List<User> userList = null;

        String surname = "";
        String firstName = "";
        String contactNumber = "";
        int age = 0;
        LocalDate date = LocalDate.now();

        if (action != null) {
            action = action.toLowerCase().trim();

            switch (action) {

                //---------------------------------------Add user to database-----------------------------------------------------
                case "adduser":

                    try {
                    surname = request.getParameter("surname");
                    firstName = request.getParameter("firstName");
                    contactNumber = request.getParameter("contactNumber");
                    age = Integer.parseInt(request.getParameter("age"));
                } catch (Exception ex) {
                    System.out.println("Error: " + ex.getMessage());
                }

                if (!surname.isEmpty() && age >= 5 && age <= 120) {
                    if (addUser(new User(surname, firstName, contactNumber, age, date))) {
                        request.setAttribute("user", "User added");
                    } else {
                        request.setAttribute("ans", "User not added");
                    }
                }
                userView = "addsurvey.jsp";
                break;
                //--------------------------------------Get all users from database----------------------------------------------    
                case "getallusers":

                    userList = userDao.getAllUsers();

                    if (userList != null && !userList.isEmpty()) {
                        request.setAttribute("allUsers", userList);
                    } else {
                        request.setAttribute("ans", "No users found");
                    }
                    userView = "";
                    break;
            }
        }
    }

    @Override
    public void processTheResponse(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(userView);
        try {
            requestDispatcher.forward(request, response);
        } catch (ServletException | IOException ex) {
            System.err.println("Error Dispatching View: " + ex.getMessage());
        }
    }

}
