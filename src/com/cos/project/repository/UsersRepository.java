package com.cos.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cos.project.db.DBConn;
import com.cos.project.model.GameInfos;
import com.cos.project.model.Users;

public class UsersRepository {
		private static final String TAG = "UsersRepository  : ";
		private static UsersRepository instance = new UsersRepository();
		private UsersRepository() {}
		
		public static UsersRepository getInstance() {
			return instance;
		}
		
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		public Users findById(int id) {
			final String SQL = "SELECT id, username, displayname, email, userProfile, userRole, createDate, tel, address, company, companyVAT, companyAddress FROM users WHERE id = ?";		
			Users user = null;
			
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, id);
			
				//if 돌려서 rs
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					user = new Users();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setDisplayName(rs.getString("displayName"));
					user.setEmail(rs.getString("email"));
					user.setUserProfile(rs.getString("userProfile"));
					user.setUserRole(rs.getString("userRole"));
					user.setCreateDate(rs.getTimestamp("createDate"));
					user.setTel(rs.getString("tel"));
					user.setAddress(rs.getString("address"));
					user.setCompany(rs.getString("company"));
					user.setCompanyVAT(rs.getInt("companyVAT"));
					user.setCompanyAddress(rs.getString("companyAddress"));
				}
				return user;
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"findById : "+e.getMessage());
				
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		
		public int findByEmail(String email) {
			final String SQL = "SELECT count(*) FROM users WHERE email=?";		
			Users user = null;
			
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setString(1, email);
				
				//if 돌려서 rs
				rs = pstmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1); // 0 or 1
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"findByEmail : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		public Users findByEmailAndPassword(String email, String password) {
			final String SQL = "SELECT id, username, displayname, email, userProfile, userRole, createDate, tel, address, company, companyVAT, companyAddress FROM users WHERE email=? AND password = ?";		
			Users user = null;
			
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setString(1, email);
				pstmt.setString(2, password);
				
				//if 돌려서 rs
				rs = pstmt.executeQuery();
				if(rs.next()) {
					user = new Users();
					user.setId(rs.getInt("id"));
					user.setUsername(rs.getString("username"));
					user.setDisplayName(rs.getString("displayName"));
					user.setEmail(rs.getString("email"));
					user.setUserProfile(rs.getString("userProfile"));
					user.setUserRole(rs.getString("userRole"));
					user.setCreateDate(rs.getTimestamp("createDate"));
					user.setTel(rs.getString("tel"));
					user.setAddress(rs.getString("address"));
					user.setCompany(rs.getString("company"));
					user.setCompanyVAT(rs.getInt("companyVAT"));
					user.setCompanyAddress(rs.getString("companyAddress"));
				}
				return user;
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"findByEmailAndPassword : "+e.getMessage());
				
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		
		
		public int save(Users user) {
			final String SQL = "INSERT INTO users(id, username, displayname, email, password, userProfile, userRole, createDate) VALUES(USERS_SEQ.nextval,?,?,?,?,?,?,sysdate)";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setString(1, user.getUsername());
				pstmt.setString(2, user.getDisplayName());
				pstmt.setString(3, user.getEmail());
				pstmt.setString(4, user.getPassword());
				pstmt.setString(5, user.getUserProfile());
				pstmt.setString(6, user.getUserRole());

				
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"save : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		public int update(Users user) {
			final String SQL ="UPDATE users SET  displayName = ? , tel = ? , address = ? , company = ? , companyVAT = ? , companyAddress = ?  WHERE id = ?";
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				// 물음표 완성하기
				
				pstmt.setString(1, user.getDisplayName());
				pstmt.setString(2, user.getTel());
				pstmt.setString(3, user.getAddress());
				pstmt.setString(4, user.getCompany());
				pstmt.setInt(5, user.getCompanyVAT());
				pstmt.setString(6, user.getCompanyAddress());
				
				pstmt.setInt(7, user.getId());
				
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"update : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt);
			}
			
			return -1;
		}
		
}
