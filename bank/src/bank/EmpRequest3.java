package bank;

import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import common.MyRequest;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EmpRequest3 {

	public static void main(String[] args) {
		
		// 배열로 받아온 경우
		String strUrl = "http://192.168.0.79/bank/empList3.jsp";
		String response = MyRequest.get(strUrl);
				
		// gson
		System.out.println("=============gson=========");
		Gson gson = new Gson();

		EmpVO2[] list = gson.fromJson(response, EmpVO2[].class);
		List<EmpVO2> list2 = Arrays.asList(list); 
		// 일반 배열을 ArrayList로 바꿔야 할 때는 Arrays.asList()를 사용
		// gson.fromJson( response, new TokenType<List<EmpVO2>> () {}.getType() );

		for (EmpVO2 emp : list) {
			System.out.println(emp.addr);
		}
		for(EmpVO2 emp2 : list2 ) {
			System.out.println(emp2.name);
		}
		
		// json-lib
		System.out.println("============json-lib=========");
		JSONArray arr = JSONArray.fromObject(response);	// []
		for ( int i = 0; i < arr.size(); i++) {	
			JSONObject temp = arr.getJSONObject(i);	// {}
			temp.getString("name");
			System.out.println(temp.getString("name"));
		}

	}

}
