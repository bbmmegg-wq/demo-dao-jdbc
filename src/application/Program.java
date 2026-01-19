package application;

import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller =sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n ----- TEST 2: seller findALL-----");
		
		Department dep = new Department(2, null);
		
		
		List<Seller>list= sellerDao.findAll();
		
		
		for(Seller i: list) {
			System.out.println(i);
		}
		
	
	}

}
