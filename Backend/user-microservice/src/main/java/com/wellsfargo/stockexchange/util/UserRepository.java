package com.wellsfargo.stockexchange.util;

import org.springframework.data.repository.CrudRepository;
import com.wellsfargo.stockexchange.models.User;
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByUsername(String username);
    
    User save(User entity);

	User findByEmail(String email);

}