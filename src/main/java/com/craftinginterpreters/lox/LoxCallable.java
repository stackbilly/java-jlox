package com.craftinginterpreters.lox;

import java.util.List;

//execute callable entity
interface LoxCallable {
  int arity();
  Object call(Interpreter interpreter, List<Object> arguments);
}
