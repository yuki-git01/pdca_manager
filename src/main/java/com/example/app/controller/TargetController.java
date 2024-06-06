package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.Target;
import com.example.app.service.TargetService;

@RestController
public class TargetController {
  private final TargetService targetService;

  @Autowired
  public TargetController(TargetService targetService) {
    this.targetService = targetService;
  }

  // show targetList
  @GetMapping("/targets")
  public List<Target> showTargets() {
    return this.targetService.findDeletedAtIsNull();
  }

  // show a target
  @GetMapping("/target/{id}")
  public Target showTarget(@PathVariable("id") Integer id) {
    return this.targetService.findById(id);
  }

  // create a target
  @PostMapping("/create")
  public Integer createTarget(@RequestBody Target target) {
    return this.targetService.create(target.getUserId(), target.getTitle(), target.getDescription());
  }

  // update a target
  @PostMapping("/edit/{id}")
  public Integer edit(@PathVariable("id") Integer id, @RequestBody Target target) {
    return this.targetService.updateById(id, target.getTitle(), target.getDescription(),
        target.getProgress());
  }

  // delete a target
  @PostMapping("/delete/{id}")
  public Integer delete(@PathVariable("id") Integer id) {
    return this.targetService.deleteById(id);
  }

}
