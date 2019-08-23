package model;

public class Category {
	private Long id;
	private String categoryDescription;
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public String getCategoryDescription() {
		return categoryDescription;
	}
	
	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	public String toString() {
		return "Category - Id: " + id + ", Category Description: "
				+ categoryDescription;
	}
}