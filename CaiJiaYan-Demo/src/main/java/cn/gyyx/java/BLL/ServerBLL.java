package cn.gyyx.java.BLL;

import java.util.List;



import java.util.concurrent.TimeoutException;

import org.junit.Assert;

import scala.annotation.meta.getter;
import net.rubyeye.xmemcached.exception.MemcachedException;
import cn.gyyx.java.DAL.ServerDAL;
import cn.gyyx.java.Model.GameInfo;
import cn.gyyx.java.Model.ServerInfo;

public class ServerBLL {

	ServerDAL dal = new ServerDAL();
	
	private  String cacheKey = "/java_learn/caijiayan_game_server/L/{}";

	public List<ServerInfo> queryListByGameId(int gameId)
	{
		List<ServerInfo> list = getCache(gameId);
		if(list==null || list.size()==0){
			list = dal.queryListByGameId(gameId);
			if(list!=null && list.size()>0){
				setCache(gameId, list);
			}
		}
		return list;
	}	
	
	public ServerInfo getById(int id,int gameId){
		List<ServerInfo> list = queryListByGameId(gameId);
		if(list!=null && list.size()>0){
			for (ServerInfo serverInfo : list) {
				if(serverInfo.getId()==id){
					return serverInfo;
				}
			}
		}
		return null;
	}
	
	public int insert(ServerInfo info){
		int result = dal.insert(info);
		if(result>0){
			deleteCache(info.getGameId());			
		}
		return result;
	}
	
	public int update(ServerInfo info){
		
		int result =dal.update(info);
		if(result>0){
			deleteCache(info.getGameId());			
		}
		return result;
	}
	
	public int delete(int id){
		
		int result =dal.delete(id);
		if(result>0){
			deleteCache(id);			
		}
		return result;
	}
	
	
	
	
	
 	private List<ServerInfo> getCache(int gameId) 
	{
		try {
			String key = String.format(cacheKey, gameId);
			return (List<ServerInfo>) Memcached.getValue(key);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	private void setCache(int gameId, List<ServerInfo> list){
	
		try {
			String key = String.format(cacheKey, gameId);
			Memcached.setValue(key, list);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void deleteCache(int gameId){
		
		String key = String.format(cacheKey, gameId);
		try {
			Memcached.deleteValue(key);
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}
