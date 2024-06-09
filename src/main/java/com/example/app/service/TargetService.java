package com.example.app.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.app.entity.Progress;
import com.example.app.entity.Target;
import com.example.app.error.NotFoundException;
import com.example.app.mapper.TargetMapper;

@Service
public class TargetService {
  private final TargetMapper targetMapper;

  @Autowired
  public TargetService(TargetMapper targetMapper) {
    this.targetMapper = targetMapper;
  }

  public List<Target> findAllTargetListByUserId(Integer userId) {
    List<Target> targetList = this.targetMapper.findAllTargetListByUserId(userId);
    if (targetList.isEmpty()) {
      throw new NotFoundException("Targets not found one.");
    }
    return targetList;
  }

  public Target findTargetByIdAndUserId(Integer userId, Integer id) {
    List<Target> targetList = this.findAllTargetListByUserId(userId);
    Optional<Target> target = targetList.stream().filter(listInTarget -> listInTarget.getId() == id).findAny();
    if (target.isEmpty()) {
      throw new NotFoundException("Target is not found");
    }
    return target.get();
  }

  public void save(Integer userId, String title, String description) {
    Target target = new Target();
    Progress progress = new Progress();
    progress.setId(0);
    target.setUserId(userId);
    target.setTitle(title);
    target.setDescription(description);
    target.setProgress(progress);
    target.setLastUpdated(LocalDateTime.now());
    this.targetMapper.insert(target);
  }

  public void updateByIdAndUserId(Integer userId, Integer id, String title, String description, Integer progressId) {
    Target target = this.findTargetByIdAndUserId(userId, id);
    Progress progress = new Progress();
    progress.setId(progressId);
    target.setTitle(title);
    target.setDescription(description);
    target.setProgress(progress);
    target.setLastUpdated(LocalDateTime.now());
    this.targetMapper.update(target);
  }

  public void deleteByIdAndUserId(Integer userId, Integer id) {
    // ただnullチェック挟みたいだけ
    Target target = this.findTargetByIdAndUserId(userId, id);
    this.targetMapper.delete(target.getUserId(), target.getId());
  }
}
