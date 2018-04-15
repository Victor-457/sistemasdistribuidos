package faculdade.sistemasDistribuidos.trabalho1;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import faculdade.sistemasDistribuidos.trabalho1.jpa.Nota;
import faculdade.sistemasDistribuidos.trabalho1.jpa.NotaId;
import faculdade.sistemasDistribuidos.trabalho1.jpa.util.JPAUtil;
import faculdade.sistemasDistribuidos.trabalho1.jpa.util.Querys;

public class QueryTeste {
	public static void main(String[] args) {
		NotaId notaId = new NotaId("AA123","201578011-2");
		System.out.println(Querys.existeNotaDisciplina(notaId));
		System.out.println(Querys.existeNota("201578011-2"));
		List<BigDecimal> notas = Querys.listaNotas("201578011-2");
		BigDecimal soma = notas.stream().reduce((x, y) -> x.add(y)).get();
		System.out.println(soma.divide(new BigDecimal(notas.size())));
	}
}
