package modelos;
import java.sql.Date;

public class Medico extends Pessoas {

	public static final String TABELA_MEDICOS = "RESUMO_MEDICOS";	

	private String especialidade;
	private int crm;


	public static String campos[] = { "nome", "sexo", "especialidade", "crm", "data_de_nascimento", "telefone", "email",
	"endereco" };

	public Medico(String nome, String sexo, String especialidade, int crm, Date data, String numerotel, String email,
			String endereco, String cpf) {
		super(nome, sexo, cpf, data, numerotel, email, endereco);
		this.especialidade = especialidade;
		this.crm = crm;
	}

	public String createQueryInsertMedico() {
		return "INSERT INTO MEDICOS(idMedico, crm, idEspec, idPessoa) VALUES" 
				+ "(SEQ_IDMEDICOS.NEXTVAL, '" + crm + "',(SELECT idEspec FROM especialidades WHERE nome='"+especialidade+"'), SEQ_IDPESSOAS.currval)";
	}

	@Override
	public String toString() {
		return getNome() + "#" + getSexo() + "#" + especialidade + "#" + crm + "#" + getData() + "#" + getTelefone() + "#" + getEmail() + "#"
				+ getEndereco();
	}
}
