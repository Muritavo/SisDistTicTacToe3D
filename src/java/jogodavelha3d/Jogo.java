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
    private Player player1;
    private Player player2;
    
    private Ponto[][][] ambienteJogo = new Ponto[3][3][3];

    public boolean playerVenceu(Ponto pontoJogada) {
        int xAux = (int) (pontoJogada.getX() - 1);
        int yAux = (int) (pontoJogada.getY() - 1);
        int zAux = (int) (pontoJogada.getZ() - 1);

        //Itera sobre o X
        while (xAux <= pontoJogada.getX() + 1) {
            //Itera sobre o Y
            while (yAux <= pontoJogada.getY() + 1) {
                //Itera sobre o Z
                while (zAux <= pontoJogada.getZ() + 1) {
                    Ponto pontoVizinho = getPointAt(xAux, yAux, zAux);
                    if (pontoVizinho == pontoJogada) {
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
                }
            }
        }
        return false;
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

        return getPointAt(xDiff, yDiff, zDiff);
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
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }
}
