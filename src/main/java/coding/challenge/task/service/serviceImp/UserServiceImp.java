package coding.challenge.task.service.serviceImp;


import coding.challenge.task.dto.UserDTO;
import coding.challenge.task.model.User;
import coding.challenge.task.repository.UserRepository;
import coding.challenge.task.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImp implements UserService {
    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user = User.builder()
                .firstName(userDTO.getFirstName())
                .lastName(userDTO.getLastName())
                .email(userDTO.getEmail())
                .phoneNumber(userDTO.getPhoneNumber())
                .sector(userDTO.getSector())
                .subSector(userDTO.getSubSector())
                .build();
        User savedUser = userRepository.save(user);
        UserDTO savedUserDTO = UserDTO.builder()
                .firstName(savedUser.getFirstName())
                .lastName(savedUser.getLastName())
                .email(savedUser.getEmail())
                .phoneNumber(savedUser.getPhoneNumber())
                .sector(savedUser.getSector())
                .subSector(savedUser.getSubSector())
                .build();
        return savedUserDTO;

    }

    @Override
    public UserDTO getUserById(Long id) {
        return userRepository.findById(id)
                .map(user -> modelMapper.map(user, UserDTO.class))
                .orElse(null);
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public UserDTO updateUser(Long id, UserDTO updatedUserDTO) {
        User user = userRepository.findById(id).orElse(null);
        if (user != null) {
            user.setFirstName(updatedUserDTO.getFirstName());
            user.setLastName(updatedUserDTO.getLastName());
            user.setEmail(updatedUserDTO.getEmail());
            user.setPhoneNumber(updatedUserDTO.getPhoneNumber());
            user.setSector(updatedUserDTO.getSector());
            User savedUser = userRepository.save(user);
            UserDTO savedUserDTO = UserDTO.builder()
                    .firstName(savedUser.getFirstName())
                    .lastName(savedUser.getLastName())
                    .email(savedUser.getEmail())
                    .phoneNumber(savedUser.getPhoneNumber())
                    .sector(savedUser.getSector())
                    .subSector(savedUser.getSubSector())
                    .build();
            return savedUserDTO;

        }
        return null;
    }
    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
