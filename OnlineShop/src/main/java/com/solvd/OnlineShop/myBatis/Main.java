package com.solvd.OnlineShop.myBatis;

import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.solvd.OnlineShop.dao.IUserDAO;
import com.solvd.OnlineShop.models.User;

public class Main {
	private static final Logger LOGGER = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		try {
			myBatisUtil();
		} catch (IOException e) {
			LOGGER.error(e);
		}
	}

	private static void myBatisUtil() throws IOException {	
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		sqlSessionFactory.getConfiguration().addMapper(IUserDAO.class);
		
		try(SqlSession session = ((SqlSessionFactory) sqlSessionFactory).openSession()) {
			User user = session.selectOne("getUserById", 1);
			LOGGER.info(user.toString());
		}
	}
	
	
	
	
	
}
