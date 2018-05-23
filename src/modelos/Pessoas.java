package modelos;
import java.sql.Date;

public abstract class Pessoas {

	private String nome;
	private String sexo;
	private String cpf;
	private Date data;
	private String telefone;
	private String email;
	private String endereco;

	public Pessoas(String nome, String sexo, String cpf, Date data, String telefone, String email, String endereco) {
		this.nome = nome;
		this.sexo = sexo;
		this.cpf = cpf;
		this.data = data;
		this.telefone = telefone;
		this.email = email;
		this.endereco = endereco;
	}

	public String createQueryInsertPessoa() {
		return "INSERT INTO PESSOAS (nome, sexo, CPF, telefone, dataNasc, email, endereco, IDPESSOA) "
				+ "VALUES ('" + nome + "', '" + sexo + "', '" + cpf + "', '" + telefone + "', DATE '" + data + "','"
				+ email + "', '" + endereco + "', SEQ_IDPESSOAS.NEXTVAL)";
	}

	public String getNome() {
		return nome;
	}

	public String getSexo() {
		return sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public Date getData() {
		return data;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getEmail() {
		return email;
	}

	public String getEndereco() {
		return endereco;
	}
}

// INSERT INTO PESSOAS (nome, sexo, CPF, telefone, dataNasc, email, endereco,
// IDPESSOA)
// VALUES ('Violeta', 'F', '5527854', '44515547', DATE '1999-05-14',
// 'violeta@incrivel.com', 'Av. dos Incriveis, 999', SEQ_IDPESSOAS.NEXTVAL);

//
// INSERT INTO ESPECIALIDADES (idEspec, nome) VALUES (seq_idespec.nextval,
// 'Neurologia');
//
//
// INSERT INTO MEDICOS(idMedico, crm, idEspec, idPessoa) VALUES
// (SEQ_IDMEDICOS.NEXTVAL, '3250',2 , SEQ_IDPESSOAS.currval);
//
//
// INSERT INTO PACIENTES(idPaciente, idPessoa) VALUES (SEQ_IDPACIENTES.NEXTVAL,
// SEQ_IDPESSOAS.currval);
//
//
// INSERT INTO CONSULTAS(idConsulta, idMedico, idPaciente, data) VALUES
// (SEQ_IDCONSULTA.NEXTVAL, 1, 2, sysdate);