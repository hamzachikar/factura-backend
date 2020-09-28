package com.springboot.project.gestionFacture.jparepo;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.springboot.project.gestionFacture.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
	public Optional<User> findByEmail(String email);
	public List<User> findByAdminUser(User user);

}
