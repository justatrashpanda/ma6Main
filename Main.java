package greerj.ma6;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
public class Main {
        static Scanner sc = new Scanner(System.in);
        static Random random = new Random();
        

    public static void main(String[] args) {
        //gets name and sets into Player
        //function calls
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        Player player = new Player();
        player.setName(name);
        String phrase = getPhrase();
        game(player,phrase);
    }

    //game
    public static void game(Player player, String phraseStr){
      int input = 0;
      //starts game if types 1
      System.out.println("Type 1 if you are ready to play or 2 to quit:");
      input = sc.nextInt();

      //replaces characters in phrase with *
      if(input == 1){
          char array[] =new char[phraseStr.length()];
          for(int i=0;i<array.length; i++){
            if(phraseStr.charAt(i)!=' '){
                array[i]='*';
            }else{
                array[i]=' ';
            }
          }
          //appends asterisk phrases to stringBuilder
          StringBuilder sb = new StringBuilder();
          sb.append(array);
          System.out.println("Your phrase:" + sb);
          sc.nextLine();
          
            //gets guess and tallys attempt each guess
            while(checkWord(array)){
              System.out.println("Enter your guess(single letter or whole phrase):");
              String guess = sc.nextLine();
              player.timesGuessed(1);
              
                //if guess is more than one character, compares guess to entire string
                if(guess.length()>1){
                    if(phraseStr.equalsIgnoreCase(guess)){
                        player.result();
                        player.timesGuessed(0);
                        break;
                    }else{
                        System.out.println("Wrong guess. Try again.");
                    }
                }else{//if guess is 1 character, calls update function 
                    char ch=guess.charAt(0);
                    //call update function to place in location if found
                        if(update(array,ch,phraseStr)){
                            display(array);
                        }else{
                            System.out.println("Guess again.");
                            display(array);
                        }
                }//end of last else
            }//end of while
      }else{//if chose 2 at the beginning
          System.out.println("You chose not to play. See you next time!");
      }//end of last else
     System.out.println("Do you want to play again?");
     System.out.println("Type 1 to play again or 2 to quit");
     input = sc.nextInt();
        if (input == 1){
            //int noGuesses = 0;
            String phrase = getPhrase();
            game(player,phrase);
            //player.noGuesses = 0;
        }else{
            System.out.println("Adios!");
        }
    }//end of game

    //gets random phrase
    public static String getPhrase(){
        // Phrases for guessing
        String[] phrases = {"Hello world", "Good morning", "Rise and shine", 
                        "Seize the day", "God bless America"};
        String phraseStr = phrases[(int)(Math.random() * phrases.length)];//randomizes phrase
        return phraseStr;
    }

    //updates phrase. puts guessed letter instead of asterisk where it belongs
    public static boolean update(char a[],char ch,String phraseStr){
        boolean flag=false;
        for(int i=0;i<a.length;i++){
            if(phraseStr.charAt(i)!=' ' && Character.toLowerCase(phraseStr.charAt(i))==Character.toLowerCase(ch))
            {
                flag=true;
                a[i]=phraseStr.charAt(i);
            }
        }
        return flag;
    }

    //checks if there are still asterisks 
    public static boolean checkWord(char a[]){
        for(int i=0;i<a.length;i++)
            if(a[i]=='*')
            return true;
        return false;
    }
    //displays phrase
    public static void display(char[] a){
        for(int i=0;i<a.length;i++)
            System.out.print(a[i]);
        System.out.println();
    }
}
