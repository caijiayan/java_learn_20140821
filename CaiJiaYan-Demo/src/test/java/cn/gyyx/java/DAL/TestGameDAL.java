package cn.gyyx.java.DAL;





import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import cn.gyyx.java.DAL.*;
import cn.gyyx.java.Model.GameInfo;

public class TestGameDAL {

	GameDAL gameDal = new GameDAL();
	
	@Test
	public void queryList(){
		
		List<GameInfo> list = gameDal.queryList();
		//Assert.assertTrue(list.isEmpty());
		assertNotNull(list);
		
	}
	
}
