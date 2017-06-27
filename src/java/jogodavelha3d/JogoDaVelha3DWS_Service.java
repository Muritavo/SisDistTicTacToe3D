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
    private GerenciadorJogo gerenciador = new GerenciadorJogo(500);
    
    /**
     * Web service operation
     */
    @WebMethod(operationName = "preRegistro")
    public int preRegistro(@WebParam(name = "nomeJogador1") String nomeJogador1, @WebParam(name = "idJogador1") int idJogador1, @WebParam(name = "nomeJogador2") String nomeJogador2, @WebParam(name = "idJogador2") int idJogador2) {
        //TODO write your implementation code here:
        return gerenciador.preRegistro(nomeJogador1, idJogador1, nomeJogador2, idJogador2);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "registraJogador")
    public int registraJogador(@WebParam(name = "nomeJogador") String nomeJogador) {
        //TODO write your implementation code here:
        return gerenciador.registraJogador(nomeJogador);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "encerraPartida")
    public int encerraPartida(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return gerenciador.encerraPartida(idJogador);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "temPartida")
    public int temPartida(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return gerenciador.temPartida(idJogador);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "ehMinhaVez")
    public int ehMinhaVez(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return gerenciador.ehMinhaVez(idJogador);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemTabuleiro")
    public String obtemTabuleiro(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return gerenciador.obtemTabuleiro(idJogador);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "realizaJogada")
    public int realizaJogada(@WebParam(name = "idJogador") int idJogador, @WebParam(name = "nivel") int nivel, @WebParam(name = "linha") int linha, @WebParam(name = "coluna") int coluna) {
        //TODO write your implementation code here:
        return gerenciador.realizaJogada(idJogador, nivel, linha, coluna);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "obtemOponente")
    public String obtemOponente(@WebParam(name = "idJogador") int idJogador) {
        //TODO write your implementation code here:
        return gerenciador.obtemOponente(idJogador);
    }
}
