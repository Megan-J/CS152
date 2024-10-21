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

        String operation = op.toString();


        int val1 = Integer.parseInt(v1.toString());
        int val2 = Integer.parseInt(v2.toString());

        if(operation.equals("ADD")){
            int sum = val1+val2;
            return new IntVal(sum);
        }
        else if(operation.equals("SUBTRACT")){
            int diff = val1-val2;
            return new IntVal(diff);
        }
        else if(operation.equals("MULTIPLY")){
            int product = val1*val2;
            return new IntVal(product);
        }
        else if(operation.equals("DIVIDE")){
            int div = val1/val2;
            return new IntVal(div);
        }
        else if(operation.equals("MOD")){
            int mod = val1%val2;
            return new IntVal(mod);
        }
        else if(operation.equals("GT")){
            boolean gt = val1>val2;
            return new BoolVal(gt);
        }
        else if(operation.equals("GE")){
            boolean ge = val1>=val2;
            return new BoolVal(ge);
        }
        else if(operation.equals("LT")){
            boolean lt = val1<val2;
            return new BoolVal(lt);
        }
        else if(operation.equals("LE")){
            boolean le = val1<=val2;
            return new BoolVal(le);
        }
        else if(operation.equals("EQ")){
            boolean eq = val1==val2;
            return new BoolVal(eq);
        }

        return null;
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
        // YOUR CODE HERE
        return null;
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
        // YOUR CODE HERE
        return null;
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
        // TODO: waiting on assign expression to be completed

        Value v1 = e1.evaluate(env);
        Value v2 = e2.evaluate(env);

        System.out.println(v1);
        System.out.println(v2);

        return null;
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
        // TODO: Waiting on seq expression to be completed
        return null;
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
        // YOUR CODE HERE
        return null;
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
        // evaulating the first expression
        Value v1 = f.evaluate(env);

        // evaluating the other expressions
        List<Value> evaluatedArgs = new ArrayList<>();
        for(Expression x : args){
            evaluatedArgs.add(x.evaluate(env));
        }

        // TODO: the rest of creating function app


        return null;
    }
}
