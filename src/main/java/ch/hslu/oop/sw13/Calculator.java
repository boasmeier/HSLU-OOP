/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw13;

/**
 * Class for simple Calculations.
 *
 * @author boasm
 */
public class Calculator implements Calculate {

    /**
     *
     */
    public Calculator() {

    }

    /**
     *
     * @param x
     * @param y
     * @return
     */
    @Override
    public long addition(int x, int y) {
        return (long) x + y;
    }
}
