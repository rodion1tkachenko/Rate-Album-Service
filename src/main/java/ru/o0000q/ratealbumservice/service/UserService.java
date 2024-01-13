package ru.o0000q.ratealbumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.o0000q.ratealbumservice.dto.UserDto;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.repository.UserRepository;

@RequiredArgsConstructor
@Transactional
@Service
public class UserService {
    private final UserRepository userRepository;


    public void setUserInfo(UserDto userDto) {
        userRepository.setUserInfo(userDto.getPassword(), userDto.getLogin(), userDto.getPassword(), userDto.getId());
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void saveUser(User user) {
        userRepository.saveUser(user);
    }

    public User getUserById(Long id) {
        return userRepository.getUserById(id).get();
    }

    public User getUserByNickname(String nickname) {
        return userRepository.getUserByNickname(nickname).get();
    }
}
