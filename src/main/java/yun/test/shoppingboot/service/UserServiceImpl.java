package yun.test.shoppingboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import yun.test.shoppingboot.dao.UserDao;
import yun.test.shoppingboot.domain.User;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserDao userDao;

    public void addUser(User user){
        userDao.addUser(user);
    }
}
