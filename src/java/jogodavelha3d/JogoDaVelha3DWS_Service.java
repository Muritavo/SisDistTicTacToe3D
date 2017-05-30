/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha3d;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Murilo
 */
@WebService(serviceName = "JogoDaVelha3DWS_Service")
public class JogoDaVelha3DWS_Service {
    List<Jogo> jogosEmAberto;
    List<Jogo> jogosOcupados;
    List<Player> jogadores;
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "preRegistro")
    public int preRegistro(@WebParam(name = "nomeJogador1") String nomeJogador1, @WebParam(name = "idJogador1") String idJogador1, @WebParam(name = "nomeJogador2") String nomeJogador2, @WebParam(name = "idJogador2") String idJogador2) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registraJogador")
    public int registraJogador(@WebParam(name = "nomeJogador") String nomeJogador) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encerraPartida")
    public int encerraPartida(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "temPartida")
    public int temPartida(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ehMinhaVez")
    public int ehMinhaVez(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemTabuleiro")
    public String obtemTabuleiro(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "realizaJogada")
    public int realizaJogada(@WebParam(name = "idJogador") int idJogador, @WebParam(name = "nivel") int nivel, @WebParam(name = "linha") int linha, @WebParam(name = "coluna") int coluna) {
        //TODO write your implementation code here:
        return 0;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemOponente")
    public String obtemOponente(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return null;
    }
}
