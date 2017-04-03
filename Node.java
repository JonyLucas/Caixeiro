public class Node {
	
	String path = "";
	int dist, level, city;
	Node[] children;
	
	public Node(String caminho, int cidade, int distancia, int nivel, Node filhos[]){
		path = caminho;
		city = cidade;
		dist = distancia;
		level = nivel;
		children = filhos;
	}
	
	public int getCity(){
		return city;
	}
	
	public Node[] getChildren(){
		return children;
	}
	
	public int getDist(){
		return dist;
	}
	
	public String getPath(){
		return path;
	}
	
	public int getLevel(){
		return level;
	}
	
	public void setChildren(Node filhos[]){
		this.children = filhos;
	}

}
