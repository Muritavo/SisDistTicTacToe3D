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
 * @author murit
 */
public class GerenciadorJogoTest {
    private GerenciadorJogo jogo;
    private static String p1;
    private static String p2;
    
    public GerenciadorJogoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        p1 = "Murilo";
        p2 = "Gustavo";
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        jogo = new GerenciadorJogo(500);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void TestPreRegistro() {
        assertEquals(0, jogo.preRegistro("Murilo", 666, "Gustavo", 999));
        assertEquals(666, jogo.registraJogador("Murilo"));
        assertEquals(999, jogo.registraJogador("Gustavo"));
    }
    
    @Test
    public void TestSemJogadorDuplo() {
        jogo.registraJogador("Murilo");
        assertEquals(-1, jogo.registraJogador("Murilo"));
    }
    
    @Test
    public void TestLimiteJogadoresAlcancado() {
        for (int i = 0; i < 1000; i++) {
            jogo.registraJogador(String.valueOf(i));
        }
        assertEquals(-2, jogo.registraJogador("Murilo"));
    }
    
    @Test
    public void TestTemPartida() {
        int p1ID = jogo.registraJogador(p1);
        assertEquals(1, jogo.temPartida(p1ID));
        int p2ID = jogo.registraJogador(p2);
        assertEquals(2, jogo.temPartida(p2ID));
    }
    
    @Test
    public void TesEhMinhaVez() {
        int p1ID = jogo.registraJogador(p1);
        assertEquals(-2, jogo.ehMinhaVez(p1ID));//Ainda não há 2 jogadores
        assertEquals(-1, jogo.ehMinhaVez(-26317)); //Erro por id invalido
        int p2ID = jogo.registraJogador(p2);
        assertEquals(0, jogo.ehMinhaVez(p2ID)); //Nao e a vez do P2
        assertEquals(1, jogo.ehMinhaVez(p1ID)); //Eh a vez de P1
    }
}
