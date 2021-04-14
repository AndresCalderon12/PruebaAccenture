package com.almacen.Dtos;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class BillDTO {
	private int idBill;
	private Date createdAt;
	private List<ProductDto> productos;
	private double totalPrice;
	private String direction;
	private int shippingCost;

	public List<ProductDto> getProductos() {
		return productos;
	}

	public int getIdBill() {
		return idBill;
	}

	public void setIdBill(int idBill) {
		this.idBill = idBill;
	}

	
	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setProductos(List<ProductDto> productos) {
		this.productos = productos;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double d) {
		this.totalPrice = d;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public int getShippingCost() {
		return shippingCost;
	}

	public void setShippingCost(int shippingCost) {
		this.shippingCost = shippingCost;
	}

}
