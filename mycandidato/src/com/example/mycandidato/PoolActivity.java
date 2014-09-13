package com.example.mycandidato;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

public class PoolActivity extends ActionBarActivity {
	private Enquete enquete;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_pool);
		
		enquete = new Enquete();
		final EnqueteService client = new EnqueteService();
		
		Button btEnviar = (Button) findViewById(R.id.button1);
		btEnviar.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				new Thread(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
					
				// TODO Auto-generated method stub
				RadioButton rbOp1 = (RadioButton) findViewById(R.id.radioButton1);
				RadioButton rbOp2 = (RadioButton) findViewById(R.id.radioButton2);
				RadioButton rbOp3 = (RadioButton) findViewById(R.id.radioButton3);
				
				TextView tvResultado1 = (TextView) findViewById(R.id.textView2);
				TextView tvResultado2 = (TextView) findViewById(R.id.textView3);
				TextView tvResultado3 = (TextView) findViewById(R.id.textView4);
				
				System.out.println("Sysout: entra no onclick");
				
				if(rbOp1.isChecked()){
					/*int soma1 = 0;
					soma1+=enquete.getContop1();
					enquete.setContop1(soma1);
					client.updateEnquete(enquete);
					tvResultado1.setText("Op 1: "+enquete.getContop1());*/
					System.out.println("Opção 2");
					System.out.println("JSON eh: "+client.getEnquete("11"));
					
				}else if(rbOp2.isChecked()){
					/*int soma2 = 0;
					soma2+=enquete.getContop2();
					enquete.setContop2(soma2);
					client.updateEnquete(enquete);
					tvResultado2.setText("Op 2: "+enquete.getContop2());*/
					
					
				}else if(rbOp3.isChecked()){
					/*int soma3 = 0;
					soma3+=enquete.getContop3();
					enquete.setContop3(soma3);	
					client.updateEnquete(enquete);
					tvResultado3.setText("Op 3: "+enquete.getContop3());*/
					
				}
				}//fecha run
				}).start();//thread
				
			}
			
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.pool, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
