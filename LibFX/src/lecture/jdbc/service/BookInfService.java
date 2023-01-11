package lecture.jdbc.service;

import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.ObservableList;
import lecture.jdbc.dao.BookInfDAO;
import lecture.jdbc.mybatis.MyBatisConnectionFactory;
import lecture.jdbc.vo.BookInfVO;

public class BookInfService {

	public ObservableList<BookInfVO> BookDetInf(String pid) {
		
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookInfDAO dao = new BookInfDAO(factory);

		ObservableList<BookInfVO> list = dao.BookDetInf(pid);

		return list;
	}

	public ObservableList<BookInfVO> selectbhave() {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookInfDAO dao = new BookInfDAO(factory);

		ObservableList<BookInfVO> list = dao.selectbhave();

		return list;
	}

	public int Bookreturn(String bisbn) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookInfDAO dao = new BookInfDAO(factory);

		int result = dao.Bookreturn(bisbn);

		return result;
	}

	public int Bookborrowinfvo(String pid, String bisbn, String btitle, String bdate, int bpage, int bprice
			, String bauthor, String btranslator, String bsupplement, String bpublisher, String imgurl) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookInfDAO dao = new BookInfDAO(factory);
		
		BookInfVO target = new BookInfVO(pid, bisbn, btitle, bpage, bdate, bprice
				, bauthor, btranslator, bsupplement, bpublisher, imgurl);
		
		
		
		
		int Bookborrowlist = dao.Bookborrowinfvo(target);

		return Bookborrowlist;
	}
	
	public int PointCalcul(String pid) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookInfDAO dao = new BookInfDAO(factory);

		int PointCalcullist = dao.PointCalcul(pid);

		return PointCalcullist;
	}
	
	public BookInfVO mainPointView(String pid) {
		
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookInfDAO dao = new BookInfDAO(factory);

		BookInfVO mainPointView = dao.mainPointView(pid);

		return mainPointView;
	}
	
	public BookInfVO bookHaveCheck(String bnumber) {
		
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookInfDAO dao = new BookInfDAO(factory);

		BookInfVO bookHaveChecktext = dao.bookHaveCheck(bnumber);

		return bookHaveChecktext;
	}
	
	public BookInfVO PeopleUpdatenp(String pid) {
		
		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		BookInfDAO dao = new BookInfDAO(factory);

		BookInfVO bookHaveChecktext = dao.PeopleUpdatenp(pid);

		return bookHaveChecktext;
	}

}
