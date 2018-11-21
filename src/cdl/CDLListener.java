// Generated from CDL.g4 by ANTLR 4.7.1

    package cdl;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CDLParser}.
 */
public interface CDLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CDLParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(CDLParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(CDLParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#cmd}.
	 * @param ctx the parse tree
	 */
	void enterCmd(CDLParser.CmdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#cmd}.
	 * @param ctx the parse tree
	 */
	void exitCmd(CDLParser.CmdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#circuit_definition}.
	 * @param ctx the parse tree
	 */
	void enterCircuit_definition(CDLParser.Circuit_definitionContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#circuit_definition}.
	 * @param ctx the parse tree
	 */
	void exitCircuit_definition(CDLParser.Circuit_definitionContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#var_list}.
	 * @param ctx the parse tree
	 */
	void enterVar_list(CDLParser.Var_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#var_list}.
	 * @param ctx the parse tree
	 */
	void exitVar_list(CDLParser.Var_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#exp_assignment}.
	 * @param ctx the parse tree
	 */
	void enterExp_assignment(CDLParser.Exp_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#exp_assignment}.
	 * @param ctx the parse tree
	 */
	void exitExp_assignment(CDLParser.Exp_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#circuit_assignment}.
	 * @param ctx the parse tree
	 */
	void enterCircuit_assignment(CDLParser.Circuit_assignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#circuit_assignment}.
	 * @param ctx the parse tree
	 */
	void exitCircuit_assignment(CDLParser.Circuit_assignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(CDLParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(CDLParser.ExpContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#term_or}.
	 * @param ctx the parse tree
	 */
	void enterTerm_or(CDLParser.Term_orContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#term_or}.
	 * @param ctx the parse tree
	 */
	void exitTerm_or(CDLParser.Term_orContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#term_xor}.
	 * @param ctx the parse tree
	 */
	void enterTerm_xor(CDLParser.Term_xorContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#term_xor}.
	 * @param ctx the parse tree
	 */
	void exitTerm_xor(CDLParser.Term_xorContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#term_and}.
	 * @param ctx the parse tree
	 */
	void enterTerm_and(CDLParser.Term_andContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#term_and}.
	 * @param ctx the parse tree
	 */
	void exitTerm_and(CDLParser.Term_andContext ctx);
	/**
	 * Enter a parse tree produced by {@link CDLParser#term_not}.
	 * @param ctx the parse tree
	 */
	void enterTerm_not(CDLParser.Term_notContext ctx);
	/**
	 * Exit a parse tree produced by {@link CDLParser#term_not}.
	 * @param ctx the parse tree
	 */
	void exitTerm_not(CDLParser.Term_notContext ctx);
}