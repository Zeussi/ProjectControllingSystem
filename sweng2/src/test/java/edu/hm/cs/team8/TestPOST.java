package edu.hm.cs.team8;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class TestPOST {

	public static void main(String[] args) throws Exception {

		HttpURLConnection conn = (HttpURLConnection) new URL("http://localhost:8080/service/time-trackings")
				.openConnection();
		conn.setRequestMethod("GET");
		conn.setDoOutput(true);


		final BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

		for (String line = reader.readLine(); line != null; line = reader.readLine())
			System.out.println(line);
	}

}
