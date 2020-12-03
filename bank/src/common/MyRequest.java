package common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MyRequest {
	public static String get(String strUrl) {
		/*
		 * BufferedReader(String) <- InputStreamReader(Char=2byte) <- InputStream(byte)
		 * 구현 : BufferedReader(new InputStreamReader(getInputStream()));
		 * google-gson-2.8.6.jar library 사용
		 */
		StringBuilder sb = new StringBuilder();
		try {
			URL url = new URL(strUrl);
			HttpURLConnection con = (HttpURLConnection) url.openConnection(); // openConnection 서버연결
			if (con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				// Stream을 처리해줘야 하는 귀찮음이 있음.
				BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8")); 
				// InputStreamReader에 결과 받아옴.(==ajax의 result)
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
				System.out.println("" + sb.toString());
			} else {
				System.out.println(con.getResponseMessage());
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
}
