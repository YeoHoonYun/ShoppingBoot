package yun.test.shoppingboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import yun.test.shoppingboot.domain.User;
import yun.test.shoppingboot.repository.UserRepository;

@Repository
public class UserDaoImpl implements UserDao{
    @Autowired
    UserRepository userRepository;

    public void addUser(User user){
        userRepository.save(user);
    }

}
