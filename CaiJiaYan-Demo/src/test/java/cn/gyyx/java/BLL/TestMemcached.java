package cn.gyyx.java.BLL;

import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import net.rubyeye.xmemcached.exception.MemcachedException;

public class TestMemcached {
	
	Memcached memcached = new Memcached();
	
	@Test
	public  void setValue() throws TimeoutException, InterruptedException, MemcachedException			{
		memcached.setValue("a1", "我必须是11");
		memcached.setValue("a2", "我必须是22");
		memcached.setValue("a3", "我必须是33");
		memcached.setValue("a4", "我必须是44");
		memcached.setValue("a5", "我必须是55");
		String value="我必须是11";
		assertEquals(value, memcached.getValue("a1"));
	}
	@Test
	public void  getValue() throws TimeoutException,
			InterruptedException, MemcachedException {
		memcached.getValue("a1");
		String value="我必须是11";
		assertEquals(value, memcached.getValue("a1"));
	}
	@Test
	public void deleteValue() throws TimeoutException, InterruptedException, MemcachedException{
		boolean blag= memcached.deleteValue("a2");
		assertTrue(blag);
		
	}	
	
	
}
