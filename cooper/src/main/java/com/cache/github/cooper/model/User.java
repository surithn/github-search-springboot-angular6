/**
 * 
 */
package com.cache.github.cooper.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Data;

/**
 * @author kxhb130
 *
 */
@Data
@Entity
public class User {
	@Id
	private String login;

	@Column(name="url")
	private String url;
	
	@Column(name="repos_url")
	private String repos_url;
	
	@Column(name="avatar_url")
	private String avatar_url;

	@OneToMany(cascade = CascadeType.ALL)
	private List<Repositories> repos;
}
