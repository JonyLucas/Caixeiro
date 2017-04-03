import java.util.Scanner;

public class Caixeiro {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		int tam = scan.nextInt();
		int[][] adjMatrix = new int[tam][tam];
		
		for(int i = 0; i < tam; i++){
			for(int j = 0; j < tam; j++){
				adjMatrix[i][j] = scan.nextInt();
			}
		}
		
		showQuadMatrix(adjMatrix, tam);
		
		/*** Cria uma nova arvore, com um novo nó raiz, com distancia 0, nivel 0, e numero de folhas n! ***/
		Tree arv = new Tree(new Node("0", 0, 0, 0, new Node[tam-1]), tam, new Node[factorial(tam-1)]);

		arv.construct(adjMatrix, tam);
		//arv.showTree();
		
		scan.close();

	}
	
	public static void treeConst(int adjMatrix, int tam, String iniCity){
		
		for(int i = 1; i < tam; i++){
			/*** Cria uma nova arvore, com um novo nó raiz, com distancia 0, nivel 0, e numero de folhas n! ***/
			//Tree arv = new Tree(new Node(iniCity, 0, 0, new Node[tam-1]), tam, new Node[factorial(tam)]);
		}
		
	}
	
	public static void showQuadMatrix(int vet[][], int size){
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print(vet[i][j] + " ");
			}
			System.out.print("\n");
		}
	}
	
	public static int factorial(int n){
		int fat = 1;
		for(int i = n; i > 0; i--){
			fat *= i;
		}
		
		return fat;
	}

}
