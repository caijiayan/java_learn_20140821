package cn.gyyx.java.DAL;

import java.util.Hashtable;
import java.util.List;

import cn.gyyx.java.Model.ServerInfo;

import org.apache.ibatis.session.SqlSession;


public class ServerDAL extends BaseDAL {

	private SqlSession session= null;
	
	public List<ServerInfo> queryListByGameId(int gameId){
		
		String statm = "ServerInfo.queryListByGameId";
		
		List<ServerInfo> list = null;
		
		try {
			
			session= sessionFactory.openSession();
			list = session.selectList(statm,gameId);			
			
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			e.printStackTrace();
		} finally		{
			session.close();
		}
		
		return list;		
		
	}
	
	public ServerInfo getById(int id){
		String statm = "ServerInfo.queryById";
		
	ServerInfo info = null;
		
		try {
			
			session= sessionFactory.openSession();
			info = session.selectOne(statm, id);
			
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			e.printStackTrace();
		} finally		{
			session.close();
		}
		
		return info;		
	}
	
	public int insert(ServerInfo info){
		
		String statm="ServerInfo.insert";
		int result=0;
		
		try {
			session= sessionFactory.openSession();
			Hashtable param = new Hashtable();
			param.put("gameId", info.getGameId());
			param.put("serverName", info.getServerName());
			result = session.insert(statm, param);
		}  catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			e.printStackTrace();
		} finally		{
			session.close();
		}
		return result;
	}
	
	public int update(ServerInfo info){
		
		String statm="ServerInfo.Update";
		int result=0;
		
		try {
			session= sessionFactory.openSession();
			Hashtable param = new Hashtable();
			param.put("gameId", info.getGameId());
			param.put("serverName", info.getServerName());
			param.put("id", info.getId());
			result = session.update(statm, param);
		}  catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			e.printStackTrace();
		} finally		{
			session.close();
		}
		return result;
		
	}
	
	public int delete(int id){
		
		String statm="ServerInfo.Delete";
		int result=0;
		
		try {
			session= sessionFactory.openSession();
			result = session.delete(statm, id);
		}  catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			e.printStackTrace();
		} finally		{
			session.close();
		}
		return result;
		
	}
	
}
