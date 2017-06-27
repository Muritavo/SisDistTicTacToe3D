/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha3d;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Murilo
 */
public class JogoTest {
    static Player p1;
    static Player p2;
    static Jogo jogo;
    
    public JogoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        p1 = new Player(101, "Roland");
        p2 = new Player(102, "Murilo");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jogo = new Jogo();
        jogo.setPlayer1(p1);
        jogo.setPlayer2(p2);
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void TesteSeOsPlayersForamInseridosComSucesso() {
        assertNotNull("Player inserido no jogo", jogo.getPlayer1());
        assertNotNull("Player2 inserido no jogo", jogo.getPlayer2());
    }
    
    @Test
    public void TesteSeOPlayer1Vence() throws Exception {
        Ponto x0y0z0 = new Ponto(0, 0, 0, 'x');
        Ponto x1y0z0 = new Ponto(1, 0, 0, 'x');
        Ponto x2y0z0 = new Ponto(2, 0, 0, 'x');
        Ponto x1y0z1 = new Ponto(1, 0, 1, 'o');
        Ponto x2y0z1 = new Ponto(2, 0, 1, 'o');
        jogo.setJogada(x0y0z0, p1);
        jogo.setJogada(x2y0z1, p2);
        jogo.setJogada(x2y0z0, p1);
        jogo.setJogada(x1y0z1, p2);
        jogo.setJogada(x1y0z0, p1);
        
        assertEquals(StatusJogo.PLAYER_1_VENCEU, jogo.statusJogo);
    }
    
    @Test
    public void TesteSeOPlayer2Vence() throws Exception {
        Ponto x0y0z0 = new Ponto(0, 0, 0, 'x');
        Ponto x1y0z0 = new Ponto(1, 0, 0, 'o');
        Ponto x2y0z0 = new Ponto(2, 0, 0, 'o');
        Ponto x1y1z0 = new Ponto(1, 1, 0, 'x');
        Ponto x2y2z0 = new Ponto(2, 2, 0, 'x');
        Ponto x1y0z1 = new Ponto(1, 0, 1, 'o');
        
        jogo.setJogada(x2y0z0, p1);
        jogo.setJogada(x0y0z0, p2);
        jogo.setJogada(x1y0z0, p1);
        jogo.setJogada(x1y1z0, p2);
        jogo.setJogada(x1y0z1, p1);
        jogo.setJogada(x2y2z0, p2);
        
        assertEquals(StatusJogo.PLAYER_2_VENCEU, jogo.statusJogo);
    }
    
    @Test (expected = Exception.class)
    public void TesteSePlayerNaoPodeJogar2Vezes() throws Exception {
        Ponto x1y1z0 = new Ponto(1, 1, 0, 'x');
        Ponto x2y2z0 = new Ponto(2, 2, 0, 'x');
        jogo.setJogada(x1y1z0, p2);
        jogo.setJogada(x2y2z0, p2);
    }
    
    @Test
    public void TesteSeOPlayer1VenceWO() throws Exception {
        jogo.setPlayer1(null);
        
        assertEquals(StatusJogo.PLAYER_2_VENCEU_WO, jogo.statusJogo);
    }
    
    @Test
    public void TesteSeOPlayer2VenceWO() throws Exception {        
        jogo.setPlayer2(null);
        
        assertEquals(StatusJogo.PLAYER_1_VENCEU_WO, jogo.statusJogo);
    }
}
