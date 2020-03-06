package dal;

import entities.Roles;
import entities.User;

import java.util.List;

public interface UserRolesDAO {

    List<Roles> getUserRolesById(int id);

    void addRole(User user,Roles roles);
    

    void deleteRole(User user,Roles role);
}
