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
	
	@SuppressWarnings("deprecation")
	@Override
	public MyUser authenticate(String unm, String passwd) {
		try {
		return jdbctemp.queryForObject("select * from user where username=? and password=?", new Object[] {unm, passwd},
				BeanPropertyRowMapper.newInstance(MyUser.class));
		}catch(Exception e) {
			return null;
		}
	}
	

}
