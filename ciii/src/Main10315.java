import java.io.*;
import java.util.*;

class Main
{
    static String ReadLn (int maxLg)  // utility function to read from stdin
    {
        byte lin[] = new byte [maxLg];
        int lg = 0, car = -1;
        try
        {
            while (lg < maxLg)
            {
                car = System.in.read();
                if ((car < 0) || (car == '\n')) break;
                lin [lg++] += car;
            }
        }
        catch (IOException e)
        {
            return (null);
        }

        if ((car < 0) && (lg == 0)) return (null);  // eof
        return (new String (lin, 0, lg));
    }

    public static void main (String args[])  // entry point from OS
    {
        MyClass myWork = new MyClass();  // create a dinamic instance
        myWork.Begin();            // the true entry point
    }

    
}


class MyClass {

   public static final int TIE=0;
   public static final int BLACK=1;
   public static final int WHITE=2;
    
   public static final int NUM_VALUE=13;
   public static final int NUM_SUIT=4;
   public static final int NUM_CARD=5;

   public static final int HIGH=1;
   public static final int PAIR=2;
   public static final int TWO_PAIR=3;
   public static final int THREE_KIND=4;
   public static final int STRAIGHT=5;
   public static final int FLUSH=6;
   public static final int FULL_HOUSE=7;
   public static final int FOUR_KIND=8;
   public static final int S_FLUSH=9;

   public static final int CLUB=0;
   public static final int DIAMOND=1;
   public static final int HEART=2;
   public static final int SPADE=3;

    void Begin()
    {
        String input;
        StringTokenizer idata;
        int i,j;
        String card = "AH";
        int suit[][] = new int[2][NUM_SUIT];
        int value[][] = new int[2][NUM_VALUE];
        // rank[][0] stores the type of hand
        // rank[][1] stores info about the highest card
        int rank[][] = new int[2][2];  

        while ((input = Main.ReadLn (255)) != null)
        {
          idata = new StringTokenizer (input);
          init_array(suit, NUM_SUIT);
          init_array(value, NUM_VALUE);
          init_array(rank, 2);
          for (i=0; i<2; i++) 
          {
             for (j=0; j<NUM_CARD; j++)
             {
                card = idata.nextToken();
                value[i][get_value(card.charAt(0))]++;
                suit[i][get_suit(card.charAt(1))]++;
             }
             calc_rank(value[i], suit[i], rank[i]);
          }
//          printarray(value, NUM_VALUE);
//          printarray(suit, NUM_SUIT);
//          printarray(rank, 2);
          check_winner(rank);
        }
    }

    void init_array(int n[][], int c)
    {
       for (int i=0; i<c; i++) {
          n[0][i]=0;
          n[1][i]=0;
       }
    }

    int get_value(char c)
    {
       int tmp;
       tmp = (int) c - (int) '0';
       if (tmp <= 9 && tmp >= 2)
          return tmp-2;
       switch (c) {
         case 'T':
            return NUM_VALUE-5;
         case 'J':
            return NUM_VALUE-4;
         case 'Q':
            return NUM_VALUE-3;
         case 'K':
            return NUM_VALUE-2;
         case 'A':
            return NUM_VALUE-1;
       }
       return -1;
    }

    int get_suit(char c)
    {
       switch (c) {
         case 'C':
           return CLUB;
         case 'D':
           return DIAMOND;
         case 'H':
           return HEART;
         case 'S':
           return SPADE;
       }
       return -1;
    }

    void printarray(int n[][], int c)
    {
        for (int i=0; i<2; i++) {
           for (int j=0; j<c; j++)
              System.out.print(n[i][j]+" ");
           System.out.println();
        }
    }

    // r[0] stores the rank, r[1] stores the high card value
    void calc_rank(int v[], int s[], int r[])
    {
       int max;
       if (check_flush(s)) {
          if (check_straight(v, r))
             r[0] = S_FLUSH;
          else
             r[0] = FLUSH;
       } else {
          max = calc_max(v, r);
          switch (max) {
             case 4: r[0] = FOUR_KIND; break;
             case 3: if (check_full(v, r))
                        r[0] = FULL_HOUSE;
                     else
                        r[0] = THREE_KIND;
                     break;
             case 2: if (check_two(v, r))
                        r[0] = TWO_PAIR;
                     else
                        r[0] = PAIR;
                     break;
             case 1: if (check_straight(v, r))
                        r[0] = STRAIGHT;
                     else
                        r[0] = HIGH;
          }
       }
    }

    boolean check_flush(int s[])
    {
       int i=0;
       while (i<NUM_SUIT && s[i] == 0)
         i++;
       if (s[i] == NUM_CARD)
         return true;
       return false;
    }

    // r[1] stores the high card value
    boolean check_straight(int v[], int r[])
    {
       boolean is_straight=true;
       int high=NUM_VALUE-1;
       while (high>=0 && v[high] == 0)
          high--;
       for (int i=1; i<NUM_CARD; i++)
          if (v[high-i] == 0)
             is_straight = false;
       r[1] = 1;
       for (int i=high-1; i>=0; i--)
          r[1] = r[1] * 2 + (v[i] == 0 ? 0 : 1);
       return is_straight;
    }

    // r[1] stores the index of the max of v[]
    int calc_max(int v[], int r[])
    {
       int max = 0;
       for (int i=1; i<NUM_VALUE; i++) {
          if (v[i] >= v[max])
             max = i;
       }
       r[1] = max;
       return v[max];
    }

    // input: r[1] stores the index of the max of v[]
    boolean check_full(int v[], int r[])
    {
       int max=0;
       for (int i=0; i<NUM_VALUE; i++) {
          if (v[i] > max && i != r[1]) {
             max = v[i];
          }
       }
       if (max == 2)
          return true;  
       return false;  
    }

    // input: r[1] stores the index of the max of v[]
    // output: r[1] stores calculated score based on the two pairs
    boolean check_two(int v[], int r[])
    {
       int max=0, imax=-1, rank2;
       for (int i=0; i<NUM_VALUE; i++) {
          if (v[i] > max && i != r[1]) {
             imax = i;
             max = v[i];
          }
       }
       if (max == 2) {
          rank2 = (r[1]+1) * NUM_VALUE * NUM_VALUE + (imax+1) * NUM_VALUE;
          for (int i=0; i<NUM_VALUE; i++)
             if (v[i] == 1)
                rank2 += (i+1);
          r[1] = rank2;
          return true;  
       }
       rank2 = 0;
       for (int i=NUM_VALUE-1; i>=0; i--)
          rank2 = rank2 * 2 + (v[i] == 1 ? 1 : 0);
       r[1] = rank2 + (int) ((r[1]+1) * Math.pow(2.0, NUM_VALUE+1));
       return false;  
    }

    void check_winner(int r[][])
    {
       int winner;
       if (r[0][0] > r[1][0])
          winner = BLACK;
       else if (r[0][0] < r[1][0])
          winner = WHITE;
       else {
          if (r[0][1] > r[1][1])
             winner = BLACK;
          else if (r[0][1] < r[1][1])
             winner = WHITE;
          else
             winner = TIE;
       }
       if (winner == TIE)
          System.out.println("Tie.");
       else 
          System.out.println((winner == BLACK ? "Black" : "White") + " wins.");
    }
}