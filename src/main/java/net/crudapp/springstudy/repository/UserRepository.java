package net.crudapp.springstudy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.crudapp.springstudy.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
