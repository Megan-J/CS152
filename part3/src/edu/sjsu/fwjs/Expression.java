package edu.sjsu.fwjs;

import java.util.ArrayList;
import java.util.List;

/**
 * FWJS expressions.
 */
public interface Expression {
    /**
     * Evaluate the expression in the context of the specified environment.
     */
    public Value evaluate(Environment env);
}

// NOTE: Using package access so that all implementations of Expression
// can be included in the same file.

/**
 * FWJS constants.
 */
class ValueExpr implements Expression {
    private Value val;
    public ValueExpr(Value v) {
        this.val = v;
    }
    public Value evaluate(Environment env) {
        return this.val;
    }
}

/**
 * Expressions that are a FWJS variable.
 */
class VarExpr implements Expression {
    private String varName;
    public VarExpr(String varName) {
        this.varName = varName;
    }
    public Value evaluate(Environment env) {
        return env.resolveVar(varName);
    }
}

/**
 * A print expression.
 */
class PrintExpr implements Expression {
    private Expression exp;
    public PrintExpr(Expression exp) {
        this.exp = exp;
    }
    public Value evaluate(Environment env) {
        Value v = exp.evaluate(env);
        System.out.println(v.toString());
        return v;
    }
}
/**
 * Binary operators (+, -, *, etc).
 * Currently only numbers are supported.
 */
class BinOpExpr implements Expression {
    private Op op;
    private Expression e1;
    private Expression e2;
    public BinOpExpr(Op op, Expression e1, Expression e2) {
        this.op = op;
        this.e1 = e1;
        this.e2 = e2;
    }

    @SuppressWarnings("incomplete-switch")
    public Value evaluate(Environment env) {
        Value v1 = e1.evaluate(env);
        Value v2 = e2.evaluate(env);

        int val1 = Integer.parseInt(v1.toString());
        int val2 = Integer.parseInt(v2.toString());
        Value v = new NullVal();

        switch(op) {
            case ADD:
                v = new IntVal(val1+val2);
                break;
            case SUBTRACT:
                v = new IntVal(val1-val2);
                break;
            case MULTIPLY:
                v = new IntVal(val1*val2);
                break;
            case DIVIDE:
                v = new IntVal(val1/val2);
                break;
            case MOD:
                v = new IntVal(val1%val2);
                break;
            case GT:
                v = new BoolVal(val1>val2);
                break;
            case GE:
                v = new BoolVal(val1>=val2);
                break;
            case LT:
                v = new BoolVal(val1<val2);
                break;
            case LE:
                v = new BoolVal(val1<=val2);
                break;
            case EQ:
                v = new BoolVal(val1==val2);
                break;
        }

        return v;
    }
}

/**
 * If-then-else expressions.
 * Unlike JS, if expressions return a value.
 */
class IfExpr implements Expression {
    private Expression cond;
    private Expression thn;
    private Expression els;
    public IfExpr(Expression cond, Expression thn, Expression els) {
        this.cond = cond;
        this.thn = thn;
        this.els = els;
    }
    public Value evaluate(Environment env) {
        Value condition = cond.evaluate(env);

        // check if condition is boolean
        if(condition instanceof BoolVal) {

          // if condition is true, evaluate thn
          if(((BoolVal)condition).toBoolean()) {
            return thn.evaluate(env);
          } else if(els != null) {  // if condition is false, evaluate els
            return els.evaluate(env);
          } else {
            return new NullVal();
          }
        } else {
          throw new RuntimeException("Condition must evaluate to a boolean");
        }
    }
}

/**
 * While statements (treated as expressions in FWJS, unlike JS).
 */
class WhileExpr implements Expression {
    private Expression cond;
    private Expression body;
    public WhileExpr(Expression cond, Expression body) {
        this.cond = cond;
        this.body = body;
    }
    public Value evaluate(Environment env) {
      Value res = new NullVal();
      while (true) {
        Value condition = cond.evaluate(env);
        
        if(condition instanceof BoolVal) {
          
          // if condition is true, evaluate body
          if(((BoolVal)condition).toBoolean()) {
           res = body.evaluate(env);
          } else {  // otherwise, break out of while loop
            break;
          }
        } else {
          throw new RuntimeException("Condition must evaluate to a boolean");
        }
      }
      return res;
    }
}

/**
 * Sequence expressions (i.e. 2 back-to-back expressions).
 */
class SeqExpr implements Expression {
    private Expression e1;
    private Expression e2;
    public SeqExpr(Expression e1, Expression e2) {
        this.e1 = e1;
        this.e2 = e2;
    }
    public Value evaluate(Environment env) {
        // evaluate the first expression
         e1.evaluate(env);

        // evaluate the second expression
        // return the value of the second evaluated expression
        return e2.evaluate(env);
    }
}

/**
 * Declaring a variable in the local scope.
 */
class VarDeclExpr implements Expression {
    private String varName;
    private Expression exp;
    public VarDeclExpr(String varName, Expression exp) {
        this.varName = varName;
        this.exp = exp;
    }
    public Value evaluate(Environment env) {
        Value value = exp.evaluate(env);
        env.createVar(varName, value);

        return value;
    }
}

/**
 * Updating an existing variable.
 * If the variable is not set already, it is added
 * to the global scope.
 */
class AssignExpr implements Expression {
    private String varName;
    private Expression e;
    public AssignExpr(String varName, Expression e) {
        this.varName = varName;
        this.e = e;
    }
    public Value evaluate(Environment env) {
        Value expRes = e.evaluate(env);
        
        // update existing var
        if (env.resolveVar(varName) != null) {
          env.updateVar(varName, expRes);
        } else {  // add to global scope if var is not set
          env.createVar(varName, expRes);
        }
        return expRes;
    }
}

/**
 * A function declaration, which evaluates to a closure.
 */
class FunctionDeclExpr implements Expression {
    private List<String> params;
    private Expression body;
    public FunctionDeclExpr(List<String> params, Expression body) {
        this.params = params;
        this.body = body;
    }
    public Value evaluate(Environment env) {
      // Return a closure with params, body, and environment
      return new ClosureVal(params, body, env);
    }
}

/**
 * Function application.
 */
class FunctionAppExpr implements Expression {
    private Expression f;
    private List<Expression> args;
    public FunctionAppExpr(Expression f, List<Expression> args) {
        this.f = f;
        this.args = args;
    }
    public Value evaluate(Environment env) {
        // evaluating the expression
        Value v = this.f.evaluate(env);

        // evaluating the other expressions
        List<Value> evaluatedArgs = new ArrayList<>();
        for(Expression exp : args){
            evaluatedArgs.add(exp.evaluate(env));
        }

        ClosureVal closure = (ClosureVal) v;

        return closure.apply(evaluatedArgs);
    }
}

