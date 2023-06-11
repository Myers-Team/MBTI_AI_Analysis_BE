package com.mbtiai.demo.user;

import javax.transaction.Transactional;
import java.util.Map;

public interface UserService {
    Long signUp(UserSignUpRequestDto requestDto);
    String signin(UserSignInRequestDto requestDto);
}
