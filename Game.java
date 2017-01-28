import java.util.Scanner; 

public class Game {
   
    public static void main(String[] args) {
            
        String mTypeOfItem;
        int mMaxNumber;
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("What type of item? ");
        System.out.printf("%n");
        mTypeOfItem = scanner.next();  
        System.out.print("How many will fit in the jar? ");
        System.out.printf("%n");

        do {
          while (!scanner.hasNextInt()) {
            String input = scanner.next();
            System.out.printf("%s is not a valid number.\n", input);
            System.out.printf("Pick a number: ");
          }
          mMaxNumber = scanner.nextInt();
          if(mMaxNumber == 0){
            System.out.printf("Number can not be 0, pick a new number.\n");
            System.exit(0);
          }
        } while (mMaxNumber == 0);

      Jar jar = new Jar(mTypeOfItem, mMaxNumber);
      
      Prompter prompter = new Prompter(jar);
      do{
        prompter.play(); 
      }while(prompter.promptNewGame());              
    }
}