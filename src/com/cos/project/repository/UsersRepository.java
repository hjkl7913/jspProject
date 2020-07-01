package com.cos.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cos.project.db.DBConn;
import com.cos.project.model.Carts;
import com.cos.project.model.GameCode;
import com.cos.project.model.GameInfos;
import com.cos.project.model.UsedGameCode;
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
		

		
		// 사용한 코드 목록 userId로 찾기
		public List<UsedGameCode> UsedGameCodeSearch(int userId) {
			final String SQL = "SELECT id, userId, gameId, gamename, gameCode, useDate FROM USEDGAMECODE WHERE userId = ?";		
			
			List<UsedGameCode> usedGameCodes = new ArrayList<>();
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, userId);
			
				//if 돌려서 rs
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					UsedGameCode usedGameCode = new UsedGameCode(
							rs.getInt("id"),
							rs.getInt("userId"),
							rs.getInt("gameId"),
							rs.getString("gamename"),
							rs.getString("gameCode"),
							rs.getTimestamp("useDate")
							);
					usedGameCodes.add(usedGameCode);
				}
				return usedGameCodes;
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"gameCodeUse : "+e.getMessage());
				
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		// 구매 테이블에 추가하기
		public int BuyGameAdd(int gameId ,int userId, String gamename) {
			final String SQL = "INSERT INTO userOrderList(orderId, gameId, userId, gamename, buyDate) VALUES(BUYLIST_SEQ.nextval,?,?,?,sysdate)";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기gameId
				pstmt.setInt(1, gameId);
				pstmt.setInt(2, userId);
				pstmt.setString(3, gamename);

				
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"BuyGameAdd : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		//사용된 코드 테이블에 추가
		public int UsedGameCodeAdd(int userId ,int gameId, String gamename, String Gcode) {
			final String SQL = "INSERT INTO USEDGAMECODE(id, userId, gameId, gamename, gameCode, useDate) VALUES(USEDCODE_SEQ.nextval,?,?,?,?,sysdate)";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, userId);
				pstmt.setInt(2, gameId);
				pstmt.setString(3, gamename);
				pstmt.setString(4, Gcode);

				
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"UsedGameCodeAdd : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		
		// gameCode 정보 가져가기
		public GameCode gameCodeUse(String code) {
			final String SQL = "SELECT codeId, gameId, gamename , code FROM gameCode WHERE code = ?";		
			
			GameCode gameCode = null;
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setString(1, code);
			
				//if 돌려서 rs
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					gameCode = new GameCode();
					gameCode.setCodeId(rs.getInt("codeId"));
					gameCode.setGameId(rs.getInt("gameId"));
					gameCode.setGamename(rs.getString("gamename"));
					gameCode.setCode(rs.getString("code"));
				}
				return gameCode;
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"gameCodeUse : "+e.getMessage());
				
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		//gameCode 테이블에서 지우기
		public int gameCodeDelete(int codeId) {
			final String SQL = "DELETE FROM gamecode WHERE codeId = ?";		

			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, codeId);
				
				//if 돌려서 rs
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+" gameCodeDelete : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		
		//게임코드 체크 
		public GameCode gameCodeCheck(String code) {
			final String SQL = "SELECT codeId, gameId, gamename, code  FROM gameCode WHERE code = ?";		
				
				GameCode gameCode = null;
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setString(1, code);
			
				//if 돌려서 rs
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					gameCode = GameCode.builder()
							.codeId(rs.getInt("codeId"))
							.gameId(rs.getInt("gameId"))
							.gamename(rs.getString("gamename"))
							.code(rs.getString("code"))
							.build();
								
				}
				return gameCode;
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"gameCodeCheck : "+e.getMessage());
				
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		
		// 게임 구매 하기 
		public int gameBuy(int gameId, int userId, String gamename) {
			final String SQL = "INSERT INTO userOrderList(orderId , gameId , userId, gamename, buyDate) VALUES(BUYLIST_SEQ.nextval,?,?,?,sysdate)";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, gameId);
				pstmt.setInt(2, userId);
				pstmt.setString(3, gamename);

				
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"gameBuy : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		//게임구매시 카운트 증가
		public int gameBuyCount(int id) {
			final String SQL = "UPDATE gameinfo SET buyCount = buyCount+1 where id = ? ";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, id);
				

				System.out.println("SQL : " +SQL);
				
				System.out.println("pstmt.executeUpdate() : "+ pstmt.executeUpdate());
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"gameBuyCount : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		//게임 구매했는지 확인
		public int userGamebuyCheck(int gameId, int userId, String gamename) {
			final String SQL = "SELECT count(*) FROM userOrderList WHERE gameid=? and userid = ? and gamename = ?";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, gameId);
				pstmt.setInt(2, userId);
				pstmt.setString(3, gamename);

				//if 돌려서 rs
				rs = pstmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1); // 0 or 1
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"userGamebuyCheck : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		
		public int cartDeleteById(int id) {
			final String SQL = "DELETE FROM cart WHERE id = ?";		

			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, id);
				
				//if 돌려서 rs
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+" cartDeleteById : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		
		public List<Carts> findCartByUserId(int userId) {
			final String SQL = "SELECT id, gameId, userId, gamename, contentImage, price FROM cart WHERE userId = ?";		
			
			List<Carts> carts = new ArrayList<>(); 
			
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, userId);
			
				//if 돌려서 rs
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					Carts cart = new Carts(
							rs.getInt("id"),
							rs.getInt("gameId"),
							rs.getInt("userId"),
							rs.getString("gamename"),
							rs.getString("contentImage"),
							rs.getString("price")
							);
					carts.add(cart);
				}
				return carts;
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"findCartByUserId : "+e.getMessage());
				
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		public int findCartCheck(int gameId, int userId, String gamename) {
			final String SQL = "SELECT count(*) FROM cart WHERE gameid=? and userid = ? and gamename = ?";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, gameId);
				pstmt.setInt(2, userId);
				pstmt.setString(3, gamename);

				//if 돌려서 rs
				rs = pstmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1); // 0 or 1
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"findCartCheck : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		
		public int passwordUpdate(int id, String newPassword) {
			final String SQL ="UPDATE users SET  password = ?  WHERE id = ?";
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				// 물음표 완성하기
				
				pstmt.setString(1, newPassword);
				pstmt.setInt(2, id);
				
				
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"passwordUpdate : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt);
			}
			
			return -1;
		}
		
		
		public int cartAdd(int gameId, int userId, String gamename, String contentImage, String price) {
			final String SQL = "INSERT INTO cart(id, gameId , userId, gamename, contentImage, price) VALUES(CART_SEQ.nextval,?,?,?,?,?)";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, gameId);
				pstmt.setInt(2, userId);
				pstmt.setString(3, gamename);
				pstmt.setString(4, contentImage);
				pstmt.setString(5, price);

				
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"cartAdd : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		public int idAndPasswordCheck(int id, String password) {
			final String SQL = "SELECT count(*) FROM users WHERE id=? and password = ?";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, id);
				pstmt.setString(2, password);
				
				//if 돌려서 rs
				rs = pstmt.executeQuery();
				if(rs.next()) {
					return rs.getInt(1); // 0 or 1
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"idAndPasswordCheck : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		public int tempPasswordUpdate(String email, String nasuPassword) {
			final String SQL ="UPDATE users SET password = ?  WHERE email = ?";
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				// 물음표 완성하기
				
				pstmt.setString(1, nasuPassword);
				pstmt.setString(2, email);
				
				
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"tempPasswordUpdate : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt);
			}
			
			return -1;
		}
		
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
