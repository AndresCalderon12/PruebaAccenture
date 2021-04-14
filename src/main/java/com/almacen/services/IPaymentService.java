package com.almacen.services;


import java.util.List;

import com.almacen.Dtos.BuyDTO;
import com.almacen.Dtos.ProductDto;

public interface IPaymentService {

	String createBill(BuyDTO orderRequest);

	String deleteBill(int idBill);

	String editOrder(int idBill, BuyDTO newProducts);

}
