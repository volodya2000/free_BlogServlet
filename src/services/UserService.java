package services;

import dal.UserDAOImpl;
import dal.UserRolesDAO;
import dal.UserRolesDAOImpl;
import entities.Roles;
import entities.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private UserDAOImpl userDAOImpl =new UserDAOImpl();
    private List<User> userList=new ArrayList<>();
    private UserRolesDAOImpl userRolesDAO=new UserRolesDAOImpl();

    public UserService() {
    }

    public void addUser(User user)
    {
        userDAOImpl.addUser(user);
    }

    public void addRole(int userId,Roles role)
    {
        userRolesDAO.addRole(userId,role);
    }

    public List<Roles> getUserRoles(User user) { return userRolesDAO.getUserRolesById(user.getId()); }

    public boolean deleteUser(int id)
    {
        return userDAOImpl.deleteUser(id);
    }

    public boolean updateUser(User user)
    {
        return userDAOImpl.updateUser(user);
    }

    public List<User> findAll()
    {
        userList= userDAOImpl.getAllUsers();
        return userList;
    }

    public User findByEmailAndPassword(String email,String password)
    { return userDAOImpl.getUserByUserEmailAndPassword(email,password); }

    public User findUserByNickname(String nickname) {return userDAOImpl.getUserByNickname(nickname);}

    public boolean isExist(String email) { return userDAOImpl.isExist(email);}
}



