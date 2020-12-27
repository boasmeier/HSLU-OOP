/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ch.hslu.oop.sw08;

import java.util.Comparator;

/**
 *
 * @author boasm
 */
public class TemperaturVerlaufComparator implements Comparator<Temperatur> {

    @Override
    public int compare(Temperatur temperatur0, Temperatur temperatur1) {
        return temperatur0.compareTo(temperatur1);
    }

}
