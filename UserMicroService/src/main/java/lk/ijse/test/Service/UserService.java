package lk.ijse.test.Service;

import lk.ijse.test.Dto.UserDTO;
import lk.ijse.test.Entity.User;

import lk.ijse.test.Repo.UserRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<UserDTO> getAllUsers() {
        // Fetch all users from the repository
        List<User> users = (List<User>) userRepository.findAll();

        // Map each User entity to UserDTO and collect them into a List
        return users.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }


    public UserDTO getUserById(Integer id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(u -> modelMapper.map(u, UserDTO.class)).orElse(null);
    }

    public UserDTO createUser(UserDTO userDTO) {
        User user = modelMapper.map(userDTO, User.class);
        User savedUser = userRepository.save(user);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    public UserDTO updateUser(Integer id, UserDTO userDTO) {
        if (userRepository.existsById(id)) {
            User user = modelMapper.map(userDTO, User.class);
            user.setId(id);
            User updatedUser = userRepository.save(user);
            return modelMapper.map(updatedUser, UserDTO.class);
        }
        return null;
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
