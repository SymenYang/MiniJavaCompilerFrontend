# Generated from MiniJava.g4 by ANTLR 4.7.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .MiniJavaParser import MiniJavaParser
else:
    from MiniJavaParser import MiniJavaParser

# This class defines a complete generic visitor for a parse tree produced by MiniJavaParser.

class MiniJavaVisitor(ParseTreeVisitor):

    # Visit a parse tree produced by MiniJavaParser#goal.
    def visitGoal(self, ctx:MiniJavaParser.GoalContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#mainClass.
    def visitMainClass(self, ctx:MiniJavaParser.MainClassContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#classDeclaration.
    def visitClassDeclaration(self, ctx:MiniJavaParser.ClassDeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#varDeclaration.
    def visitVarDeclaration(self, ctx:MiniJavaParser.VarDeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#methodDeclaration.
    def visitMethodDeclaration(self, ctx:MiniJavaParser.MethodDeclarationContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#INTARRAY.
    def visitINTARRAY(self, ctx:MiniJavaParser.INTARRAYContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#BOOL.
    def visitBOOL(self, ctx:MiniJavaParser.BOOLContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#INT.
    def visitINT(self, ctx:MiniJavaParser.INTContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#ID.
    def visitID(self, ctx:MiniJavaParser.IDContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#TRUE.
    def visitTRUE(self, ctx:MiniJavaParser.TRUEContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#FALSE.
    def visitFALSE(self, ctx:MiniJavaParser.FALSEContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#INTLIT.
    def visitINTLIT(self, ctx:MiniJavaParser.INTLITContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#VAR.
    def visitVAR(self, ctx:MiniJavaParser.VARContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#THIS.
    def visitTHIS(self, ctx:MiniJavaParser.THISContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#NEWINT.
    def visitNEWINT(self, ctx:MiniJavaParser.NEWINTContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#NEWID.
    def visitNEWID(self, ctx:MiniJavaParser.NEWIDContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#NOT.
    def visitNOT(self, ctx:MiniJavaParser.NOTContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#BRACKET.
    def visitBRACKET(self, ctx:MiniJavaParser.BRACKETContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#SQUAREBRACKET.
    def visitSQUAREBRACKET(self, ctx:MiniJavaParser.SQUAREBRACKETContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#LENGTH.
    def visitLENGTH(self, ctx:MiniJavaParser.LENGTHContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#FUNCTION.
    def visitFUNCTION(self, ctx:MiniJavaParser.FUNCTIONContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#BIOP.
    def visitBIOP(self, ctx:MiniJavaParser.BIOPContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#NULL.
    def visitNULL(self, ctx:MiniJavaParser.NULLContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#CURLYBRACKET.
    def visitCURLYBRACKET(self, ctx:MiniJavaParser.CURLYBRACKETContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#IFELSE.
    def visitIFELSE(self, ctx:MiniJavaParser.IFELSEContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#WHILE.
    def visitWHILE(self, ctx:MiniJavaParser.WHILEContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#PRINT.
    def visitPRINT(self, ctx:MiniJavaParser.PRINTContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#ASSIGN.
    def visitASSIGN(self, ctx:MiniJavaParser.ASSIGNContext):
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#ARRAYASSIGN.
    def visitARRAYASSIGN(self, ctx:MiniJavaParser.ARRAYASSIGNContext):
        return self.visitChildren(ctx)



del MiniJavaParser