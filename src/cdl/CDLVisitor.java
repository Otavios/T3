// Generated from CDL.g4 by ANTLR 4.7.1

    package cdl;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CDLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CDLParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(CDLParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#cmd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCmd(CDLParser.CmdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#circuit_definition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCircuit_definition(CDLParser.Circuit_definitionContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#var_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_list(CDLParser.Var_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#exp_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp_assignment(CDLParser.Exp_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#circuit_assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCircuit_assignment(CDLParser.Circuit_assignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#exp}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExp(CDLParser.ExpContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#term_or}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_or(CDLParser.Term_orContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#term_xor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_xor(CDLParser.Term_xorContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#term_and}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_and(CDLParser.Term_andContext ctx);
	/**
	 * Visit a parse tree produced by {@link CDLParser#term_not}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm_not(CDLParser.Term_notContext ctx);
}