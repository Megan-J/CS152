package edu.sjsu.fwjs;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.fwjs.parser.FeatherweightJavaScriptBaseVisitor;
import edu.sjsu.fwjs.parser.FeatherweightJavaScriptParser;

public class ExpressionBuilderVisitor extends FeatherweightJavaScriptBaseVisitor<Expression>{
    @Override
    public Expression visitProg(FeatherweightJavaScriptParser.ProgContext ctx) {
        List<Expression> stmts = new ArrayList<Expression>();
        for (int i=0; i<ctx.stat().size(); i++) {
            Expression exp = visit(ctx.stat(i));
            if (exp != null) stmts.add(exp);
        }
        return listToSeqExp(stmts);
    }
    @Override
    public Expression visitPrint(FeatherweightJavaScriptParser.PrintContext ctx) {
        Expression exp = visit(ctx.expr());
        return new PrintExpr(exp);
    }
    
    @Override
    public Expression visitVarDecl(FeatherweightJavaScriptParser.VarDeclContext ctx) {
        String varName = ctx.ID().getText();
        Expression exp = visit(ctx.expr());
        return new VarDeclExpr(varName, exp);
    }

    @Override
    public Expression visitFuncDecl(FeatherweightJavaScriptParser.FuncDeclContext ctx) {
        List<String> params = visitParams(ctx.params());
        Expression body = visit(ctx.block());
        return new FunctionDeclExpr(params, body);
    }

    @Override
    public Expression visitFuncApp(FeatherweightJavaScriptParser.FuncAppContext ctx) {
        Expression func = new VarExpr(ctx.ID().getText()); // Treat function name as variable reference
        List<Expression> args = visitArgs(ctx.args());
        return new FunctionAppExpr(func, args);
    }

    @Override
    public Expression visitBool(FeatherweightJavaScriptParser.BoolContext ctx) {
        boolean val = Boolean.parseBoolean(ctx.BOOL().getText());
        return new ValueExpr(new BoolVal(val));
    }
  
    @Override
    public Expression visitAddSub(FeatherweightJavaScriptParser.AddSubContext ctx) {
        Expression left = visit(ctx.expr(0));
        Expression right = visit(ctx.expr(1));
        Op op = ctx.op.getType() == FeatherweightJavaScriptParser.ADD ? Op.ADD : Op.SUBTRACT;
        return new BinOpExpr(op, left, right);
    }

    @Override
    public Expression visitMulDivMod(FeatherweightJavaScriptParser.MulDivModContext ctx) {
        Expression e1 = visit(ctx.expr(0));
        Expression e2 = visit(ctx.expr(1));
        Op op;
        if (ctx.op.getType() == FeatherweightJavaScriptParser.MUL) {
            op = Op.MULTIPLY;
        } else if (ctx.op.getType() == FeatherweightJavaScriptParser.DIV) {
            op = Op.DIVIDE;
        } else {
            op = Op.MOD;
        }
        return new BinOpExpr(op, e1, e2);
    }

    @Override
    public Expression visitEmptyStmt(FeatherweightJavaScriptParser.EmptyStmtContext ctx) {
        return new ValueExpr(new NullVal());
    }

    @Override
    public Expression visitBareExpr(FeatherweightJavaScriptParser.BareExprContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Expression visitIfThenElse(FeatherweightJavaScriptParser.IfThenElseContext ctx) {
        Expression cond = visit(ctx.expr());
        Expression thn = visit(ctx.block(0));
        Expression els = visit(ctx.block(1));
        return new IfExpr(cond, thn, els);
    }

    @Override
    public Expression visitIfThen(FeatherweightJavaScriptParser.IfThenContext ctx) {
        Expression cond = visit(ctx.expr());
        Expression thn = visit(ctx.block());
        return new IfExpr(cond, thn, null);
    }

    @Override
    public Expression visitInt(FeatherweightJavaScriptParser.IntContext ctx) {
        int val = Integer.valueOf(ctx.INT().getText());
        return new ValueExpr(new IntVal(val));
    }

    @Override
    public Expression visitParens(FeatherweightJavaScriptParser.ParensContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public Expression visitFullBlock(FeatherweightJavaScriptParser.FullBlockContext ctx) {
        List<Expression> stmts = new ArrayList<Expression>();
        for (int i=1; i<ctx.getChildCount()-1; i++) {
            Expression exp = visit(ctx.getChild(i));
            stmts.add(exp);
        }
        return listToSeqExp(stmts);
    }

    @Override
    public Expression visitWhile(FeatherweightJavaScriptParser.WhileContext ctx) {
        Expression cond = visit(ctx.expr());
        Expression body = visit(ctx.block());
        return new WhileExpr(cond, body);
    }

    @Override public Expression visitVarRef(FeatherweightJavaScriptParser.VarRefContext ctx) {
        return new VarExpr(String.valueOf(ctx.ID().getText()));
    }

    @Override public Expression visitVarAssign(FeatherweightJavaScriptParser.VarAssignContext ctx) {
        // varName, expression
         return new AssignExpr(ctx.ID().getText(), visit(ctx.expr()));
    }

    @Override public Expression visitNull(FeatherweightJavaScriptParser.NullContext ctx) {
         return new ValueExpr(new NullVal());
    }

    @Override public Expression visitParams(FeatherweightJavaScriptParser.ParamsContext ctx) { 
        List<String> params = new ArrayList<>();
        List<TerminalNode> nodes = ctx.ID();

        for(int i=0; i<nodes.size(); i++){
            params.add(String.valueOf(nodes.get(i)));
        }
        
        // TODO: FIX THE RETURN
        return new ValueExpr(new NullVal());
    }

    @Override public Expression visitArgs(FeatherweightJavaScriptParser.ArgsContext ctx) { 
        List<String> args = new ArrayList<>();
        List<ExprContext> contexts = ctx.expr();

        for(int i=0; i<contexts.size(); i++){
            args.add(String.valueOf(contexts.get(i)));
        }
        
        //TODO: FIX THE RETURN
        return new ValueExpr(new NullVal());
    }

    @Override public Expression visitComparison(FeatherweightJavaScriptParser.ComparisonContext ctx) { 
        Expression expr1 = visit(ctx.expr(0));
        Expression expr2 = visit(ctx.expr(1));
        int operator = ctx.op.getType();

        if(operator == FeatherweightJavaScriptParser.GT){
            return new BinOpExpr(Op.GT, expr1, expr2);
        }
        else if(operator == FeatherweightJavaScriptParser.LT){
            return new BinOpExpr(Op.LT, expr1, expr2);
        }
        else if(operator == FeatherweightJavaScriptParser.GE){
            return new BinOpExpr(Op.GE, expr1, expr2);
        }
        else if(operator == FeatherweightJavaScriptParser.LE){
            return new BinOpExpr(Op.LE, expr1, expr2);
        }
        else {
            return new BinOpExpr(Op.EQ, expr1, expr2);
        }
    }


    /**
     * Converts a list of expressions to one sequence expression,
     * if the list contained more than one expression.
     */
    private Expression listToSeqExp(List<Expression> stmts) {
        if (stmts.isEmpty()) return null;
        Expression exp = stmts.get(0);
        for (int i=1; i<stmts.size(); i++) {
            exp = new SeqExpr(exp, stmts.get(i));
        }
        return exp;
    }

    @Override
    public Expression visitSimpBlock(FeatherweightJavaScriptParser.SimpBlockContext ctx) {
        return visit(ctx.stat());
    }

}
