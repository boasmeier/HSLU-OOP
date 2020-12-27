/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

/**
 *
 * @author boasm
 */
public enum AggregatStates {
    SOLID("solid"),
    LIQUID("liquid"),
    GAS("gas");

    private final String state;

    AggregatStates(String State) {
        this.state = State;
    }

    public String getState() {
        return state;
    }
}
