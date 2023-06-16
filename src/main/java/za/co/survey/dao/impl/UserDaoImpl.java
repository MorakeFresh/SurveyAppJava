package za.co.survey.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import za.co.survey.dao.UserDao;
import za.co.survey.model.User;

public class UserDaoImpl implements UserDao {

    private static UserDaoImpl userDaoImpl = null;
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    private UserDaoImpl(Connection con) {
        this.con = con;
    }

    public static UserDaoImpl getInstance(Connection dbCon) {
        if (userDaoImpl == null) {
            userDaoImpl = new UserDaoImpl(dbCon);
        }
        return userDaoImpl;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();

        if (con == null) {
            return userList;
        }

        try {
            ps = con.prepareStatement("SELECT userId, surname, firstName, contactNumber, age, date FROM user");
            rs = ps.executeQuery();
            
            while(rs.next()){
                userList.add(new User(rs.getInt("userId"), rs.getString("surname"), rs.getString("firstName"), rs.getString("contactNumber"), rs.getInt("age"), LocalDate.parse(rs.getString("date"))));
            }
            
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return userList;
    }

    @Override
    public boolean addUser(User user) {
        boolean add = false;

        if (con == null) {
            return add;
        }

        try {
            ps = con.prepareStatement("INSERT INTO user(surname, firstName, contactNumber, age, date) VALUES(?,?,?,?,?)");
            ps.setString(1, user.getSurname());
            ps.setString(2, user.getFirstName());
            ps.setString(3, user.getContactNumber());
            ps.setInt(4, user.getAge());
            ps.setString(5, user.getDate().toString());
            if (ps.executeUpdate() > 0) {
                add = true;
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return add;

    }

}
