package bank;

import java.util.ArrayList;

import com.google.gson.Gson;

import common.MyRequest;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class EmpRequest {

	public static void main(String[] args) {

		String strUrl = "http://192.168.0.79/bank/empList.jsp";
		String response = MyRequest.get(strUrl);

		// gson
		System.out.println("=========gson===========");
		Gson gson = new Gson();

		/*
		 * 메서드를 만들지 않고 바로 사용. EmpList list = gson.fromJson(response, EmpList.class);
		 * 
		 * ArrayList<EmpVO> emplist = list.empList; for(EmpVO i : emplist) {
		 * System.out.println(i.age); }
		 */

		// 메서드를 만들어 사용
		EmpList empList = gson.fromJson(response, EmpList.class);

		for (EmpVO emp : empList.getEmpList()) {
			System.out.println(emp.getName());
		}

		for (int i = 0; i < empList.getEmpList().size(); i++) {
			EmpVO temp = empList.getEmpList().get(i);
			System.out.println(temp.getName());
		}

		// json-lib
		System.out.println("=========json-lib=========");
		JSONObject obj = JSONObject.fromObject(response); // {}
		JSONArray arr = obj.getJSONArray("empList"); // [] == 파싱하는 방법 (JSONArray) obj.get("empList")
		for (int i = 0; i < arr.size(); i++) {
			JSONObject temp = arr.getJSONObject(i);
			temp.getString("name");
			System.out.println(temp.getString("name"));
		}
	}

}
