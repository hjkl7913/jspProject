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
import com.cos.project.model.Users;

public class GameInfoRepository {
		private static final String TAG = "GameInfoRepository  : ";
		private static GameInfoRepository instance = new GameInfoRepository();
		private GameInfoRepository() {}
		
		public static GameInfoRepository getInstance() {
			return instance;
		}
		
		private Connection conn = null;
		private PreparedStatement pstmt = null;
		private ResultSet rs = null;
		
		//코드삭제
		public int adminCodeDeleteById(int codeId) {
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
				System.out.println(TAG+"adminCodeDeleteById : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		
		public List<GameCode> AdminCodeSearchAll() {
			final String SQL = "SELECT codeId, gameId, gamename, code FROM gamecode ORDER BY gamename";		
			
			List<GameCode> gameCodes = new ArrayList<>(); 
			
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
			

				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					GameCode gameCode = new GameCode(
							rs.getInt("codeId"),
							rs.getInt("gameId"),
							rs.getString("gamename"),
							rs.getString("code")
							);
					gameCodes.add(gameCode);
				}
				return gameCodes;
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"findCartByUserId : "+e.getMessage());
				
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		
		// 코드 있는지 체크 
		public int gameCodeCheck(String code) {
			final String SQL = "SELECT count(*)  FROM gameCode WHERE code = ?";		
				
				GameCode gameCode = null;
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setString(1, code);
			
				//if 돌려서 rs
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					return rs.getInt(1); // 0 or 1
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"gameCodeCheck : "+e.getMessage());
				
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		//코드 추가
		public int codeAdd(GameCode gameCode) {
			final String SQL = "INSERT INTO gamecode(codeId, gameId, gamename, code) VALUES(GAMECODE_SEQ.nextval,?,?,?)";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, gameCode.getGameId());
				pstmt.setString(2, gameCode.getGamename());
				pstmt.setString(3, gameCode.getCode());

				
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"codeAdd : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		public List<GameInfos> findByKeyword(String keyword) {
			final String SQL = "SELECT * FROM gameinfo WHERE gamename LIKE ?";
			
			List<GameInfos> gameInfos = new ArrayList<>();

			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				// 물음표 완성하기
				pstmt.setString(1, "%"+keyword+"%");
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					GameInfos gameInfo = new GameInfos(
							rs.getInt("id"),
							rs.getString("gamename"),
							rs.getString("price"),
							rs.getString("img"),
							rs.getString("movie"),
							rs.getString("developer"),
							rs.getString("publisher"),
							rs.getString("explanation"),
							rs.getString("tags"),
							rs.getString("rating"),
							rs.getString("releasedate"),
							rs.getString("platform"),
							rs.getString("minos"),
							rs.getString("minprocessor"),
							rs.getString("minmemory"),
							rs.getString("minGraphics"),
							rs.getString("minDirectX"),
							rs.getString("minStorage"),
							rs.getString("recomos"),
							rs.getString("recomprocessor"),
							rs.getString("recommemory"),
							rs.getString("recomGraphics"),
							rs.getString("recomDirectX"),
							rs.getString("recomStorage"),
							rs.getString("LanguagesSup"),
							rs.getString("freeDown"),
							rs.getString("gamePlayImage1"),
							rs.getString("gamePlayImage2"),
							rs.getString("gamePlayImage3"),
							rs.getString("contentImage"),
							rs.getString("content"),
							rs.getInt("buyCount")
					);
					gameInfos.add(gameInfo);
				}
				
