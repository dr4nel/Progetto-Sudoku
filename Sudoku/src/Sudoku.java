import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sudoku{
    public static void main(String[] args){

        // matrice riga x colonna
        int[][] matrix=
        // {//Risolto
        //     {2, 0, 9, 0, 0, 0, 6, 0, 0},
        //     {0, 4, 0, 8, 7, 0, 0, 1, 2},
        //     {8, 0, 0, 0, 1, 9, 0, 4, 0},
        //     {0, 3, 0, 7, 0, 0, 8, 0, 1},
        //     {0, 6, 5, 0, 0, 8, 0, 3, 0},
        //     {1, 0, 0, 0, 3, 0, 0, 0, 7},
        //     {0, 0, 0, 6, 5, 0, 7, 0, 9},
        //     {6, 0, 4, 0, 0, 0, 0, 2, 0},
        //     {0, 8, 0, 3, 0, 1, 4, 5, 0}
        // };
		// {   //Risolto
        //     {5,3,0,0,7,0,0,0,0},
        //     {6,0,0,1,9,5,0,0,0},
        //     {0,9,8,0,0,0,0,6,0},
        //     {8,0,0,0,6,0,0,0,3},
        //     {4,0,0,8,0,3,0,0,1},
        //     {7,0,0,0,2,0,0,0,6},
        //     {0,6,0,0,0,0,2,8,0},
        //     {0,0,0,4,1,9,0,0,5},
        //     {0,0,0,0,8,0,0,7,9}
        // };
		{   //Non risolve
            {4,0,1,0,0,0,0,0,0},
            {0,0,0,6,0,0,7,0,0},
            {8,5,0,0,0,0,0,0,0},
            {0,0,0,0,9,8,0,4,1},
            {3,0,0,2,0,0,0,0,0},
            {0,0,0,0,0,0,0,5,0},
            {0,6,0,0,0,0,3,0,0},
            {0,0,0,0,5,0,0,0,0},
            {0,0,0,0,0,4,0,0,0}
        };

		Map<Integer, ArrayList<Integer>> possibilita = new HashMap<>();


		//Conta Zeri
		int zeri = 0;
		int controllo = 0;
		for(int righe = 0; righe<9; righe++) {
       	 	for(int colonne = 0; colonne<9; colonne++) {
       	 		if(matrix[righe][colonne]==0){
					zeri++;
				}
       	 	}
        }

		System.out.println(zeri);

		while(zeri>0){
			controllo++;
			for(int righe = 0; righe<9; righe++) {
				for(int colonne = 0; colonne<9; colonne++) {
					if(matrix[righe][colonne]==0){
						if(possibilita.get(righe*10+colonne)!=null && possibilita.get(righe*10+colonne).size()==1){
							matrix[righe][colonne] = possibilita.get(righe*10+colonne).get(0);
							zeri--;
						} else {
							ArrayList<Integer> verifiche = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
							ArrayList<Integer> verificheDaMod = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));


							int[][] posizioni= new int[9][2];
							int[] quadrato = new int[9];
							posizioni=posizioniQuadrato(righe, colonne);
							for(int k=0; k<9; k++) {
								int x = posizioni[k][0];
								int y = posizioni[k][1];
								quadrato[k]=matrix[x][y];

							}
							//controllo della riga di indice "righe"
							for(int i = 0; i<9; i++) {
								//ciclo per controllare quali numeri sono presenti nella riga
								for (Integer verifica : verifiche) {
									//analisi della riga
									if(matrix[righe][i]==verifica) {
										verificheDaMod.remove(verifica);
									}
									//analisi della colonna
									if(matrix[i][colonne]==verifica) {
										verificheDaMod.remove(verifica);
									}
									//analisi del quadrato
									if(quadrato[i]==verifica) {
										verificheDaMod.remove(verifica);
									}
								}
							}

							possibilita.put(righe*10+colonne, verificheDaMod);

							System.out.println(righe+ "-"+colonne+ " "+verificheDaMod);
						}
					}
				}
			}
			System.out.println(zeri);
		}

		//Stampa il sudoku
        for(int righe = 0; righe<9; righe++) {
       	 	for(int colonne = 0; colonne<9; colonne++) {
       	 		//Revolutions, Resurrection
       	 		System.out.print(matrix[righe][colonne] + "\t");
       	 	}
       	 	System.out.println();
        }
		System.out.println(controllo);

    }

    public static int[][] posizioniQuadrato(int riga, int colonna){
    	int[][] posizioni = new int[9][2];
    	int quadrato=0;
    	if(riga<3) {
    		if(colonna<3) {
    			quadrato=1;
    		}
    		else if(colonna<6) {
    			quadrato=2;
    		}
    		else if(colonna<9) {
    			quadrato=3;
    		}
    	}
    	else if(riga<6) {
    		if(colonna<3) {
    			quadrato=4;
    		}
    		else if(colonna<6) {
    			quadrato=5;
    		}
    		else if(colonna<9) {
    			quadrato=6;
    		}

    	}
    	else if(riga<9) {
    		if(colonna<3) {
    			quadrato=7;
    		}
    		else if(colonna<6) {
    			quadrato=8;
    		}
    		else if(colonna<9) {
    			quadrato=9;
    		}
    	}
    	switch(quadrato) {
    		case 1:
    			//riga 1
    			posizioni[0][0]=0; posizioni[0][1]=0;
    			posizioni[1][0]=0; posizioni[1][1]=1;
    			posizioni[2][0]=0; posizioni[2][1]=2;
    			//riga 2
    			posizioni[3][0]=1; posizioni[3][1]=0;
    			posizioni[4][0]=1; posizioni[4][1]=1;
    			posizioni[5][0]=1; posizioni[5][1]=2;
    			//riga 3
    			posizioni[6][0]=2; posizioni[6][1]=0;
    			posizioni[7][0]=2; posizioni[7][1]=1;
    			posizioni[8][0]=2; posizioni[8][1]=2;

    			break;
    		case 2:
    			//riga 1
    			posizioni[0][0]=0; posizioni[0][1]=3;
    			posizioni[1][0]=0; posizioni[1][1]=4;
    			posizioni[2][0]=0; posizioni[2][1]=5;
    			//riga 2
    			posizioni[3][0]=1; posizioni[3][1]=3;
    			posizioni[4][0]=1; posizioni[4][1]=4;
    			posizioni[5][0]=1; posizioni[5][1]=5;
    			//riga 3
    			posizioni[6][0]=2; posizioni[6][1]=3;
    			posizioni[7][0]=2; posizioni[7][1]=4;
    			posizioni[8][0]=2; posizioni[8][1]=5;
    			break;
    		case 3:
    			//riga 1
    			posizioni[0][0]=0; posizioni[0][1]=6;
    			posizioni[1][0]=0; posizioni[1][1]=7;
    			posizioni[2][0]=0; posizioni[2][1]=8;
    			//riga 2
    			posizioni[3][0]=1; posizioni[3][1]=6;
    			posizioni[4][0]=1; posizioni[4][1]=7;
    			posizioni[5][0]=1; posizioni[5][1]=8;
    			//riga 3
    			posizioni[6][0]=2; posizioni[6][1]=6;
    			posizioni[7][0]=2; posizioni[7][1]=7;
    			posizioni[8][0]=2; posizioni[8][1]=8;
    			break;
    		case 4:
    			//riga 4
    			posizioni[0][0]=3; posizioni[0][1]=0;
    			posizioni[1][0]=3; posizioni[1][1]=1;
    			posizioni[2][0]=3; posizioni[2][1]=2;
    			//riga 5
    			posizioni[3][0]=4; posizioni[3][1]=0;
    			posizioni[4][0]=4; posizioni[4][1]=1;
    			posizioni[5][0]=4; posizioni[5][1]=2;
    			//riga 6
    			posizioni[6][0]=5; posizioni[6][1]=0;
    			posizioni[7][0]=5; posizioni[7][1]=1;
    			posizioni[8][0]=5; posizioni[8][1]=2;
    			break;
    		case 5:
    			//riga 4
    			posizioni[0][0]=3; posizioni[0][1]=3;
    			posizioni[1][0]=3; posizioni[1][1]=4;
    			posizioni[2][0]=3; posizioni[2][1]=5;
    			//riga 5
    			posizioni[3][0]=4; posizioni[3][1]=3;
    			posizioni[4][0]=4; posizioni[4][1]=4;
    			posizioni[5][0]=4; posizioni[5][1]=5;
    			//riga 6
    			posizioni[6][0]=5; posizioni[6][1]=3;
    			posizioni[7][0]=5; posizioni[7][1]=4;
    			posizioni[8][0]=5; posizioni[8][1]=5;
    			break;
    		case 6:
    			//riga 4
    			posizioni[0][0]=3; posizioni[0][1]=6;
    			posizioni[1][0]=3; posizioni[1][1]=7;
    			posizioni[2][0]=3; posizioni[2][1]=8;
    			//riga 5
    			posizioni[3][0]=4; posizioni[3][1]=6;
    			posizioni[4][0]=4; posizioni[4][1]=7;
    			posizioni[5][0]=4; posizioni[5][1]=8;
    			//riga 6
    			posizioni[6][0]=5; posizioni[6][1]=6;
    			posizioni[7][0]=5; posizioni[7][1]=7;
    			posizioni[8][0]=5; posizioni[8][1]=8;
    			break;
    		case 7:
    			//riga 7
    			posizioni[0][0]=6; posizioni[0][1]=0;
    			posizioni[1][0]=6; posizioni[1][1]=1;
    			posizioni[2][0]=6; posizioni[2][1]=2;
    			//riga 8
    			posizioni[3][0]=7; posizioni[3][1]=0;
    			posizioni[4][0]=7; posizioni[4][1]=1;
    			posizioni[5][0]=7; posizioni[5][1]=2;
    			//riga 9
    			posizioni[6][0]=8; posizioni[6][1]=0;
    			posizioni[7][0]=8; posizioni[7][1]=1;
    			posizioni[8][0]=8; posizioni[8][1]=2;
    			break;
    		case 8:
    			//riga 7
    			posizioni[0][0]=6; posizioni[0][1]=3;
    			posizioni[1][0]=6; posizioni[1][1]=4;
    			posizioni[2][0]=6; posizioni[2][1]=5;
    			//riga 8
    			posizioni[3][0]=7; posizioni[3][1]=3;
    			posizioni[4][0]=7; posizioni[4][1]=4;
    			posizioni[5][0]=7; posizioni[5][1]=5;
    			//riga 9
    			posizioni[6][0]=8; posizioni[6][1]=3;
    			posizioni[7][0]=8; posizioni[7][1]=4;
    			posizioni[8][0]=8; posizioni[8][1]=5;
    			break;
    		case 9:
    			//riga 7
    			posizioni[0][0]=6; posizioni[0][1]=6;
    			posizioni[1][0]=6; posizioni[1][1]=7;
    			posizioni[2][0]=6; posizioni[2][1]=8;
    			//riga 8
    			posizioni[3][0]=7; posizioni[3][1]=6;
    			posizioni[4][0]=7; posizioni[4][1]=7;
    			posizioni[5][0]=7; posizioni[5][1]=8;
    			//riga 9
    			posizioni[6][0]=8; posizioni[6][1]=6;
    			posizioni[7][0]=8; posizioni[7][1]=7;
    			posizioni[8][0]=8; posizioni[8][1]=8;
    			break;
    	}
    	return posizioni;
    }
}
