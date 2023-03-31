package model;

import etu2063.framework.annot.*;
/**
 *
 * @author Dragon
 */
public class Emp {
    @Url(url="emp-insert")
    public String insert(){
         return "insertion";
             }
}
