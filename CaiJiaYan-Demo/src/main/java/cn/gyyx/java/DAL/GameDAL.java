package cn.gyyx.java.DAL;

import java.util.List;

import cn.gyyx.java.Model.GameInfo;

import org.apache.ibatis.session.SqlSession;

public class GameDAL extends BaseDAL {

	private SqlSession session= null;
	
	public List<GameInfo> queryList(){
		
		String statm = "GameInfo.queryList";
		
		List<GameInfo> list = null;
		
		try {
			
			session= sessionFactory.openSession();
			list = session.selectList(statm,null);			
			
		} catch (Exception e) {
			// TODO: handle exception
			session.rollback();
			e.printStackTrace();
		} finally		{
			session.close();
		}
		
		return list;
		
		
	}
	
	
}
