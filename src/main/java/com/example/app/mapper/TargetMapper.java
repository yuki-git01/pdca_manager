package com.example.app.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.entity.Target;

@Mapper
public interface TargetMapper {
  public List<Target> findAllTargetListByUserId(Integer userId);

  public void insert(Target target);

  public void update(Target target);

  public void delete(Integer userId, Integer id);

}
