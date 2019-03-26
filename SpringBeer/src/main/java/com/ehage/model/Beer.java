package com.ehage.model;

public class Beer {

	private long id;
	
	private String name;
	private String style;	
	private double rating;
	private String notes;
	
	public Beer() {	
		super();
	}

	public Beer(long id, String name, String style, double rating, String notes) {
		super();
		this.id = id;
		this.name = name;
		this.style = style;
		this.rating = rating;
		this.notes = notes;
	}

	public Beer(String name, String style, double rating, String notes) {
		super();
		this.name = name;
		this.style = style;
		this.rating = rating;
		this.notes = notes;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStyle() {
		return style;
	}

	public void setStyle(String style) {
		this.style = style;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Beer other = (Beer) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Beer [id=" + id + ", name=" + name + ", style=" + style
				+ ", rating=" + rating + ", notes=" + notes + "]";
	}
	
	
	
}
