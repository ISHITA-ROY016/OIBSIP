import java.util.*;

class NumberGuessingGame {
    public static int guessing(int x, int r, int chance) {
        Scanner sc = new Scanner(System.in);
        int guess = sc.nextInt();
        if (x == guess) {
            System.out.println("\nCongratulations!! \nYou guessed the correct number in attempt no. " + chance + " .");
            return 1;
        } else if (guess > x) {
            System.out.println("Guess a Lesser Number than this.");

        } else if (guess < x) {
            System.out.println("Guess a Greater Number than this. ");

        }
        return 0;
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int score, chance, r, x;
            Boolean play = true;
            String answer;
            Random random = new Random();
            System.out.println("\nWelcome to NNUMBER GUESSING GAME!!!");
            System.out.println(
                    "\nGuess the number between 1 to 100. \nLet's see if you can guess it correctly within 10 attempts!!");
            System.out.println("\nAre you ready to start the game ??\nYES? type 1 \nNo? type  0");
            int start = sc.nextInt();
            if (start == 1) {
                System.out.println("\nEnter your name: ");
                String name = sc.next();
                System.out.println("Hello " + name + ", All the Best!");
                do {
                    score = 100;
                    chance = 1;
                    r = 0;
                    x = random.nextInt(101);
                    playGame(score, chance, r, x);

                    System.out.println("\n\nDo you want to play again?\nType y or n.");
                    answer = sc.next();
                    if (answer.equals("y")) {
                        play = true;
                    } else {
                        play = false;
                        System.out.println("Thanks for playing.\n");
                        break;
                    }
                } while (play);

                System.exit(1);

            } else {
                System.out.println("\nSure!! Let's play some another time");
            }
        }

    }

    public static void playGame(int score, int chance, int r, int x) {
        while (chance <= 10) {
            System.out.println("\nAttempt: " + chance);
            r = guessing(x, r, chance);
            if (r == 1) {
                System.out.println("Your Score is " + score);
                break;
            }
            score = score - 10;
            chance++;
        }
        if (score <= 0) {
            System.out.print("\nSorry you have used all of your chances :( \nBetter Luck Next Time\n");
            System.out.println("\nThe number is " + x);
        }
    }
}
