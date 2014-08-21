package cn.gyyx.java.DAL;



import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;


import cn.gyyx.java.Model.ServerInfo;

public class TestServerDAL {

	ServerDAL serverDal = new ServerDAL();
	
	@Test
	public void TestQueryListByGameId(){
		
		List<ServerInfo> list = serverDal.queryListByGameId(1);

		assertNotNull(list);
	}
	
	@Test
	public void TestInsert(){
		ServerInfo info = new ServerInfo();
		info.setGameId(2);
		info.setServerName("測試");
		int result = serverDal.insert(info);
	
		assertTrue(result>0);
	}
	@Test
	public void TestUpdate(){
		ServerInfo info = new ServerInfo();
		info.setGameId(2);
		info.setServerName("測試1");
		info.setId(2);
		int result = serverDal.update(info);		
		
		assertTrue(result>0);
	}
	@Test
	public void TestDelete(){
		int id = 2;
		int result = serverDal.delete(id);		
		assertTrue(result>0);
	}
	@Test
	public void TestGetById(){
		int id=1;
		ServerInfo info = serverDal.getById(id);
		assertNotNull(info);
	}
}
