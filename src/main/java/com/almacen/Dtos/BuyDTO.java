package com.almacen.Dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BuyDTO {
	private String tpyeIdBuyer;
	private String IdBuyer;
	private String direction;
	private List<ProductDto> products;


}
