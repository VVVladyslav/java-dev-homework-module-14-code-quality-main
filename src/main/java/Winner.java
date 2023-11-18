public class Winner {
    public boolean win(byte winner){
        if (winner == 1) {
            System.out.println("You won the game!\nThanks for playing!");
        } else if (winner == 2) {
            System.out.println("You lost the game!\nThanks for playing!");
        } else if (winner == 3) {
            System.out.println("It's a draw!\nThanks for playing!");

        }
        return false;
    }
}
