/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ErrorHandling;

import javax.swing.JOptionPane;

/**
 *
 * @author adrian
 */
public class AccountException extends Exception {

    String fieldname;

    public AccountException() {

    }

    public AccountException(String fieldname) {
        this.fieldname = fieldname;
    }

    public AccountException(String fieldname, String value) {
        System.out.println(value);
        this.fieldname = fieldname;
    }

    public void promptFieldError() {
        JOptionPane.showMessageDialog(null, "Invalid input in " + fieldname + " field.", "Error Input", JOptionPane.ERROR_MESSAGE);
    }

}
