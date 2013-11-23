package db;

public class Usuario {
	
	private String idUsuario = "_idUsuario";
	private String nomeUsuario = "nomeUsuario";
	private String emailUsuario = "emailUsuario";
	private String loginUsuario = "loginUsuario";
	private String senhaUsuario = "senhaUsuario";
	
	
	public String getIdUsuario() {
		return idUsuario;
	}


	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	public String getEmailUsuario() {
		return emailUsuario;
	}

	public void setEmailUsuario(String emailUsuario) {
		this.emailUsuario = emailUsuario;
	}
	
	public String getLoginUsuario() {
		return loginUsuario;
	}

	public void setLoginUsuario(String loginUsuario) {
		this.loginUsuario = loginUsuario;
	}

	public String getSenhaUsuario() {
		return senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

	public void criarTabelaUsuario () {
		
		String sql = "CREATE TABLE IF NOT EXISTS usuario ("+idUsuario+" INTEGER PRIMARY KEY, "+
				                                            nomeUsuario+" TEXT NOT NULL,"+ 
				                                            emailUsuario+" TEXT NOT NULL"+
				                                            loginUsuario+" TEXT NOT NULL"+
				                                            senhaUsuario+" TEXT NOT NULL);";															
		
	}
	
	public String inserirUsuario (String nomeUsuario, String emailUsuario, String loginUsuario, String senhaUsuario) {
		
		String sql = "INSERT INTO usuario ("+nomeUsuario+", "+emailUsuario+" ,"+loginUsuario+","+senhaUsuario+"" +
				     "VALUES ("+nomeUsuario+","+emailUsuario+","+loginUsuario+","+senhaUsuario+");";
		
		return sql;
	}

}
