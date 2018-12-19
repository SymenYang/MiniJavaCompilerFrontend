from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser

class TypeCheckVisitor(MiniJavaVisitor):
    def __init__(self,TypeTable,ClassParamTable):
        '''
        Expression 返回这个表达式最终的type
        Expression2 返回[语句类型，[sub类型（OP等），[对应类型]]]
        '''
        self.Types = TypeTable.copy()
        self.Types['INT'] = 'type'
        self.Types['INTARRAY'] = 'type'
        self.Types['BOOL'] = 'type'

        self.ClassParam = ClassParamTable
        self.classVars = {} # {varName : typeString}
        self.methodVars = {} # {varName : typeString}
        self.nowClass = ''
        self.HasError = False

    def visitClassDeclaration(self, ctx:MiniJavaParser.ClassDeclarationContext):
        self.classVars = {}
        self.nowClass = str(ctx.Identifier(0))
        self.classVars = self.ClassParam[self. nowClass].Vars

        # 跳过所有class的var，直接去每个methods
        methods = ctx.methodDeclaration()
        for item in methods:
            self.visit(item)
        return

    def visitMethodDeclaration(self, ctx:MiniJavaParser.MethodDeclarationContext):
        self.methodVars = {}
        super(TypeCheckVisitor,self).visitMethodDeclaration(ctx)
        return

    def visitVarDeclaration(self, ctx:MiniJavaParser.VarDeclarationContext):
        vartype = self.visit(ctx.atype())
        if not vartype in self.Types:
            # TODO: 变量定义类型错误提示
            print('变量定义类型错误')
            return
        varname = str(ctx.Identifier())
        self.methodVars[varname] = vartype
        return

    # Visit a parse tree produced by MiniJavaParser#TRUEFALSE.
    def visitTRUEFALSE(self, ctx:MiniJavaParser.TRUEFALSEContext):
        reType = self.visit(ctx.expression2())
        if reType[0] == 'None':
            return 'None'
        # reType : ['BIOP' or 'NULL',op(And...),expression type]
        if reType[0] == 'NULL':
            pass
        else:
            if reType[2] == 'BOOL':
                pass
            else:
                # TODO: 运算符错误
                print('运算符错误')
                return 'None'
        return 'BOOL'


    # Visit a parse tree produced by MiniJavaParser#INTLIT.
    def visitINTLIT(self, ctx:MiniJavaParser.INTLITContext):
        reType = self.visit(ctx.expression2())
        # reType : ['BIOP' or 'NULL',op(And...),expression type]
        if reType[0] == 'None':
            return 'None'
        if reType[0] == 'NULL':
            return 'INT'
        if reType[0] == 'BIOP':
            if reType[2] != 'INT':
                # TODO: 运算符错误
                print('运算符错误')
                return 'None'
            if reType[1] == 'Less':
                return 'BOOL'
            else:
                return 'INT'
        return 'None'


    # Visit a parse tree produced by MiniJavaParser#VAR.
    def visitVAR(self, ctx:MiniJavaParser.VARContext):
        Id = str(ctx.Identifier())
        if not (Id in self.methodVars or Id in self.classVars):
            # TODO: 变量未定义
            print('变量未定义')
            return 'None'
        VarType = ''
        IdType = ''
        if Id in self.methodVars:
            VarType = self.methodVars[Id]
        else:
            VarType = self.classVars[Id]
        IdType = self.Types[VarType]
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

    def visitINTARRAY(self,ctx:MiniJavaParser.INTARRAYContext):
        return 'INTARR'
    
    def visitBOOL(self, ctx:MiniJavaParser.BOOLContext):
        return 'BOOL'

    def visitINT(self, ctx:MiniJavaParser.INTContext):
        return 'INT'

    def visitID(self, ctx:MiniJavaParser.IDContext):
        return str(ctx.Identifier())