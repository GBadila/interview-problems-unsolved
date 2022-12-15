package org.example.problem1;

import java.util.List;

public class Module {

  private final int id;
  private final int stage;
  private final List<Integer> inbounds;
  private final List<Integer> outbounds;
  private Status status;

  public Module(int id, int stage, Status status, List<Integer> inbounds, List<Integer> outbounds) {
    this.id = id;
    this.stage = stage;
    this.status = status;
    this.inbounds = inbounds;
    this.outbounds = outbounds;
  }

  public int getId() {
    return id;
  }

  public int getStage() {
    return stage;
  }

  public Status getStatus() {
    return status;
  }

  public void setStatus(Status status) {
    this.status = status;
  }

  public List<Integer> getInbounds() {
    return inbounds;
  }

  public List<Integer> getOutbounds() {
    return outbounds;
  }

  enum Status {
    NOT_STARTED,
    IN_PROGRESS,
    COMPLETED
  }
}
