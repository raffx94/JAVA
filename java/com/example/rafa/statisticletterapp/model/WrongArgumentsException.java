package com.example.rafa.statisticletterapp.model;

/**
 * Created by Rafał on 18.01.2018.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rafał
 * @version 1.0
 */
public class WrongArgumentsException extends Throwable {

    /**
     * Creates a new instance of <code>NewException</code> without detail
     * message.
     */
    public WrongArgumentsException() {


    }

    /**
     * Constructs an instance of <code>NewException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public WrongArgumentsException(String msg) {
        super(msg);
    }
}
