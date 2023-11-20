public class App {
    public static void main(String[] args) {

        ShowMessage showMessage1 = new ShowMessage();
        ShowTableGame showTableGame = new ShowTableGame();
        CheckWhoWin checkWhoWin = new CheckWhoWin();
        Logic logic = new Logic(checkWhoWin, showTableGame, showMessage1);
        logic.logicInside();
    }
}
