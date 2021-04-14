package com.almacen.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ResponseDTO {
	private int status;
	private String message;
	private BillDTO bill;
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public BillDTO getBill() {
		return bill;
	}
	public void setBill(BillDTO bill) {
		this.bill = bill;
	}
	
	
}
