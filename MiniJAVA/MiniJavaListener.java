// Generated from MiniJava.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiniJavaParser}.
 */
public interface MiniJavaListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void enterGoal(MiniJavaParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#goal}.
	 * @param ctx the parse tree
	 */
	void exitGoal(MiniJavaParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void enterMainClass(MiniJavaParser.MainClassContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 */
	void exitMainClass(MiniJavaParser.MainClassContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(MiniJavaParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void enterMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 */
	void exitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INTARRAY}
	 * labeled alternative in {@link MiniJavaParser#atype}.
	 * @param ctx the parse tree
	 */
	void enterINTARRAY(MiniJavaParser.INTARRAYContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INTARRAY}
	 * labeled alternative in {@link MiniJavaParser#atype}.
	 * @param ctx the parse tree
	 */
	void exitINTARRAY(MiniJavaParser.INTARRAYContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link MiniJavaParser#atype}.
	 * @param ctx the parse tree
	 */
	void enterBOOL(MiniJavaParser.BOOLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link MiniJavaParser#atype}.
	 * @param ctx the parse tree
	 */
	void exitBOOL(MiniJavaParser.BOOLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INT}
	 * labeled alternative in {@link MiniJavaParser#atype}.
	 * @param ctx the parse tree
	 */
	void enterINT(MiniJavaParser.INTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INT}
	 * labeled alternative in {@link MiniJavaParser#atype}.
	 * @param ctx the parse tree
	 */
	void exitINT(MiniJavaParser.INTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ID}
	 * labeled alternative in {@link MiniJavaParser#atype}.
	 * @param ctx the parse tree
	 */
	void enterID(MiniJavaParser.IDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link MiniJavaParser#atype}.
	 * @param ctx the parse tree
	 */
	void exitID(MiniJavaParser.IDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code TRUEFALSE}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTRUEFALSE(MiniJavaParser.TRUEFALSEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code TRUEFALSE}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTRUEFALSE(MiniJavaParser.TRUEFALSEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code INTLIT}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterINTLIT(MiniJavaParser.INTLITContext ctx);
	/**
	 * Exit a parse tree produced by the {@code INTLIT}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitINTLIT(MiniJavaParser.INTLITContext ctx);
	/**
	 * Enter a parse tree produced by the {@code VAR}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterVAR(MiniJavaParser.VARContext ctx);
	/**
	 * Exit a parse tree produced by the {@code VAR}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitVAR(MiniJavaParser.VARContext ctx);
	/**
	 * Enter a parse tree produced by the {@code THIS}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTHIS(MiniJavaParser.THISContext ctx);
	/**
	 * Exit a parse tree produced by the {@code THIS}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTHIS(MiniJavaParser.THISContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NEWINT}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNEWINT(MiniJavaParser.NEWINTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NEWINT}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNEWINT(MiniJavaParser.NEWINTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NEWID}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNEWID(MiniJavaParser.NEWIDContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NEWID}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNEWID(MiniJavaParser.NEWIDContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNOT(MiniJavaParser.NOTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNOT(MiniJavaParser.NOTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BRACKET}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBRACKET(MiniJavaParser.BRACKETContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BRACKET}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBRACKET(MiniJavaParser.BRACKETContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SQUAREBRACKET}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 */
	void enterSQUAREBRACKET(MiniJavaParser.SQUAREBRACKETContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SQUAREBRACKET}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 */
	void exitSQUAREBRACKET(MiniJavaParser.SQUAREBRACKETContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LENGTH}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 */
	void enterLENGTH(MiniJavaParser.LENGTHContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LENGTH}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 */
	void exitLENGTH(MiniJavaParser.LENGTHContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FUNCTION}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 */
	void enterFUNCTION(MiniJavaParser.FUNCTIONContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FUNCTION}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 */
	void exitFUNCTION(MiniJavaParser.FUNCTIONContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BIOP}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 */
	void enterBIOP(MiniJavaParser.BIOPContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BIOP}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 */
	void exitBIOP(MiniJavaParser.BIOPContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NULL}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 */
	void enterNULL(MiniJavaParser.NULLContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NULL}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 */
	void exitNULL(MiniJavaParser.NULLContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CURLYBRACKET}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterCURLYBRACKET(MiniJavaParser.CURLYBRACKETContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CURLYBRACKET}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitCURLYBRACKET(MiniJavaParser.CURLYBRACKETContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IFELSE}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIFELSE(MiniJavaParser.IFELSEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IFELSE}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIFELSE(MiniJavaParser.IFELSEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WHILE}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWHILE(MiniJavaParser.WHILEContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WHILE}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWHILE(MiniJavaParser.WHILEContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PRINT}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterPRINT(MiniJavaParser.PRINTContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PRINT}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitPRINT(MiniJavaParser.PRINTContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ASSIGN}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterASSIGN(MiniJavaParser.ASSIGNContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ASSIGN}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitASSIGN(MiniJavaParser.ASSIGNContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ARRAYASSIGN}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterARRAYASSIGN(MiniJavaParser.ARRAYASSIGNContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ARRAYASSIGN}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitARRAYASSIGN(MiniJavaParser.ARRAYASSIGNContext ctx);
}