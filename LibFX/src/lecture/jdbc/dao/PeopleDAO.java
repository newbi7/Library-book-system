package lecture.jdbc.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lecture.jdbc.vo.PeopleVO;


public class PeopleDAO {

	private SqlSessionFactory factory;

	public PeopleDAO() {	
	}

	public PeopleDAO(SqlSessionFactory factory) {
		super();
		this.factory = factory;
	}

	public ObservableList<PeopleVO> peopleSearch(String pname) {
		List<PeopleVO> list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectList("lib.people.peopleSearch", pname);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		ObservableList<PeopleVO> oList = FXCollections.observableArrayList(list);

		return oList;
	}

	public ObservableList<PeopleVO> loginpage(PeopleVO target) {

		List<PeopleVO> list = null;

		SqlSession session = factory.openSession();
		try {
			list = session.selectList("lib.people.loginpage", target);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		ObservableList<PeopleVO> oList = FXCollections.observableArrayList(list);

		return oList;
	}

	public ObservableList<PeopleVO> IDfind(PeopleVO target) {

		List<PeopleVO> list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectList("lib.people.IDfind", target);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		ObservableList<PeopleVO> oList = FXCollections.observableArrayList(list);

		return oList;
	}

	public ObservableList<PeopleVO> PWfind(PeopleVO target) {

		List<PeopleVO> list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectList("lib.people.PWfind", target);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}

		ObservableList<PeopleVO> oList = FXCollections.observableArrayList(list);

		return oList;
	}

	public int NewAssign(PeopleVO target) {
		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.insert("lib.people.NewAssign", target);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	public PeopleVO PeopleInf(String pid) {

		PeopleVO list = null;

		SqlSession session = factory.openSession();

		try {
			list = session.selectOne("lib.people.PeopleInf", pid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
		
		return list;
	}

	public PeopleVO DeletePeople(String pid) {

		PeopleVO DeletePeoples = null;

		SqlSession session = factory.openSession();

		try {
			DeletePeoples = session.selectOne("lib.people.DeletePeople", pid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			session.commit();
			session.close();
		}

		return DeletePeoples;
	}

	public ObservableList<PeopleVO> IDMatch(String pid) {

		List<PeopleVO> IDMatchpagelist = null;

		SqlSession session = factory.openSession();

		try {
			IDMatchpagelist = session.selectList("lib.people.IDMatch", pid);
		} catch (Exception e) {
			e.printStackTrace();
		} finally { 
			session.commit();
			session.close();
		}

		ObservableList<PeopleVO> oList = FXCollections.observableArrayList(IDMatchpagelist);

		return oList;
	}

	public int Peopleinfins(PeopleVO target) {

		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.update("lib.people.Peopleinfins", target);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}

		return result;
	}

	public int Peoplepointcount(PeopleVO target) {

		int result = 0;

		SqlSession session = factory.openSession();

		try {
			result = session.update("lib.people.Peoplepointcount", target);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.commit();
			session.close();
		}
		return result;

	}
}
