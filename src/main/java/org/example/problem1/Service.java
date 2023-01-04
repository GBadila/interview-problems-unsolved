package org.example.problem1;

import static org.example.problem1.Module.Status.COMPLETED;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
  private static volatile Map<Integer, Module> CACHE = new HashMap<>();
  private static boolean printDetails;

  public Service(boolean printDetails) {
    this.printDetails = printDetails;
  }

  /*
    As you've been noticed by now, our product is shaped as a graph. In order to validate the
    product you have to check if the graph has any cycles.
   */
  private static boolean validateProduct(List<Module> modules) {
    boolean hasCycle = false;

    // TODO: 4. VALIDATE PRODUCT

    printValidation(hasCycle);

    return !hasCycle;
  }

  private static void checkAllModulesCompleted() {
    if (CACHE.values().stream().allMatch(module -> module.getStatus() == COMPLETED)) {
      System.out.println("==> PRODUCT COMPLETED");
    }
  }

  private static void printValidation(boolean hasCycle) {
    if (printDetails) {
      System.out.println("========================================================");
      System.out.printf("0. VALIDATION: The product %s cycles!%n",
          hasCycle ? "has" : "doesn't have");
      System.out.println("========================================================\n");
    }
  }

  private static void printResults(String title) {
    if (printDetails) {
      System.out.println("========================================================");
      System.out.println(title);
      System.out.println("--------------------------------------------------------");
      printProduct();
      System.out.println("========================================================\n");
    }
  }

  private static void printProduct() {
    System.out.println("MODULE ID: stage, inbounds, outbounds .......... STATUS");
    for (int i = 0; i < CACHE.keySet().size(); i++) {
      Module module = CACHE.get(i);
      System.out.printf("MODULE %d: ", i);
      System.out.printf("(%d), ", module.getStage());
      System.out.print(module.getInbounds());
      System.out.print(", ");
      System.out.print(module.getOutbounds());
      System.out.print(" .......... ");
      System.out.println(module.getStatus());
    }
  }

  /*
    Using the list of modules you need to create the "product" by saving those modules to the CACHE,
    only if the "product" is valid.
   */
  public Map<Integer, Module> creteProduct(List<Module> modules) {
    boolean isValidProduct = validateProduct(modules);

    // TODO: 1. CREATE PRODUCT

    printResults("1. CREATE PRODUCT");

    return CACHE;
  }

  /*
    Enabling a product means that a user can start working on a product and complete modules.

    A module can be completed only when is in IN_PROGRESS status and the first module that can be
    completed should be the very first module (id = 0).

    As soon as one module becomes read to be completed, all the standalone modules from the very
    same stage should also be ready for completion.
   */
  public Map<Integer, Module> enableProduct() {
    // TODO: 2. ENABLE PRODUCT

    printResults("2. ENABLE PRODUCT");

    return CACHE;
  }

  /*
    Completing a module means that a module has finally reached the COMPLETED status.

    A module can be completed if it's in IN_PROGRESS state and all the inbounds modules have already
    been completed.
   */
  public Map<Integer, Module> completeModule(int id) {
    // TODO: 3. COMPLETE MODULE

    printResults(String.format("3. COMPLETE MODULE %d", id));
    checkAllModulesCompleted();

    return CACHE;
  }
}
