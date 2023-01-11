package lecture.jdbc.service;

import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.ObservableList;
import lecture.jdbc.dao.BookDAO;
import lecture.jdbc.mybatis.MyBatisConnectionFactory;
import lecture.jdbc.vo.BookVO;

public class BookService {

	public BookService() {
	}
	
	public ObservableList<BookVO> selectBooksByKeyword(String btitle) {
		
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();
		
		BookDAO dao = new BookDAO(factory);

		ObservableList<BookVO> list = dao.selectbtitlesearch(btitle);

		return list;
	}

	public ObservableList<BookVO> selectdetailBooksByKeyword(String btitle) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookDAO dao = new BookDAO(factory);

		ObservableList<BookVO> detaillist = dao.detailselect(btitle);

		return detaillist;
	}


	public int Bookinfadd(String bisbn, String btitle, String bdate, int bpage, int bprice, 
			String bauthor, String btranslator, String bsupplement, String bpublisher, String bimgurl) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookDAO dao = new BookDAO(factory);

		BookVO target = new BookVO(bisbn, btitle, bdate, bpage, bprice, bauthor, btranslator, 
				bsupplement, bpublisher, bimgurl);
		
		int list = dao.BookNewAssign(target);

		return list;
	}

	public int DeleteBook(String bisbn) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookDAO dao = new BookDAO(factory);

		int list = dao.BookreturnVO(bisbn);
		
		return list;
	}

	public BookVO Bookinfstyle(String bisbn) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookDAO dao = new BookDAO(factory);

		BookVO books = dao.Bookinfstyle(bisbn);

		return books;
	}

	public int Bookinfins(String bisbn, String btitle, String bdate, int bpage, int bprice, String bauthor
			, String btranslator, String bsupplement, String bpublisher, String bimgurl) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookDAO dao = new BookDAO(factory);

		BookVO target = new BookVO(bisbn, btitle, bdate, bpage, bprice
				, bauthor, btranslator, bsupplement, bpublisher, bimgurl);
		
		int Bookinfinslist = dao.Bookinfins(target);

		return Bookinfinslist;
	}

	public int BookreturnVO(String bisbn) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookDAO dao = new BookDAO(factory);

		int list = dao.BookreturnVO(bisbn);

		return list;
	}

	public int Bookborrow(String bisbn) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookDAO dao = new BookDAO(factory);

		int Bookborrowlist = dao.Bookborrow(bisbn);

		return Bookborrowlist;
	}

	public BookVO Bookborrowcheck(String bisbn) {
		
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookDAO dao = new BookDAO(factory);

		BookVO Bookborrowchecks = dao.Bookborrowcheck(bisbn);

		return Bookborrowchecks;
	}
}






