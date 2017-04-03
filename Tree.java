public class Tree {

	int height;
	boolean choosen[];
	Node root;
	Node sheets[];
	Tree subTree[];
	
	public Tree(Node raiz, int altura, Node folhas[]){
		
		root = raiz;
		height = altura;
		sheets = folhas;
		choosen = new boolean[altura];
		
		for(int i = 0; i < altura; i++){
			if(i == root.getCity()){
				choosen[i] = true;
			}else{
				choosen[i] = false;
			}
		}

		subTree = (altura > 1)? new Tree[altura-1] : null;
	
	}
	
	private Tree(Node raiz, int altura, boolean selec[], Node folhas[]){
		
		root = raiz;
		height = altura;
		sheets = folhas;
		choosen = selec;
		subTree = (altura > 2)? new Tree[altura-1] : null;
	
	}
	
	public void addNodes(Node n){
		if(subTree == null){
			return;
		}
		
		int i = 0, c = 0;

		for(int j = 0; j < choosen.length; j++){
			if(choosen[j])
				c++;
		}

		System.out.println(c);
		
		/*System.out.println("Size: " + height);
		System.out.println("height: " + (choosen.length-1));
		System.out.println("ADD");
		System.out.println("n: " + n.getCity());
		*/
		//showChoosen();

		do{

			System.out.println(i);
			while(i < choosen.length-1 && subTree[i] != null)
				i++;

			if(i < choosen.length && !choosen[i+1] ){
				//choosen[i+1] = true;
				//showChoosen();
				subTree[i] = new Tree(n, height-1, choosen.clone(), sheets);
				choosen[i+1] = false;
				//showChoosen();
				break;
			}else{
				System.out.println("Pulo");
				i++;
			}
		}while(i < choosen.length-1);
	}
	
	public int construct(int vet[][], int size){
		
		int res = 0, dist, nivel = root.getLevel();
		String caminho;

		showChoosen();

		for(int i = 1; i < size; i++){
			System.out.print("i: " + i);
			dist = root.getDist();
			dist += vet[root.getCity()][i];
			System.out.print(", dist: " + dist);
			if(dist == 0 || choosen[i]){
				System.out.println(" endl");
				continue;
			}
			
			caminho = root.getPath() + " " + i;
			System.out.print(", path: " + caminho);
			nivel = root.getLevel();
			System.out.println(", nivel: " + (nivel+1));
			addNodes(new Node(caminho, i, dist, nivel+1, new Node[size-1]));
			
		}
		
		//showChoosen();

		/*for(Tree subt : subTree){
			if(subt!=null)
				subt.construct(vet, size);
		}*/
		
		//System.out.println("Teste");
		
		for(int i = 0; i < height-1; i++){
			if(subTree[i]== null){
				System.out.println("NULL");
				continue;
			}
			//System.out.println(i);
			subTree[i].construct(vet, size);
		}
		
		return 0;
		
	}
	

	public void showChoosen(){
		System.out.print("Choosen: ");
		for(int i = 0; i < height; i++){
			if(choosen[i])
				System.out.print(i + " ");
		}
		System.out.println();
	}
	
	public void showTree(){
		
		System.out.println("Nível " + root.getLevel() + " - \t Nó: " + root.getCity() + " Path: " + root.getPath());
		for(Tree subt : subTree){
			subt.showTree();
		}
		
	}
	
	
}
