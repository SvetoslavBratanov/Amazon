package com.amazon.model;

public class Categoria {
	
	private String name;
	private Integer parentID;
	
	public Categoria(String name, Integer parentID) {
		super();
		this.name = name;
		this.parentID = parentID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParentID() {
		return parentID;
	}

	public void setParentID(Integer parentID) {
		this.parentID = parentID;
	}
	
	
	
	
}
