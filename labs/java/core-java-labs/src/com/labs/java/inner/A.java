package com.labs.java.inner;

public class A {
    private  String message = "Hello from A";

    public void show() {
        System.out.println("A class show method..." + " " + new C().message2 );
    }

    public static class B {
        private String message1 = "Hello from B";
        public void display() {
            System.out.println("B class display method...");
        }
    }

    public class C {
        private String message2 = "Hello from C";
        public void display() {
            System.out.println("C class display method..." + message);
        }
    }

    public static void main(String[] args) {
        A a = new A();
        a.show();

        // static inner class
        A.B b = new A.B();
        b.display();

        // non-static inner class
        A.C c = a.new C();
        c.display();
    }
}


