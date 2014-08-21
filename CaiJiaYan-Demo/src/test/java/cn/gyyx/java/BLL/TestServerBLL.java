package cn.gyyx.java.BLL;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.gyyx.java.BLL.*;
import cn.gyyx.java.Model.ServerInfo;

public class TestServerBLL {

	ServerBLL serverBll = new ServerBLL();
	

	@Test
	public void TestQueryListByGameId()
	{		
		List<ServerInfo>	list= serverBll.queryListByGameId(1);
		assertNotNull(list);
	}
	@Test
	public void TestGetById(){
		ServerInfo info= serverBll.getById(1, 1);
		assertNotNull(info);
	}
	@Test
	public void TestInsert(){		
		ServerInfo info = new ServerInfo();
		info.setGameId(2);
		info.setServerName("測試11");
		
		int result =  serverBll.insert(info);
		assertTrue(result>0);
	}
	@Test
	public void TestUpdate(){
		ServerInfo info = new ServerInfo();
		info.setGameId(2);
		info.setServerName("測試231");
		info.setId(2);
		int result = serverBll.update(info);
	    assertTrue(result>0);
	}
	@Test
	public void TestDelete(){
		int id = 4;
		int result = serverBll.delete(id);
		//assertTrue(result>0);
	}
	
	
}
