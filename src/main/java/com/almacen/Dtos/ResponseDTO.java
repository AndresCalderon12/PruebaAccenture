package com.almacen.Dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ResponseDTO {
	private int status;
	private String message;
	private BillDTO bill;

	
	
}
