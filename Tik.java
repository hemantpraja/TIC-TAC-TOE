import java.util.Scanner;
import java.io.Console;
import java.util.Random;

public class Tik {
    static String password = " ";
    static Scanner sc = new Scanner(System.in);
    static Console console = System.console();
    
    /* Method for printing Board */
    static void printBoard(char board[][]){
        System.out.println("\n\n"+Color.WHITE_BAGROUND+"---------------"+Color.RESET);
        System.out.println(Color.WHITE_BAGROUND+" | "+board[0][0]+" | "+board[0][1]+" | "+board[0][2]+" | "+Color.RESET);
        System.out.println(Color.WHITE_BAGROUND+" | "+board[1][0]+" | "+board[1][1]+" | "+board[1][2]+" | "+Color.RESET);
        System.out.println(Color.WHITE_BAGROUND+" | "+board[2][0]+" | "+board[2][1]+" | "+board[2][2]+" | "+Color.RESET);
        System.out.println(Color.WHITE_BAGROUND+"---------------"+Color.RESET);
    }

    /* Method for checking Won or Not */
    static boolean haveWon(char board[][], char player){
        // check for row
        for(int row = 0; row<board.length; row++){
            if(board[row][0] == player && board[row][1] == player && board[row][2] == player){
                return true;
            }
        }
        
        // check for column
        for(int col = 0; col<board.length; col++){
            if(board[0][col] == player && board[1][col] == player && board[2][col] == player){
                return true;
            }
        }
        
        // check diagonal 
        if(board[0][0] == player && board[1][1] == player && board[2][2] == player ){
            return true;
        }
        else if(board[0][2] == player && board[1][1] == player && board[2][0] == player ){
            return true;
            
        }
        return false;
    }

    /* Method for Creating new Board */
    static char[][] createBoard(){
        char board[][] = new char[3][3];
        for(int row = 0; row<board.length; row++){
            for(int col=0; col<board[row].length;col++){
                board[row][col] = ' ';
            }
        }
        return board;
    }

    /* Method for Validate User */
    static void validateUser(){
        boolean bool;
        do{
            String pass = new String(console.readPassword("\nEnter Password : "));
            bool = pass.equals(password);
            if(bool!=true){
                System.out.println(Color.RED+"---Invalid Password---\n"+Color.RESET);
                System.out.println("Select Option :\n"+Color.BLUE+"1. Retry\n2. Forget Password"+Color.RESET);
                int ch;
                do{
                    ch = sc.nextInt();
                    if(ch==2){
                        System.out.print("\nSecurity Question : \n"+Color.BLUE+"-> What is your lucky number ? "+Color.RESET+"\nEnter Answer : ");
                        int ans = sc.nextInt();
                        if(ans==10){
                            password = new String(console.readPassword("\nEnter new password: "));
                            System.out.println(Color.YELLOW+"\n..Password Changed Successfully.."+Color.RESET);
                        }
                        else{
                            System.out.println(Color.RED+"---Wrong Answer Try Next Time---\n"+Color.RESET);
                        }
                    }
                    else if(ch<1 || ch>2){
                        System.out.println(Color.RED+"---Invalid Choice---\nPlease Choose Again--"+Color.RESET);
                    }
                }while(ch<1 || ch>2);
            }
        }while(bool!=true);
        
    }

    /* Two Player Game */
    static void twoPlayer(char board[][]){
        char player = 'X';
        boolean game_Over = false;
        System.out.println(Color.PURPLE+"--: Board is Ready :--"+Color.RESET);
        while(game_Over==false){
            Tik.printBoard(board);
            System.out.print("\nPlayer "+player+" Enter : ");
            int row = 0;
            int col = 0;
            do{
                row = sc.nextInt();
                col = sc.nextInt();
                if(row<0 || row>2 || col<0 || col>2){
                    System.out.print(Color.RED+"--Invalid row or column--"+Color.RESET+"\n\nPlease re-rnter : ");
                }
            }while(row<0 || row>2 || col<0 || col>2);

            
            if(board[row][col]==' '){
                board[row][col] = player;
                game_Over = Tik.haveWon(board,player);
                if(game_Over==true){
                    Tik.printBoard(board);
                    System.out.println("\n"+Color.PURPLE+"   !!! Congrats !!!\n"+Color.RESET+"Player "+player+" has Won the Match.\n");
                    return;
                } else{
                    if(player=='X'){
                        player = 'O';
                    } else{
                        player = 'X';
                    }
                }
            } else{
                System.out.print(Color.RED+"--Invalid Move--Try Again--");
            }
            boolean draw = true;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[i][j]==' '){
                        draw = false;
                    }
                }
            }
            if(draw ){
                System.out.println(Color.CYAN+"\n---- MATCH DRAW -----"+Color.RESET);
                return;
            }
            
        }
    }

    /* Random Number generator */
    static int Rndoms(){
        Random random = new Random();
        int num = random.nextInt((2 - 0) + 1) + 0;
        return num;
    }

    /* Single Player Game */
    static void singlePlayer(char board[][]){
        char player = 'X';
        boolean game_Over = false;
        System.out.print(Color.PURPLE+"--: Board is Ready :--"+Color.RESET);
        while(game_Over==false){
            Tik.printBoard(board);
            System.out.print("\nPlayer "+player+" Enter : ");
            int row = 0;
            int col = 0;
            if(player=='X'){

                do{
                    row = sc.nextInt();
                    col = sc.nextInt();
                    if(row<0 || row>2 || col<0 || col>2){
                        System.out.print(Color.RED+"--Invalid row or column--"+Color.RESET+"\nPlease re-rnter : ");
                        return;
                    }
                }while(row<0 || row>2 || col<0 || col>2);
            }
            else {
                do{
                    row = Rndoms();
                    col = Rndoms();
                }while(board[row][col]!=' ');
            }
            
            if(board[row][col]==' '){
                board[row][col] = player;
                game_Over = Tik.haveWon(board,player);
                if(game_Over==true){
                    Tik.printBoard(board);
                    System.out.println("\n"+Color.PURPLE+"   !!! Congrats !!!\n"+Color.RESET+"Player "+player+" has Won the Match.\n");
                } else{
                    if(player=='X'){
                        player = 'O';
                    } else{
                        player = 'X';
                    }
                }
            } 
            else{
                System.out.println(Color.RED+"--Invalid move--Try Again--"+Color.RESET);
            }
            boolean draw = true;
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    if(board[i][j]==' '){
                        draw = false;
                    }
                }
            }
            if(draw){
                System.out.println(Color.CYAN+"\n---- MATCH DRAW -----"+Color.RESET);
                return;
            }
        }
    }
}
    