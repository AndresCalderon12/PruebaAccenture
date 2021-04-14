package com.almacen.services;

import com.almacen.Dtos.BuyDTO;

public interface IPaymentService {

	String createBill(BuyDTO orderRequest);

	String deleteBill(int idBill);

	String editOrder(int idBill, BuyDTO newProducts);

}
