package org.example.problem1;

import static java.util.Collections.emptyList;
import static org.example.problem1.Module.Status.NOT_STARTED;

import java.util.List;

// TEST EXECUTION
public class TestSuite1 {

  public static void main(String[] args) {
    Service service = new Service(false);

    runTest(service, 1);
    runTest(service, 2);
    runTest(service, 3);
    runTest(service, 4);

  }

  private static void runTest(Service service, int testNumber) {
    System.out.println("========================================================");
    System.out.printf("##### RUN TEST %d #####\n", testNumber);
    switch (testNumber) {
      case 1 -> test1(service);
      case 2 -> test2(service);
      case 3 -> test3(service);
      case 4 -> test4(service);
    }
    System.out.println("========================================================\n");
  }

  private static void test1(Service service) {
    final List<Module> modules =
        List.of(
            new Module(0, 0, NOT_STARTED, emptyList(), List.of(3)),
            new Module(1, 0, NOT_STARTED, emptyList(), List.of(3)),
            new Module(2, 0, NOT_STARTED, emptyList(), emptyList()),
            new Module(3, 1, NOT_STARTED, List.of(0, 1), List.of(4)),
            new Module(4, 2, NOT_STARTED, List.of(3), emptyList()));

    boolean isValidProduct = service.creteProduct(modules);

    if (isValidProduct) {
      service.enableProduct();
      service.completeModule(0);
      service.completeModule(1);
      service.completeModule(3);
      service.completeModule(4);
      service.completeModule(2);
    }
  }

  private static void test2(Service service) {
    final List<Module> modules =
        List.of(
            new Module(0, 0, NOT_STARTED, emptyList(), List.of(4)),
            new Module(1, 0, NOT_STARTED, emptyList(), List.of(2)),
            new Module(2, 0, NOT_STARTED, List.of(1), List.of(4)),
            new Module(3, 0, NOT_STARTED, emptyList(), List.of(5)),
            new Module(4, 1, NOT_STARTED, List.of(0, 2), List.of(5)),
            new Module(5, 2, NOT_STARTED, List.of(3, 4), emptyList()));

    boolean isValidProduct = service.creteProduct(modules);

    if (isValidProduct) {
      service.enableProduct();
      service.completeModule(0);
      service.completeModule(1);
      service.completeModule(2);
      service.completeModule(4);
      service.completeModule(3);
      service.completeModule(5);
    }
  }

  private static void test3(Service service) {
    final List<Module> modules =
        List.of(
            new Module(0, 0, NOT_STARTED, emptyList(), emptyList()),
            new Module(1, 0, NOT_STARTED, emptyList(), emptyList()));

    boolean isValidProduct = service.creteProduct(modules);

    if (isValidProduct) {
      service.enableProduct();
      service.completeModule(0);
      service.completeModule(1);
    }
  }

  private static void test4(Service service) {
    final List<Module> modules =
        List.of(
            new Module(0, 0, NOT_STARTED, emptyList(), List.of(2)),
            new Module(1, 0, NOT_STARTED, emptyList(), List.of(2)),
            new Module(2, 0, NOT_STARTED, List.of(0, 1), List.of(3)),
            new Module(3, 1, NOT_STARTED, List.of(2), List.of(5, 6)),
            new Module(4, 1, NOT_STARTED, emptyList(), List.of(6)),
            new Module(5, 2, NOT_STARTED, List.of(3), List.of(7)),
            new Module(6, 2, NOT_STARTED, List.of(3, 4), List.of(7)),
            new Module(7, 3, NOT_STARTED, List.of(5, 6), emptyList()),
            new Module(8, 3, NOT_STARTED, emptyList(), emptyList()));

    boolean isValidProduct = service.creteProduct(modules);

    if (isValidProduct) {
      service.enableProduct();
      service.completeModule(0);
      service.completeModule(1);
      service.completeModule(2);
      service.completeModule(4);
      service.completeModule(3);
      service.completeModule(6);
      service.completeModule(5);
      service.completeModule(7);
      service.completeModule(8);
    }
  }
}
