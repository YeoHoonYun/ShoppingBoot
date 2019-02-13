package yun.test.shoppingboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yun.test.shoppingboot.domain.Role;
import yun.test.shoppingboot.domain.User;
import yun.test.shoppingboot.repository.RoleRepository;
import yun.test.shoppingboot.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl{
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Transactional
    public void addUser(User user){
        Role role = roleRepository.getRoleByName("USER");
        user.addRole(role);
        userRepository.save(user);
    }
}
