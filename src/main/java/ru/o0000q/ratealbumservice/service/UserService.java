package ru.o0000q.ratealbumservice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.o0000q.ratealbumservice.dto.UserDto;
import ru.o0000q.ratealbumservice.entity.User;
import ru.o0000q.ratealbumservice.mapper.UserMapperImp;
import ru.o0000q.ratealbumservice.repository.UserRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Transactional
@Service
public class  UserService implements UserDetailsService {
    private final UserRepository userRepository;
    private final UserMapperImp userMapper;

    public void setUserInfo(UserDto userDto) {
        userRepository.setUserInfo(userDto.getPassword(),
                userDto.getLogin(),
                userDto.getNickname(),
                userDto.getId());
    }

    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    public void saveUser(User user) {
        if (user == null) {
            throw new NullPointerException("You are trying to save null");
        }
        userRepository.save(user);
    }

    public Optional<User> getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    public Optional<User> getUserByNickname(String nickname) {
        return userRepository.getUserByNickname(nickname);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username)
                .map(user->new org.springframework.security.core.userdetails.User(
                        user.getLogin(),
                        user.getPassword(),
                        Collections.singleton(user.getRole())
                ))
                .orElseThrow(()->new UsernameNotFoundException("no such user"));
    }
}
