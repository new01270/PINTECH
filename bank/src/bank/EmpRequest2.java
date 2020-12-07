package bank;

import com.google.gson.Gson;

import common.MyRequest;
import net.sf.json.JSONObject;

public class EmpRequest2 {
	public static void main(String[] args) {
		
		//객체로 받아온 경우
		String strUrl = "http://192.168.0.79/bank/empList2.jsp";		
		String response = MyRequest.get(strUrl);
		
		//gson
		Gson gson = new Gson();
		
		EmpVO2 emp = gson.fromJson(response, EmpVO2.class);	// {}에 EmpVo를 받아옴.
		
		System.out.println("==========gson==========");
		System.out.println(emp.name);
		System.out.println(emp.age);
		System.out.println(emp.addr);
		
		//json-lib
		System.out.println("==========json-lib==========");
		JSONObject obj = JSONObject.fromObject(response);
		System.out.println(obj.getString("name"));	// VO만들 필요 없이 get메서드를 이용해 필드값을 가져온다.
		System.out.println(obj.getInt("age"));
	}

}
