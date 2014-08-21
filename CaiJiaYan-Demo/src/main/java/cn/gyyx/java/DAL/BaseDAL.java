package cn.gyyx.java.DAL;

import java.io.IOException;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BaseDAL {

	private final static String resource = "cn/gyyx/java/Persistence/sqlMapConfig.xml";

	protected SqlSessionFactory sessionFactory;

	protected BaseDAL() {
		sessionFactory = createSession();
	}

	private SqlSessionFactory createSession() {
		if (sessionFactory == null) {
			if (sessionFactory == null) {
				try {
					sessionFactory = new SqlSessionFactoryBuilder()
							.build(Resources.getResourceAsReader(resource));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();					
				}
			}
		}
		return sessionFactory;
	}
	
}
