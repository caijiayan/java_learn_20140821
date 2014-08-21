package cn.gyyx.java.Model;

import static org.junit.Assert.*;

import org.junit.Test;

import junit.framework.Assert;
import cn.gyyx.java.Model.*;

public class TestServerInfo {
	
	ServerInfo serverInfo = new ServerInfo();
	
	@Test
	public void TestGetId() {
		 serverInfo.setId(2);
		 int id =  serverInfo.getId();
		assertEquals(2,id);
	}
	@Test
	public void TestSetId(){
		serverInfo.setId(3);
		 int id =  serverInfo.getId();
		assertEquals(3,id);
	}
	@Test
	public void TestGetGameId() {
		serverInfo.setGameId(1);
		 int gameId =  serverInfo.getGameId();
		assertEquals(1,gameId);
	}
	@Test
	public void TestSetGameId() {
		
		serverInfo.setGameId(2);
		 int gameId =  serverInfo.getGameId();
		assertEquals(2,gameId);
		
	}
	@Test
	public void TestGetServerName() {
		serverInfo.setServerName("區服1");
		 String serverName =  serverInfo.getServerName();
		assertEquals("區服1",serverName);
	}
	@Test
	public void TestSetServerName() {
		serverInfo.setServerName("區服2");
		 String serverName =  serverInfo.getServerName();
		assertEquals("區服2",serverName);
	}
	
	
	
}
