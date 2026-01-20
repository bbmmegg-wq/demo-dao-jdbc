package model.dao;

import db.DB;
import model.dao.impl.DepartmentDaoJDBC;

public class DaoFactoryDepartment {
	
	public static DepartmentDao createDepartment() {
		return new DepartmentDaoJDBC(DB.getConnection());
	}

}
