package com.amit.jpa.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author Amit Patil
 *
 **/
@Entity
@Table(name = "posts")
public class Post extends AuditModel {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2543970158242678895L;

	@Id
	@GenericGenerator(name = "sequencePost",
		strategy = "enhanced-sequence",
		parameters = {
				@Parameter(name = "optimizer", value="pooled-lo"),
				@Parameter(name = "initial_value", value = "1"),
				@Parameter(name = "increment_size", value = "5")
		})
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequencePost")
	private Long id;

	@NotNull
	@Size(max = 100)
	@Column(unique = true)
	private String title;

	@NotNull
	@Size(max = 250)
	private String description;

	@NotNull
	@Lob
//    @Column(name = "content", nullable = false, columnDefinition = "CLOB")
	private String content;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
