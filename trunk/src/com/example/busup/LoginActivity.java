package com.example.busup;


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
	
	Cursor cursor;
	SQLiteDatabase database;
	Usuario usuario = new Usuario();
	EditText etLogin, etSenhaLogin;
	Button btEntrar;
	CheckedTextView ctvCadastrar;
	String login, senha;
   // SQL CSQLiteDatabase.CursorFactory()
	
	
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
				
				mensagemExibir("teste", "O clique ta funcionando");
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
	
	
	public void mensagemExibir (String titulo, String mensagem) {
		AlertDialog.Builder caixaAlerta = new AlertDialog.Builder(LoginActivity.this);
		caixaAlerta.setTitle(titulo);
		caixaAlerta.setMessage(mensagem);
		caixaAlerta.setNeutralButton("OK",null);
		caixaAlerta.show();
		
	}
	
	
	public boolean logar () {
		
		try{
		login = etLogin.getText().toString();
		senha = etSenhaLogin.getText().toString();
		
		cursor = database.query("usuario", 
			     new String [] {"nomeUsuario","emailUsuario","loginUsuario","senhaUsuario"},
			     null,
			     null, 
				 null, 
				 null,
				 null);
		
		
			 
			 if(cursor.getColumnName(2).intern().equals(login) && cursor.getColumnName(3).intern().equals(senha)) {
				 
				 mensagemExibir("Teste", "Usuário encontrado");	 
				 
			 }
			
				 
		 //int i = cursor.getColumnName(2).length();
		
	
		}catch (Exception ex) {
			mensagemExibir("Atenção!", "Login ou senha incorretos!"+ex.getMessage());

		
		}
		return false;
		
	}
	
	
	public void abreBanco () {
		try{
			String name = "BusUpdb";
	        database = openOrCreateDatabase(name, SQLiteDatabase.CREATE_IF_NECESSARY, null);
			mensagemExibir("Teste", "Banco Criado com sucesso");
			//database.close();
			
		
		}catch(Exception ex) {
			mensagemExibir("Teste","Erro ao criar banco: "+ex.getMessage());
			
		}
		
		
	}
	
	public void criaTabelas() {
        String sql = usuario.criarTabelaUsuario();
		
		try {
			database.execSQL(sql);
			mensagemExibir("Teste", "Tabela de usuários criada com sucesso");
			
			
		}catch(Exception ex) {
			mensagemExibir("Comando sql",sql);
			mensagemExibir("Teste", "Erro ao criar Tabela de usuários: "+ex.getMessage());
			
		}
		
	}
	
	 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
}