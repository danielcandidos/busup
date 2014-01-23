package com.example.busup2;


import db.Usuario;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.app.AlertDialog;


public class LoginActivity extends Activity {
	
	SQLiteDatabase database;
	Usuario usuario = new Usuario();
	EditText etLogin, etSenhaLogin;
	Button btEntrar;
	CheckedTextView ctvCadastrar;
	String login, senha;
	Cursor cursor;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		abreBanco();
	    criaTabelas();
		
		
		etLogin = (EditText) findViewById(R.id.etLogin);
		etSenhaLogin = (EditText) findViewById(R.id.etSenhaLogin);
		btEntrar = (Button) findViewById (R.id.btEntrar);
		ctvCadastrar = (CheckedTextView) findViewById (R.id.ctvCadastrar);
		
		 btEntrar.setOnClickListener (new View.OnClickListener () {
			
			public void onClick (View v) {
				logar();
			
			
			}		
		});
		 
		 
		 ctvCadastrar.setOnClickListener (new View.OnClickListener (){

			 public void onClick(View v) {
				 chamarCadastro();
				
			 }
			 
		 });
		
		}
		
		
		
	
	
	public void chamarCadastro() {
		Intent intent = new Intent(this, CadastroActivity.class);
		startActivity(intent);
		
			 
		
	}
	
	public void chamarPrincipal () {
		Intent intent = new Intent (this, MainActivity.class);
		startActivity(intent);
	}
	
	
	
	
	
	public void logar () {
		
		try {
		login = etLogin.getText().toString();
		senha = etSenhaLogin.getText().toString();
		cursor = database.rawQuery("SELECT * FROM usuario WHERE loginUsuario = ? AND "+
				"senhaUsuario = ? ",new String [] {login, senha});	
		
		int numeroRegistros = cursor.getCount();
	
		
		 if (numeroRegistros == 0) {
					mensagemAlerta("Atenção", "Usuário ou senha incorretos"); 
		 }
		 
		 else if (numeroRegistros != 0) {
				mensagemAlerta("Teste", "Login efetuado com sucesso");
				chamarPrincipal(); }
			
		}catch(Exception ex) {
			mensagemAlerta("Teste", "Erro: "+ex.getMessage());
			
		}
		
	}
	
	
	 public void abreBanco () {
		

		try{
	        database = openOrCreateDatabase("BusUpdb", SQLiteDatabase.CREATE_IF_NECESSARY, null);
			//mensagemAlerta("Teste", "Banco Criado com sucesso");
			//database.close();
			
		
		}catch(Exception ex) {
			mensagemAlerta("Teste","Erro ao criar banco: "+ex.getMessage());
			
		}
		
		
	}
	
	
	
	public void criaTabelas() {
        String sql = usuario.criarTabelaUsuario();
		
		try {
			database.execSQL(sql);
			//mensagemAlerta("Teste", "Tabela de usuários criada com sucesso");
			
			
		}catch(Exception ex) {
			mensagemAlerta("Comando sql",sql);
			mensagemAlerta("Teste", "Erro ao criar Tabela de usuários: "+ex.getMessage());
			
		}
		
	}
	
	public void mensagemAlerta(String titulo, String mensagem) {
		AlertDialog.Builder caixaAlerta = new AlertDialog.Builder(LoginActivity.this);
		caixaAlerta.setTitle(titulo);
		caixaAlerta.setMessage(mensagem);
		caixaAlerta.setNeutralButton("OK",null);
		caixaAlerta.show();
		
		
	}
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
}

