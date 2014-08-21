package cn.gyyx.java.BLL;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.gyyx.java.BLL.*;
import cn.gyyx.java.Model.GameInfo;

public class TestGameBLL {

	GameBLL gameBll = new GameBLL();
	
	@Test
	public void TestQueryList(){
		List<GameInfo> list = gameBll.queryList();
	
		assertNotNull(list);
	}
	
}
