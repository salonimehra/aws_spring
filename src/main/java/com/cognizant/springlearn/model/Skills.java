package com.cognizant.springlearn.model;

public class Skills {
	private int id;
	private String name;
	
	public Skills() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Skills(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Skills [id=" + id + ", name=" + name + "]";
	}
}
