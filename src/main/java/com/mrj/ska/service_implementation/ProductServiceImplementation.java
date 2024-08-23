package com.mrj.ska.service_implementation;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mrj.ska.model.Notification;
import com.mrj.ska.model.Product;
import com.mrj.ska.model.PurchaseHistory;
import com.mrj.ska.repository.NotificationRepository;
import com.mrj.ska.repository.ProductRepository;
import com.mrj.ska.repository.PurchaseHistoryRepo;
import com.mrj.ska.service.ProductService;

@Service
public class ProductServiceImplementation implements ProductService {

	ProductRepository proRepo;
	PurchaseHistoryRepo purRepo;
	NotificationRepository notRepo;

	public ProductServiceImplementation(ProductRepository proRepo, PurchaseHistoryRepo purRepo,
			NotificationRepository notRepo) {
		super();
		this.proRepo = proRepo;
		this.purRepo = purRepo;
		this.notRepo = notRepo;
	}

	@Override
	public String addProduct(Product pro) {
		String msg = "";
		PurchaseHistory purchaseHistory = new PurchaseHistory();
		purchaseHistory.setProduct(pro);
		purchaseHistory.setUser(pro.getUser());
		purchaseHistory.setQuantity(pro.getQuantity());
		msg = proRepo.save(pro);
		purRepo.save(purchaseHistory);
		return msg;
	}

	@Override
	public String updateProduct(Product pro) {
		String msg = "";
		int preCount = proRepo.getSingleProductQuant(pro);
		int newCount = pro.getQuantity();
		if (preCount < newCount) {
			
			PurchaseHistory purchaseHistory = new PurchaseHistory();

			// product and user adding in purchase history
			purchaseHistory.setProduct(pro);
			purchaseHistory.setQuantity(newCount - preCount);
			purchaseHistory.setUser(pro.getUser());

			// product is updated
			msg = proRepo.update(pro);

			// purchase history saved
			purRepo.save(purchaseHistory);
		} else if (newCount == 0) {
			// Notification created
			Notification not = new Notification();
			not.setProduct(pro);
			not.setMessage(pro.getProductName() + " is Out of Stock. please re-fill it");
			not.setUser(pro.getUser());

			// product is updated
			msg = proRepo.update(pro);

			// Notification saved
			notRepo.save(not);
		} else {
			msg = proRepo.update(pro);
		}
		return msg;
	}

	@Override
	public String removeProduct(int id) {
		return proRepo.delete(id);
	}

	@Override
	public List<Product> getAllProducts() {
		return proRepo.findAllProducts();
	}

	@Override
	public List<Product> getProductsByUserId(int id) {
		return proRepo.filterProductByUserId(id);
	}

}
