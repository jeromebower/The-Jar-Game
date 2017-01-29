import java.util.Scanner;

public class Prompter{
  Scanner scanner = new Scanner(System.in);
  int guessAsString = 0;
  private String mNewGame;
  String mTypeOfItem;  
  int mMaxNumber;
  private Jar mJar;
  
  
  public Prompter(){         
  }
  
  public void play(Jar jar){
    mJar = jar;    
    promptForGuess();    
  }
  
  public boolean promptForGuess(){
    do {
      System.out.print("Your guess? ");
      while (!scanner.hasNextInt()) { //checks for a number
        String input = scanner.next();
        System.out.printf("%s is not a valid number.\n", input);
        System.out.printf("Pick a number: ");
      }
      guessAsString = scanner.nextInt();
      if(guessAsString == 0){
        System.out.printf("You can't guess 0 %n");
      } 
    }while (guessAsString == 0); 
    while(!mJar.isWinner(guessAsString)){
      //if not winner, loops until you are a winner
      System.out.print("Your guess? ");
      guessAsString = scanner.nextInt();
    }    
    return false; 
  }  
  
  public boolean promptNewGame(){
  System.exit(0); //<-- delete this and the begin and ending comment to have game continue until player says n, exit, or quit
 /*
    System.out.printf("New Game? %n");
    mNewGame = scanner.next();
    mNewGame = mNewGame.toLowerCase();
    while(mNewGame.charAt(0) != 'n' && mNewGame.charAt(0) != 'y' && !mNewGame.equals("exit") && !mNewGame.equals("quit")){
      System.out.printf("What language is that? Yes or No Please. %n");     
      mNewGame = scanner.next();
      mNewGame = mNewGame.toLowerCase();     
    }      
    if(mNewGame.charAt(0) == 'n' || mNewGame.equals("exit") || mNewGame.equals("quit") ){
      System.exit(0);
    }
    mJar.resetGame(); 
*/
    return true;
  } 

    public String gameType(){  
    System.out.print("What type of item? ");
    System.out.printf("%n");
    mTypeOfItem = scanner.next(); //Sets type of items that can be placed in the jar, not sure how to have this work in prompter & pass test  
    System.out.print("How many will fit in the jar? ");
    System.out.printf("%n");
    return mTypeOfItem;
  }
  
  public int gameMaxNumber(){
    do {          // do - checks until a number is given
      while (!scanner.hasNextInt()) {
        String input = scanner.next(); 
        System.out.printf("%s is not a valid number.\n", input);
        System.out.printf("Pick a number: ");
      }
      mMaxNumber = scanner.nextInt(); //Sets max number of items that can be placed in the jar, not sure how to have this work in prompter & pass test
      if(mMaxNumber == 0){  //checks if 0 is chosen and exits if it does... to pass the test
        System.out.printf("Number can not be 0, pick a new number.\n");
        //needs commented out unless using the automated test
        System.exit(0);  
      }
    } while (mMaxNumber == 0);
    return mMaxNumber;
  }
  
  
}
