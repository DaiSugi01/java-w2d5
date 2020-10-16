import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {

  /* FromAyumi, Daiki, Chihori  */
  
  /**
   * (Game: play a tic-tac-toe game) 
   * In a game of tic-tac-toe, two players take turns marking an available cell in a 3 * 3 grid with their respective tokens (either X or O). 
   * When one player has placed three tokens in a horizontal, vertical, or diagonal row on the grid, the game is over and that player has won. 
   * A draw (no winner) occurs when all the cells on the grid have been filled with tokens and neither player has achieved a win. 
   * Create a program for playing tic-tac-toe.
   * The program prompts two players to enter an X token and O token alternately. 
   * Whenever a token is entered, the program redisplays the board on the console and determines the status of the game (win, draw, or continue).
   */

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    String[][] tokens = new String[3][3];
    int turnCount = 1;
    String player;
    boolean isFinished;
    final int MAX_TURN_COUNT = 9;

    do {
      player = (turnCount % 2 == 0) ? "O" : "X";

      printTable(tokens);
      while(true){
        System.out.print("Enter a row (0, 1 or 2) for player " + player + ": ");
        int row = input.nextInt();
        System.out.print("Enter a column (0, 1 or 2) for player " + player + ": ");
        int column = input.nextInt();
        System.out.println("");
        
        if(Objects.isNull(tokens[row][column])){
          tokens[row][column] = player;
          break;
        }else{
          System.out.println("Already taken");
        }
      }
      isFinished = checkResult(tokens);
      turnCount++;
      if(turnCount > MAX_TURN_COUNT){
        break;
      }

    } while(!isFinished);

    printTable(tokens);
    if (isFinished){
      System.out.println(player + " player won!");
    }else{
      System.out.println("two players are draw");
    }
    
  }

  /**
   * Print the game table.
   * 
   * @param tokens
   */
  public static void printTable(String[][] tokens) {

    System.out.println("-------------");

    for(int i = 0; i < tokens.length; i++) {
      for(int j = 0; j < tokens[i].length; j++) {
        if (Objects.isNull(tokens[i][j])) {
          System.out.print("|   ");
        } else {
          System.out.print("| " + tokens[i][j] + " ");
        }
      }
      System.out.println("|");
      System.out.println("-------------");
    }
  }


  /**
   * Check the game result.
   * 
   * @param tokens
   * @return game result
   */
  public static boolean checkResult(String[][] tokens) {
    for(int i = 0; i < tokens.length; i++) {
      if ((tokens[i][0] + tokens[i][1] + tokens[i][2]).equals("XXX") 
            || (tokens[i][0] + tokens[i][1] + tokens[i][2]).equals("OOO")) {
        return true;
      }
      if ((tokens[0][i] + tokens[1][i] + tokens[2][i]).equals("XXX") 
            || (tokens[0][i] + tokens[1][i] + tokens[2][i]).equals("OOO")) {
        return true;
      }
    }

    if ((tokens[0][0] + tokens[1][1] + tokens[2][2]).equals("XXX") 
            || (tokens[0][0] + tokens[1][1] + tokens[2][2]).equals("OOO")) {
      return true;
    }
    if ((tokens[0][2] + tokens[1][1] + tokens[2][0]).equals("XXX") 
            || (tokens[0][2] + tokens[1][1] + tokens[2][0]).equals("OOO")) {
      return true;
    }

    return false;
  }
}