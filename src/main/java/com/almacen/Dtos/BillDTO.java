package com.almacen.Dtos;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BillDTO {
	private int idBill;
	private Date createdAt;
	private List<ProductDto> productos;
	private double totalPrice;
	private String direction;
	private int shippingCost;


}
