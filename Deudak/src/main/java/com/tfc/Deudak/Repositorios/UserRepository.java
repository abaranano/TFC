package com.tfc.Deudak.Repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import com.tfc.Deudak.Modelos.UserModel;

public interface UserRepository extends JpaRepository<UserModel, Long> {
	UserModel findByEmail(String email);
}
