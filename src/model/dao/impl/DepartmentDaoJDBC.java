package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import model.dao.DepartmentDao;
import model.entities.Department;

public class DepartmentDaoJDBC implements DepartmentDao {
	
	
	
	public DepartmentDaoJDBC(Connection conn) {
		
		this.conn = conn;
	}

	private Connection conn;

	@Override
	public void insert(Department obj) {
		PreparedStatement st = null;
		
		try {
			st=conn.prepareStatement(
					"INSERT INTO Department "
							+"(Name) "
							+"VALUES" 
							+"(?)",
							Statement.RETURN_GENERATED_KEYS);
			
			st.setString(1, obj.getName());
			
			int rowsAffect = st.executeUpdate();
			
			if (rowsAffect >0) {
				ResultSet rs = st.getGeneratedKeys();
				if(rs.next()) {
					int id= rs.getInt(1);
					obj.setId(id);
				}DB.closeResultSet(rs);
			}
			
		} catch (SQLException e) {
			throw new DbException(e.getMessage());
			
		}
		finally {
			DB.closeStatement(st);
		}
				
		
	}

	@Override
	public void update(Department obj) {
		
		PreparedStatement st = null;
		
		try {
			st = conn.prepareStatement(
					"UPDATE department "
					+"SET Name = ? "
					+"WHERE Id = ? ");
			
			st.setString(1, obj.getName());
			st.setInt(2, obj.getId());
			
			st.executeUpdate();
			
		} catch (SQLException e) {
			throw new DbException (e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
	}

	@Override
	public void deleteById(Integer id) {
		
		PreparedStatement st = null;
		try {
			st= conn.prepareStatement(
					"DELETE FROM department "
					+"WHERE "
					+"Id=  ?");
			st.setInt(1, id);
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new DbIntegrityException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
		}
		
		
	}

	@Override
	public Department findById(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st=conn.prepareStatement("SELECT* FROM department WHERE id = ?");
			 st.setInt(1, id);
			 
			 rs=st.executeQuery();
			 if(rs.next()) {
			 Department department = instantiateDepartment(rs);
			 return department;
			 }
			 else {
				 return null;
			 }
			
			 
			 
			
		} catch (SQLException e) {
			throw new DbException (e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
		
	}

	private Department instantiateDepartment(ResultSet rs) throws SQLException {
		
		Department department = new Department(
				rs.getInt("Id"),
				rs.getString("Name"));
		
		return department;
	}

	@Override
	public List<Department> findAll() {
		PreparedStatement st= null;
		ResultSet rs = null;
		Department department;
		List<Department> list= new ArrayList<>();
		
		try {
			st=conn.prepareStatement(
					"SELECT * FROM department ORDER BY name");
			
			rs= st.executeQuery();
			
			while(rs.next()) {
				department= instantiateDepartment(rs);
				list.add(department);
				
			}
			return list;
		} catch (SQLException e) {
			throw new DbException (e.getMessage());
			
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
		
	}
	
	

}
