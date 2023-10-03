package com.craftinginterpreters.lox;

//break class
public class Break extends RuntimeException{
    Break(){
        super(null,null,false,false);
    }
}
