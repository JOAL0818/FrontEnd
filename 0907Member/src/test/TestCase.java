package test;

import org.junit.Test;

import dao.UserDao;
import dao.UserDaoImpl;
import vo.TMember;

public class TestCase {
	@Test
	public void sampleTest() {
		UserDao userDao = UserDaoImpl.sharedInstance();
		TMember member = new TMember();
		member.setEmail("joal@naver.com");
		member.setPw("12345678");
		member.setName("조아라");
		member.setPhone("01021345678");
		member.setAddr("서울시중구");
		boolean r = userDao.registerMember(member);
		System.out.println(r);
	}
}
