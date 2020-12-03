package bank;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import com.google.gson.Gson;

import common.MyRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class MovieRequest {

	public static void main(String[] args) {

		String strUrl = "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=12664b24453335d2c3eca0fdc4b3b013&targetDt=20201202";
		String response = MyRequest.get(strUrl);
		
		///////gson
		System.out.println("=======gson=======");
		// string -> 자바객체
		Gson gson = new Gson();
		MovieList list = gson.fromJson(response, MovieList.class);

		// 영화제목 출력
		ArrayList<Movie> mvlist = list.boxOfficeResult.dailyBoxOfficeList;
		// 일반 for
		for (int i = 0; i < mvlist.size(); i++) {
			System.out.println(mvlist.get(i).movieNm);
		}
		// 확장for
		for (Movie i : mvlist) {
			System.out.println(i.movieNm);
		}
		
		/////// json-lib
		System.out.println("=======json-lib=======");
		JSONObject obj = JSONObject.fromObject(response);	// 전체 {}
		JSONObject obj2 = obj.getJSONObject("boxOfficeResult");	// 안{}
		obj2.getString("boxofficeType");	//안1.
		JSONArray arr = obj2.getJSONArray("dailyBoxOfficeList");	//안2.
		for(int i = 0; i < arr.size(); i++) {
			JSONObject temp = arr.getJSONObject(i);
			temp.getString("movieNm");
			System.out.println(temp.getString("movieNm"));
		}
		obj2.getString("showRange");	//안3.
	}

}
