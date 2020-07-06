package com.cos.project.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.cos.project.db.DBConn;
import com.cos.project.model.GameInfos;
import com.cos.project.model.GameNews;
import com.cos.project.model.Users;

public class GameNewsRepository {
		private static final String TAG = "GameNewsRepository  : ";
		private static GameNewsRepository instance = new GameNewsRepository();
		private GameNewsRepository() {}
		
		public static GameNewsRepository getInstance() {
			return instance;
		}
		
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		
		public List<GameNews> findNewsAll() {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT /*+ INDEX_DESC(GAMENEWS GAMENEWS_PK)*/id, ");
			sb.append("gameId, image, content, createDate,timeAgo ");
			sb.append("FROM GAMENEWS ");	
			sb.append("ORDER BY id DESC ");	
			//sb.append("OFFSET ? ROWS FETCH FIRST 16 ROWS ONLY ");
			
			
			final String SQL = sb.toString();
			System.out.println(TAG+" SQL : "+SQL);
			List<GameNews> gameNews = new ArrayList<>();
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
					
				
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				while(rs.next()) {
					GameNews gameNew = new GameNews(
							rs.getInt("id"),
							rs.getInt("gameId"),
							rs.getString("image"),
							rs.getString("content"),
							rs.getTimestamp("createDate"),
							rs.getString("timeAgo")
					);
					gameNews.add(gameNew);
				}
				
				return gameNews;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"findNewsAll() : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		public int newsAdd(GameNews gameNews) {
			final String SQL = "INSERT INTO GAMENEWS(id, gameId, image, content, createDate) VALUES(GAMENEWS_SEQ.nextval,?,?,?,sysdate)";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, gameNews.getGameId());
				pstmt.setString(2, gameNews.getImage());
				pstmt.setString(3, gameNews.getContent());

				
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"newsAdd : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
}
