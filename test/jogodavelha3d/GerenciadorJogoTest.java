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
    
    @Test
    public void TestObtemOponente() {
        int p1ID = jogo.registraJogador(p1);
        assertEquals("", jogo.obtemOponente(p1ID));
        int p2ID = jogo.registraJogador(p2);
        assertEquals("Gustavo", jogo.obtemOponente(p1ID));
        assertEquals("Murilo", jogo.obtemOponente(p2ID));
    }
    
    @Test
    public void TestRealizaJogada() {
        int p1ID = jogo.registraJogador(p1);
        assertEquals(-1, jogo.realizaJogada(-84123, 0, 1, 0)); //ID nao existe ERRO
        assertEquals(-2, jogo.realizaJogada(p1ID, 0, 1, 0)); //Não iniciou a partida
        int p2ID = jogo.registraJogador(p2);
        assertEquals(1, jogo.realizaJogada(p1ID, 0, 1, 0)); //Jogada válida
        assertEquals(-3, jogo.realizaJogada(p1ID, 0, 2, 0)); //Não pode jogar denovo
        assertEquals(0, jogo.realizaJogada(p2ID, 0, 1, 0)); //Casa já ocupada
    }
    
    @Test
    public void TestRealizaJogadaAteEmpate() {
        int p1ID = jogo.registraJogador(p1);
        int p2ID = jogo.registraJogador(p2);
        
        jogo.realizaJogada(p1ID, 0, 0, 0);
        jogo.realizaJogada(p2ID, 0, 0, 1);
        jogo.realizaJogada(p1ID, 0, 0, 2);
        jogo.realizaJogada(p2ID, 0, 1, 0);
        jogo.realizaJogada(p1ID, 0, 1, 1);
        jogo.realizaJogada(p2ID, 0, 1, 2);
        jogo.realizaJogada(p1ID, 0, 2, 0);
        jogo.realizaJogada(p2ID, 0, 2, 1);
        jogo.realizaJogada(p1ID, 0, 2, 2);
        
        jogo.realizaJogada(p2ID, 1, 0, 0);
        jogo.realizaJogada(p1ID, 1, 0, 1);
        jogo.realizaJogada(p2ID, 1, 0, 2);
        jogo.realizaJogada(p1ID, 1, 1, 0);
        jogo.realizaJogada(p2ID, 1, 1, 1);
        jogo.realizaJogada(p1ID, 1, 1, 2);
        jogo.realizaJogada(p2ID, 1, 2, 0);
        jogo.realizaJogada(p1ID, 1, 2, 1);
        jogo.realizaJogada(p2ID, 1, 2, 2);
        
        jogo.realizaJogada(p1ID, 2, 0, 0);
        jogo.realizaJogada(p2ID, 2, 0, 1);
        jogo.realizaJogada(p1ID, 2, 0, 2);
        jogo.realizaJogada(p2ID, 2, 1, 0);
        jogo.realizaJogada(p1ID, 2, 1, 1);
        jogo.realizaJogada(p2ID, 2, 1, 2);
        jogo.realizaJogada(p1ID, 2, 2, 0);
        jogo.realizaJogada(p2ID, 2, 2, 1);
        jogo.realizaJogada(p1ID, 2, 2, 2);
        
        assertEquals("xoxoxoxoxoxoxoxoxoxoxoxoxox", jogo.obtemTabuleiro(p1ID));
        assertEquals(4, jogo.ehMinhaVez(p1ID));
        assertEquals(4, jogo.ehMinhaVez(p2ID));
    }
    
    @Test
    public void TestObtemTabuleiro() {
        int p1ID = jogo.registraJogador(p1);
        int p2ID = jogo.registraJogador(p2);
        jogo.realizaJogada(p1ID, 0, 0, 0);
        jogo.realizaJogada(p2ID, 2, 2, 2);
        jogo.realizaJogada(p1ID, 1, 1, 0);
        jogo.realizaJogada(p2ID, 2, 2, 0);
        
        assertEquals("x...........x...........o.o", jogo.obtemTabuleiro(p1ID));
        assertEquals("x...........x...........o.o", jogo.obtemTabuleiro(p2ID));
    }
}
