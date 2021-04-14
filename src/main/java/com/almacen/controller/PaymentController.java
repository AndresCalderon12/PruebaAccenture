package com.almacen.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.almacen.Dtos.BillDTO;
import com.almacen.Dtos.BuyDTO;
import com.almacen.Dtos.ProductDto;
import com.almacen.services.IPaymentService;

@RestController
@RequestMapping("payments")
public class PaymentController {
	 private final IPaymentService iPaymentService;

	    public PaymentController(IPaymentService iPaymentService) {
	        this.iPaymentService = iPaymentService;
	    }
	    
	    @GetMapping("/order")
	    public String OrderRequest(@RequestBody BuyDTO orderRequest) {
	        return iPaymentService.createBill(orderRequest);
	    }
	    
	    @GetMapping("/deleteorder")
	    public String deleteOrder(int idBill) {
	        return iPaymentService.deleteBill(idBill);
	    }
	    @GetMapping("/editorder")
	    public String editOrder(int idBill,@RequestBody BuyDTO newProducts) {
	        return iPaymentService.editOrder(idBill,newProducts);
	    }
}
