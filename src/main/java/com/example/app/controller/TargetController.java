package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
    return this.targetService.findAll();

  }

  // show target
  @GetMapping("/target/{id}")
  public String editTarget(@PathVariable("id") Integer id) {

    return "this targetId is" + id;
  }

  // create target
  @PostMapping("/create")
  public String createTarget() {

    return "hello createTarget";
  }
}
