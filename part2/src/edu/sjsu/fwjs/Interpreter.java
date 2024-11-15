package edu.sjsu.fwjs;

public class Interpreter {

    public static void main(String[] args) throws Exception {
        Expression prog = new BinOpExpr(Op.ADD,
                new ValueExpr(new IntVal(3)),
                new ValueExpr(new IntVal(4)));
        System.out.println("'3 + 4;' evaluates to " + prog.evaluate(new Environment()));

        // Test assignment
        Expression valueExpr = new ValueExpr(new IntVal(12));
        AssignExpr x = new AssignExpr("x", valueExpr);
        Value result = x.evaluate(new Environment());
        System.out.println("Result of x: " + result);  // Result of x: 12
    }
}
