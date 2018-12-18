// Generated from MiniJava.g4 by ANTLR 4.7.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiniJavaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiniJavaVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#goal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(MiniJavaParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#mainClass}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMainClass(MiniJavaParser.MainClassContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(MiniJavaParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#varDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(MiniJavaParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiniJavaParser#methodDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodDeclaration(MiniJavaParser.MethodDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INTARRAY}
	 * labeled alternative in {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINTARRAY(MiniJavaParser.INTARRAYContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BOOL}
	 * labeled alternative in {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBOOL(MiniJavaParser.BOOLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INT}
	 * labeled alternative in {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINT(MiniJavaParser.INTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ID}
	 * labeled alternative in {@link MiniJavaParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitID(MiniJavaParser.IDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TRUE}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTRUE(MiniJavaParser.TRUEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FALSE}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFALSE(MiniJavaParser.FALSEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code INTLIT}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitINTLIT(MiniJavaParser.INTLITContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VAR}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVAR(MiniJavaParser.VARContext ctx);
	/**
	 * Visit a parse tree produced by the {@code THIS}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTHIS(MiniJavaParser.THISContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NEWINT}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEWINT(MiniJavaParser.NEWINTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NEWID}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNEWID(MiniJavaParser.NEWIDContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NOT}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNOT(MiniJavaParser.NOTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BRACKET}
	 * labeled alternative in {@link MiniJavaParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBRACKET(MiniJavaParser.BRACKETContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SQUAREBRACKET}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSQUAREBRACKET(MiniJavaParser.SQUAREBRACKETContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LENGTH}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLENGTH(MiniJavaParser.LENGTHContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FUNCTION}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFUNCTION(MiniJavaParser.FUNCTIONContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BIOP}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBIOP(MiniJavaParser.BIOPContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NULL}
	 * labeled alternative in {@link MiniJavaParser#expression2}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNULL(MiniJavaParser.NULLContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CURLYBRACKET}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCURLYBRACKET(MiniJavaParser.CURLYBRACKETContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IFELSE}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIFELSE(MiniJavaParser.IFELSEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WHILE}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWHILE(MiniJavaParser.WHILEContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PRINT}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPRINT(MiniJavaParser.PRINTContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ASSIGN}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitASSIGN(MiniJavaParser.ASSIGNContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ARRAYASSIGN}
	 * labeled alternative in {@link MiniJavaParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitARRAYASSIGN(MiniJavaParser.ARRAYASSIGNContext ctx);
}