package cn.gyyx.java.BLL;

import java.util.List;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.exception.MemcachedException;
import cn.gyyx.java.DAL.GameDAL;
import cn.gyyx.java.Model.GameInfo;




public class GameBLL {

	GameDAL dal = new GameDAL();
	
    private  String cacheKey = "/java_learn/caijiayan_game/L/";
	
	public List<GameInfo> queryList() 
	{
		List<GameInfo> list = null;
		try {
			
			list = getCache();
			if(list==null || list.size()==0){
				list = dal.queryList();
				if(list != null && list.size()>0){
					setCache(list);
				}
			}
			
		} catch (Exception e) {
			// 
		}
		
		return list;
	}
	
	private List<GameInfo> getCache() 
	{
		try {
			return (List<GameInfo>) Memcached.getValue(cacheKey);
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
	
	private void setCache(List<GameInfo> list){
	
		try {
			Memcached.setValue(cacheKey, list);
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
