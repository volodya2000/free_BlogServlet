package dal;

import entity.User;

import java.util.List;

public interface UserDAO {
    User getUserById(int id);
    List<User> getAllUsers();
    User getUserByUserEmailAndPassword(String email,String password);
    boolean insertUser(User user);
    boolean updateUser(User user);
    boolean deleteUser(int id);
}
