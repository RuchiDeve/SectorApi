package coding.challenge.task.service;

import coding.challenge.task.UserDTO;
import coding.challenge.task.model.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);

    UserDTO getUserById(Long id);

    List<UserDTO> getAllUsers();

    UserDTO updateUser(Long id, UserDTO updatedUserDTO);

    void deleteUser(Long id);

}