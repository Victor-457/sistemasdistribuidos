package faculdade.sistemasDistribuidos.trabalho1.jpa;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;


@Entity
public class Nota {
	
	@EmbeddedId
	private NotaId codigoDisciplinaMatriculaAluno;
	@Column(name = "valor", nullable = false)
	private BigDecimal nota;
	
	public Nota(){
		
	}
	public Nota(NotaId notaId){
		this.setCodigoDisciplinaMatriculaAluno(notaId);
	}
	public NotaId getCodigoDisciplinaMatriculaAluno() {
		return codigoDisciplinaMatriculaAluno;
	}
	public void setCodigoDisciplinaMatriculaAluno(NotaId codigoDisciplinaMatriculaAluno) {
		if(codigoDisciplinaMatriculaAluno != null){
			this.codigoDisciplinaMatriculaAluno = codigoDisciplinaMatriculaAluno;
		}
		
	}

	public String getMatriculaAluno() {
		return codigoDisciplinaMatriculaAluno.getMatriculaAluno();
	}
	
	public String getCodigoDisciplina() {
		return codigoDisciplinaMatriculaAluno.getCodigoDisciplina();
	}

	
	public BigDecimal getNota() {
		return nota;
	}
	public void setNota(BigDecimal nota) {
		if(nota.intValue() >=0 || nota.intValue() <= 10){
			this.nota = nota;
		}else{
			throw new IllegalArgumentException("Nota invalida, deve estar no intervalo [0-10]");
		}
		
	}
}
