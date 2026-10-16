import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main() {

        boolean done = false;

        Scanner in = new Scanner(System.in);

        do {

            Random rnd = new Random();
            int dice1 = rnd.nextInt(6) + 1;
            int dice2 = rnd.nextInt(6) + 1;
            int sum = dice1 + dice2;

            System.out.printf("%6s\t%6s\t%4s\n", "dice1", "dice2", "sum" );
            System.out.printf("%6d\t%6d\t%4d\n", dice1, dice2, sum );

            if ((sum ==2) || (sum==3) || (sum==12))
            {
                IO.println("Crapping out! You lost.");

                done =!playAgain(in);
            }

            else if ((sum ==7) || (sum==11))
            {
                IO.println("Natural! You win!");

                done =!playAgain(in);
            }

            else
            {
                IO.println("Now your sum becomes the point: " + sum + ". Let's make subsequent rolls!\n");
                boolean donePhrase2 = false;

                do {

                    int dice3 = rnd.nextInt(6) + 1;
                    int dice4 = rnd.nextInt(6) + 1;
                    int newSum = dice3 + dice4;

                    System.out.printf("%6s\t%6s\t%4s\t%6s\n", "dice3", "dice4", "sum", "the point");
                    System.out.printf("%6d\t%6d\t%4d\t%9d\n", dice3, dice4, newSum, sum);

                    if (newSum == sum){
                        donePhrase2 = true;
                        IO.println("Made point and won!\n");
                        done =!playAgain(in);
                    }

                    else if (newSum == 7){
                        donePhrase2 = true;
                        IO.println("You got a seven! You lost.\n");
                        done =!playAgain(in);
                    }

                    else{
                        donePhrase2 = false;
                        IO.println("Roll again.\n");
                    }


                } while (!donePhrase2);
            }

        } while (!done);

    }

    public static boolean playAgain(Scanner in) {
        do {

            System.out.print("Do you want to play again? [Y/N]: ");
            String playMore = in.nextLine();
            if (playMore.equalsIgnoreCase("Y"))
                return true;
            else if (playMore.equalsIgnoreCase("N"))
                return false;
            else
                IO.println("Invalid input, please enter Y or N: ");
        } while (true);
    }
}
