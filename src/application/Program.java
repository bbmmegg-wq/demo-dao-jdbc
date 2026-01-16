package application;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner (System.in);
		
		Department department= new Department();
		
		Seller seller= new Seller(21, "Bob", "Bob@gmail.com", LocalDate.now(), 3000.00, department);
		
		System.out.println(seller);
		
		
		sc.close();
	
	}

}
