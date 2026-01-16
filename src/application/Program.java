package application;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller =sellerDao.findById(2);
		
		System.out.println(seller);
		
		
		
	
	}

}
