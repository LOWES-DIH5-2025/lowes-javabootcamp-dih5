package com.labs.java.exception;

public class ExceptionDemo {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 4, 5};
//        System.out.println(arr[3]); // Accessing first element
        try {
            int output = compute(10, 2);
            System.out.println(output);

        }catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
            e.printStackTrace();
        }
        System.out.println("Program completed successfully.");
//        Thread.sleep(1000);
    }

    public static int compute(int a, int b) throws RuntimeException {
        int result = 0;
        try {
            int[] arr = {1, 2, 3, 4, 5};
            result = arr[a/3] / b;
            System.out.println("Result: " + result);
        } catch(ArrayIndexOutOfBoundsException aoe) {
            System.out.println("Array Index Out of Range : " + aoe.getMessage());
            result = -1; // Assign a default value or handle accordingly
            throw new RuntimeException("Invalid array index access", aoe);
        }
        catch(ArithmeticException ae) {
            System.out.println("ArithmeticException: " + ae.getMessage());
            result = -1;
//            ae.printStackTrace();
            throw new RuntimeException("Division by zero is not allowed", ae);
        } finally {
            System.out.println("Finally block executed.");
            // You can perform cleanup or final actions here
            // For example, closing resources if any were opened
        }

        System.out.println("Compute method completed successfully.");
        return result;
    }
}
