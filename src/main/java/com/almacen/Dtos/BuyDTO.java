package com.almacen.Dtos;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BuyDTO {
	private String tpyeIdBuyer;
	private String IdBuyer;
	private String direction;
	private List<ProductDto> products;

	public String getTpyeIdBuyer() {
		return tpyeIdBuyer;
	}

	public void setTpyeIdBuyer(String tpyeIdBuyer) {
		this.tpyeIdBuyer = tpyeIdBuyer;
	}

	public String getIdBuyer() {
		return IdBuyer;
	}

	public void setIdBuyer(String idBuyer) {
		IdBuyer = idBuyer;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public List<ProductDto> getProducts() {
		return products;
	}

	public void setProducts(List<ProductDto> products) {
		this.products = products;
	}

}
