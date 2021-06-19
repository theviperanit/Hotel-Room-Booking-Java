import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random rand = new Random();
        int randomInt= rand.nextInt(999);
        Hotel hotel = new Hotel(randomInt,"Galaxy");
        UserInterface userInterface = new UserInterface(hotel,scanner);
        userInterface.start();
    }
}
