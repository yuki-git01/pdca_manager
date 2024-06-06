package com.example.app.mapper;

import java.util.List;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.example.app.entity.Target;

@Mapper
public interface TargetMapper {
  public List<Target> findDeletedAtIsNull();

  public Optional<Target> findById(Integer id);

  public int insert(Target target);

  public int update(Target target);

  public int delete(Target target);

}
