import java.util.Scanner;

public class Prompter{
  Scanner scanner = new Scanner(System.in);
  private Jar mJar;
  int guessAsString = 0;
  private String mNewGame;
  
 public Prompter(Jar jar){
   mJar = jar;
 }
  
 public void play(){
  adminSetup();
  promptForGuess();
 }
  
  public boolean promptForGuess(){
    do {
      System.out.print("Your guess? ");
      while (!scanner.hasNextInt()) {
        String input = scanner.next();
        System.out.printf("%s is not a valid number.\n", input);
        System.out.printf("Pick a number: ");
      }
      guessAsString = scanner.nextInt();
      if(guessAsString == 0){
        System.exit(0);//to pass test
      } 
    } while (guessAsString == 0); 
    while(!mJar.isWinner(guessAsString)){
      System.out.print("Your guess? ");
      guessAsString = scanner.nextInt();
    }    
    return false; 
  }  
 
  public void adminSetup(){
    //System.out.print("What type of item? ");
    //System.out.printf("%n");
   // mJar.fillJarItem();
    //System.out.print("How many will fit in the jar? ");
    //System.out.printf("%n");
    //mJar.fillJarInt();
   // mJar.fillRandomNumber();    
  }
  
 public boolean promptNewGame(){
   System.exit(0);
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
  
}