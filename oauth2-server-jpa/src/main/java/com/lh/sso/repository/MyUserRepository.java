package com.lh.sso.repository;

import com.lh.sso.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser,Long> {

    MyUser findOneByUsername(String username);

}
