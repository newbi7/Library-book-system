package lecture.jdbc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture.jdbc.vo.BookVO;

public class BookDAO {

	private SqlSessionFactory factory;

	public BookDAO() {
	}

	public BookDAO(SqlSessionFactory factory) {
		this.factory = factory;
	}

	public ObservableList<BookVO> selectbtitlesearch(String btitle) {

		List<BookVO> list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectList("lib.book.selectbtitlesearch", btitle);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		ObservableList<BookVO> oList = FXCollections.observableArrayList(list);

		return oList;
	}

	public ObservableList<BookVO> detailselect(String btitle) {

		List<BookVO> list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectList("lib.book.detailselect", btitle);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		ObservableList<BookVO> oList = FXCollections.observableArrayList(list);

		return oList;

	}

	public int BookNewAssign(BookVO target) {

		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.update("lib.book.BookNewAssign", target);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	public int DeleteBooks(String bisbn) {

		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.update("lib.book.DeleteBooks", bisbn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	public BookVO Bookinfstyle(String bisbn) {

		BookVO list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectOne("lib.book.Bookinfstyle", bisbn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public int Bookinfins(BookVO target) {

		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.update("lib.book.Bookinfins", target);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	public int BookreturnVO(String bisbn) {

		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.update("lib.book.BookreturnVO", bisbn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	public int Bookborrow(String bisbn) {

		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.update("lib.book.Bookborrow", bisbn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	public BookVO Bookborrowcheck(String bisbn) {

		BookVO list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectOne("lib.book.Bookborrowcheck", bisbn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
		
	}
}
