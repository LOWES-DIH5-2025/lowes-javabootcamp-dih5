package com.labs.java.pkg.pkg2;

import com.labs.java.pkg.pkg1.Test1;
// static import
//import static com.labs.java.pkg.pkg1.Test1.COMPANY_NAME;
//import static com.labs.java.pkg.pkg1.Test1.print;

// Import all static members of Test1
 import static com.labs.java.pkg.pkg1.Test1.*;

public class Test2 {

    public static void main(String[] args) {
        print();
        System.out.println("Company Name: " + COMPANY_NAME);

        Test1 test1 = new Test1();
        System.out.println("City: " + test1.city);
        test1.display();
    }
}
