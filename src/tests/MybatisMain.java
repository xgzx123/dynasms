package tests;

import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import models.User;
/**
 * @author badqiu
 */
public class MybatisMain {
	
	public static void main(String[] args) throws Exception {
		
		Reader reader = Resources.getResourceAsReader("Configuration.xml");
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
		SqlSession session = sessionFactory.openSession();
		
		testCrud(session);
	}

	private static void testCrud(SqlSession session) {
		
		User user = new User();
		user.setName("JayZ");
		user.setPhone("13488888888");
		user.setAddr("shanghai");
		user.setDuty("software engineer");
		
		//test insert
		session.insert("UserMapper.insert",user);
		User fromDb = (User) session.selectOne("UserMapper.getById", user.getId());
		session.commit();
		System.out.println("user:"+user);
		System.out.println("fromDb:"+fromDb);
		assertTrue(user.equals(fromDb));
		
		//test update
		user.setName("badqiu");
		session.update("UserMapper.update",user);
		fromDb = (User) session.selectOne("UserMapper.getById", user.getId());
		assertTrue(user.equals(fromDb));
		
		// test select
		Long count = (Long)session.selectOne("UserMapper.count",user);
		assertTrue(1 == count);
		List list = session.selectList("UserMapper.pageSelect",user);
		fromDb = (User)list.get(0);
		assertTrue(fromDb.getName().equals(user.getName()));
		assertTrue(fromDb.equals(user));
		 
		//test delete
		session.delete("UserMapper.delete",user.getId());
		fromDb = (User) session.selectOne("UserMapper.getById", user.getId());
		assertTrue(fromDb == null);
	}
	
	public static void assertTrue(boolean v) {
		if(! v) {
			throw new IllegalStateException("test expression must be true");
		}
	}
}
