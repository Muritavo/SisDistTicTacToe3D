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
public class Player {
    private int ID;
    private String nome;

    public Player(int ID, String nome) {
        this.ID = ID;
        this.nome = nome;
    }

    public Player(String nome) {
        this.nome = nome;
        this.ID = IDGenerator.getNewId();
    }
    
    public int getID() {
        return ID;
    }

    public String getNome() {
        return nome;
    }    
}

class IDGenerator {
    private static int curID = 0;
    
    public static int getNewId() {
        curID = curID + 1;
        return curID;
    }
}