
import java.util.Scanner;

public class Greetings {
  
    public static void main(String[] args) throws InterruptedException {

        Scanner in = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = in.nextLine();

        System.out.print("Hello " + in.nextLine() + "! Welcome to Lowe's!");
        name = null;

        // more logic


        // Thread.sleep(1000 * 60 * 5); // Sleep for 5 mins
        in.close();
    }
  
}
