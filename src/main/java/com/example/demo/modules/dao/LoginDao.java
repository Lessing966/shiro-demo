package com.example.demo.modules.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.modules.entity.LoginEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginDao extends BaseMapper<LoginEntity> {

}
