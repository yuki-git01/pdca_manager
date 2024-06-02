package com.example.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TargetController {

  // show targetList
  @GetMapping("/targets")
  public String showTargets() {

    return "hello ";
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
