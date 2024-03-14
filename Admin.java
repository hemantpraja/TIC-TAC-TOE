import java.util.Scanner;
public class Admin{
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println(Color.PURPLE+"---------------------------------------------------------------------------------------------------------------------------");
        System.out.println("--------------------------------------: "+Color.CYAN+"WelCome to The World of TIK TAK TOE"+Color.PURPLE+" :----------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------"+Color.RESET);

        Tik.validateUser();
        char ch = ' ';
        do{
        
            System.out.println("\nSelect Player : \n"+Color.BLUE+"1. Single Player\n2. Two Player"+Color.RESET);
            int choice = 0;
            do{
                choice = sc.nextInt();
                if(choice<1 || choice>2){
                    System.out.print(Color.RED+"\n---Invalid Selection---\n"+Color.RESET+"\nPlease Select Again : ");
                }
            }while(choice<1 || choice>2);
            
            char board[][] = Tik.createBoard();
            if(choice == 1){
                Tik.singlePlayer(board);
            }
            else if(choice == 2){
                Tik.twoPlayer(board);
            }
            System.out.print("\nDo you want to play again ?(Y/N) : ");
            ch = sc.next().charAt(0);
        }while(ch=='y' || ch=='Y');
    }
    
}