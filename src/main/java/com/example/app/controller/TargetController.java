package com.example.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.app.entity.Target;
import com.example.app.form.TargetForm;
import com.example.app.service.TargetService;

@RestController
@RequestMapping(path = TargetController.BASE_URL)
public class TargetController {
  public static final String BASE_URL = "/target-manager";
  private final TargetService targetService;

  @Autowired
  public TargetController(TargetService targetService) {
    this.targetService = targetService;
  }

  // 一旦pathからuserId取得する形で実装しログイン認証実装後にLoginUserクラスから取得する形に変更する
  // show targetList
  @GetMapping("/{userId}/target-list")
  public List<Target> showTargetList(@PathVariable("userId") Integer userId) {
    List<Target> targets = this.targetService.findAllTargetListByUserId(userId);
    return targets;
  }

  // show a target
  @GetMapping("/{userId}/find/{id}")
  public Target showTarget(@PathVariable("userId") Integer userId, @PathVariable("id") Integer id) {
    Target target = this.targetService.findTargetByIdAndUserId(userId, id);
    return target;
  }

  // create a target
  @PostMapping("/{userId}/create")
  public void createTarget(@PathVariable("userId") Integer userId, @RequestBody @Validated TargetForm targetForm) {
    this.targetService.save(userId, targetForm.getTitle(), targetForm.getDescription());
  }

  // update a target
  @PostMapping("/{userId}/edit/{id}")
  public void edit(@PathVariable("userId") Integer userId, @PathVariable("id") Integer id,
      @RequestBody @Validated TargetForm targetForm) {
    this.targetService.updateByIdAndUserId(
        userId,
        id, targetForm.getTitle(), targetForm.getDescription(),
        targetForm.getProgressId());
  }

  // delete a target
  @PostMapping("/{userId}/delete/{id}")
  public void delete(@PathVariable("userId") Integer userId, @PathVariable("id") Integer id) {
    this.targetService.deleteByIdAndUserId(userId, id);
  }

}