				return gameInfos;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"findByKeyword : "+e.getMessage());
			} finally {
				DBConn.close(conn, pstmt, rs);
			}

			return null;
		}
		
		
		public List<GameInfos> findAll() {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT /*+ INDEX_DESC(GAMEINFO SYS_C007853)*/id, ");
			sb.append("gamename, price, img, movie, developer, publisher, explanation, tags, rating, releasedate, platform, minos, minprocessor, minmemory, minGraphics, minDirectX, minStorage, recomos, recomprocessor, recommemory, recomGraphics, recomDirectX, recomStorage, LanguagesSup, freedown, gamePlayImage1, gamePlayImage2, gamePlayImage3, contentImage, content, buyCount ");
			sb.append("FROM GAMEINFO ");	
			//sb.append("OFFSET ? ROWS FETCH FIRST 16 ROWS ONLY ");
			
			
			final String SQL = sb.toString();
			System.out.println(TAG+" SQL : "+SQL);
			List<GameInfos> gameInfos = new ArrayList<>();
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
					
				
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				while(rs.next()) {
					GameInfos gameInfo = new GameInfos(
							rs.getInt("id"),
							rs.getString("gamename"),
							rs.getString("price"),
							rs.getString("img"),
							rs.getString("movie"),
							rs.getString("developer"),
							rs.getString("publisher"),
							rs.getString("explanation"),
							rs.getString("tags"),
							rs.getString("rating"),
							rs.getString("releasedate"),
							rs.getString("platform"),
							rs.getString("minos"),
							rs.getString("minprocessor"),
							rs.getString("minmemory"),
							rs.getString("minGraphics"),
							rs.getString("minDirectX"),
							rs.getString("minStorage"),
							rs.getString("recomos"),
							rs.getString("recomprocessor"),
							rs.getString("recommemory"),
							rs.getString("recomGraphics"),
							rs.getString("recomDirectX"),
							rs.getString("recomStorage"),
							rs.getString("LanguagesSup"),
							rs.getString("freeDown"),
							rs.getString("gamePlayImage1"),
							rs.getString("gamePlayImage2"),
							rs.getString("gamePlayImage3"),
							rs.getString("contentImage"),
							rs.getString("content"),
							rs.getInt("buyCount")
					);
					gameInfos.add(gameInfo);
				}
				
				return gameInfos;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"findAll() : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		
		public List<GameInfos> findByTags(String tags) {
			final String SQL = "SELECT * FROM gameinfo WHERE tags LIKE ?";
			
			List<GameInfos> gameInfos = new ArrayList<>();

			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				// 물음표 완성하기
				pstmt.setString(1, "%"+tags+"%");
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					GameInfos gameInfo = new GameInfos(
							rs.getInt("id"),
							rs.getString("gamename"),
							rs.getString("price"),
							rs.getString("img"),
							rs.getString("movie"),
							rs.getString("developer"),
							rs.getString("publisher"),
							rs.getString("explanation"),
							rs.getString("tags"),
							rs.getString("rating"),
							rs.getString("releasedate"),
							rs.getString("platform"),
							rs.getString("minos"),
							rs.getString("minprocessor"),
							rs.getString("minmemory"),
							rs.getString("minGraphics"),
							rs.getString("minDirectX"),
							rs.getString("minStorage"),
							rs.getString("recomos"),
							rs.getString("recomprocessor"),
							rs.getString("recommemory"),
							rs.getString("recomGraphics"),
							rs.getString("recomDirectX"),
							rs.getString("recomStorage"),
							rs.getString("LanguagesSup"),
							rs.getString("freeDown"),
							rs.getString("gamePlayImage1"),
							rs.getString("gamePlayImage2"),
							rs.getString("gamePlayImage3"),
							rs.getString("contentImage"),
							rs.getString("content"),
							rs.getInt("buyCount")
							
					);
					gameInfos.add(gameInfo);
				}
				
				return gameInfos;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"findByTags : "+e.getMessage());
			} finally {
				DBConn.close(conn, pstmt, rs);
			}

			return null;
		}
		
		
		public List<GameInfos> ExpectedGameSelect() {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT /*+ INDEX_DESC(GAMEINFO SYS_C007853)*/id, ");
			sb.append("gamename, price, img, movie, developer, publisher, explanation, tags, rating, releasedate, platform, minos, minprocessor, minmemory, minGraphics, minDirectX, minStorage, recomos, recomprocessor, recommemory, recomGraphics, recomDirectX, recomStorage, LanguagesSup, freedown, gamePlayImage1, gamePlayImage2, gamePlayImage3, contentImage, content, buyCount ");
			sb.append("FROM GAMEINFO ");
			sb.append("WHERE releasedate like ? ");
			
			
			final String SQL = sb.toString();
			List<GameInfos> gameInfos = new ArrayList<>();
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				pstmt.setString(1, "%출시예정%");
				
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				while(rs.next()) {
					GameInfos gameInfo = new GameInfos(
							rs.getInt("id"),
							rs.getString("gamename"),
							rs.getString("price"),
							rs.getString("img"),
							rs.getString("movie"),
							rs.getString("developer"),
							rs.getString("publisher"),
							rs.getString("explanation"),
							rs.getString("tags"),
							rs.getString("rating"),
							rs.getString("releasedate"),
							rs.getString("platform"),
							rs.getString("minos"),
							rs.getString("minprocessor"),
							rs.getString("minmemory"),
							rs.getString("minGraphics"),
							rs.getString("minDirectX"),
							rs.getString("minStorage"),
							rs.getString("recomos"),
							rs.getString("recomprocessor"),
							rs.getString("recommemory"),
							rs.getString("recomGraphics"),
							rs.getString("recomDirectX"),
							rs.getString("recomStorage"),
							rs.getString("LanguagesSup"),
							rs.getString("freeDown"),
							rs.getString("gamePlayImage1"),
							rs.getString("gamePlayImage2"),
							rs.getString("gamePlayImage3"),
							rs.getString("contentImage"),
							rs.getString("content"),
							rs.getInt("buyCount")
					);
					gameInfos.add(gameInfo);
				}
				
				return gameInfos;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"BestGameSelect : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		public List<GameInfos> greateBestGameSelect() {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT /*+ INDEX_DESC(GAMEINFO SYS_C007853)*/id, ");
			sb.append("gamename, price, img, movie, developer, publisher, explanation, tags, rating, releasedate, platform, minos, minprocessor, minmemory, minGraphics, minDirectX, minStorage, recomos, recomprocessor, recommemory, recomGraphics, recomDirectX, recomStorage, LanguagesSup, freedown, gamePlayImage1, gamePlayImage2, gamePlayImage3, contentImage, content, buyCount ");
			sb.append("FROM GAMEINFO ");
			sb.append("ORDER BY buyCount desc ");		
			sb.append("OFFSET 0 ROWS FETCH FIRST 5 ROWS ONLY ");
			
			
			final String SQL = sb.toString();
			List<GameInfos> gameInfos = new ArrayList<>();
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
					
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				while(rs.next()) {
					GameInfos gameInfo = new GameInfos(
							rs.getInt("id"),
							rs.getString("gamename"),
							rs.getString("price"),
							rs.getString("img"),
							rs.getString("movie"),
							rs.getString("developer"),
							rs.getString("publisher"),
							rs.getString("explanation"),
							rs.getString("tags"),
							rs.getString("rating"),
							rs.getString("releasedate"),
							rs.getString("platform"),
							rs.getString("minos"),
							rs.getString("minprocessor"),
							rs.getString("minmemory"),
							rs.getString("minGraphics"),
							rs.getString("minDirectX"),
							rs.getString("minStorage"),
							rs.getString("recomos"),
							rs.getString("recomprocessor"),
							rs.getString("recommemory"),
							rs.getString("recomGraphics"),
							rs.getString("recomDirectX"),
							rs.getString("recomStorage"),
							rs.getString("LanguagesSup"),
							rs.getString("freeDown"),
							rs.getString("gamePlayImage1"),
							rs.getString("gamePlayImage2"),
							rs.getString("gamePlayImage3"),
							rs.getString("contentImage"),
							rs.getString("content"),
							rs.getInt("buyCount")
					);
					gameInfos.add(gameInfo);
				}
				
				return gameInfos;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"greateBestGameSelect : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		public List<GameInfos> BestGameSelect() {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT /*+ INDEX_DESC(GAMEINFO SYS_C007853)*/id, ");
			sb.append("gamename, price, img, movie, developer, publisher, explanation, tags, rating, releasedate, platform, minos, minprocessor, minmemory, minGraphics, minDirectX, minStorage, recomos, recomprocessor, recommemory, recomGraphics, recomDirectX, recomStorage, LanguagesSup, freedown, gamePlayImage1, gamePlayImage2, gamePlayImage3, contentImage, content, buyCount  ");
			sb.append("FROM GAMEINFO ");
			sb.append("ORDER BY price desc ");		
			sb.append("OFFSET 0 ROWS FETCH FIRST 6 ROWS ONLY ");
			
			
			final String SQL = sb.toString();
			List<GameInfos> gameInfos = new ArrayList<>();
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				while(rs.next()) {
					GameInfos gameInfo = new GameInfos(
							rs.getInt("id"),
							rs.getString("gamename"),
							rs.getString("price"),
							rs.getString("img"),
							rs.getString("movie"),
							rs.getString("developer"),
							rs.getString("publisher"),
							rs.getString("explanation"),
							rs.getString("tags"),
							rs.getString("rating"),
							rs.getString("releasedate"),
							rs.getString("platform"),
							rs.getString("minos"),
							rs.getString("minprocessor"),
							rs.getString("minmemory"),
							rs.getString("minGraphics"),
							rs.getString("minDirectX"),
							rs.getString("minStorage"),
							rs.getString("recomos"),
							rs.getString("recomprocessor"),
							rs.getString("recommemory"),
							rs.getString("recomGraphics"),
							rs.getString("recomDirectX"),
							rs.getString("recomStorage"),
							rs.getString("LanguagesSup"),
							rs.getString("freeDown"),
							rs.getString("gamePlayImage1"),
							rs.getString("gamePlayImage2"),
							rs.getString("gamePlayImage3"),
							rs.getString("contentImage"),
							rs.getString("content"),
							rs.getInt("buyCount")
					);
					gameInfos.add(gameInfo);
				}
				
				return gameInfos;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"BestGameSelect : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		
		public List<GameInfos> findByPriceZero() {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT /*+ INDEX_DESC(GAMEINFO SYS_C007853)*/id, ");
			sb.append("gamename, price, img, movie, developer, publisher, explanation, tags, rating, releasedate, platform, minos, minprocessor, minmemory, minGraphics, minDirectX, minStorage, recomos, recomprocessor, recommemory, recomGraphics, recomDirectX, recomStorage, LanguagesSup, freedown, gamePlayImage1, gamePlayImage2, gamePlayImage3, contentImage, content, buyCount ");
			sb.append("FROM GAMEINFO ");
			sb.append("WHERE price = ? ");		
			sb.append("OFFSET 0 ROWS FETCH FIRST 3 ROWS ONLY ");
			
			
			final String SQL = sb.toString();
			List<GameInfos> gameInfos = new ArrayList<>();
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				// 물음표 완성하기
				pstmt.setString(1, "무료");
				
				
				
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				while(rs.next()) {
					GameInfos gameInfo = new GameInfos(
							rs.getInt("id"),
							rs.getString("gamename"),
							rs.getString("price"),
							rs.getString("img"),
							rs.getString("movie"),
							rs.getString("developer"),
							rs.getString("publisher"),
							rs.getString("explanation"),
							rs.getString("tags"),
							rs.getString("rating"),
							rs.getString("releasedate"),
							rs.getString("platform"),
							rs.getString("minos"),
							rs.getString("minprocessor"),
							rs.getString("minmemory"),
							rs.getString("minGraphics"),
							rs.getString("minDirectX"),
							rs.getString("minStorage"),
							rs.getString("recomos"),
							rs.getString("recomprocessor"),
							rs.getString("recommemory"),
							rs.getString("recomGraphics"),
							rs.getString("recomDirectX"),
							rs.getString("recomStorage"),
							rs.getString("LanguagesSup"),
							rs.getString("freeDown"),
							rs.getString("gamePlayImage1"),
							rs.getString("gamePlayImage2"),
							rs.getString("gamePlayImage3"),
							rs.getString("contentImage"),
							rs.getString("content"),
							rs.getInt("buyCount")
					);
					gameInfos.add(gameInfo);
				}
				
				return gameInfos;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"findByPriceZero : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		
		public int update(GameInfos gameInfos) {
			final String SQL ="UPDATE gameinfo SET gamename = ?, price = ?, img = ?, movie = ?, developer = ?, publisher = ?, explanation = ?, tags = ?, rating = ?, releasedate = ?, platform = ?, minos = ?, minprocessor = ?, minmemory = ?, minGraphics = ?, minDirectX = ?, minStorage = ?, recomos = ?, recomprocessor = ?, recommemory = ?, recomGraphics = ?, recomDirectX = ?, recomStorage = ?, LanguagesSup = ?, freedown = ?, gamePlayImage1 = ?, gamePlayImage2 = ?, gamePlayImage3 = ?, contentImage = ? , content = ? WHERE id = ?";
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				// 물음표 완성하기
				
				pstmt.setString(1, gameInfos.getGamename());
				pstmt.setString(2, gameInfos.getPrice());
				pstmt.setString(3, gameInfos.getImage());
				pstmt.setString(4, gameInfos.getMovie());
				pstmt.setString(5, gameInfos.getDeveloper());
				pstmt.setString(6, gameInfos.getPublisher());
				pstmt.setString(7, gameInfos.getExplanation());
				pstmt.setString(8, gameInfos.getTags());
				pstmt.setString(9, gameInfos.getRating());
				pstmt.setString(10, gameInfos.getReleasedate());
				pstmt.setString(11, gameInfos.getPlatform());
				pstmt.setString(12, gameInfos.getMinOS());
				pstmt.setString(13, gameInfos.getMinProcessor());
				pstmt.setString(14, gameInfos.getMinMemory());
				pstmt.setString(15, gameInfos.getMinGraphics());
				pstmt.setString(16, gameInfos.getMinDirectX());
				pstmt.setString(17, gameInfos.getMinStorage());
				pstmt.setString(18, gameInfos.getRecomOS());
				pstmt.setString(19, gameInfos.getRecomProcessor());
				pstmt.setString(20, gameInfos.getRecomMemory());
				pstmt.setString(21, gameInfos.getRecomGraphics());
				pstmt.setString(22, gameInfos.getRecomDirectX());
				pstmt.setString(23, gameInfos.getRecomStorage());
				pstmt.setString(24, gameInfos.getLanguagesSupported());
				pstmt.setString(25, gameInfos.getFreeDown());
				pstmt.setString(26, gameInfos.getGamePlayImage1());
				pstmt.setString(27, gameInfos.getGamePlayImage2());
				pstmt.setString(28, gameInfos.getGamePlayImage3());
				pstmt.setString(29, gameInfos.getContentImage());
				pstmt.setString(30, gameInfos.getContent());
				pstmt.setInt(31, gameInfos.getId());
				
				return pstmt.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"update : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt);
			}
			
			return -1;
		}
		
		public GameInfos findById(int id) {
			final String SQL = "SELECT * FROM gameinfo WHERE id = ?";
			GameInfos gameInfos = null;

			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				// 물음표 완성하기
				pstmt.setInt(1, id);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					gameInfos = GameInfos.builder()
							.id(rs.getInt("id"))
							.gamename(rs.getString("gamename"))
							.price(rs.getString("price"))
							.image(rs.getString("img"))
							.movie(rs.getString("movie"))
							.developer(rs.getString("developer"))
							.publisher(rs.getString("publisher"))
							.explanation(rs.getString("explanation"))
							.tags(rs.getString("tags"))
							.rating(rs.getString("rating"))
							.releasedate(rs.getString("releasedate"))
							.platform(rs.getString("platform"))
							.minOS(rs.getString("minos"))
							.minProcessor(rs.getString("minprocessor"))
							.minMemory(rs.getString("minmemory"))
							.minGraphics(rs.getString("minGraphics"))
							.minDirectX(rs.getString("minDirectX"))
							.minStorage(rs.getString("minStorage"))
							.recomOS(rs.getString("recomos"))
							.recomProcessor(rs.getString("recomprocessor"))
							.recomMemory(rs.getString("recommemory"))
							.recomGraphics(rs.getString("recomGraphics"))
							.recomDirectX(rs.getString("recomDirectX"))
							.recomStorage(rs.getString("recomStorage"))
							.languagesSupported(rs.getString("LanguagesSup"))
							.freeDown(rs.getString("freedown"))
							.gamePlayImage1(rs.getString("gamePlayImage1"))
							.gamePlayImage2(rs.getString("gamePlayImage2"))
							.gamePlayImage3(rs.getString("gamePlayImage3"))
							.contentImage(rs.getString("contentImage"))
							.content(rs.getString("content"))
							.buyCount(rs.getInt("buyCount"))
							.build();
								
				}
				return gameInfos;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"findById : "+e.getMessage());
			} finally {
				DBConn.close(conn, pstmt, rs);
			}

			return null;
		}
		
		
		public List<GameInfos> findByPageAndKeyword(int page, String keyword) {
			StringBuilder sb = new StringBuilder();
			sb.append("SELECT /*+ INDEX_DESC(GAMEINFO SYS_C007853)*/id, ");
			sb.append("gamename, price, img, movie, developer, publisher, explanation, tags, rating, releasedate, platform, minos, minprocessor, minmemory, minGraphics, minDirectX, minStorage, recomos, recomprocessor, recommemory, recomGraphics, recomDirectX, recomStorage, LanguagesSup, freedown, gamePlayImage1, gamePlayImage2, gamePlayImage3, contentImage, content, buyCount ");
			sb.append("FROM GAMEINFO ");
			sb.append("WHERE gamename like ? ");		
			sb.append("OFFSET ? ROWS FETCH FIRST 16 ROWS ONLY ");
			
			
			final String SQL = sb.toString();
			System.out.println(TAG+" SQL : "+SQL);
			List<GameInfos> gameInfos = new ArrayList<>();
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				// 물음표 완성하기
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setInt(2, page*16);
				
				
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				while(rs.next()) {
					GameInfos gameInfo = new GameInfos(
							rs.getInt("id"),
							rs.getString("gamename"),
							rs.getString("price"),
							rs.getString("img"),
							rs.getString("movie"),
							rs.getString("developer"),
							rs.getString("publisher"),
							rs.getString("explanation"),
							rs.getString("tags"),
							rs.getString("rating"),
							rs.getString("releasedate"),
							rs.getString("platform"),
							rs.getString("minos"),
							rs.getString("minprocessor"),
							rs.getString("minmemory"),
							rs.getString("minGraphics"),
							rs.getString("minDirectX"),
							rs.getString("minStorage"),
							rs.getString("recomos"),
							rs.getString("recomprocessor"),
							rs.getString("recommemory"),
							rs.getString("recomGraphics"),
							rs.getString("recomDirectX"),
							rs.getString("recomStorage"),
							rs.getString("LanguagesSup"),
							rs.getString("freeDown"),
							rs.getString("gamePlayImage1"),
							rs.getString("gamePlayImage2"),
							rs.getString("gamePlayImage3"),
							rs.getString("contentImage"),
							rs.getString("content"),
							rs.getInt("buyCount")
					);
					gameInfos.add(gameInfo);
				}
				
				return gameInfos;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"findByPageAndKeyword(page, keyword) : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return null;
		}
		
		public int findBoardCount(String keyword) {
			int result = 0;
			final String SQL ="SELECT count(*) FROM board WHERE title Like ? OR content Like ?";
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				// 물음표 완성하기
				pstmt.setString(1, "%"+keyword+"%");
				pstmt.setString(2, "%"+keyword+"%");
				
				
				// while 돌려서 rs -> java 오브젝트에 집어넣기
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					result = rs.getInt(1);  
					System.out.println("result2 : "+result);
				
				}
				
				
				return result;
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(TAG+"findBoard(keyword) : "+e.getMessage());
				
			} finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
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
		
		public int deleteById(int id) {
			final String SQL = "DELETE FROM gameinfo WHERE id = ?";		

			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setInt(1, id);
				
				//if 돌려서 rs
				return pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"deleteById : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		public Users findByEmailAndPassword(String email, String password) {
			final String SQL = "SELECT id, username, displayname, email, userProfile, userRole, createDate FROM users WHERE email=? AND password = ?";		
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
		
		public int save(GameInfos gameInfos) {
			final String SQL = "INSERT INTO GAMEINFO(id, gamename, price, img, movie, developer, publisher, explanation, tags, rating, releasedate, platform, minos, minprocessor, minmemory, minGraphics, minDirectX, minStorage, recomos, recomprocessor, recommemory, recomGraphics, recomDirectX, recomStorage, LanguagesSup, freedown, gamePlayImage1, gamePlayImage2, gamePlayImage3, contentImage, content) VALUES(GAMEINFO_SEQ.nextval,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";		
			
			try {
				conn = DBConn.getConnection();
				pstmt = conn.prepareStatement(SQL);
				
				//물음표 완성하기
				pstmt.setString(1, gameInfos.getGamename());
				pstmt.setString(2, gameInfos.getPrice());
				pstmt.setString(3, gameInfos.getImage());
				pstmt.setString(4, gameInfos.getMovie());
				pstmt.setString(5, gameInfos.getDeveloper());
				pstmt.setString(6, gameInfos.getPublisher());
				pstmt.setString(7, gameInfos.getExplanation());
				pstmt.setString(8, gameInfos.getTags());
				pstmt.setString(9, gameInfos.getRating());
				pstmt.setString(10, gameInfos.getReleasedate());
				pstmt.setString(11, gameInfos.getPlatform());
				pstmt.setString(12, gameInfos.getMinOS());
				pstmt.setString(13, gameInfos.getMinProcessor());
				pstmt.setString(14, gameInfos.getMinMemory());
				pstmt.setString(15, gameInfos.getMinGraphics());
				pstmt.setString(16, gameInfos.getMinDirectX());
				pstmt.setString(17, gameInfos.getMinStorage());
				pstmt.setString(18, gameInfos.getRecomOS());
				pstmt.setString(19, gameInfos.getRecomProcessor());
				pstmt.setString(20, gameInfos.getRecomMemory());
				pstmt.setString(21, gameInfos.getRecomGraphics());
				pstmt.setString(22, gameInfos.getRecomDirectX());
				pstmt.setString(23, gameInfos.getRecomStorage());
				pstmt.setString(24, gameInfos.getLanguagesSupported());
				pstmt.setString(25, gameInfos.getFreeDown());
				pstmt.setString(26, gameInfos.getGamePlayImage1());
				pstmt.setString(27, gameInfos.getGamePlayImage2());
				pstmt.setString(28, gameInfos.getGamePlayImage3());
				pstmt.setString(29, gameInfos.getContentImage());
				pstmt.setString(30, gameInfos.getContent());

				
				return pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println(TAG+"save : "+e.getMessage());
			}finally {
				DBConn.close(conn, pstmt ,rs);
			}
			
			return -1;
		}
		
		
		
		
}
