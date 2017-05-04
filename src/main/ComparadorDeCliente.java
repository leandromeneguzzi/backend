/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.util.Comparator;
import model.bean.Cliente;

/**
 *
 * @author Leandro
 */
public class ComparadorDeCliente implements Comparator<Cliente> {

    @Override
    public int compare(Cliente c1, Cliente c2) {
        if (c1.getSaldo() == c2.getSaldo()) {
            return 0;
        }
        if (c1.getSaldo() > c2.getSaldo()) {
            return 1;
        } else {
            return -1;
        }
    }
}
