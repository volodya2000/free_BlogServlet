package services;

import dal.UserDAOImpl;
import dal.UserRolesDAO;
import dal.UserRolesDAOImpl;
import entities.Roles;
import entities.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        userRolesDAO.deleteAllRoles(id);
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

    public User findUserByNickname(String nickname) {
        User user =userDAOImpl.getUserByNickname(nickname);
        if(user!=null)
        {
            user.setRolesList(userRolesDAO.getUserRolesById(user.getId()));
        }
        return user;
    }

    public boolean isExist(String email,String nickname) { return userDAOImpl.isExist(email,nickname);}

}



