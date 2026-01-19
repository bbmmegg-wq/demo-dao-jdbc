package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		SellerDao sellerDao = DaoFactory.createSellerDao();
		
		Seller seller =sellerDao.findById(3);
		
		System.out.println(seller);
		
		System.out.println("\n ----- TEST 2: seller findALL-----");
		
		Department dep = new Department(2, null);
		
		
		List<Seller>list= sellerDao.findAll();
		
		
		for(Seller i: list) {
			System.out.println(i);
		}
		
		LocalDate date = LocalDate.parse("17/12/1998", fmt);
		Seller seller1 = new Seller(null, "Beatriz", "bbmmegg@gmail.com", date, 3000.00, dep);
		
		sellerDao.insert(seller1);
		
		
		System.out.println("Inserted! New Id= " + seller1.getId());
		
	}

}
