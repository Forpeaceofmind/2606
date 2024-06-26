package edu.training.web.bean;

import java.io.Serializable;
import java.util.Objects;

public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	private String view;
	private String id;
	private String type;

	public Profile() {
	}

	public Profile(String view, String type, String id) {
		super();
		this.view = view;
		this.id = id;
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getView() {
		return view;
	}

	public void setView(String view) {
		this.view = view;
	}

	@Override
	public int hashCode() {
		return Objects.hash(type, view);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Profile other = (Profile) obj;
		return Objects.equals(type, other.type) && Objects.equals(view, other.view);
	}

}
