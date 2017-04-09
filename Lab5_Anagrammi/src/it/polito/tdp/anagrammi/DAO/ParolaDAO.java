package it.polito.tdp.anagrammi.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ParolaDAO {
	/*
	 * Controllo se parola contenuta nel dizionario
	 */
	public boolean isParolaCorretta(String parola) {

		final String sql = "SELECT * FROM parola where nome=?";

		try {
			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, parola);

			ResultSet rs = st.executeQuery();

			boolean returnValue = false;

			if (rs.next())
				returnValue = true;

			conn.close();
			return returnValue;

		} catch (SQLException e) {
			e.printStackTrace();
		throw new RuntimeException("Errore Db");
		}
	}

}

