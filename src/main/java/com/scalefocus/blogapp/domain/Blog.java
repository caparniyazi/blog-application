package com.scalefocus.blogapp.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Blog {
	@Builder
	public Blog(Long id, String title, String body, String shortSummary, LocalDateTime createdDate, BlogUser blogUser) {
		this.id = id;
		this.title = title;
		this.body = body;
		this.shortSummary = shortSummary;
		this.createdDate = createdDate;
		this.blogUser = blogUser;
	}
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(updatable = false, nullable = false)
	private Long id;

	@Column(nullable = false)
	private String title;

	@Column(columnDefinition = "TEXT", nullable = false)
	private String body;

	@Column(nullable = false)
	private String shortSummary;
	@CreationTimestamp
	@Column(updatable = false, nullable = false)
	private LocalDateTime createdDate;

	@ManyToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
	private BlogUser blogUser;

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Blog blog = (Blog) o;
		return id != null && Objects.equals(id, blog.id);
	}

	@Override
	public int hashCode() {
		return getClass().hashCode();
	}

	@PrePersist
	void onCreate() {
		setCreatedDate(LocalDateTime.now());
	}
}
