package faculdade.sistemasDistribuidos.trabalho1.rmi;

import java.math.BigDecimal;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RepositorioNotasInterface extends Remote {
	public void cadastrar_nota (String matriculaAluno, String codigoDisciplina, BigDecimal nota) throws RemoteException;
	public BigDecimal consultar_nota(String matriculaAluno,String codigoDisciplina) throws RemoteException;
	public List<BigDecimal> consultar_notas(String matriculaAluno) throws RemoteException;
	public BigDecimal consular_cr(String matriculaAluno) throws RemoteException;

}
