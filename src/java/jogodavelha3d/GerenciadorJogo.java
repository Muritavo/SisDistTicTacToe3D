/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha3d;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author murit
 */
public class GerenciadorJogo {
    private int limiteJogos;
    private int limiteJogadores;
    
    private List<Jogo> jogosEmAndamento = new ArrayList<>();
    private List<Jogo> jogosAbertos = new ArrayList<>();
    private Map<Integer, Player> jogadoresPorID = new HashMap<>();
    private Map<String, Player> jogadoresPorNome = new HashMap<>();
    private Map<String, Player> jogadoresPreRegistro = new HashMap<>();
    
    public GerenciadorJogo(int i) {
        this.limiteJogos = i; 
        this.limiteJogadores = i * 2;
    }
    
    public int preRegistro(String nomeJogador1, int idJogador1, String nomeJogador2, int idJogador2) {
        Player jogador1 = new Player(idJogador1, nomeJogador1);
        Player jogador2 = new Player(idJogador2, nomeJogador2);
        
        jogadoresPreRegistro.put(nomeJogador1, jogador1);
        jogadoresPreRegistro.put(nomeJogador2, jogador2);
        
        addJogador(jogador1);
        addJogador(jogador2);
        
        return 0;
    }

    public int registraJogador(String nomeJogador) {
        if (jogadoresPreRegistro.containsKey(nomeJogador)){
            return jogadoresPreRegistro.get(nomeJogador).getID();
        }
        if (jogadoresPorNome.containsKey(nomeJogador)) {
            return -1;
        }
        if (jogadoresPorID.size() >= limiteJogadores) {
            return -2;
        }
        Player newJogador = new Player(nomeJogador);
        addJogador(newJogador);
        return newJogador.getID();
    }
    
    private void addJogador (Player newJogador) {
        jogadoresPorID.put(newJogador.getID(), newJogador);
        jogadoresPorNome.put(newJogador.getNome(), newJogador);
        Jogo j = getJogo();
        //Se veio um jogo
        if (j != null) {
            //Se o jogo tem vaga livre
            if (j.partidaLivre() != 0) {
                //Define o jogo do jogador
                newJogador.jogo = j;
                //Se a partida tem vaga de p1
                if (j.partidaLivre() == 1) {
                    //Seta o p1
                    j.setPlayer1(newJogador);
                } else {
                    //Seta o p2
                    j.setPlayer2(newJogador);
                }
                //Se ocupou todas as vagas
                if (j.partidaLivre() == 0) {
                    //Remove dos jogos abertos
                    jogosAbertos.remove(j);
                    //Coloca nos jogos em andamento
                    jogosEmAndamento.add(j);
                }
            }
        }
    }

    public int encerraPartida(int idJogador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int temPartida(int idJogador) {
       Player p = jogadoresPorID.get(idJogador);
       if (p == null) {
           return -1;
       }
       if (p.jogo == null) {
           return 0;
       } else {
           if (p.jogo.getPlayer1() == p) {
               return 1;
           } else {
               return 2;
           }
       }
    }

    public int ehMinhaVez(int idJogador) {
       Player p = jogadoresPorID.get(idJogador);
       if (p == null || p.jogo == null) {
           return -1;
       }
       switch (p.jogo.statusJogo) {
           case EM_ABERTO:
               return -2;
           case EM_JOGO:
               return (p.jogo.nextToPlay == p) ? 1 : 0;
           case PLAYER_1_VENCEU:
               return (p.jogo.getPlayer1() == p) ? 2 : 3;
           case PLAYER_1_VENCEU_WO:
               return (p.jogo.getPlayer1() == p) ? 5 : 6;
           case PLAYER_2_VENCEU:
               return (p.jogo.getPlayer2() == p) ? 2 : 3;
           case PLAYER_2_VENCEU_WO:
               return (p.jogo.getPlayer2() == p) ? 5 : 6;
            default:
                return 4;
       }
    }

    public String obtemTabuleiro(int idJogador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public int realizaJogada(int idJogador, int nivel, int linha, int coluna) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String obtemOponente(int idJogador) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private Jogo getJogo() {
        if (jogosAbertos.size() > 0) {
            return jogosAbertos.get(0);
        }
        if (jogosAbertos.size() + jogosEmAndamento.size() < limiteJogos) {
            Jogo j = new Jogo();
            jogosAbertos.add(j);
            return j;
        } else {
            return null;
        }
    }
}
