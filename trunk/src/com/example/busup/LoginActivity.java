package com.example.busup;


import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.app.AlertDialog;


public class LoginActivity extends Activity {
	
	TextView tvSenhaLogin, tvLogin, tvAcessoRedes;
	EditText etLogin, etSenhaLogin;
	Button btEntrar;
	CheckedTextView ctvCadastrar;
	String login, senha;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		abreBanco();
		
		
		etLogin = (EditText) findViewById(R.id.etLogin);
		etSenhaLogin = (EditText) findViewById(R.id.etSenhaLogin);
		btEntrar = (Button) findViewById (R.id.btEntrar);
		ctvCadastrar = (CheckedTextView) findViewById (R.id.ctvCadastrar);
		
		 btEntrar.setOnClickListener (new View.OnClickListener () {
			
			public void onClick (View v) {
				
				login = String.valueOf(etLogin.getText());
				senha =  String.valueOf(etSenhaLogin.getText());
				
			
				
			}
			
			
			
		});
		 
		 
		 ctvCadastrar.setOnClickListener (new View.OnClickListener (){

			 public void onClick(View v) {
				 chamarCadastro();
				
			 }
			 
		 });
		
		
	
		
		Cursor cursor;
		
		
	}
	
	public void chamarCadastro() {
		setContentView(R.layout.activity_cadastro);
			 
		
	}
	
	
	public void mensagemExibir (String titulo, String mensagem) {
		AlertDialog.Builder caixaAlerta = new AlertDialog.Builder(LoginActivity.this);
		caixaAlerta.setTitle(titulo);
		caixaAlerta.setMessage(mensagem);
		caixaAlerta.setNeutralButton("OK",null);
		caixaAlerta.show();
		
	}
	
	
	public void abreBanco () {
		try{
			String name = "BusUpdb";
			SQLiteDatabase database = openOrCreateDatabase(name, SQLiteDatabase.CREATE_IF_NECESSARY, null);
			mensagemExibir("Teste", "Banco Criado com sucesso");
		
		}catch(Exception ex) {
			mensagemExibir("Teste","Erro ao criar banco: "+ex.getMessage());
			
		}
	}
	
	 

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
}