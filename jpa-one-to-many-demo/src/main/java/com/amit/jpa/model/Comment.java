package com.amit.jpa.model;

import com.fasterxml.jackson.annotation.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author Amit Patil
 *
 **/
@Entity
@Table(name = "comments")
public class Comment extends AuditModel {
	@Id
	@GenericGenerator(name = "sequenceComment",
	strategy = "enhanced-sequence",
	parameters = {
			@Parameter(name = "optimizer", value="pooled-lo"),
			@Parameter(name = "initial_value", value = "1"),
			@Parameter(name = "increment_size", value = "5")
	})

	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceComment")
	private Long id;

	@NotNull
	@Lob
	private String text;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "post_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
	@JsonIdentityReference(alwaysAsId = true)
	@JsonProperty("post_id")
	private Post post;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}
}
