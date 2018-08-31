/**
 * 
 */
package com.cache.github.cooper.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cache.github.cooper.model.User;

/**
 * @author kxhb130
 *
 */
@Repository
public interface UserRepository extends JpaRepository<User, String> {

	List<User> findAllByOrderByLogin();
}
