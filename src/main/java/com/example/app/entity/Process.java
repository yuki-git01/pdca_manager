package com.example.app.entity;

import java.util.List;

/**
 * Targetの子クラス
 * 1 <--> many
 * Target process
 */
public class Process {
  private int id;
  private String description;
  private List<Kpi> kpis;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public List<Kpi> getKpis() {
    return kpis;
  }

  public void setKpis(List<Kpi> kpis) {
    this.kpis = kpis;
  }

}
