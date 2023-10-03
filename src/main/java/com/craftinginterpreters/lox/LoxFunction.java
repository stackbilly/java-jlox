package com.craftinginterpreters.lox;

import java.util.List;

//implements LoxCallable interface for regular func
class LoxFunction implements LoxCallable {
  private final Stmt.Function declaration;
  private final Environment closure;

  LoxFunction(Stmt.Function declaration, Environment closure) {
    this.closure = closure;
    this.declaration = declaration;
  }
  @Override
  public String toString() {
    return "<fn " + declaration.name.lexeme + ">";
  }
  @Override
  public int arity() {
    return declaration.params.size();
  }
  @Override
  public Object call(Interpreter interpreter,
                     List<Object> arguments) {
    Environment environment = new Environment(closure);
    for (int i = 0; i < declaration.params.size(); i++) {
      environment.define(declaration.params.get(i).lexeme,
          arguments.get(i));
    }

    try {
      interpreter.executeBlock(declaration.body, environment);
    } catch (Return returnValue) {
      return returnValue.value;
    }
    return null;
  }
}

class LoxLambda implements LoxCallable{

  private final Stmt.Lambda declaration;
  private final Environment closure;

  LoxLambda(Stmt.Lambda declaration, Environment closure){
    this.closure = closure;
    this.declaration = declaration;
  }
  @Override
  public int arity() {
    return declaration.parameters.size();
  }

  @Override
  public String toString(){
    return "<lambda>";
  }

  @Override
  public Object call(Interpreter interpreter, List<Object> arguments) {
    Environment environment = new Environment(closure);
    for (int i = 0; i < declaration.parameters.size(); i++){
      environment.define(declaration.parameters.get(i).lexeme, arguments.get(i));
    }
    try {
      interpreter.executeBlock(declaration.body, environment);
    }catch (Return returnValue){
      return returnValue.value;
    }
    return null;
  }
}