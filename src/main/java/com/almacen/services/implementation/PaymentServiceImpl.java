package com.almacen.services.implementation;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;

import com.almacen.Dtos.BillDTO;
import com.almacen.Dtos.BuyDTO;
import com.almacen.Dtos.ProductDto;
import com.almacen.Dtos.ResponseDTO;
import com.almacen.services.IPaymentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

@Service
@PropertySource(value = { "file:${app.home}/application.properties" }, ignoreResourceNotFound = true)
public class PaymentServiceImpl implements IPaymentService {

	private List<BillDTO> orders = new ArrayList<BillDTO>();
	private int billId;

	public String createBill(BuyDTO orderRequest) {
		ResponseDTO response=new ResponseDTO();

		BillDTO bill = new BillDTO();
		billId++;
		int totalPrice = 0;
		for (ProductDto product : orderRequest.getProducts()) {
			totalPrice += product.getPrice();
		}
		 //Code for Trying the deleted service with more than 12 hours created
//		String olderDate = "11/04/201";
//		SimpleDateFormat formatter1 = new SimpleDateFormat("dd/MM/yyyy");
//		Date parsedDate = null;
//		try {
//			parsedDate = formatter1.parse(olderDate);
//		} catch (ParseException e2) {
//			// TODO Auto-generated catch block
//			e2.printStackTrace();
//		}
//
//		bill.setCreatedAt(parsedDate);
		// comment next line to uncomment the previous block
		bill.setCreatedAt(new Date());
		bill.setDirection(orderRequest.getDirection());
		bill.setProductos(orderRequest.getProducts());
		bill.setTotalPrice(totalPrice);
		bill.setIdBill(billId);
		if (totalPrice <= 70000) {
			bill.setShippingCost(5000);
		} else if (totalPrice > 70000 && totalPrice <= 100000) {
			bill.setTotalPrice(totalPrice + totalPrice * 0.19);

		} else if (totalPrice > 100000) {
			bill.setTotalPrice(totalPrice + totalPrice * 0.19);
			bill.setShippingCost(0);
		}
		orders.add(bill);
		response.setStatus(200);
		response.setMessage("Bill Created Sucsesfully");
		response.setBill(bill);
		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		String jsonString = null;
		try {
			jsonString = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return jsonString;
	}

	@Override
	public String deleteBill(int idBill) {
		String result = "";
		ResponseDTO response=new ResponseDTO();

		for (int i = 0; i < orders.size(); i++) {
			if (orders.get(i).getIdBill() == idBill) {
				Calendar createdAt = new GregorianCalendar();
				Calendar currentDate = new GregorianCalendar();
				createdAt.setTime(orders.get(i).getCreatedAt());
				currentDate.setTime(new Date());
				int currentHour = currentDate.get(Calendar.HOUR_OF_DAY);
				int createdAtHout = createdAt.get(Calendar.HOUR_OF_DAY);
				int hoursSinceCreated = currentHour - createdAtHout;
				if (hoursSinceCreated < 12) {
					orders.remove(i);
					response.setStatus(200);
					response.setMessage("Order Succesfully canceled");
				} else {
					BillDTO cancelationBill = new BillDTO();
					cancelationBill.setCreatedAt(new Date());
					cancelationBill.setTotalPrice(orders.get(i).getTotalPrice() * 0.10);
					response.setStatus(3);
					response.setStatus(hoursSinceCreated);
					response.setBill(cancelationBill);
					
					orders.remove(i);

				}
			}
		}
		ObjectMapper mapper = new ObjectMapper();

		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		try {
			result = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;
	}

	@Override
	public String editOrder(int idBill, BuyDTO newProducts) {
		String result ="";
		ResponseDTO response=new ResponseDTO();

		double totalPriceNewProducts = 0;
		for (int i = 0; i < newProducts.getProducts().size(); i++) {
			totalPriceNewProducts+=newProducts.getProducts().get(i).getPrice();
		}
		for (int i = 0; i < orders.size(); i++) {
			
			if (orders.get(i).getIdBill()==idBill) {
				Calendar createdAt = new GregorianCalendar();
				Calendar currentDate = new GregorianCalendar();
				createdAt.setTime(orders.get(i).getCreatedAt());
				currentDate.setTime(new Date());
				int currentHour = currentDate.get(Calendar.HOUR_OF_DAY);
				int createdAtHout = createdAt.get(Calendar.HOUR_OF_DAY);
				int hoursSinceCreated = currentHour - createdAtHout;
				if (hoursSinceCreated>5) {
					response.setStatus(1);
					response.setMessage("You can't edit the order because has been more than 5 hours since is created");
				}else {
					if (totalPriceNewProducts<orders.get(i).getTotalPrice()) {
						response.setStatus(2);
						response.setMessage("You can't edit your order because the totalprice is lower than the previous one");
					}else {
						if (totalPriceNewProducts>=70000 && totalPriceNewProducts<=100000) {
							totalPriceNewProducts=totalPriceNewProducts+totalPriceNewProducts*0.19;
						}else if (totalPriceNewProducts>100000) {
							totalPriceNewProducts=totalPriceNewProducts+totalPriceNewProducts*0.19;
							orders.get(i).setShippingCost(0);
							
						}
						orders.get(i).setProductos(newProducts.getProducts());
						orders.get(i).setTotalPrice(totalPriceNewProducts);
						response.setStatus(200);
						response.setMessage("Order edited sucsessfuly");
						response.setBill(orders.get(i));
					
					}
				}
				
			}
		}
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
		
		try {
			result = mapper.writeValueAsString(response);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}




}
