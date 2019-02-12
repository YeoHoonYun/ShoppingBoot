package yun.test.shoppingboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yun.test.shoppingboot.dao.UserDao;
import yun.test.shoppingboot.domain.Role;
import yun.test.shoppingboot.domain.User;
import yun.test.shoppingboot.repository.RoleRepository;
import yun.test.shoppingboot.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    UserRepository userRepository;
    RoleRepository roleRepository;

    public void addUser(User user){
        Role role = roleRepository.getRoleByName("USER");
        user.addRole(role);
        userRepository.save(user);
    }
}
