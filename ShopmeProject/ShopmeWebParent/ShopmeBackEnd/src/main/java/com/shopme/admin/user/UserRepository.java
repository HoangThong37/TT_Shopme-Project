package com.shopme.admin.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.shopme.common.entity.Role;
import com.shopme.common.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
	@Query("SELECT u From User u WHERE u.email = :email")
	public User getUserByEmail(@Param("email") String email);
	
	public Long countById(Integer id);
	
	@Query("UPDATE User u set u.enabled = ?2 where u.id = ?1")
	@Modifying // cập nhật dữ liệu db
	public void updateEnabledAndStatus(Integer id, boolean enabled);

}
