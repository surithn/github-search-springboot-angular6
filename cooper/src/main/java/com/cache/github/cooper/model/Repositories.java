/**
 * 
 */
package com.cache.github.cooper.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

/**
 * @author kxhb130
 *
 */
@Data
@Entity
public class Repositories {

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_at")
	private String created_at;
	
	@Column(name = "forks_count")
	private String forks_count;
	
	@Column(name = "full_name")
	private String full_name;
	
	@Column(name = "html_url")
	private String html_url;
}
