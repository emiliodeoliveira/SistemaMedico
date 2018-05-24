package db.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;
import modelos.Consulta;
import modelos.Medico;
import modelos.Paciente;
//import java.text.SimpleDateFormat;
//import java.sql.Date;

/**
 * @author IT Academy #4
 * 
 * 
 */

public class DBConnection {
	//// Efetua os testes através do método main.
	//	public static void main(String args[]) {
	//		try {
	//			DBConnection objeto = new DBConnection();
	//			
	//			//consulta pacientes
	//			objeto.consultaTabelas(Paciente.TABELA_PACIENTES).stream().forEach((String x) -> {System.out.println(String.join(" ", x.split("#")));});
	//			System.out.println("---------------");
	//			
	////			//consulta consultas
	//			objeto.consultaTabelas(Consulta.TABELA_CONSULTAS).stream().forEach((x)->{System.out.println(String.join(" ",x.split("#")));});
	//			System.out.println("---------------");
	//			
	//			//consulta medicos
	//			objeto.consultaTabelas(Medico.TABELA_MEDICOS).stream().forEach((x)->{System.out.println(String.join(" ",x.split("#")));});
	//			System.out.println("---------------");
	//			
	//			//consulta especializacao
	//			objeto.consultaTabelas(DBConnection.TABELA_ESPECIALIZACAO).stream().forEach((x)->{System.out.println(String.join(" ",x.split("#")));});
	//
	//			//insercao
	//			Medico medi = new Medico("Zeze", "M", "Dermatologia", 7234,new Date(new SimpleDateFormat("dd/MM/yyyy").parse("02/01/1991").getTime()), "72345578","ze@gmail.com", "Rua Parana 667", "222388888");
	//			Paciente p = new Paciente("Carla", "F", "554564", new Date(new SimpleDateFormat("dd/MM/yyyy").parse("02/01/1991").getTime()), "3711817", "carla@gmail.com", "Rua ninguem, 000");
	//			System.out.println(p.createQueryInsertPessoa());
	//			System.out.println(p.createQueryInsertPaciente());
	//			objeto.createPacienteInDB(p);	 
	//		} catch (Exception e) {
	//			e.printStackTrace();
	//
	//		}
	//	}

	public static final String TABELA_ESPECIALIZACAO = "RESUMO_ESPECIALIDADES";
	private Connection conexao = null;

	private void conectarBanco() throws SQLException {
		conexao = DriverManager.getConnection("jdbc:oracle:thin:@//camburi.pucrs.br:1521/facin11g", "pqts6", "pqts");
		conexao.setAutoCommit(false);
	}

	private void commit() throws SQLException {
		conexao.commit();
	}

	private void fecharBanco() throws SQLException {
		if (!conexao.isClosed())
			conexao.close();
	}

	private void mandaInsert(String query) throws SQLException {
		PreparedStatement statimant = conexao.prepareStatement(query);
		statimant.execute();
		statimant.close();
	}

	public void createPacienteInDB(Paciente paci) throws SQLException{
		conectarBanco();
		mandaInsert(paci.createQueryInsertPessoa());
		mandaInsert(paci.createQueryInsertPaciente());
		commit();
		fecharBanco();
	}

	public void createMedicoInDB(Medico medi) throws SQLException {
		conectarBanco();
		mandaInsert(medi.createQueryInsertPessoa());
		mandaInsert(medi.createQueryInsertMedico());
		commit();
		fecharBanco();
	}

	public List<String> consultaTabelas(String tabela) throws SQLException {
		if (tabela == null || tabela.isEmpty()
				|| !(tabela.equals(Medico.TABELA_MEDICOS)) && !(tabela.equals(Consulta.TABELA_CONSULTAS))
				&& !(tabela.equals(Paciente.TABELA_PACIENTES)) && !(tabela.equals(TABELA_ESPECIALIZACAO)))
			throw new IllegalArgumentException();

		List<String> QueryResult = null;
		String statement = "SELECT * FROM " + tabela;

		conectarBanco();

		PreparedStatement stmt = conexao.prepareStatement(statement);
		ResultSet rs = stmt.executeQuery();

		QueryResult = new LinkedList<String>();

		switch (tabela) {
		case Medico.TABELA_MEDICOS:
			while (rs.next()) {
				Medico med = new Medico(rs.getString(Medico.campos[0]), rs.getString(Medico.campos[1]),
						rs.getString(Medico.campos[2]), rs.getInt(Medico.campos[3]), rs.getDate(Medico.campos[4]),
						rs.getString(Medico.campos[5]), rs.getString(Medico.campos[6]), rs.getString(Medico.campos[7]),
						null);
				QueryResult.add(med.toString());
			}
			break;
		case Paciente.TABELA_PACIENTES:
			while (rs.next()) {
				Paciente pac = new Paciente(rs.getString(Paciente.campos[0]), rs.getString(Paciente.campos[1]),
						rs.getString(Paciente.campos[2]), rs.getDate(Paciente.campos[3]),
						rs.getString(Paciente.campos[4]), rs.getString(Paciente.campos[5]),
						rs.getString(Paciente.campos[6]));
				QueryResult.add(pac.toString());
			}
			break;
		case Consulta.TABELA_CONSULTAS:
			while (rs.next()) {
				Consulta con = new Consulta(rs.getString(Consulta.campos[0]), rs.getString(Consulta.campos[1]),
						rs.getString(Consulta.campos[2]), rs.getDate(Consulta.campos[3]),
						rs.getInt(Consulta.campos[4]));
				QueryResult.add(con.toString());
			}
			break;
		case TABELA_ESPECIALIZACAO:
			while (rs.next()) {
				String esp = "" + rs.getString("especialidade") + "#" + rs.getString("nome");
				QueryResult.add(esp);
			}
			break;
		}
		fecharBanco();
		return QueryResult;
	}
}
