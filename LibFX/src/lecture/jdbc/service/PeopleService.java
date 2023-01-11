package lecture.jdbc.service;

import org.apache.ibatis.session.SqlSessionFactory;

import javafx.collections.ObservableList;
import lecture.jdbc.dao.PeopleDAO;
import lecture.jdbc.mybatis.MyBatisConnectionFactory;
import lecture.jdbc.vo.PeopleVO;

public class PeopleService {

	public ObservableList<PeopleVO> SearchPeopleService(String Id) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		PeopleDAO dao = new PeopleDAO(factory);

		ObservableList<PeopleVO> list = dao.peopleSearch(Id);

		return list;
	}

	public ObservableList<PeopleVO> loginPageService(String Id, String Pw) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		PeopleDAO dao = new PeopleDAO(factory);

		PeopleVO target = new PeopleVO();
		target.setPid(Id);
		target.setPpw(Pw);

		ObservableList<PeopleVO> list = dao.loginpage(target);

		return list;
	}

	public ObservableList<PeopleVO> IDFindpssnumber(String pname, String psNum) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		PeopleDAO dao = new PeopleDAO(factory);

		PeopleVO target = new PeopleVO(); target.setPname(pname);
		target.setPssnumber(psNum);

		ObservableList<PeopleVO> list = dao.IDfind(target);

		return list; 
	}

	public ObservableList<PeopleVO> PWFindpssnumber(String pname, String psNum,
			String pid) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		PeopleDAO dao = new PeopleDAO(factory);

		PeopleVO target = new PeopleVO(); 
		target.setPname(pname);
		target.setPssnumber(psNum); 
		target.setPid(pid);

		ObservableList<PeopleVO> list = dao.PWfind(target);

		return list; 
	}

	public int Newassign(String pid, String ppw, String pname, String pssnumber,
			String pphone) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		PeopleDAO dao = new PeopleDAO(factory);

		PeopleVO target = new PeopleVO(pid, ppw, pname, pssnumber, pphone);

		int result = dao.NewAssign(target);

		return result; 
	}


	public PeopleVO Peopleinf(String pid) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		PeopleDAO dao = new PeopleDAO(factory);

		PeopleVO list = dao.PeopleInf(pid);

		return list;
	}

	public PeopleVO DeletePeople(String pid) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		PeopleDAO dao = new PeopleDAO(factory);

		PeopleVO person = dao.DeletePeople(pid);

		return person; 
	}

	public ObservableList<PeopleVO> IDMatch(String pid) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		PeopleDAO dao = new PeopleDAO(factory);

		ObservableList<PeopleVO> list = dao.IDMatch(pid);

		return list; 
	}

	public int Peopleinfins(String pid, String ppw,
			String pname, String pssnumber, String pphone) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		PeopleDAO dao = new PeopleDAO(factory);

		PeopleVO target = new PeopleVO(pid, ppw, pname, pssnumber, pphone);

		int result = dao.Peopleinfins(target);

		return result; 
		
	}

	public int Peoplepointcount(int pbnumber, int ppoint, String pid) {

		SqlSessionFactory factory = MyBatisConnectionFactory.getSqlSessionFactory();

		PeopleDAO dao = new PeopleDAO(factory);

		PeopleVO target = new PeopleVO(pbnumber, ppoint, pid);
		int result = dao.Peoplepointcount(target);

		return result;

	}

}
