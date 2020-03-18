package dal;

import entities.Roles;
import entities.User;

import java.util.List;

public interface UserRolesDAO {

    List<Roles> getUserRolesById(int id);

    void addRole(int userId,Roles roles);

    void deleteRole(User user,Roles role);

    void deleteAllRoles(int userId);
}
