/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw10;

import java.util.Comparator;

/**
 *
 * @author boasm
 */
public class TemperaturVerlaufComparator implements Comparator<Temperatur> {

    /**
     *
     * @param temperatur0
     * @param temperatur1
     * @return
     */
    @Override
    public int compare(Temperatur temperatur0, Temperatur temperatur1) {
        return temperatur0.compareTo(temperatur1);
    }

}
