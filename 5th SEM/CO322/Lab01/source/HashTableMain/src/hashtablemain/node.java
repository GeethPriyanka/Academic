/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Geeth
 */
class node {        //node is the entity which create the linked list and store vakues and keys
    String key;
    Integer value;
    node next = null;
    public node(String key, int value){
        this.key = key;
        this.value = value;
    }
   
}
