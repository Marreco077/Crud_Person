package com.marreco.crud_person.service;

import com.marreco.crud_person.dto.UserDTO;
import com.marreco.crud_person.entity.User;
import com.marreco.crud_person.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public UserDTO saveUser(UserDTO userDTO) {
        User user = new User(userDTO);
        User savedUser = repository.saveAndFlush(user);
        return convertToDTO(savedUser);
    }

    public UserDTO getUserById(Long id) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return convertToDTO(user);
    }

    public void deleteUserById(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("User not found with id: " + id);
        }
        repository.deleteById(id);
    }

    public UserDTO updateUserById(Long id, UserDTO userDTO) {
        User user = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));

        if (userDTO.name() != null) user.setName(userDTO.name());
        if (userDTO.lastName() != null) user.setLastName(userDTO.lastName());
        if (userDTO.email() != null) user.setEmail(userDTO.email());
        if (userDTO.password() != null) user.setPassword(userDTO.password());

        User updatedUser = repository.save(user);
        return convertToDTO(updatedUser);
    }

    private UserDTO convertToDTO(User user) {
        return new UserDTO(
                user.getName(),
                user.getLastName(),
                user.getEmail(),
                user.getPassword()
        );
    }
}