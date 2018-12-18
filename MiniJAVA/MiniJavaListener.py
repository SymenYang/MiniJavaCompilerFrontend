# Generated from MiniJava.g4 by ANTLR 4.7.1
from antlr4 import *
if __name__ is not None and "." in __name__:
    from .MiniJavaParser import MiniJavaParser
else:
    from MiniJavaParser import MiniJavaParser

# This class defines a complete listener for a parse tree produced by MiniJavaParser.
class MiniJavaListener(ParseTreeListener):

    # Enter a parse tree produced by MiniJavaParser#goal.
    def enterGoal(self, ctx:MiniJavaParser.GoalContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#goal.
    def exitGoal(self, ctx:MiniJavaParser.GoalContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#mainClass.
    def enterMainClass(self, ctx:MiniJavaParser.MainClassContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#mainClass.
    def exitMainClass(self, ctx:MiniJavaParser.MainClassContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#classDeclaration.
    def enterClassDeclaration(self, ctx:MiniJavaParser.ClassDeclarationContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#classDeclaration.
    def exitClassDeclaration(self, ctx:MiniJavaParser.ClassDeclarationContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#varDeclaration.
    def enterVarDeclaration(self, ctx:MiniJavaParser.VarDeclarationContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#varDeclaration.
    def exitVarDeclaration(self, ctx:MiniJavaParser.VarDeclarationContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#methodDeclaration.
    def enterMethodDeclaration(self, ctx:MiniJavaParser.MethodDeclarationContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#methodDeclaration.
    def exitMethodDeclaration(self, ctx:MiniJavaParser.MethodDeclarationContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#INTARRAY.
    def enterINTARRAY(self, ctx:MiniJavaParser.INTARRAYContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#INTARRAY.
    def exitINTARRAY(self, ctx:MiniJavaParser.INTARRAYContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#BOOL.
    def enterBOOL(self, ctx:MiniJavaParser.BOOLContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#BOOL.
    def exitBOOL(self, ctx:MiniJavaParser.BOOLContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#INT.
    def enterINT(self, ctx:MiniJavaParser.INTContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#INT.
    def exitINT(self, ctx:MiniJavaParser.INTContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#ID.
    def enterID(self, ctx:MiniJavaParser.IDContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#ID.
    def exitID(self, ctx:MiniJavaParser.IDContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#TRUEFALSE.
    def enterTRUEFALSE(self, ctx:MiniJavaParser.TRUEFALSEContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#TRUEFALSE.
    def exitTRUEFALSE(self, ctx:MiniJavaParser.TRUEFALSEContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#INTLIT.
    def enterINTLIT(self, ctx:MiniJavaParser.INTLITContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#INTLIT.
    def exitINTLIT(self, ctx:MiniJavaParser.INTLITContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#VAR.
    def enterVAR(self, ctx:MiniJavaParser.VARContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#VAR.
    def exitVAR(self, ctx:MiniJavaParser.VARContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#THIS.
    def enterTHIS(self, ctx:MiniJavaParser.THISContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#THIS.
    def exitTHIS(self, ctx:MiniJavaParser.THISContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#NEWINT.
    def enterNEWINT(self, ctx:MiniJavaParser.NEWINTContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#NEWINT.
    def exitNEWINT(self, ctx:MiniJavaParser.NEWINTContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#NEWID.
    def enterNEWID(self, ctx:MiniJavaParser.NEWIDContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#NEWID.
    def exitNEWID(self, ctx:MiniJavaParser.NEWIDContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#NOT.
    def enterNOT(self, ctx:MiniJavaParser.NOTContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#NOT.
    def exitNOT(self, ctx:MiniJavaParser.NOTContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#BRACKET.
    def enterBRACKET(self, ctx:MiniJavaParser.BRACKETContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#BRACKET.
    def exitBRACKET(self, ctx:MiniJavaParser.BRACKETContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#SQUAREBRACKET.
    def enterSQUAREBRACKET(self, ctx:MiniJavaParser.SQUAREBRACKETContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#SQUAREBRACKET.
    def exitSQUAREBRACKET(self, ctx:MiniJavaParser.SQUAREBRACKETContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#LENGTH.
    def enterLENGTH(self, ctx:MiniJavaParser.LENGTHContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#LENGTH.
    def exitLENGTH(self, ctx:MiniJavaParser.LENGTHContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#FUNCTION.
    def enterFUNCTION(self, ctx:MiniJavaParser.FUNCTIONContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#FUNCTION.
    def exitFUNCTION(self, ctx:MiniJavaParser.FUNCTIONContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#BIOP.
    def enterBIOP(self, ctx:MiniJavaParser.BIOPContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#BIOP.
    def exitBIOP(self, ctx:MiniJavaParser.BIOPContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#NULL.
    def enterNULL(self, ctx:MiniJavaParser.NULLContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#NULL.
    def exitNULL(self, ctx:MiniJavaParser.NULLContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#CURLYBRACKET.
    def enterCURLYBRACKET(self, ctx:MiniJavaParser.CURLYBRACKETContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#CURLYBRACKET.
    def exitCURLYBRACKET(self, ctx:MiniJavaParser.CURLYBRACKETContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#IFELSE.
    def enterIFELSE(self, ctx:MiniJavaParser.IFELSEContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#IFELSE.
    def exitIFELSE(self, ctx:MiniJavaParser.IFELSEContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#WHILE.
    def enterWHILE(self, ctx:MiniJavaParser.WHILEContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#WHILE.
    def exitWHILE(self, ctx:MiniJavaParser.WHILEContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#PRINT.
    def enterPRINT(self, ctx:MiniJavaParser.PRINTContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#PRINT.
    def exitPRINT(self, ctx:MiniJavaParser.PRINTContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#ASSIGN.
    def enterASSIGN(self, ctx:MiniJavaParser.ASSIGNContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#ASSIGN.
    def exitASSIGN(self, ctx:MiniJavaParser.ASSIGNContext):
        pass


    # Enter a parse tree produced by MiniJavaParser#ARRAYASSIGN.
    def enterARRAYASSIGN(self, ctx:MiniJavaParser.ARRAYASSIGNContext):
        pass

    # Exit a parse tree produced by MiniJavaParser#ARRAYASSIGN.
    def exitARRAYASSIGN(self, ctx:MiniJavaParser.ARRAYASSIGNContext):
        pass


