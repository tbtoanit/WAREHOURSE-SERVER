package com.toandev;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {
	@Id
	@Column(name = "prod_id")
	private String prod_id;
	
	@Column(name = "prod_name")
	private String prod_name;
	
	@Column(name = "prod_cate_id")
	private String prod_cate_id;
	
	@Column(name = "prod_weight")
	private Double prod_weight;
	
	@Column(name = "prod_weight_unit")
	private String prod_weight_unit;
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getProd_cate_id() {
		return prod_cate_id;
	}
	public void setProd_cate_id(String prod_cate_id) {
		this.prod_cate_id = prod_cate_id;
	}
	public Double getProd_weight() {
		return prod_weight;
	}
	public void setProd_weight(Double prod_weight) {
		this.prod_weight = prod_weight;
	}
	public String getProd_weight_unit() {
		return prod_weight_unit;
	}
	public void setProd_weight_unit(String prod_weight_unit) {
		this.prod_weight_unit = prod_weight_unit;
	}
	

}
