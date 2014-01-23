package com.example.busup2;

import java.io.ByteArrayOutputStream; 
import java.io.File; 
import java.io.FileNotFoundException; 
import java.io.IOException; 
import java.net.MalformedURLException; 

import android.app.Activity; 
import android.content.Context; 
import android.content.Intent; 
import android.content.SharedPreferences; 
import android.content.pm.ActivityInfo; 
import android.database.Cursor; 
import android.graphics.Bitmap; 
import android.graphics.BitmapFactory; 
import android.net.Uri; 
import android.os.Bundle; 
import android.provider.MediaStore; 
import android.view.View; 
import android.widget.EditText; 
import android.widget.ImageView; 
import android.widget.Toast; 

//import com.example.busup_teste.R;
import com.facebook.android.AsyncFacebookRunner; 
import com.facebook.android.AsyncFacebookRunner.RequestListener; 
import com.facebook.android.DialogError; 
import com.facebook.android.Facebook; 
import com.facebook.android.Facebook.DialogListener; 
import com.facebook.android.FacebookError; 

public class FacebookActivity extends Activity { 
	private static final String APP_ID = "1413003102269063"; 
	
	private static final String ACCESS_EXPIRES = "access_expires"; 
	private static final String ACCESS_TOKEN = "access_token"; 
	
	private Facebook facebook; 
	private SharedPreferences prefs; 
	
	private Bitmap fotoTirada; 
	private ImageView img1; 
	private File caminhoFoto; 
	
	private Bitmap image; 
	
	String[] salvarimg = new String[0]; 
	
	String corpo; 
	
	private int cont = 0;
	
	
	
	@SuppressWarnings("deprecation")
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState); 
		setContentView(R.layout.activity_facebook);
		
		facebook = new Facebook("1413003102269063"); 
		prefs = getPreferences(MODE_PRIVATE); 
		
		// Carrega a accessToken pra saber se o usuário já se autenticou 
		loadAccessToken(); 
		
		// Caso não tenha se autenticado abre o login 
		if (!facebook.isSessionValid()) { 
			// Chama a tela de login do facebook 
			facebook.authorize(this, new String[] { "publish_stream" }, 
					new DialogListener() { 
						// Login com sucesso, salva o accessToken 
						public void onComplete(Bundle values) { 
							saveAccessToken(); } 
						// Os métodos abaixo devem ser 
						// implementados para tratatmento dos 
						// fluxos width="640" alternativos (Já veio assim)
						public void onFacebookError(FacebookError error) {
						} 
						
						public void onError(DialogError e) {
						} 
						
						public void onCancel() {							
						} 
					}); 
			this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		} 
		
		img1 = (ImageView) findViewById(R.id.imageView1); 
	} 
	
	
	private void loadAccessToken() {
		String access_token = prefs.getString(ACCESS_TOKEN, null);
		long expires = prefs.getLong(ACCESS_EXPIRES, 0); 
		if (access_token != null) { 
			facebook.setAccessToken(access_token); 
		} 
		if (expires != 0) {
			facebook.setAccessExpires(expires); 
		} 
	}
	
	
	private void saveAccessToken() { 
		SharedPreferences.Editor editor = prefs.edit(); 
		editor.putString(ACCESS_TOKEN, facebook.getAccessToken()); 
		editor.putLong(ACCESS_EXPIRES, facebook.getAccessExpires()); 
		editor.commit(); 
	}
	
	
	public void galleryButtonClick(View v) {
		Intent intent = new Intent(Intent.ACTION_GET_CONTENT); 
		intent.setType("image/*"); 
		startActivityForResult(intent, 0); 
		cont++; 
	}
	
	
	// Evento de clique do botão para atualizar o status 
	public void updateStatusClick(View v) { 
		EditText edt = (EditText) findViewById(R.id.editText1); 
		if ((edt.getText().toString().trim().equals("")) || (edt.getText().toString() == null)) { 
			Toast.makeText(this, "Ops!!!, Digite algo para seus amigos...", Toast.LENGTH_LONG).show(); 
		} 
		// Não entendi essa parte de baixo, vê se tu entende kkkkk
		else if ((edt.getText().toString().trim().equals("")) || (edt.getText().toString() == null) || cont > 0) { 
			corpo = edt.getText().toString(); 
			sendPhoto(edt.getText().toString());
		} else if (cont == 0) { 
			corpo = edt.getText().toString(); 
			updateStatus(edt.getText().toString()); 
		}
		//^^ Até aqui ^^
		edt.setText("Aguarde enquanto publicamos o seu post, isso pode demorar um pouco..."); 
		edt.setEnabled(false); 
	}

	private RequestListener requestListener = new RequestListener() {
		public void onMalformedURLException(MalformedURLException e, Object state) { 
			showToast("URL mal formada"); 
		} 
		public void onIOException(IOException e, Object state) { 
			showToast("Problema de comunicação"); 
		} 
		public void onFileNotFoundException(FileNotFoundException e, Object state) { 
			showToast("Recurso não existe"); 
		} 
		public void onFacebookError(FacebookError e, Object state) { 
			showToast("Erro no Facebook: " + e.getLocalizedMessage()); 
		} 
		public void onComplete(String response, Object state) { 
			showToast("Publicação realizada com sucesso"); 
		} 
	};
	
	// Método que efetivamente atualiza o status 
	private void updateStatus(String status) { 
		AsyncFacebookRunner runner = new AsyncFacebookRunner(facebook); 
		Bundle params = new Bundle(); 
		params.putString("message", status); 
		runner.request("me/feed", params, "POST", requestListener, null); 
	}
	
	// Método que efetivamente atualiza o status com imagem 
	private void sendPhoto(String status) { 
		AsyncFacebookRunner runner = new AsyncFacebookRunner(facebook); 
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); 
		image.compress(Bitmap.CompressFormat.PNG, 100, baos); 
		byte[] bytes = baos.toByteArray(); 
		Bundle params = new Bundle(); 
		params.putByteArray("picture", bytes); 
		params.putString("message", status); 
		runner.request("me/photos", params, "POST", requestListener, null); 
	}
	
	private void showToast(final String s) { 
		final Context ctx = FacebookActivity.this; 
		runOnUiThread(new Runnable() { 
			public void run() { 
				Toast.makeText(ctx, s, Toast.LENGTH_SHORT).show(); 
			} 
		});
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) { 
		super.onActivityResult(requestCode, resultCode, data); 
		if (cont == 0) { 
			// A API do Facebook exige essa chamada para 
			// concluir o processo de login 
			facebook.authorizeCallback(requestCode, resultCode, data); 
		} else {
			if (resultCode == RESULT_OK) { 
				switch (requestCode) { 
				case 0:
					Uri selectedImage = data.getData(); 
					String[] filePathColumn = { MediaStore.Images.Media.DATA };
					Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null); 
					cursor.moveToFirst(); 
					int columnIndex = cursor.getColumnIndex(filePathColumn[0]); 
					String filePath = cursor.getString(columnIndex); // file
					
					cursor.close(); 
					
					Bitmap yourSelectedImage = BitmapFactory .decodeFile(filePath); 
					img1.setImageBitmap(yourSelectedImage); 
					image = yourSelectedImage; 
					
					break;
				
				case 1: 
					fotoTirada = BitmapFactory.decodeFile(caminhoFoto .getAbsolutePath()); 
					img1.setImageBitmap(fotoTirada); 
					
					break;	
				}
			}
		}		
	}
}	