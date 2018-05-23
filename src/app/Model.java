package app;

import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Model extends RecursiveTreeObject<Model> {


    StringProperty data;
    StringProperty paciente;
    StringProperty medico;
    StringProperty especialidade;

    public Model(String data ,String paciente ,String medico ,String especialidade){

        this.data=new SimpleStringProperty(data);
        this.paciente=new SimpleStringProperty(paciente);
        this.medico=new SimpleStringProperty(medico);
        this.especialidade=new SimpleStringProperty(especialidade);
    }

    public String getData() {
        return data.get();
    }

    public StringProperty dataProperty() {
        return data;
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public String getPaciente() {
        return paciente.get();
    }

    public StringProperty pacienteProperty() {
        return paciente;
    }

    public void setPaciente(String paciente) {
        this.paciente.set(paciente);
    }

    public String getMedico() {
        return medico.get();
    }

    public StringProperty medicoProperty() {
        return medico;
    }

    public void setMedico(String medico) {
        this.medico.set(medico);
    }

    public String getEspecialidade() {
        return especialidade.get();
    }

    public StringProperty especialidadeProperty() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade.set(especialidade);
    }
}
