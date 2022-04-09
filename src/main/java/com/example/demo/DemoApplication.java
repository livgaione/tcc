package com.example.demo;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.UUID;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {

		String urlName = "https://dlcdn.apache.org/maven/maven-3/3.8.5/source/apache-maven-3.8.5-src.zip";

		try {
			URL url = new URL(urlName);

			File file = new File(String.valueOf(UUID.randomUUID()));
			FileWriter fo = new FileWriter(file);
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			urlConnection.setDoInput(true);
			BufferedReader in = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));

			String line = null;

			while ((line = in.readLine()) != null) {
				fo.write(line);
			}

			in.close();
			fo.close();
			urlConnection.disconnect();

		} catch (MalformedURLException e) {
			System.out.println("Erro ao criar URL. Formato inválido.");
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
}

