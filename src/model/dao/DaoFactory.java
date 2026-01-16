package model.dao;

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {
	
	public SellerDao crateSellerDao() {
		return new SellerDaoJDBC();
	}
	

}
