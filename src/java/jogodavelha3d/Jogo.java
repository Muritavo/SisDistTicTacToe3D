/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha3d;

/**
 *
 * @author Murilo
 */
public class Jogo {
    public StatusJogo statusJogo = StatusJogo.EM_ABERTO;
    private Player player1;
    private Player player2;
    public Player nextToPlay;

    private Ponto[][][] ambienteJogo = new Ponto[3][3][3];

    public void setJogada(Ponto pontoJogada, Player jogador) throws Exception {
        if (jogador == this.nextToPlay) {
            if (getPointAt((int) pontoJogada.getX(), (int) pontoJogada.getY(), (int) pontoJogada.getZ()) == null) {
                switchPlayer();
                ambienteJogo[(int) pontoJogada.getX()][(int) pontoJogada.getY()][(int) pontoJogada.getZ()] = pontoJogada;
                updateStatus(pontoJogada, jogador);
            } else {
                throw new Exception("Jogada não permitida");
            }
        } else {
            throw new Exception("Não é a vez do jogador");
        }
    }

    /**
     *
     * @param ponto1 O primeiro ponto
     * @param ponto2 O próximo ponto
     * @return O ponto na sequência dos pontos informados
     */
    public Ponto getNextPoint(Ponto ponto1, Ponto ponto2) {
        int xDiff = (int) (ponto2.getX() - ponto1.getX());
        int yDiff = (int) (ponto2.getY() - ponto1.getY());
        int zDiff = (int) (ponto2.getZ() - ponto1.getZ());

        return getPointAt(
                (int) (ponto2.getX() + xDiff),
                (int) (ponto2.getY() + yDiff),
                (int) (ponto2.getZ() + zDiff)
        );
    }

    public Ponto getPointAt(int x, int y, int z) {
        if (posicaoValida(x) && posicaoValida(y) && posicaoValida(z)) {
            return ambienteJogo[x][y][z];
        }
        return null;
    }

    public boolean posicaoValida(int posicao) {
        return (posicao >= 0 && posicao <= 2);
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
        this.nextToPlay = this.player1;
        if (statusJogo == StatusJogo.EM_JOGO && player1 == null) {
            statusJogo = StatusJogo.PLAYER_2_VENCEU_WO;
        }
        if (statusJogo == StatusJogo.EM_ABERTO && (this.player1 != null && this.player2 != null)) {
            statusJogo = StatusJogo.EM_JOGO;
        }
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
        if (statusJogo == StatusJogo.EM_JOGO && player2 == null) {
            statusJogo = StatusJogo.PLAYER_1_VENCEU_WO;
        }
        if (statusJogo == StatusJogo.EM_ABERTO && (this.player1 != null && this.player2 != null)) {
            statusJogo = StatusJogo.EM_JOGO;
        }
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    private void updateStatus(Ponto pontoJogada, Player jogador) {
        if (checkIfIsWinningPoint(pontoJogada)) {
            if (jogador == player1) {
                //Seta que O JOGADOR 1 VENCEU
                statusJogo = StatusJogo.PLAYER_1_VENCEU;
            } else {
                //SETA QUE o jogador 2 venceu
                statusJogo = StatusJogo.PLAYER_2_VENCEU;
            }
        } else {
            //Set que o jogo esta em andamento
            statusJogo = StatusJogo.EM_JOGO;
        }
    }

    private boolean checkIfIsWinningPoint(Ponto pontoJogada) {
        int xAux = (int) (pontoJogada.getX() - 1);
        int yAux = (int) (pontoJogada.getY() - 1);
        int zAux = (int) (pontoJogada.getZ() - 1);
        int xInicial = xAux;
        int yInicial = yAux;
        int zInicial = zAux;

        //Itera sobre o X
        while (xAux <= pontoJogada.getX() + 1) {
            //Itera sobre o Y
            while (yAux <= pontoJogada.getY() + 1) {
                //Itera sobre o Z
                while (zAux <= pontoJogada.getZ() + 1) {
                    Ponto pontoVizinho = getPointAt(xAux, yAux, zAux);
                    if (pontoVizinho == pontoJogada) {
                        zAux++;
                        continue;
                    }
                    if (pontoVizinho != null && pontoVizinho.getSimbolo() == pontoJogada.getSimbolo()) {
                        Ponto pontoAnterior = getNextPoint(pontoJogada, pontoVizinho);
                        if (pontoAnterior != null && pontoAnterior.getSimbolo() == pontoJogada.getSimbolo()) {
                            return true;
                        }

                        Ponto proximoPonto = getNextPoint(pontoVizinho, pontoJogada);
                        if (proximoPonto != null && proximoPonto.getSimbolo() == pontoJogada.getSimbolo()) {
                            return true;
                        }
                    }
                    zAux++;
                }
                zAux = zInicial;
                yAux++;
            }
            zAux = zInicial;
            yAux = yInicial;
            xAux++;
        }
        return false;
    }

    private void switchPlayer() {
        nextToPlay = (nextToPlay == player1) ? player2 : player1;
    }
    
    public int partidaLivre() {
        if (player1 == null) {
            return 1;
        }
        if (player2 == null) {
            return 2;
        }
        
        return 0;
    }
}
