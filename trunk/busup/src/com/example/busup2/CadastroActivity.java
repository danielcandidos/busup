package com.example.busup2;

import db.Usuario;
import android.os.Bundle;
import android.app.Activity;
import android.view.*;
import android.widget.*;
import android.app.AlertDialog;
//import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
//import android.database.Cursor;


public class CadastroActivity extends Activity {
	
	Usuario usuario;
	
	EditText etNome, etEmail, etLogin, etSenha;
	String nome, email, login, senha;
	Button btSalvar, btVoltar;
	SQLiteDatabase database;
	//BancoActivity ca = new BancoActivity();
	//LoginActivity loginActivity = new LoginActivity();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_cadastro);
		
		abreBanco();
		etNome = (EditText) findViewById(R.id.etNome);
		etEmail= (EditText) findViewById(R.id.etEmail);
		etLogin = (EditText) findViewById (R.id.etLogin);
		etSenha = (EditText) findViewById (R.id.etSenha);
		btSalvar = (Button) findViewById (R.id.btSalvar);
		btVoltar = (Button) findViewById (R.id.btVoltar);
		
		/*usuario.setNomeUsuario(etNome.getText().toString());
        usuario.setEmailUsuario(etEmail.getText().toString());
        usuario.setLoginUsuario(etLogin.getText().toString());
        usuario.setSenhaUsuario(etSenha.getText().toString());

	    nome = usuario.getNomeUsuario();
	   	email = usuario.getEmailUsuario();
		login = usuario.getLoginUsuario();
		senha = usuario.getSenhaUsuario();
			*/		
		
		
		btSalvar.setOnClickListener (new View.OnClickListener(){
			
			//String sql = "INSERT INTO usuario (nomeUsuario, emailUsuario ,loginUsuario, senhaUsuario) VALUES ('"+nome+"','"+email+"','"+login+"','"+senha+"');";
			public void onClick (View v) {
						///	loginActivity.abreBanco();

                	try{
                		    nome = etNome.getText().toString();
                			email = etEmail.getText().toString();
                			login = etLogin.getText().toString();
                			senha = etSenha.getText().toString();
                			
                		    
                            String sql = "INSERT INTO usuario (nomeUsuario, emailUsuario, loginUsuario, senhaUsuario) VALUES ('"+nome+"','"+email+"','"+login+"','"+senha+"');";
                    		//String sql = usuario.inserirUsuario(nome, email, login, senha);
                			database.execSQL(sql);
                			mensagemAlerta("Cadastro","Cadastro efetuado com sucesso");
                }	catch(Exception ex) {
                			mensagemAlerta("Cadastro","Erro ao efetuar cadastro:"+ex.getMessage());
                			//mensagemAlerta ("Teste",sql);
                        
                }
				
			}
				
		});
		
		
		btVoltar.setOnClickListener (new View.OnClickListener(){
			
			public void onClick (View v) {
				chamarLogin ();
			
			}
			
			
		});
		
		
		
		}
	
	public void mensagemExibir (String titulo, String mensagem) {
		AlertDialog.Builder caixaAlerta = new AlertDialog.Builder(CadastroActivity.this);
		caixaAlerta.setTitle(titulo);
		caixaAlerta.setMessage(mensagem);
		caixaAlerta.setNeutralButton("OK",null);
		caixaAlerta.show();
		
	}
	
	
	public void abreBanco () {
		

		try{
	        database = openOrCreateDatabase("BusUpdb", SQLiteDatabase.CREATE_IF_NECESSARY, null);
			//mensagemExibir("Teste", "Banco Criado com sucesso");
			//database.close();
			
		
		}catch(Exception ex) {
			mensagemExibir("Teste","Erro ao criar banco: "+ex.getMessage());
			
		}
		
		
	}
			
	
	public void chamarLogin () {
		Intent intent = new Intent(this,LoginActivity.class);
		startActivity(intent);
		
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