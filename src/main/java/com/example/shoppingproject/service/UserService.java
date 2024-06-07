package com.example.shoppingproject.service;

import com.example.shoppingproject.domain.User;
import com.example.shoppingproject.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User createUser(User user) {
        // 유효성 검사
        if (!isValidEmail(user.getEmail())) {
            throw new IllegalArgumentException("유효하지 않은 이메일입니다.");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new RuntimeException("이미 등록된 이메일입니다.");
        }
        // 데이터베이스에 유저 정보 저장
        return userRepository.save(user);
    }

    private boolean isValidEmail(String email) {
        // 이메일 유효성 검사
        return email.matches("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
    }

    public boolean authenticateByEmail(String email, String password) {
        // 이메일을 기준으로 사용자 조회
        User user = userRepository.findByEmail(email);

        // 사용자가 존재하고 비밀번호가 일치하는지 확인
        return user != null && password.equals(user.getPassword());
    }
}
