package org.example.problem1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Service {
  private static volatile Map<Integer, Module> CACHE = new HashMap<>();
  private static boolean printDetails;

  public Service(boolean printDetails) {
    this.printDetails = printDetails;
  }

  private static boolean validateProduct(List<Module> modules) {
    boolean hasCycle = false;

    // TODO: 4. VALIDATE PRODUCT

    printValidation(hasCycle);

    return !hasCycle;
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

  public Map<Integer, Module> creteProduct(List<Module> modules) {
    boolean isValidProduct = validateProduct(modules);

    // TODO: 1. CREATE PRODUCT

    printResults("1. CREATE PRODUCT");

    return CACHE;
  }

  public Map<Integer, Module> enableProduct() {
    // TODO: 2. ENABLE PRODUCT

    printResults("2. ENABLE PRODUCT");

    return CACHE;
  }

  public Map<Integer, Module> completeModule(int id) {
    // TODO: 3. COMPLETE MODULE

    printResults(String.format("3. COMPLETE MODULE %d", id));

    return CACHE;
  }
}
