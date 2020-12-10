package mypet.serv;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import mypet.common.PetDAO;
import mypet.common.PetVO;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebServlet("/PetListServ")
public class PetListServ extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public PetListServ() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setContentType("application/json; charset=utf-8");

		PetDAO dao = new PetDAO();
		ArrayList<PetVO> list = dao.selectAll();

		Gson gson = new Gson();		
		String result = gson.toJson(list); // list를 gson으로 변환.

		response.getWriter().append(result); // result 출력.
		
		/*
		JSONArray jarr = new JSONArray();
		
		for(int i = 0; i < list.size(); i++) {
			JSONObject obj = JSONObject.fromObject(list.get(i));
			jarr.add(obj);
		}
		
		response.getWriter().append(jarr.toString());
		*/

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
