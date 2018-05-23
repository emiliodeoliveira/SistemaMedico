package modelos;
import java.sql.Date;

public class Consulta {
	
	public static final String TABELA_CONSULTAS = "RESUMO_CONSULTAS";
	
	private String medico;
	private String especialidade;
	private String paciente;
	private Date data;
	private int crm;
	public static String campos[] = {"medico", "especialidade", "paciente", "data", "crm"};
	
	
	public Consulta(String medico, String especialidade, String paciente, Date data, int crm) {
		this.medico = medico;
		this.especialidade = especialidade;
		this.paciente = paciente;
		this.data = data;
		this.crm = crm;
	}


	@Override
	public String toString() {
		return medico + "#" + especialidade + "#" + paciente + "#"
				+ data + "#" + crm;
	}
}
