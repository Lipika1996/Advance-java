package com.js.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductCrud {
	static String url = "jdbc:mysql://127.0.0.01:3306/jdbc_ps";
	static String user = "root";
	static String password = "Lipika@1234";

	public void saveProduct(Product p) {
		String query="insert into product values(?,?,?,?,?)";
		Connection c = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url, user, password);
			PreparedStatement ps = c.prepareStatement(query);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setString(3,p.getBrand());
			ps.setInt(4, p.getQuantity());
			ps.setDouble(5, p.getPrice());
			
	        ps.execute();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		finally {
			try {
				c.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
		
		public void deleteProduct(int id) {
			String url = "jdbc:mysql://127.0.0.01:3306/jdbc_ps";
			String user = "root";
			String password = "Lipika@1234";
			String query="delete from product where id=?";
			Connection c = null;
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				c = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = c.prepareStatement(query);
				ps.setInt(1, id);
		        ps.execute();
		        System.out.println("Deleted");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			finally {
				try {
					c.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
		}
	}
		
		public void updateProduct(int id ,Product p) {
			ProductCrud pc = new ProductCrud();
			boolean b = pc.getProductById(id);
			if(b) {
				String query ="update product set name=?,brand=?,quantity=?,price=? where id=?";
				Connection c = null;
	
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				c = DriverManager.getConnection(url, user, password);
				PreparedStatement ps = c.prepareStatement(query);
				ps.setString(1, p.getName());
				ps.setString(2, p.getBrand());
				ps.setInt(3, p.getQuantity());
				ps.setDouble(4,p.getPrice());
				ps.setInt(5, id);
		        ps.execute();
		        System.out.println("Updated");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			finally {
				try {
					c.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
		else {
			System.out.println("No product with given id");
		}
		}

		private boolean getProductById(int id) {
			
			return false;
		}
}
	

