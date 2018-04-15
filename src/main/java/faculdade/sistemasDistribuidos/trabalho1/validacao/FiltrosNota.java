package faculdade.sistemasDistribuidos.trabalho1.validacao;

public class FiltrosNota {
	
	public static String filtroMatriculaAluno() {
		return "\\d{9}-\\d";
	}
	
	public static String  filtroCodigodisciplina() {
		return "^[A-Z]{2}\\d{3}";
	}
	

}
