package com.neo.mapper;

import java.util.List;

import com.neo.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	
	List<User> getAll();
	
	User getById(@Param("id") Long id);

	User getByName(@Param("name") String name);

	void insert(@Param("id") Long id, @Param("name") String name, @Param("age") Integer age, @Param("address") String address);

	void update(@Param("id") Long id, @Param("name") String name, @Param("age") Integer age, @Param("address") String address);

	void delete(@Param("id") Long id);

	void deleteByName(@Param("name") String name);

}