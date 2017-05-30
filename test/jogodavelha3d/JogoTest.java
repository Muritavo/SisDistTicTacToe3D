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
        jogo = new Jogo();
        p1 = new Player(101, "Roland");
        p2 = new Player(102, "Murilo");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
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
        jogo.setPlayer1(p1);
        jogo.setPlayer2(p2);
        assertNotNull("Player inserido no jogo", jogo.getPlayer1());
        assertNotNull("Player2 inserido no jogo", jogo.getPlayer2());
    }
}
