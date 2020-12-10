package mypet.common;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class PetDAO extends DAO {
	PreparedStatement psmt;
	ResultSet rs;

	private final String petSelectAll = "SELECT * FROM PET";

	public ArrayList<PetVO> selectAll() {
		ArrayList<PetVO> list = new ArrayList<PetVO>();
		PetVO vo;
		try {
			psmt = conn.prepareStatement(petSelectAll);
			rs = psmt.executeQuery();
			while(rs.next()) {
				vo = new PetVO();
				vo.setId(rs.getInt("id"));
				vo.setName(rs.getString("name"));
				vo.setPicture(rs.getString("picture"));
				vo.setAge(rs.getInt("age"));
				vo.setBreed(rs.getString("breed"));
				vo.setLocation(rs.getString("location"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}
}
