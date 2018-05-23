package modelos;
import java.sql.Date;

public class Paciente extends Pessoas {

	public static final String TABELA_PACIENTES = "RESUMO_PACIENTES";
	public static String campos[] = { "nome", "sexo", "cpf", "data_de_nascimento", "telefone", "email", "endereco" };

	public Paciente(String nome, String sexo, String cpf, Date data, String telefone, String email, String endereco) {
		super(nome, sexo, cpf, data, telefone, email, endereco);
	}

	@Override
	public String toString() {
		return getNome() + "#" + getSexo() + "#" + getCpf() + "#" + getData() + "#" + getTelefone() + "#" + getEmail() + "#" + getEndereco();
	}

	public String createQueryInsertPaciente() {
		return "INSERT INTO PACIENTES(idPaciente, idPessoa) VALUES (SEQ_IDPACIENTES.NEXTVAL," + 
				"SEQ_IDPESSOAS.currval)";

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