package com.cdac.restro.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cdac.restro.beans.AllPaidUnpaidOrders;
import com.cdac.restro.beans.CustomerDetails;
import com.cdac.restro.beans.CustomerOrderDetails;
import com.cdac.restro.beans.FeedbackDetails;
import com.cdac.restro.beans.ItemDetails;
import com.cdac.restro.beans.LoginRequest;
import com.cdac.restro.beans.LoginResponse;
import com.cdac.restro.beans.OrderDetails;
import com.cdac.restro.beans.OrderRequest;
import com.cdac.restro.beans.PaidOrderDetails;
import com.cdac.restro.repo.CustomerRepository;
import com.cdac.restro.repo.FeedbackRepository;
import com.cdac.restro.repo.ItemDetailsRepository;
import com.cdac.restro.repo.OrderRepository;
import com.cdac.restro.repo.PaidOrdersRepository;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class ItemController {

	@Autowired
	private ItemDetailsRepository repo;
	@Autowired
	private OrderRepository orderRepo;
	@Autowired
	private FeedbackRepository feedbackRepo;
	@Autowired
	private CustomerRepository custRepo;


	@Autowired
	private PaidOrdersRepository paidOrderRepo;
	@Autowired
	private CustomerRepository customerRepository;

	@GetMapping("/getAllVegItems")
	public List<ItemDetails> getAllVegItems() {
		List<ItemDetails> all = repo.findAll();
		return all.stream().filter(obj -> obj.getItemCategory().equalsIgnoreCase("veg")).collect(Collectors.toList());
	}

	@GetMapping("/getAllNonVegItems")
	public List<ItemDetails> getAllNonVegItems() {
		List<ItemDetails> all = repo.findAll();
		return all.stream().filter(obj -> obj.getItemCategory().equalsIgnoreCase("non-veg"))
				.collect(Collectors.toList());
	}

	@GetMapping("/getAllIColdDrinktems")
	public List<ItemDetails> getAllIColdDrinktems() {
		List<ItemDetails> all = repo.findAll();
		return all.stream().filter(obj -> obj.getItemCategory().equalsIgnoreCase("cold-drinks"))
				.collect(Collectors.toList());
	}

	@GetMapping("/getAllItems")
	public List<ItemDetails> getAllItems() {
		return repo.findAll();
	}

	@PostMapping("/createItem")
	public ItemDetails createItem(@RequestBody ItemDetails user) {
		System.out.println(user);
		return repo.save(user);
	}
	@PostMapping("/createFeedback")
	public FeedbackDetails createFeedback(@RequestBody FeedbackDetails feedbackDetails) {
		System.out.println(feedbackDetails);
		return feedbackRepo.save(feedbackDetails);
	}
	@GetMapping("/getAllFeedbacks")
	public List<FeedbackDetails> getAllFeedbacks() {
		return feedbackRepo.findAll();
	}

	@DeleteMapping("/deleteItemByID/{id}")
	public void deleteItemByID(@PathVariable("id") Integer id) {
		repo.deleteById(id);
		
	}
	
	@PostMapping("/createCustomerDetails")
	public CustomerDetails createCustomerDetails(@RequestBody CustomerDetails user) {
		return custRepo.save(user);
	}

	@PostMapping("/createOrder")
	public OrderDetails createOrder(@RequestBody OrderRequest user) {
		System.out.println(user);
		// save order details
		OrderDetails orderDetails = new OrderDetails();
		orderDetails.setItemID(user.getItemID());
		orderDetails.setItemQuantity(user.getItemQuantity());
		orderDetails.setItemPrice(user.getPrice());
		int price = getItemPriceByID(user.getItemID());
		int total = user.getItemQuantity() * price;
		orderDetails.setPriceWithQuantity(total);
		orderDetails.setUserID(user.getCusID());
		orderDetails.setPayStatus("unpaid");
		System.out.println("orderDetails " + orderDetails);
		return orderRepo.save(orderDetails);
	}


	private Integer getItemPriceByID(Integer name) {
		List<ItemDetails> allItems = getAllItems();
		Integer itemPrice = 0;
		for (ItemDetails itemObj : allItems) {
			if (itemObj.getItemID() == name) {
				itemPrice = itemObj.getPrice();
				break;
			}
		}
		return itemPrice;
	}

	private Integer getItemIDByName(String name) {
		List<ItemDetails> allItems = getAllItems();
		Integer itemID = 0;
		for (ItemDetails itemObj : allItems) {
			if (itemObj.getItemName().equalsIgnoreCase(name)) {
				itemID = itemObj.getItemID();
				break;
			}
		}
		return itemID;
	}

	@GetMapping("/getAllOrdersByCusID/{cusID}")
	public List<CustomerOrderDetails> getAllOrdersByCusID(@PathVariable("cusID") Integer id) {
//		get all orders by id
		List<OrderDetails> all = orderRepo.findAll();
		List<OrderDetails> ordersByID = all.stream().filter(obj -> obj.getUserID() == id).collect(Collectors.toList());
//		CustomerOrderDetails finalOrder=new CustomerOrderDetails();
		List<CustomerOrderDetails> customerItems = new ArrayList<>();
		String name = "";

		for (OrderDetails detailed : ordersByID) {
			CustomerOrderDetails finalOrder = new CustomerOrderDetails();
			finalOrder.setCusID(detailed.getUserID());
			finalOrder.setOrderID(detailed.getOrderID());
			finalOrder.setTotalPrice(detailed.getPriceWithQuantity());
			finalOrder.setItemName(getItemNameByID(detailed.getItemID()));
			finalOrder.setCusName("ankur");
			finalOrder.setItemQuantity(detailed.getItemQuantity());
			finalOrder.setItemPrice(detailed.getItemPrice());

			customerItems.add(finalOrder);
		}

//		finalOrder.set
		return customerItems;
	}

	private String getItemNameByID(Integer itemID) {
		List<ItemDetails> items = getAllItems();
		String itemname = "";
		for (ItemDetails item : items) {
			if (item.getItemID() == itemID) {
				itemname = item.getItemName();
				break;
			}

		}
		return itemname;
	}

	public List<CustomerDetails> allCUstomers() {
		return customerRepository.findAll();
	}

	@GetMapping("/payNow/{cusID}")
	public List<OrderDetails> payNow(@PathVariable("cusID") Integer cusID) {
		List<OrderDetails> all = orderRepo.findAll();
		int totalCout = 0;

		all.stream().filter(obj -> obj.getUserID() == cusID).forEach(obj -> {
			obj.setPayStatus("paid");
			orderRepo.save(obj);
		});

		return orderRepo.findAll();
	}

	@GetMapping("/getAllOrders")
	public List<OrderDetails> getAllOrders() {

		return orderRepo.findAll();
	}

	@GetMapping("/getAllPaidUnpaidOrders")
	public List<AllPaidUnpaidOrders> getAllPaidUnpaidOrders() {
		AllPaidUnpaidOrders paidUnpaidOrders = new AllPaidUnpaidOrders();
		List<OrderDetails> allOrders = getAllOrders();
		System.out.println(allOrders);
		List<AllPaidUnpaidOrders> allPaidUnpaidOrders = new ArrayList<>();
		for (OrderDetails order : allOrders) {
			paidUnpaidOrders.setItemID(order.getItemID());
			paidUnpaidOrders.setOrderID(order.getOrderID());
			paidUnpaidOrders.setPayStatus(order.getPayStatus());
			paidUnpaidOrders.setUserID(order.getUserID());
			paidUnpaidOrders.setPriceWithQuantity(order.getPriceWithQuantity());
//			paidUnpaidOrders.setUserName(getUserNameByID(order.getUserID()));
			System.out.println(paidUnpaidOrders.getOrderID() + " " + paidUnpaidOrders.getPayStatus());
			allPaidUnpaidOrders.add(paidUnpaidOrders);

		}
		return allPaidUnpaidOrders;
	}

	@GetMapping("/getUserNameByID/{cusID}")
	public String getUserNameByID(@PathVariable("cusID") Integer userID) {
		List<CustomerDetails> allCust = customerRepository.findAll();
		for (CustomerDetails cus : allCust) {
			if (userID == cus.getUserID())
				return cus.getFullName();

		}
		return null;
	}

	@PostMapping("/login")
	public LoginResponse login(@RequestBody LoginRequest req) {
		LoginResponse response = new LoginResponse();
		boolean flag = false;
		List<CustomerDetails> allCustomers = customerRepository.findAll();
		for (CustomerDetails cus : allCustomers) {
			if (req.getMail().equals(cus.getMail()) && req.getPassword().equals(cus.getPassword())) {
				response.setId(cus.getUserID());
				response.setRole(cus.getRole());
				response.setMessage("success");
				flag = true;
				break;
			}

		}
		System.out.println(response);
		if (!flag)
			response.setMessage("invalid credentials");

		return response;

	}
}
