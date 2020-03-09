package dal;

import entities.User;

import java.util.List;

public interface UserDAO {
    User getUserById(int id);
    List<User> getAllUsers();
    User getUserByUserEmailAndPassword(String email,String password);
    boolean addUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
    boolean isExist(String email);
}
