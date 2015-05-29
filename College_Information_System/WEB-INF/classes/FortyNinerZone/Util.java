/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FortyNinerZone;

/**
 *
 * @author priyanka
 */
public class Util {
    
     /*
     Validates order quantity
     Must be positive integer
     */

    public static boolean IsValidOrderQty(String str) {
        if (str == null || str.isEmpty()) {
            return true;
        }
        try {
            int q = Integer.parseInt(str);
            if (q < 0) {
                return false;
            }
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;
    }
}

    

