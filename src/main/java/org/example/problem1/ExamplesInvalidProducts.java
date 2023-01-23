package org.example.problem1;

import static java.util.Collections.emptyList;
import static org.example.problem1.Module.Status.NOT_STARTED;

import java.util.List;

// VALIDATE GRAPH: check for cycles
public class ExamplesInvalidProducts {

  public static void main(String[] args) {
    Service service = new Service(false);

    runTest(service, 1);
    runTest(service, 2);
    runTest(service, 3);

  }

  private static void runTest(Service service, int testNumber) {
    System.out.println("========================================================");
    System.out.printf("##### RUN TEST %d #####\n", testNumber);
    switch (testNumber) {
      case 1 -> test1(service);
      case 2 -> test2(service);
      case 3 -> test3(service);
    }
    System.out.println("========================================================\n");
  }

  private static void test1(Service service) {
    final List<Module> modules =
        List.of(
            new Module(0, 0, NOT_STARTED, List.of(1), List.of(1)),
            new Module(1, 0, NOT_STARTED, List.of(0), List.of(0)));

    service.createProduct(modules);
  }

  private static void test2(Service service) {
    final List<Module> modules =
        List.of(
            new Module(0, 0, NOT_STARTED, List.of(3), List.of(1)),
            new Module(1, 0, NOT_STARTED, List.of(0), List.of(3)),
            new Module(2, 0, NOT_STARTED, emptyList(), emptyList()),
            new Module(3, 1, NOT_STARTED, List.of(1), List.of(0, 4)),
            new Module(4, 2, NOT_STARTED, List.of(3), emptyList()));

    service.createProduct(modules);
  }

  private static void test3(Service service) {
    final List<Module> modules =
        List.of(
            new Module(0, 0, NOT_STARTED, emptyList(), List.of(2)),
            new Module(1, 1, NOT_STARTED, List.of(2), List.of(3)),
            new Module(2, 1, NOT_STARTED, List.of(0, 4), List.of(3)),
            new Module(3, 2, NOT_STARTED, List.of(1, 2), List.of(5)),
            new Module(4, 2, NOT_STARTED, List.of(5), List.of(2)),
            new Module(5, 3, NOT_STARTED, List.of(3), List.of(4)));

    service.createProduct(modules);
  }
}
