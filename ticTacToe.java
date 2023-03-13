import java.util.*;
class ticTacToe
{
    public static char piece;
    public static String p1,p2;
    public static char board[][]={{' ','|',' ','|',' '},
               {'-','+','-','+','-'},
               {' ','|',' ','|',' '},
               {'-','+','-','+','-'},
               {' ','|',' ','|',' '},
               };
    public static void drawBoard()
    {
        int i,j;
        for(i=0;i<board.length;i++)
        {
            for(j=0;j<board[i].length;j++)
            {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static boolean checkPosition(int pos,char board[][])
    {
        int i,j;
        if(pos==1)
        {
            i=j=0;
        }
        else if(pos==2)
        {
            i=0;j=2;
        }
        else if(pos==3)
        {
            i=0;j=4;
        }
        else if(pos==4)
        {
            i=2;j=0;
        }
        else if(pos==5)
        {
            i=2;j=2;
        }
        else if(pos==6)
        {
            i=2;j=4;
        }
        else if(pos==7)
        {
            i=4;j=0;
        }
        else if(pos==8)
        {
            i=4;j=2;
        }
        else{
            i=4;j=4;
        }
        if(board[i][j]==' ')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    public static void placePiece(int pos,char piece,char board[][])
    {
        int i,j;
        if(pos==1)
        {
            i=j=0;
        }
        else if(pos==2)
        {
            i=0;j=2;
        }
        else if(pos==3)
        {
            i=0;j=4;
        }
        else if(pos==4)
        {
            i=2;j=0;
        }
        else if(pos==5)
        {
            i=2;j=2;
        }
        else if(pos==6)
        {
            i=2;j=4;
        }
        else if(pos==7)
        {
            i=4;j=0;
        }
        else if(pos==8)
        {
            i=4;j=2;
        }
        else{
            i=4;j=4;
        }
        board[i][j]=piece;

    }
    public static boolean checkWin(char board[][])
    {
        if((board[0][0]=='X' && board[0][2]=='X' && board[0][4]=='X')||
           (board[2][0]=='X' && board[2][2]=='X' && board[2][4]=='X')||
           (board[4][0]=='X' && board[4][2]=='X' && board[4][4]=='X')||
           (board[0][0]=='X' && board[2][2]=='X' && board[4][4]=='X')||
           (board[0][4]=='X' && board[2][2]=='X' && board[4][0]=='X'))
           {
            return true;
           }
           else if((board[0][0]=='O' && board[0][2]=='O' && board[0][4]=='O')||
           (board[2][0]=='O' && board[2][2]=='O' && board[2][4]=='O')||
           (board[4][0]=='O' && board[4][2]=='O' && board[4][4]=='O')||
           (board[0][0]=='O' && board[2][2]=='O' && board[4][4]=='O')||
           (board[0][4]=='O' && board[2][2]=='O' && board[4][0]=='O'))
           {
            return true;
           }
           else
           {
            return false;
           }
    }
    public static String whoWon(char board[][])
    {
        if((board[0][0]=='X' && board[0][2]=='X' && board[0][4]=='X')||
           (board[2][0]=='X' && board[2][2]=='X' && board[2][4]=='X')||
           (board[4][0]=='X' && board[4][2]=='X' && board[4][4]=='X')||
           (board[0][0]=='X' && board[2][2]=='X' && board[4][4]=='X')||
           (board[0][4]=='X' && board[2][2]=='X' && board[4][0]=='X'))
           {
            return p1;
           }
           else if((board[0][0]=='O' && board[0][2]=='O' && board[0][4]=='O')||
           (board[2][0]=='O' && board[2][2]=='O' && board[2][4]=='O')||
           (board[4][0]=='O' && board[4][2]=='O' && board[4][4]=='O')||
           (board[0][0]=='O' && board[2][2]=='O' && board[4][4]=='O')||
           (board[0][4]=='O' && board[2][2]=='O' && board[4][0]=='O'))
           {
            return p2;
           }
           else
           {
            return "NUN";
           }
    }
    public static boolean countBlank(char board[][])
    {
        int i,j,c=0;
        for(i=0;i<board.length;i++)
        {
            for(j=0;j<board[i].length;j++)
            {
                if(board[i][j]==' ')
                {
                    c++;
                }
            }
        }
        if(c==0)
        return false;
        else
        return true;
    }
    public static void main(String args[])
    {
        
        int c=1,pos;
        Scanner in=new Scanner(System.in);
        System.out.println("Enter name of 1st player");
        p1=in.next();
        System.out.println("Enter name of second player");
        p2=in.next();
        drawBoard();
        while(!checkWin(board) && countBlank(board))
        {
            if(c%2==0)
            {
                System.out.println(p2+" Enter piece position");
                pos=in.nextInt();
                if(checkPosition(pos,board)){
                placePiece(pos,'O',board);
                drawBoard();
                c++;
                }
                else{
                    drawBoard();
                    System.out.println("entered loaction is laready filled please enter other location");
                    continue;
                }
            }
            else{
                System.out.println(p1+" Enter piece position");
                pos=in.nextInt();
                if(checkPosition(pos,board)){
                placePiece(pos,'X',board);
                drawBoard();
                c++;
                }
                else{
                    drawBoard();
                    System.out.println("Entered position is already filled please enter other location");
                    continue;
                }
            }
        }
        if(checkWin(board))
        {
            String winner=whoWon(board);
            
            System.out.println(winner+" won the match");
            System.exit(0);
        }
        System.out.println("match was a tie");
    }
}
