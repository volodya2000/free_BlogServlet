package dal;

import entities.Roles;
import entities.User;

import java.util.List;

public interface UserRolesDAO {

    List<Roles> getUserRolesById(int id);

    void addRole(User user,Roles roles);

    List<Roles> getUserRolesByUser(User user);

    void deleteRole(User user,Roles role);
}
