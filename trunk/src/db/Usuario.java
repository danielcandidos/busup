package db;

public class Usuario {
	
	String idUsuario = "_idUsuario";
	String nomeUsuario = "nomeUsuario";
	String emailUsuario = "emailUsuario";
	String senhaUsuario = "senhaUsuario";
	
	
	public final void criarTabelaUsuario () {
		
		String sql = "CREATE TABLE IF NOT EXISTS usuario ("+idUsuario+" INTEGER PRIMARY KEY, "+
				                                            nomeUsuario+" TEXT NOT NULL,"+ 
				                                            emailUsuario+" TEXT NOT NULL"+
				                                            senhaUsuario+" TEXT NOT NULL)";															
		
	}
	
	public final void inserirUsuario () {
		
		String sql = "INSERT INTO usuario ()";
		
	}

}
