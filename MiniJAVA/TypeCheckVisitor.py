from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser

class TypeCheckVisitor(MiniJavaVisitor):
    def __init__(self,ClassTable,FuncTable):
        super(TypeCheckVisitor,self).__init__()
        self.Types = ClassTable
        self.Types['INTARR'] = 'type'
        self.Types['INT'] = 'type'
        self.Types['BOOL'] = 'type'

        self.FuncTypes = FuncTable
        self.BigWrong = False
        for item in self.FuncTypes:
            if not self.FuncTypes[item] in self.Types:
                print('方法返回类型错误,方法：' + item[0] + '.' + item[1] + ' 得到未知类型：' + self.FuncTypes[item])
                self.BigWrong = True
        # Expression2 return (OP String,Type0,Type1...)
        # Expression return type


    def visitTRUE(self, ctx:MiniJavaParser.TRUEContext):
        if self.BigWrong:
            return None
        reType = self.visit( ctx.expression2(0) )
        if reType == None:
            return reType
        if reType[0] != 'BIOP' and reType[0] != 'NULL':
            self.BigWrong = True
            print('错误用法，\'true\'后接非法操作')
        if reType[1]


    # Visit a parse tree produced by MiniJavaParser#FALSE.
    def visitFALSE(self, ctx:MiniJavaParser.FALSEContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#INTLIT.
    def visitINTLIT(self, ctx:MiniJavaParser.INTLITContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#VAR.
    def visitVAR(self, ctx:MiniJavaParser.VARContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#THIS.
    def visitTHIS(self, ctx:MiniJavaParser.THISContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#NEWINT.
    def visitNEWINT(self, ctx:MiniJavaParser.NEWINTContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#NEWID.
    def visitNEWID(self, ctx:MiniJavaParser.NEWIDContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#NOT.
    def visitNOT(self, ctx:MiniJavaParser.NOTContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#BRACKET.
    def visitBRACKET(self, ctx:MiniJavaParser.BRACKETContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#SQUAREBRACKET.
    def visitSQUAREBRACKET(self, ctx:MiniJavaParser.SQUAREBRACKETContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#LENGTH.
    def visitLENGTH(self, ctx:MiniJavaParser.LENGTHContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#FUNCTION.
    def visitFUNCTION(self, ctx:MiniJavaParser.FUNCTIONContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#BIOP.
    def visitBIOP(self, ctx:MiniJavaParser.BIOPContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#NULL.
    def visitNULL(self, ctx:MiniJavaParser.NULLContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#CURLYBRACKET.
    def visitCURLYBRACKET(self, ctx:MiniJavaParser.CURLYBRACKETContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#IFELSE.
    def visitIFELSE(self, ctx:MiniJavaParser.IFELSEContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#WHILE.
    def visitWHILE(self, ctx:MiniJavaParser.WHILEContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#PRINT.
    def visitPRINT(self, ctx:MiniJavaParser.PRINTContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#ASSIGN.
    def visitASSIGN(self, ctx:MiniJavaParser.ASSIGNContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#ARRAYASSIGN.
    def visitARRAYASSIGN(self, ctx:MiniJavaParser.ARRAYASSIGNContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)