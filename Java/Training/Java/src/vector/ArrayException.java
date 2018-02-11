/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vector;

/**
 *
 * @author Saia
 */
class ArrayException extends Exception {
    String text;

    ArrayException(String text) {
        super(text);
        this.text = text;
    }
    
    public String getMessage() {
        return text;
    }
    
}
