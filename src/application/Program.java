package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.DaoFactoryDepartment;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		SellerDao sellerDao = DaoFactory.createSellerDao();

		Seller seller = sellerDao.findById(3);

		System.out.println(seller);

		System.out.println("\n ----- TEST 2: seller findALL-----");

		Department dep = new Department(2, null);

		List<Seller> list = sellerDao.findAll();

		for (Seller i : list) {
			System.out.println(i);
		}

		LocalDate date = LocalDate.parse("17/12/1998", fmt);
		Seller seller1 = new Seller(null, "Beatriz", "bbmmegg@gmail.com", date, 3000.00, dep);

		sellerDao.insert(seller1);

		System.out.println("Inserted! New Id= " + seller1.getId());

		System.out.println("\n---------------- TEST UPGRADE ");
		seller = sellerDao.findById(16);
		seller.setBaseSalary(15000.0);
		sellerDao.update(seller);

		System.out.println("Update complete!");

		System.out.println("---------------TESTE DELETE---------------");
		sellerDao.deleteById(1);

		List<Department> list2 = new ArrayList<>();

		DepartmentDao dep2 = DaoFactoryDepartment.createDepartment();

		list2 = dep2.findAll();
		
		System.out.println("---------TEST DEPARTMENT------");

		for (Department i : list2) {
			System.out.println(i);
		}

	}

}
