package com.example.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Target;
import com.example.app.mapper.TargetMapper;

@Service
public class TargetService {
  private final TargetMapper targetMapper;

  @Autowired
  public TargetService(TargetMapper targetMapper) {
    this.targetMapper = targetMapper;
  }

  public List<Target> findAll() {
    return this.targetMapper.findAll();
  }
}
