import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class SudokuAggiornamento{
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


		//inizializza: conta gli zeri e riempe possibilita per la prima volta
		int zeri;
		int iterazioni = 0;
		boolean blockint = true;
		// boolean singolaPossibilita;
		// boolean doppiaPossibilita;
		zeri = init(matrix, possibilita); //analyzer
		System.out.println(zeri);

		while(zeri>0){
			// singolaPossibilita = false;
			// doppiaPossibilita = false;
			System.out.println("---------------------");
			System.out.println("Posizioni vuote: " + zeri);
			System.out.println("Possibilità: ");
			iterazioni++;

			for (Entry<Integer, ArrayList<Integer>> entry : possibilita.entrySet()) {
				//Entry è la possibilità per posizione; trovare un nome migliore
				if(entry.getValue().size() == 1){
					int posizione = entry.getKey();
					int riga = posizione/10;
					int colonna = posizione%10;
					matrix[riga][colonna]=entry.getValue().get(0);
					blockint = false;
					// singolaPossibilita = true;
				}
			}


			//Block Interactions
			if(blockint){       //Se vero deve fare il procedimento di BlockInteractions
				// int[][] quadrato1 = posizioniQuadrato(1);
				// int[][] quadrato2 = posizioniQuadrato(2);
				// int[][] quadrato3 = posizioniQuadrato(3);
				// int[][] quadrato4 = posizioniQuadrato(4);
				// int[][] quadrato5 = posizioniQuadrato(5);
				// int[][] quadrato6 = posizioniQuadrato(6);
				// int[][] quadrato7 = posizioniQuadrato(7);
				// int[][] quadrato8 = posizioniQuadrato(8);
				// int[][] quadrato9 = posizioniQuadrato(9);

				//creo un contenitore per le posizioni vuote in base al quadrato
				Map<Integer, ArrayList<Integer>> posizioniPerQuadrato = new HashMap<>();
				//inizializzo il contenitore
				for(int i = 1; i < 10; i++){
					posizioniPerQuadrato.put(i, new ArrayList<>());
				}
				//riempio il contenitore con le posizioni degli elementi vuoti
				for (Entry<Integer, ArrayList<Integer>> entry : possibilita.entrySet()) {
					int posizione = entry.getKey();
					int riga = posizione/10;
					int colonna = posizione%10;
					int quadrato = numeroQuadrato(riga, colonna);
					posizioniPerQuadrato.get(quadrato).add(posizione);				
				}

				for(int i = 1; i < 10; i++){
					
					for (int j = 0; j < posizioniPerQuadrato.get(i).size(); j++) {
						int posizione = posizioniPerQuadrato.get(i).get(j);
						int riga = posizione/10;
						int colonna = posizione%10;

						for(int k = 0; k < posizioniPerQuadrato.get(i).size(); k++){
							int posizioneDaControllare = posizioniPerQuadrato.get(i).get(k);
							int rigaDaControllare = posizioneDaControllare/10;
							int colonnaDaControllare = posizioneDaControllare%10;
							if(j != k){
								//controllo riga
								if(riga == rigaDaControllare){
									
								}
								//controllo colonna
								if(colonna == colonnaDaControllare){
									
								}
							}
						}
					}

				}



			}


			// if(!singolaPossibilita){
			// 	//Non ci sono elementi in possibilita lunghi 1
			// 	for (Entry<Integer, ArrayList<Integer>> entry : possibilita.entrySet()) {
			// 		//Entry è la possibilità per posizione; trovare un nome migliore
			// 		if(entry.getValue().size() == 2){
			// 			int posizione = entry.getKey();
			// 			int righe = posizione/10;
			// 			int colonne = posizione%10;
			// 			//A priori scegliamo il primo
			// 			matrix[righe][colonne]=entry.getValue().get(0);
			// 			doppiaPossibilita = true;
			// 			System.out.println("Sono nel caso possibilita.size()=2");
			// 		}
			// 	}
			// }

			// if(!doppiaPossibilita){
			// 	//Non ci sono elementi in possibilita lunghi 1
			// 	for (Entry<Integer, ArrayList<Integer>> entry : possibilita.entrySet()) {
			// 		//Entry è la possibilità per posizione; trovare un nome migliore
			// 		if(entry.getValue().size() == 3){
			// 			int posizione = entry.getKey();
			// 			int righe = posizione/10;
			// 			int colonne = posizione%10;
			// 			//A priori scegliamo il primo
			// 			matrix[righe][colonne]=entry.getValue().get(0);
			// 			System.out.println("Sono nel caso possibilita.size()=3");
			// 		}
			// 	}
			// }
			zeri = init(matrix, possibilita);
		}
		
		// while(zeri>0){
		// 	iterazioni++;
		// 	for(int righe = 0; righe<9; righe++) {
		// 		for(int colonne = 0; colonne<9; colonne++) {
		// 			if(matrix[righe][colonne]==0){
		// 				if(possibilita.get(righe*10+colonne)!=null && possibilita.get(righe*10+colonne).size()==1){
		// 					matrix[righe][colonne] = possibilita.get(righe*10+colonne).get(0);
		// 					zeri--;
		// 				} else {
		// 					analyzer(matrix, righe, colonne, possibilita);
		// 				}
		// 			}
		// 		}
		// 	}
		// 	System.out.println(zeri);
		// }

		//Stampa il sudoku
		stampa(matrix);
		System.out.println("Iterazioni: " + iterazioni);

                
    }  

	public static int numeroQuadrato(int riga, int colonna){
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
		return quadrato;
	}
    

	public static int[][] posizioniQuadrato(int quadrato){
		int[][] posizioni = new int[9][2];
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
	
	public static void stampa(int[][] sudoku){
		for(int righe = 0; righe<9; righe++) {
			for(int colonne = 0; colonne<9; colonne++) {
				//Revolutions, Resurrection
				System.out.print(sudoku[righe][colonne] + "\t");
			}
			System.out.println();
		}
	}

	public static void analyzer(int[][] sudoku, int righe, int colonne, Map<Integer, ArrayList<Integer>> possibilita){
		//Analizza la posizione
		if(sudoku[righe][colonne]==0){
			ArrayList<Integer> verifiche = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
			ArrayList<Integer> verificheDaMod = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9));
			int[][] posizioni= new int[9][2];
			int[] quadrato = new int[9];

			posizioni=posizioniQuadrato(righe, colonne);

			for(int k=0; k<9; k++) {
				int x = posizioni[k][0];
				int y = posizioni[k][1];
				quadrato[k]=sudoku[x][y];
				
			}
			//controllo della riga di indice "righe"
			for(int i = 0; i<9; i++) {	
				//ciclo per controllare quali numeri sono presenti nella riga
				for (Integer verifica : verifiche) {
					//analisi della riga
					if(sudoku[righe][i]==verifica) {
						verificheDaMod.remove(verifica);
					}
					//analisi della colonna
					if(sudoku[i][colonne]==verifica) {
						verificheDaMod.remove(verifica);
					}
					//analisi del quadrato
					if(quadrato[i]==verifica) {
						verificheDaMod.remove(verifica);
					}
				}
			}
			possibilita.put(righe*10+colonne, verificheDaMod);
			System.out.println("- Posizione: " + righe + "," + colonne+ " " + verificheDaMod);
		}
	}


	public static int init(int[][] sudoku, Map<Integer, ArrayList<Integer>> possibilita){
		int zeri = 0;
		for(int righe = 0; righe<9; righe++) {
			for(int colonne = 0; colonne<9; colonne++) {
				analyzer(sudoku, righe, colonne, possibilita);
				if(sudoku[righe][colonne]==0){
					zeri++;
				}
			}
		}
		return zeri;
	}

	public static void update(int[][] sudoku, Map<Integer, ArrayList<Integer>> possibilita){
		for(int righe = 0; righe<9; righe++) {
			for(int colonne = 0; colonne<9; colonne++) {
				analyzer(sudoku, righe, colonne, possibilita);
			}
		}
	}
}
     
     
     
     
     
