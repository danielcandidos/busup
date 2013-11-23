package com.example.busup;

import db.Usuario;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import android.app.AlertDialog;
import android.database.sqlite.SQLiteDatabase;
import android.database.Cursor;


public class CadastroActivity extends Activity {
	
	Usuario usuario;
	
	EditText etNome, etEmail, etLogin, etSenha;
	String nome, email, login, senha;
	Button btSalvar, btVoltar;
	SQLiteDatabase database;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
		
		etNome = (EditText) findViewById(R.id.etNome);
		etEmail= (EditText) findViewById(R.id.etEmail);
		etLogin = (EditText) findViewById (R.id.etLogin);
		etSenha = (EditText) findViewById (R.id.etSenha);
		btSalvar = (Button) findViewById (R.id.btSalvar);
		btVoltar = (Button) findViewById (R.id.btVoltar);
		
		
		
		btSalvar.setOnClickListener (new View.OnClickListener(){
			
			public void onClick (View v) {
				
				
				usuario.setNomeUsuario(etNome.getText().toString());
				usuario.setEmailUsuario(etEmail.getText().toString());
				usuario.setLoginUsuario(etLogin.getText().toString());
				usuario.setSenhaUsuario(etSenha.getText().toString());
				
				nome = usuario.getNomeUsuario();
				email = usuario.getEmailUsuario();
				login = usuario.getLoginUsuario();
				senha = usuario.getSenhaUsuario();
				
				try{
					database.execSQL(usuario.inserirUsuario(nome, email, login, senha));
					mensagemAlerta("Cadastro","Cadastro efetuado com sucesso");
				}catch(Exception ex) {
					mensagemAlerta("Cadastro","Erro ao efetuar cadastro:"+ex.getMessage());
					
				}
			
				
			}
			
			
		});
		
		
		btVoltar.setOnClickListener (new View.OnClickListener(){
			
			public void onClick (View v) {
				mensagemAlerta("Teste","O clique ta funcionando");
				//chamarLogin ();
			
			}
			
			
		});
		
		
		
		}
		
	
	
	public void chamarLogin () {
		setContentView(R.layout.activity_login);
		
	}
	
	public void mensagemAlerta(String titulo, String mensagem) {
		AlertDialog.Builder caixaAlerta = new AlertDialog.Builder(CadastroActivity.this);
		caixaAlerta.setTitle(titulo);
		caixaAlerta.setMessage(mensagem);
		caixaAlerta.setNeutralButton("OK",null);
		caixaAlerta.show();
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.cadastro, menu);
		return true;
	}

}
