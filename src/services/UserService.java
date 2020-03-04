package services;

import dal.UserImplDAO;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private UserImplDAO userImplDAO=new UserImplDAO();
    private List<User> userList=new ArrayList<>();

    public UserService() {

    }

    public void addUser(User user)
    {
        userImplDAO.insertUser(user);
    }

    public boolean deleteUser(int id)
    {
        return userImplDAO.deleteUser(id);
    }

    public boolean updateUser(User user)
    {
        return userImplDAO.updateUser(user);
    }

    public List<User> findAll()
    {
        userList=userImplDAO.getAllUsers();
        return userList;
    }

    public User findByEmailAndPassword(String email,String password)
    {
        return userImplDAO.getUserByUserEmailAndPassword(email,password);
    }

}
