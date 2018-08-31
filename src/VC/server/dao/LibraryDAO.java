package VC.server.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import VC.common.Book;
import VC.server.db.DBstart;

public class LibraryDAO extends DBstart{

	
	public LibraryDAO() throws ClassNotFoundException, SQLException {
		super();
	}
	
	public List<Book> getBookByBookname(String bookname) throws SQLException {
		
		/*
		 * æ‰§è¡Œè¯­å�¥éƒ¨åˆ†
		 * æ­¤å¤„parasæ ¹æ�®æ‰€éœ€è¦�çš„æ•°é‡�æ�¥new
		 * sqlæŸ¥é˜…ç›¸å…³æ–‡æ¡£å�¯çŸ¥é�“
		 * å�Žç»­æ‰§è¡Œ
		 */
		paras = new String[1];
		paras[0] = null;
		paras[0] = bookname;
		sql = "select * from library where bookname = ?";
		ps = ct.prepareStatement(sql);
		for(int i=0;i<paras.length;i++)
		{
			ps.setString(i+1, paras[i]);
		}
		rs = ps.executeQuery();

		/*
		 * ç»“æžœè½¬åŒ–éƒ¨åˆ†
		 * ç»“æžœå­˜åœ¨rsé‡Œ,ä½¿ç”¨ä¸‹é�¢æ–¹æ³•å…¨éƒ¨ä»¥Listå�–å‡º
		 */
		Book book = new Book();
		List<Book> booklist = new ArrayList<Book>();
		
		while(rs.next()) {

			book = new Book();
			book.setBookName(rs.getString("bookname"));
			book.setBookAuthor(rs.getString("bookpublisher"));
			book.setBookPublisher(rs.getString("bookauthor"));
			
			booklist.add(book);
		}
		/*
		 * è¿™é‡Œä¸€å¼€å§‹ç”¨çš„æ˜¯ä¾�èµ–æ³¨å…¥çš„æ–¹å¼�  
		 * å¹¶æ²¡æœ‰åœ¨æ¯�æ¬¡çš„å¾ªçŽ¯ä¸­ä½¿ç”¨newå¯¹è±¡çš„æ–¹å¼�  ä½†æ˜¯æ¯�æ¬¡å¾ªçŽ¯ä¹Ÿæ˜¯å�Œæ ·è®¾ç½®äº†ä¸�å�Œçš„å€¼ 
		 * ä½†æ˜¯å�ŽæœŸæµ‹è¯•çš„æ—¶å€™å�‘çŽ°å¾ªçŽ¯è¿™ä¸ªlistå§‹ç»ˆå�ªèƒ½å¾—åˆ°ç¬¬ä¸€æ¬¡æ�’å…¥çš„æ•°æ�® ä¸ºä»€ä¹ˆå‘¢ï¼Ÿ
		 * åŽŸå› åœ¨è¿™é‡Œ  å› ä¸ºä¾�èµ–æ³¨å…¥çš„åŽŸå›  
		 * é‚£ä¹ˆä¹Ÿå°±æ˜¯ç›¸å½“äºŽæˆ‘ä»¬å�ªnewäº†ä¸€æ¬¡  
		 * å�Žé�¢çš„æ•°æ�®å°½ç®¡åœ¨ä¸�å�œçš„æ”¹å�˜ä½†æ˜¯ä»–åœ¨å†…å­˜ä¸­çš„idå”¯ä¸€  
		 * è€Œlist.add æ˜¯å¼•ç”¨  æ‰€ä»¥ä¸€ç›´éƒ½ä¼šæ ¹æ�®idåŽ»å¯»æ‰¾  
		 * ä¹Ÿå°±æ˜¯ç¬¬ä¸€æ¬¡newå‡ºæ�¥çš„é‚£ä¸ª
		 * ç±»ä¼¼çš„,å§‹ç»ˆå¾—åˆ°æœ€å�Žä¸€æ¬¡çš„æ•°æ�®çš„åŽŸå› æ˜¯
		 * å®ƒæŒ‡å�‘çš„æ˜¯é‚£ä¸ªæŒ‡é’ˆ,ç„¶å�Žæˆ‘ä»¬æ”¹å�˜äº†çš„æ˜¯å†…å®¹çš„å€¼
		 * æŒ‡é’ˆæ²¡æœ‰å�˜åŒ–,æ‰€ä»¥çœ‹èµ·æ�¥æŒ‡å�‘ä¸�å�Œçš„å€¼,å…¶å®žç”¨çš„æ˜¯ä¸€æ ¹æŒ‡é’ˆ
		 */
		return booklist;
	}
	
}
