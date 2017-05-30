/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jogodavelha3d;

import javafx.geometry.Point3D;

/**
 *
 * @author Murilo
 */
public class Ponto extends Point3D {
    private char simbolo;
    
    public Ponto(double d, double d1, double d2, char simbolo) {
        super(d, d1, d2);
        this.simbolo = simbolo;
    }
    
    public char getSimbolo() {
        return this.simbolo;
    }
}
