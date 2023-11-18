import java.util.Scanner;

public class Logic {
    Scanner scan = new Scanner(System.in);
    public final char BOX_OF_NUMBERS[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    public final int[][] WIN_COMB = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };
    public byte input;
    public byte rand;
    public byte zero;
    public boolean boxAvailable = false;
    public byte winner = 0;
    public boolean boxEmptyStatus = false;
    private static final int NUMBER = 9;
    public boolean result;
    public boolean isResult;
    Funct funct = new Funct();
    Writer writer = new Writer();
    Winner winner1 = new Winner();
    public void logicInside() {

        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {

            writer.write(BOX_OF_NUMBERS);

            if (!boxEmptyStatus) {
                for (zero = 0; zero < NUMBER; zero++)
                    BOX_OF_NUMBERS[zero] = ' ';
                    boxEmptyStatus = true;
            }

            isResult = winner1.win(winner);

            if (isResult = false){
                break;
            }

            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (BOX_OF_NUMBERS[input - 1] == 'X' || BOX_OF_NUMBERS[input - 1] == 'O')
                        System.out.println("That one is already in use. Enter another.");
                    else {
                        BOX_OF_NUMBERS[input - 1] = 'X';
                        break;
                    }
                } else
                    System.out.println("Invalid input. Enter again.");
            }

            result = funct.winnerFunctX(WIN_COMB, 'X', BOX_OF_NUMBERS);

            if (result == true){
                winner = 1;
            }

            boxAvailable = false;


            for (zero = 0; zero < NUMBER; zero++) {
                if (BOX_OF_NUMBERS[zero] != 'X' && BOX_OF_NUMBERS[zero] != 'O') {
                    boxAvailable = true;
                    break;
                }
            }

            if (boxAvailable == false) {
                winner = 3;
                continue;
            }

            while (true) {
                rand = (byte) (Math.random() * (9 - 1 + 1) + 1);
                if (BOX_OF_NUMBERS[rand - 1] != 'X' && BOX_OF_NUMBERS[rand - 1] != 'O') {
                    BOX_OF_NUMBERS[rand - 1] = 'O';
                    break;
                }
            }

            result = funct.winnerFunctX(WIN_COMB, 'O', BOX_OF_NUMBERS);

            if (result == true){
                winner = 2;
            }
        }
    }

}