package com.amazon.model;

public class Categoria {
	
	private int categoryID;
	private String categoryName;
	private Integer parentID;
	
	public Categoria(String name, Integer parentID) {
		super();
		this.categoryName = name;
		this.parentID = parentID;
	}

	public String getName() {
		return categoryName;
	}

	public void setName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}
	
	
	
	
}
