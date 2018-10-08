package com.example.demo.test1.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.test1.pojo.User;

@Mapper
public interface UserMapper {
	@Select("SELECT * FROM USER WHERE NAME = #{name}")
	User findByName(@Param("name") String name);

	@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
	int insert(@Param("name") String name, @Param("age") Long age);

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
	int insertByMap(Map<String, Object> map);

	@Options(useGeneratedKeys = true, keyProperty = "id")
	@Insert("INSERT INTO USER(NAME, AGE) VALUES(#{name}, #{age})")
	int insertByBean(User user);

	@Select("SELECT * FROM user")
	List<User> findAll();
}
