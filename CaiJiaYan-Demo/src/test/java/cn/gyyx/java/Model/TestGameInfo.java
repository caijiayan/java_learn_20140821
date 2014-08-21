package cn.gyyx.java.Model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestGameInfo {

GameInfo gameInfo = new GameInfo();
	
	@Test
	public void TestGetId() {
		gameInfo.setId(2);
		 int id =  gameInfo.getId();
		assertEquals(2,id);
	}
	@Test
	public void TestSetId(){
		gameInfo.setId(3);
		 int id =  gameInfo.getId();
		assertEquals(3,id);
	}

	@Test
	public void TestGetName() {
		gameInfo.setGameName("問道");
		 String gameName =  gameInfo.getGameName();
		assertEquals("問道",gameName);
	}
	@Test
	public void TestSetName() {
		gameInfo.setGameName("七殺");
		 String gameName =  gameInfo.getGameName();
		assertEquals("七殺",gameName);
	}
	
	
}
