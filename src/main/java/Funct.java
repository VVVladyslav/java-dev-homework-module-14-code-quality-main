public class Funct{
    public boolean winnerFunctX(int[][] WIN_COMB, char symbol, char[] BOX_OF_NUMBERS){
        for (int[] combination : WIN_COMB) {
            if (BOX_OF_NUMBERS[combination[0]] == symbol &&
                    BOX_OF_NUMBERS[combination[1]] == symbol &&
                    BOX_OF_NUMBERS[combination[2]] == symbol) {
                return true;
            }
        }
        return false;
    }


}
