package cn.gyyx.java.DAL;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import java.util.List;



public class TestBaseDAL {
	
	
	@Test
	public void TestBaseDAL(){
		
		BaseDAL dal = new BaseDAL();
		assertNotNull(dal);	
	}
	
}
