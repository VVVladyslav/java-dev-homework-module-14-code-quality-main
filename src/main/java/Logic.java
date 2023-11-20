import java.util.Scanner;

public class Logic {
    public final char BOX_OF_NUMBERS[] = {'1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public final int[][] WIN_COMB = {
            {0, 1, 2}, {3, 4, 5}, {6, 7, 8},
            {0, 3, 6}, {1, 4, 7}, {2, 5, 8},
            {0, 4, 8}, {2, 4, 6}
    };
    private static final int NUMBER = 9;
    private ShowTableGame showTableGame;
    private ShowMessage showMessage1;
    private CheckWhoWin checkWhoWin;
    private byte input;
    private byte rand;
    private byte zero;
    private boolean boxAvailable;
    private byte winner;
    private boolean boxEmptyStatus;
    private boolean result;
    private boolean isResult;
    public Logic(CheckWhoWin checkWhoWin, ShowTableGame showTableGame, ShowMessage showMessage1) {
        boxAvailable = false;
        winner = 0;
        boxEmptyStatus = false;
        this.checkWhoWin = checkWhoWin;
        this.showTableGame = showTableGame;
        this.showMessage1 = showMessage1;
    }
    public void logicInside() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter box number to select. Enjoy!\n");

        while (true) {

            showTableGame.showTable(BOX_OF_NUMBERS);

            if (!boxEmptyStatus) {
                for (zero = 0; zero < NUMBER; zero++)
                    BOX_OF_NUMBERS[zero] = ' ';
                    boxEmptyStatus = true;
            }

            isResult = showMessage1.showToConsole(winner);

            if (isResult = false){
                break;
            }

            while (true) {
                input = scan.nextByte();
                if (input > 0 && input < 10) {
                    if (BOX_OF_NUMBERS[input - 1] == 'X' || BOX_OF_NUMBERS[input - 1] == 'O') {
                        System.out.println("That one is already in use. Enter another.");
                    } else {
                        BOX_OF_NUMBERS[input - 1] = 'X';
                        break;
                    }
                } else {
                    System.out.println("Invalid input. Enter again.");
                }
            }

            result = checkWhoWin.check(WIN_COMB, 'X', BOX_OF_NUMBERS);

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

            result = checkWhoWin.check(WIN_COMB, 'O', BOX_OF_NUMBERS);

            if (result == true){
                winner = 2;
            }
        }
        scan.close();
    }
}
