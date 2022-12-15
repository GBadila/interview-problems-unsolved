package org.example.problem1;

import static java.util.Collections.emptyList;
import static org.example.problem1.Module.Status.NOT_STARTED;

import java.util.List;

public class Main {

  private static final List<Module> MODULES =
      List.of(
          new Module(0, 0, NOT_STARTED, emptyList(), List.of(3)),
          new Module(1, 0, NOT_STARTED, emptyList(), List.of(3)),
          new Module(2, 0, NOT_STARTED, emptyList(), emptyList()),
          new Module(3, 1, NOT_STARTED, List.of(0, 1), List.of(4)),
          new Module(4, 2, NOT_STARTED, List.of(3), emptyList()));


  public static void main(String[] args) {
    Service service = new Service(true);

    boolean isValidProduct = service.creteProduct(MODULES);

    if (isValidProduct) {
      service.enableProduct();
      service.completeModule(0);
      service.completeModule(1);
      service.completeModule(3);
      service.completeModule(4);
      service.completeModule(2);
    }
  }
}
