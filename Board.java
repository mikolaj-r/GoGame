

public class Board
{
    public Cell[][] positions;


    public Board() {
        this.positions = new Cell[19][19];
        for (int i = 0; i < 19; i++)
        {
            for (int j = 0; j < 19; j++)
            {
                positions[i][j] = new Cell();
            }
        }
    }



    public void updateBreaths()
    {

        for(int i = 0; i < 19; i++)
        {
            for(int j = 0; j < 19; j++)
            {
                int breath = 0;

                if (j > 0)
                {
                    if (positions[i][j-1].color == 0)  //lewo
                    {
                        breath++;
                    }
                }
                if (j < 18)
                {
                    if (positions[i][j+1].color == 0)  //prawo
                    {
                        breath++;
                    }
                }
                if (i > 0)
                {
                    if (positions[i-1][j].color == 0)  //gora
                    {
                        breath++;
                    }
                }
                if (i < 18)
                {
                    if (positions[i+1][j].color == 0)  // dol
                    {
                        breath++;
                    }
                }
                positions[i][j].breaths = breath;

            }
        }
    }



    public void checkBoard()  // w pierwszej iteracji wgl nie robie lancuchow wiec po prostu sprawdzam kazde pole czy ma 4 pola.
    {

        for(int i = 0; i < 19; i++)
        {
            for(int j = 0; j < 19; j++)
            {
                if(positions[i][j].breaths == 0)
                {
                    if(positions[i][j].color == 1)
                    {
                        App.pointsWhite++;
                    }
                    if(positions[i][j].color == 2)
                    {
                        App.pointsBlack++;
                    }
                    positions[i][j].color = 0;
                }
            }
        }
    }

    public boolean checkMove(int row, int column)
    {
        // w pierwszej iteracji nie sprawdzam nic poza tym czy pole jest puste, przyda sie potem
        if(positions[row][column].color == 0)
        return true;

        return false;
    }

    public void move(int row, int column, boolean turn) // turn true - black
    {
        if(turn)
        {
            positions[row][column].color = 2;
        }
        else
        {
            positions[row][column].color = 1;
        }
    }


    public void show()
    {
        int row = 1;
       System.out.println("   A B C D E F G H I J K L M N O P Q R S");
       for(int i = 0; i < 19; i++)
       {
           System.out.print(row);
           if(row<10)
           {
               System.out.print(" ");
           }
           System.out.print(" ");
           row++;
           for(int j = 0; j < 19; j++)
           {
               if(positions[i][j].color == 0)
                   System.out.print("·");
               if(positions[i][j].color == 1)
                   System.out.print("●");
               if(positions[i][j].color == 2)
                   System.out.print("○");
               System.out.print(" ");
           }
           System.out.println();
       }
    }





}
