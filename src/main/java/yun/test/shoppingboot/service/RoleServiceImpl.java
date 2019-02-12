package yun.test.shoppingboot.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import yun.test.shoppingboot.domain.Role;
import yun.test.shoppingboot.repository.RoleRepository;

/**
 * Created by cjswo9207u@gmail.com on 2019-02-12
 * Github : https://github.com/YeoHoonYun
 */
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;

    @Transactional
    public void addRole(Role role) {
        Role result = roleRepository.save(role);
        System.out.println(result.getRoleId() + ", " + result.getName());
    }
}
