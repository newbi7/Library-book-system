package lecture.jdbc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture.jdbc.vo.BookInfVO;

public class BookInfDAO {

	private SqlSessionFactory factory;

	public BookInfDAO() {	
	}

	public BookInfDAO(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}

	public ObservableList<BookInfVO> BookDetInf(String pid) {

		List<BookInfVO> list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectList("lib.bookInf.BookDetInf", pid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		ObservableList<BookInfVO> oList = FXCollections.observableArrayList(list);

		return oList;
	}

	public ObservableList<BookInfVO> selectbhave() {

		List<BookInfVO> list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectList("lib.bookInf.selectbhave");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		ObservableList<BookInfVO> oList = FXCollections.observableArrayList(list);

		return oList;
	}

	public int Bookreturn(String bisbn) {

		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.update("lib.bookInf.Bookreturn", bisbn);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	public int Bookborrowinfvo(BookInfVO target) {

		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.insert("lib.bookInf.Bookborrowinfvo", target);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}


	public int PointCalcul(String pid) {

		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.update("lib.bookInf.PointCalcul", pid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	public BookInfVO mainPointView(String pid) {

		BookInfVO list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectOne("lib.bookInf.mainPointView", pid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;
	}

	public BookInfVO bookHaveCheck(String bnumber) {

		BookInfVO list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectOne("lib.bookInf.bookHaveCheck", bnumber);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;

	}

	public BookInfVO PeopleUpdatenp(String pid) {
	
		BookInfVO list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectOne("lib.bookInf.PeopleUpdatenp", pid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		return list;

	}
}
