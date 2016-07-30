package com.spring;

public class Laptop {
	private Integer modelNum;
	private String name;
	private Integer cost;

	public Integer getModelNum() {
		return modelNum;
	}

	@Override
	public String toString() {
		return "Laptop [modelNum=" + modelNum + ", name=" + name + ", cost=" + cost + "]";
	}

	public void setModelNum(Integer modelNum) {
		this.modelNum = modelNum;
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCost() {
		return cost;
	}

	public void setCost(Integer cost) {
		this.cost = cost;
	}

}
