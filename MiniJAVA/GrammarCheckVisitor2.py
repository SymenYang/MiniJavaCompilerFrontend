from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser
from MiniJavaLexer import MiniJavaLexer
# This class defines a complete generic visitor for a parse tree produced by MiniJavaParser.

class GrammarCheckVisitor(MiniJavaVisitor):

    def __init__(self):
        super(GrammarCheckVisitor,self).__init__()
        self.HasError = False

    # Visit a parse tree produced by MiniJavaParser#TRUEFALSE.
    def visitTRUEFALSE(self, ctx:MiniJavaParser.TRUEFALSEContext):
        reType = self.visit(ctx.expression2())
        if reType[0] == 'BIOP' or reType[0] == 'NULL':
            if reType[0] == 'BIOP':
                if reType[1] == 'And':
                    pass
                else:
                    self.HasError = True
# TODO: 错误信息
                    print('语法错误: '+ ctx.getText() + ' 位置：' + str(ctx.expression2().start.line) + ':' + str(ctx.expression2().start.column))
                    pass
        else:
            self.HasError = True
# TODO: 错误信息
            print('语法错误: '+ ctx.getText() + ' 位置：' + str(ctx.expression2().start.line) + ':' + str(ctx.expression2().start.column))
            pass
        #super(GrammarCheckVisitor,self).visitTRUEFALSE(ctx)
        return ['TRUEFALSE']


    # Visit a parse tree produced by MiniJavaParser#INTLIT.
    def visitINTLIT(self, ctx:MiniJavaParser.INTLITContext):
        reType = self.visit(ctx.expression2())
        if reType[0] == 'BIOP' or reType[0] == 'NULL':
            if reType[0] == 'BIOP':
                if reType[1] == 'And':
                    self.HasError = True
# TODO: 错误信息
                    print('语法错误: '+ ctx.getText() + ' 位置：' + str(ctx.expression2().start.line) + ':' + str(ctx.expression2().start.column))
                    pass
                else:
                    pass
        else:
            self.HasError = True
# TODO: 错误信息
            print('语法错误: '+ ctx.getText() + ' 位置：' + str(ctx.expression2().start.line) + ':' + str(ctx.expression2().start.column))
            pass
        #super(GrammarCheckVisitor,self).visitChildren(ctx)
        return ['INT']

    # Visit a parse tree produced by MiniJavaParser#THIS.
    def visitTHIS(self, ctx:MiniJavaParser.THISContext):
        reType = self.visit(ctx.expression2())
        if reType[0] == 'FUNCTION' or reType[0] == 'NULL':
            pass
        else:
            self.HasError = True
# TODO: 错误信息
            print('语法错误: '+ ctx.getText() + ' 位置：' + str(ctx.expression2().start.line) + ':' + str(ctx.expression2().start.column))
            pass
        
        return ['VAR']


    # Visit a parse tree produced by MiniJavaParser#NEWINT.
    def visitNEWINT(self, ctx:MiniJavaParser.NEWINTContext):
        reType = self.visit(ctx.expression())
        if reType[0] == 'INT' or reType[0] == 'VAR':
            pass
        else:
            self.HasError = True
# TODO: 错误信息
            print('语法错误: '+ ctx.getText() + ' 位置：' + str(ctx.expression().start.line) + ':' + str(ctx.expression().start.column))
            pass
        reType = self.visit(ctx.expression2())
        if reType[0] == 'NULL' or reType[0] == 'LENGTH':
            pass
        else:
            self.HasError = True
# TODO: 错误信息
            print('语法错误: '+ ctx.getText() + ' 位置：' + str(ctx.expression2().start.line) + ':' + str(ctx.expression2().start.column))
            pass
        
        return ['NEWINT']

    def visitVAR(self ,ctx:MiniJavaParser.VARContext):
        super(GrammarCheckVisitor,self).visitVAR(ctx)
        return ['VAR']

    # Visit a parse tree produced by MiniJavaParser#NEWID.
    def visitNEWID(self, ctx:MiniJavaParser.NEWIDContext):
        reType = self.visit(ctx.expression2())
        if reType[0] == 'NULL' or reType[0] == 'FUNCTION':
            pass
        else:
            self.HasError = True
# TODO: 错误信息
            print('语法错误: '+ ctx.getText() + ' 位置：' + str(ctx.expression2().start.line) + ':' + str(ctx.expression2().start.column))
            pass
        
        return ['NEWID']


    # Visit a parse tree produced by MiniJavaParser#NOT.
    def visitNOT(self, ctx:MiniJavaParser.NOTContext):
        reType = self.visit(ctx.expression())
        #if reType [0] == 'INTLIT' or reType[0] == 'NEWINT' or reType[0] == 'NEWID':
        #    self.HasError = True
# TODO: 错误信息
        #    pass
        reType = self.visit(ctx.expression2())
        return ['NOT']

    # Visit a parse tree produced by MiniJavaParser#BRACKET.
    def visitBRACKET(self, ctx:MiniJavaParser.BRACKETContext):
        reType = self.visit(ctx.expression())
        #if reType[0] == 'NEWINT' or reType[0] == 'NEWID':
        #    self.HasError = True
# TODO: 错误信息
        #    pass
        return ['BRACKET']


    # Visit a parse tree produced by MiniJavaParser#SQUAREBRACKET.
    def visitSQUAREBRACKET(self, ctx:MiniJavaParser.SQUAREBRACKETContext):
        super(GrammarCheckVisitor,self).visitSQUAREBRACKET(ctx)
        return ['SQUAREBRACKET']


    # Visit a parse tree produced by MiniJavaParser#LENGTH.
    def visitLENGTH(self, ctx:MiniJavaParser.LENGTHContext):
        super(GrammarCheckVisitor,self).visitLENGTH(ctx)
        return ['LENGTH']


    # Visit a parse tree produced by MiniJavaParser#FUNCTION.
    def visitFUNCTION(self, ctx:MiniJavaParser.FUNCTIONContext):
        super(GrammarCheckVisitor,self).visitFUNCTION(ctx)
        return ['FUNCTION']

    # Visit a parse tree produced by MiniJavaParser#BIOP.
    def visitBIOP(self, ctx:MiniJavaParser.BIOPContext):
        reType = self.visit(ctx.expression())
        op = ctx.op
        ops = ''
        if op.type == MiniJavaLexer.And:
            ops = 'And'
        if op.type == MiniJavaLexer.Less:
            ops = 'Less'
        if op.type == MiniJavaLexer.Mul:
            ops = 'Mul'
        if op.type == MiniJavaLexer.Min:
            ops = 'Min'
        if op.type == MiniJavaLexer.Add:
            ops = 'Add'
        
        return ['BIOP',ops]


    # Visit a parse tree produced by MiniJavaParser#NULL.
    def visitNULL(self, ctx:MiniJavaParser.NULLContext):
        return ['NULL']

del MiniJavaParser