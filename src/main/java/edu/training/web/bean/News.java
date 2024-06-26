package edu.training.web.bean;

import java.io.Serializable;
import java.util.Objects;

public class News implements Serializable {

	private static final long serialVersionUID = 1L;

	private String title;
	private String brief;
	private String image;
	private String date;
	private String id;

	public News() {
	}

	public News(String title) {
		super();
		this.title = title;
	}

	public News(String title, String brief, String image, String date) {
		super();
		this.title = title;
		this.brief = brief;
		this.image = image;
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		return Objects.hash(brief, date, id, image, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		News other = (News) obj;
		return Objects.equals(brief, other.brief) && Objects.equals(date, other.date) && Objects.equals(id, other.id)
				&& Objects.equals(image, other.image) && Objects.equals(title, other.title);
	}

	@Override
	public String toString() {
		return "News [title=" + title + ", brief=" + brief + ", image=" + image + ", date=" + date + "]";
	}

}
