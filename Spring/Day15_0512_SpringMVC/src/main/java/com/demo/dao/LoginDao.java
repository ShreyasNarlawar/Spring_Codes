package com.demo.dao;

import com.demo.beans.MyUser;

public interface LoginDao {

	MyUser findUser(String uname, String passwd);
	
}
