package cn.gyyx.java;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Locale;

import junit.framework.Assert;
import cn.gyyx.java.Model.*;

import org.junit.Test;
import org.springframework.ui.Model;

import cn.gyyx.java.*;

public class TestHome {

	HomeController home = new HomeController();
	
	@Test
	public void TestGetServerListByGameId(){
		
		List<ServerInfo> list = home.getServerListByGameId(1);
		
		assertNotNull(list);
	}
	
	public void TestHome(){
	
	//	home.home(locale, model);
		
	}
	
}
