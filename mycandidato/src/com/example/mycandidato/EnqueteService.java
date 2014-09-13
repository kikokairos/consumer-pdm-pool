package com.example.mycandidato;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.GregorianCalendar;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

public class EnqueteService {
	String ip="10.0.2.2";
	
	public Enquete getEnquete(String id){
		try {
			URL url = new URL(
					"http://"+ip+":8080/Projeto-PDM-Service/bocadeurna/"
			);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			InputStreamReader reader = new InputStreamReader(conn.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(reader);
			String jsontext = bufferedReader.readLine();
			
			//converter o texto em json
			JSONObject json = new JSONObject(jsontext);
			boolean success = json.getBoolean("success");
			if (success){
								
				JSONObject dados = json.getJSONObject("dados");
				
				Integer identity = dados.getInt("id");
				String pesquisa = dados.getString("enquete");
				GregorianCalendar data = (GregorianCalendar) dados.get("data");
				String opcao1 = dados.getString("op1");
			    String opcao2 = dados.getString("op2");
				String opcao3 = dados.getString("op3");
				Integer contarop1 = dados.getInt("contop1");
				Integer contarop2 = dados.getInt("contop1");
				Integer contarop3 = dados.getInt("contop1");
				
				//criar enquete
				Enquete enquete = new Enquete();
				enquete.setId(identity);
				enquete.setEnquete(pesquisa);
				enquete.setData(data);
				enquete.setOp1(opcao1);
				enquete.setOp2(opcao2);
				enquete.setOp3(opcao3);
				enquete.setContop1(contarop1);
				enquete.setContop2(contarop2);
				enquete.setContop3(contarop3);
				
				return enquete;
				
			}
			else {
				String message = json.getString("message");
				Log.e("Sucesso get", message);
			}
		}
		catch (JSONException e) {
			Log.e("Json get", "Error on get enquete by JSON", e);
		}
		catch (IOException e){
			Log.e("IO get", "Error on get enquete by IO", e);
		}
		return null;
	}
	
	public void updateEnquete(Enquete enquete){
		try {
			URL url = new URL(
					"http://"+"ip"+":8080/Projeto-PDM-Service/bocadeurna" + enquete.getId()
			);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("PUT");
			conn.setRequestProperty("Content-type", "application/json");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//
			JSONObject json = new JSONObject();
			json.put("contop1", enquete.getContop1());
			json.put("contop2", enquete.getContop2());
			json.put("contop3", enquete.getContop3());
			//
			conn.getOutputStream().write(json.toString().getBytes());
			//
			InputStreamReader reader = new InputStreamReader(conn.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(reader);
			String jsontext = bufferedReader.readLine();
			//converter o texto em json
			JSONObject jsonresult = new JSONObject(jsontext);
			boolean success = jsonresult.getBoolean("success");
			if (success){
				Log.i("Teste update", "Sucesso");
			}
			else {
				String message = json.getString("message");
				Log.e("Teste update", message);
			}
		}
		catch (JSONException e) {
			Log.e("Teste update", "Error on get enquete by JSON", e);
		}
		catch (IOException e){
			Log.e("Teste update", "Error on get enquete by IO", e);
		}
		
	}
	
	//post
	public Enquete postEnquete(Enquete enquete){
		try {
			URL url = new URL(
					"http://"+"ip"+":8080/Projeto-PDM-Service/bocadeurna"
			);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setRequestProperty("Content-type", "application/json");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//
			JSONObject json = new JSONObject();
			json.put("contop1", enquete.getContop1());
			json.put("contop2", enquete.getContop2());
			json.put("contop3", enquete.getContop3());
			conn.getOutputStream().write(json.toString().getBytes());
			//
			InputStreamReader reader = new InputStreamReader(conn.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(reader);
			String jsontext = bufferedReader.readLine();
			
			JSONObject jsonresult = new JSONObject(jsontext);
			boolean success = jsonresult.getBoolean("success");
			if (success){
				Log.i("Teste post", "Sucesso");
			}
			else {
				String message = json.getString("message");
				Log.e("Teste post", message);
			}
			
		}
		catch (JSONException e) {
			Log.e("Teste post", "Error on get enquete by JSON", e);
		}
		catch (IOException e){
			Log.e("Teste post", "Error on get enquete by IO", e);
		}
		return null;
	}
	
	//deletar
	public void deleteEnquete(Enquete enquete){
		try {
			URL url = new URL(
					"http://"+"ip"+":8080/Projeto-PDM-Service/bocadeurna" + enquete.getId()
			);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("DELETE");
			conn.setRequestProperty("Content-type", "application/json");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			//
			JSONObject json = new JSONObject();			
			//
			conn.getOutputStream().write(json.toString().getBytes());
			//
			InputStreamReader reader = new InputStreamReader(conn.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(reader);
			String jsontext = bufferedReader.readLine();
			
			//converter o texto em json
			JSONObject jsonresult = new JSONObject(jsontext);
			boolean success = jsonresult.getBoolean("success");
			if (success){
				Log.i("Teste del", "Sucesso");
			}
			else {
				String message = json.getString("message");
				Log.e("Teste del", message);
			}
		}
		catch (JSONException e) {
			Log.e("Teste del", "Error on get enqute by JSON", e);
		}
		catch (IOException e){
			Log.e("Teste del", "Error on get enqute by IO", e);
		}		
		
	}

}
