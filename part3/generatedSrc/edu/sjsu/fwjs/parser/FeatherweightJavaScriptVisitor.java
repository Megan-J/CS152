// Generated from FeatherweightJavaScript.g4 by ANTLR 4.8
 package edu.sjsu.fwjs.parser; 
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FeatherweightJavaScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FeatherweightJavaScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FeatherweightJavaScriptParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(FeatherweightJavaScriptParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bareExpr}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBareExpr(FeatherweightJavaScriptParser.BareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifThenElse}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElse(FeatherweightJavaScriptParser.IfThenElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifThen}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThen(FeatherweightJavaScriptParser.IfThenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code print}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(FeatherweightJavaScriptParser.PrintContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(FeatherweightJavaScriptParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptyStmt}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptyStmt(FeatherweightJavaScriptParser.EmptyStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(FeatherweightJavaScriptParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(FeatherweightJavaScriptParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcApp}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncApp(FeatherweightJavaScriptParser.FuncAppContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(FeatherweightJavaScriptParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code null}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(FeatherweightJavaScriptParser.NullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(FeatherweightJavaScriptParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FeatherweightJavaScriptParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcDecl}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(FeatherweightJavaScriptParser.FuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varRef}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarRef(FeatherweightJavaScriptParser.VarRefContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varDecl}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(FeatherweightJavaScriptParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(FeatherweightJavaScriptParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varAssign}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssign(FeatherweightJavaScriptParser.VarAssignContext ctx);
	/**
	 * Visit a parse tree produced by {@link FeatherweightJavaScriptParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(FeatherweightJavaScriptParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FeatherweightJavaScriptParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(FeatherweightJavaScriptParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullBlock}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullBlock(FeatherweightJavaScriptParser.FullBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpBlock}
	 * labeled alternative in {@link FeatherweightJavaScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpBlock(FeatherweightJavaScriptParser.SimpBlockContext ctx);
}