package faculdade.sistemasDistribuidos.trabalho1.jpa;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import faculdade.sistemasDistribuidos.trabalho1.validacao.FiltrosNota;

@Embeddable
public class NotaId implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	@Column(name = "codigo_disciplina", nullable = false)
    private String codigoDisciplina;
 
    @Column(name = "matricula_aluno", nullable = false)
    private String matriculaAluno;
 
    public NotaId(){
    	
    }
    public NotaId(String codigoDisciplina, String matriculaAluno) {
    	this.setCodigoDisciplina(codigoDisciplina);
    	this.setMatriculaAluno(matriculaAluno);
    }
 
    public String getMatriculaAluno() {
		return matriculaAluno;
	}
	
	public void setMatriculaAluno(String matriculaAluno) {
		if(matriculaAluno.matches(FiltrosNota.filtroMatriculaAluno())) {
			this.matriculaAluno = matriculaAluno;
		}else {
			throw new IllegalArgumentException("A matricula do aluno deve seguir o padrao ddddddddd-d, onde d é um digito 0-9");
		}
		
	}
	
	public String getCodigoDisciplina() {
		return codigoDisciplina;
	}
	
	public void setCodigoDisciplina(String codigoDisciplina) {
		if(codigoDisciplina.matches(FiltrosNota.filtroCodigodisciplina())) {
			this.codigoDisciplina = codigoDisciplina;
		}else {
			throw new IllegalArgumentException("A matricula do aluno deve seguir o padrao AAddd, onde A é uma letra de A-Z, maiuscula e d é um digito 0-9");
		}
	}
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotaId)) return false;
        NotaId that = (NotaId) o;
        return Objects.equals(getMatriculaAluno(), that.getMatriculaAluno())
        	   &&
               Objects.equals(getCodigoDisciplina(), that.getCodigoDisciplina());
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(getMatriculaAluno(), getCodigoDisciplina());
    }
}
