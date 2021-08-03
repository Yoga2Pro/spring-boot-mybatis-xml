package com.neo.mapper;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.neo.model.User;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

	@Autowired
	private UserMapper userMapper;

	@Test
	public void test() throws Exception {
		Assert.assertTrue(20==20);
	}

//	@Test
//	public void testInsert() throws Exception {
//		userMapper.deleteByName("aa");
//		userMapper.insert("aa", 11, "hotel");
//		User u = userMapper.getByName("aa");
//		// userMapper.deleteByName("aa");
//		Assert.assertTrue(!u.getName().isEmpty());
//	}
//
//	@Test
//	public void testQuery() throws Exception {
//		List<User> users = userMapper.getAll();
//		if(users==null || users.size()==0){
//			System.out.println("is null");
//		}else{
//			System.out.println(users.toString());
//		}
//	}
//
//
//	@Test
//	public void testUpdate() throws Exception {
//		userMapper.deleteByName("aa");
//		userMapper.insert(new User("aa", "a123456", UserSexEnum.MAN));
//		User u1 = userMapper.getByUserName("aa");
//		u1.setNickName("neo");
//		userMapper.update(u1);
//		User u2 = userMapper.getByUserName("aa");
//		userMapper.deleteByName("aa");
//		Assert.assertTrue(("neo".equals(u2.getNickName())));
//	}

}