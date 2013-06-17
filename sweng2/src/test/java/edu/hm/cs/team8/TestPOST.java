package edu.hm.cs.team8;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestPOST {

	public static void main(String[] args) throws Exception {

		HttpURLConnection conn = (HttpURLConnection) new URL("http://localhost:8080/service/time-behaviour-keyfigures/ILL")
				.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);
		conn.setRequestProperty("Content-Type", "application/json");

		final String json = "[]";
		
		final DataOutputStream wr = new DataOutputStream(conn.getOutputStream());
		wr.writeBytes(json);
		wr.flush();
		wr.close();

		System.out.println(json);

		final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		for (String line = reader.readLine(); line != null; line = reader.readLine())
			System.out.println(line);
	}

}
