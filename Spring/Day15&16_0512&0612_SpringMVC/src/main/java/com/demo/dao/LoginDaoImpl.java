package com.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.beans.MyUser;

@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
	JdbcTemplate jdbctemp;

//	@SuppressWarnings("deprecation")
	@Override
	public MyUser findUser(String uname, String passwd) {
		try {
			String q = "select * from user where username = ? And password = ?";
			return jdbctemp.queryForObject(q,new Object[]{uname,passwd},BeanPropertyRowMapper.newInstance(MyUser.class));
		}catch(Exception e) {
			System.out.println("USer Not FOund..");
			return null;
		}
	}

}
