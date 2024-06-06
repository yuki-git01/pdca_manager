package com.example.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.app.entity.Target;
import com.example.app.mapper.TargetMapper;

@Service
public class TargetService {
  private final TargetMapper targetMapper;

  @Autowired
  public TargetService(TargetMapper targetMapper) {
    this.targetMapper = targetMapper;
  }

  public List<Target> findDeletedAtIsNull() {
    return this.targetMapper.findDeletedAtIsNull();
  }

  public Target findById(Integer id) {
    Optional<Target> target = this.targetMapper.findById(id);
    if (!target.isPresent()) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }
    return target.get();
  }

  public Integer create(Integer userId, String title, String description) {
    Target target = new Target();
    String progress = "0%";
    target.setUserId(userId);
    target.setTitle(title);
    target.setDescription(description);
    target.setProgress(progress);
    target.setCreatedAt(LocalDateTime.now());
    return this.targetMapper.insert(target);
  }

  public Integer updateById(Integer id, String title, String description, String progress) {
    Target target = this.findById(id);
    target.setTitle(title);
    target.setDescription(description);
    target.setProgress(progress);
    return this.targetMapper.update(target);
  }

  public Integer deleteById(Integer id) {
    Target target = this.findById(id);
    target.setDeletedAt(LocalDateTime.now());
    return this.targetMapper.delete(target);
  }
}
