package cn.gyyx.java.BLL;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.code.yanf4j.util.ResourcesUtils;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.MemcachedClientBuilder;
import net.rubyeye.xmemcached.XMemcachedClientBuilder;
import net.rubyeye.xmemcached.auth.AuthInfo;
import net.rubyeye.xmemcached.command.BinaryCommandFactory;
import net.rubyeye.xmemcached.exception.MemcachedException;
import net.rubyeye.xmemcached.impl.ElectionMemcachedSessionLocator;
import net.rubyeye.xmemcached.utils.AddrUtil;


public class Memcached {
	
	private static MemcachedClient client;

	private static Object sysncObject = new Object();

	private static MemcachedClient getClient() {
		if (client == null) {
			synchronized (sysncObject) {
				if (client == null) {
					try {
						client = new XMemcachedClientBuilder(
								AddrUtil.getAddresses("192.168.6.195:10001"))
								.build();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
		return client;
	}

	public static <T> void setValue(String key, T info)
			throws TimeoutException, InterruptedException, MemcachedException {
		getClient().set(key, 3600, info);
	}

	public static <T> T getValue(String key) throws TimeoutException,
			InterruptedException, MemcachedException {
		return getClient().get(key);
	}
	
	public static boolean deleteValue(String key) throws TimeoutException, InterruptedException, MemcachedException{
		return getClient().delete(key);
		
	}	
	
}
