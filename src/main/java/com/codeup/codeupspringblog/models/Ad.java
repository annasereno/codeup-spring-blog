
package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@ToString

@Entity
@Table(name = "adLister_ads")
public class Ad {

	//primary key on data base
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	//colums
	@Column(nullable = false, length = 100)
	private String title;

	@Column(nullable = false, length = 1024)
	private String description;

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	private User user;


	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(
			name = "ads_categories",
			joinColumns = @JoinColumn(name = "ad_id"),
			inverseJoinColumns = @JoinColumn(name = "category_id")
	)
	private Set<Category> categories;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public Ad() {
	}

	public Ad(String title, String description) {
		this.title = title;
		this.description = description;
	}
}