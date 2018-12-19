from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser
import ClassParamVisitor

class TypeCheckVisitor(MiniJavaVisitor):
    def __init__(self,TypeTable,ClassParamTable):
        '''
        Expression 返回这个表达式最终的type
        Expression2 返回[语句类型，[sub类型（OP等），[对应类型]]]
        '''
        self.ClassNames = TypeTable
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
        if reType == 'None':
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
        if reType == 'None':
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
        
        # VarType: INT,BOOL,INTARRAY,CLASSNAME
        # IdType: type,Class,MainClass(不用的)
        VarType = ''
        IdType = ''
        if Id in self.methodVars:
            VarType = self.methodVars[Id]
        else:
            VarType = self.classVars[Id]
        IdType = self.Types[VarType]

        reType = self.visit(ctx.expression2)
        if reType == 'None':
            return 'None'
        # reType : ['BIOP' or 'NULL'...,[op(And...)],expression type]
        
        if IdType == 'Class':
            # 类名后面只能接函数
            if reType[0] != 'FUNCTION':
                # 类后接错误
                print('类后接错误')
                return 'None'
            else:
                # reType: ['FUNCTION',function name,(expression type)*]
                # 判断函数中参数的类型是否正确，并返回函数返回值的类型
                functionName = reType[1]
                functionCite = ''
                for i in range(2,len(reType)):
                    functionCite = functionCite + reType[i]
                VarClassParam = self.ClassParam[VarType]
                if (functionName,functionCite) in VarClassParam.Funcs:
                    # funcs type: {(FuncName,FuncCite) : [ClassName(May be parent),ReturnType,(ParamName,ParamType)*]}
                    return VarClassParam.Funcs[(functionName,functionCite)][1]
                else:
                    # 调用的函数未定义
                    print('调用的函数未定义')
                    return 'None'

        if IdType == 'type':
            # 如果是个Int或者bool或者int[]
            if reType[0] == 'FUNCTION':
                # 不是一个类
                print('不是一个类')
                return 'None'
            if reType[0] == 'SQUAREBRACKET':
                # 只有int[]才能接[]
                if VarType == 'INTARRAY':
                    return 'INT'
                else:
                    # 对非数组变量进行下标访问
                    print('对非数组变量进行下标访问')
                    return 'None'
            if reType[0] == 'LENGTH':
                # 只有int[]才能接.length
                if VarType == 'INTARRAY':
                    return 'INT'
                else:
                    # 对非数组变量进行长度访问
                    print('对非数组变量进行长度访问')
                    return 'None'
            if reType[0] == 'BIOP':
                if reType[1] == 'And':
                    # 只有两边都是bool才能用&&
                    if reType[2] == 'BOOL' and VarType == 'BOOL':
                        return 'BOOL'
                    else:
                        # 使用非Bool变量进行&&运算
                        print('使用非Bool变量进行&&运算')
                        return 'None'
                else:
                    # 剩下的全部需要Int
                    if reType[2] == 'INT' and VarType == 'INT':
                        if reType [1] == 'Less':
                            return 'BOOL'
                        else:
                            return 'INT'
                    else:
                        # 使用非整数进行整数运算
                        print('使用非整数进行整数运算')
                        return 'None'
            if reType[0] == 'NULL':
                return VarType

        return 'None'


    # Visit a parse tree produced by MiniJavaParser#THIS.
    def visitTHIS(self, ctx:MiniJavaParser.THISContext):
        reType = self.visit(ctx.expression2)
        if reType == 'None':
            return 'None'
        if reType[0] == 'FUNCTION':
            functionName = reType[1]
            functionCite = ''
            for i in range(2,len(reType)):
                functionCite = functionCite + reType[i]
            VarClassParam = self.ClassParam[self.nowClass]
            if (functionName,functionCite) in VarClassParam.Funcs:
                # funcs type: {(FuncName,FuncCite) : [ClassName(May be parent),ReturnType,(ParamName,ParamType)*]}
                return VarClassParam.Funcs[(functionName,functionCite)][1]
            else:
                # 调用的函数未定义
                print('调用的函数未定义')
                return 'None'
        elif reType[0] == 'NULL':
            return self.nowClass
        else:
            # 错误使用this
            print('错误使用this')
            return 'None'
        
        return 'None'


    # Visit a parse tree produced by MiniJavaParser#NEWINT.
    def visitNEWINT(self, ctx:MiniJavaParser.NEWINTContext):
        reType = self.visit(ctx.expression)
        if reType == 'None':
            return 'None'
        if reType[0] != 'INT':
            # 使用非Int定义数组长度
            print('使用非Int定义数组长度')
            return 'None'
        reType = self.visit(ctx.expression2)
        if reType == 'None':
            return 'None'
        if reType[0] != 'NULL':
            # 新建数组后无法进行操作
            print('新建数组后无法进行操作')
            return 'None'
        
        return 'INTARRAY'

    # Visit a parse tree produced by MiniJavaParser#NEWID.
    def visitNEWID(self, ctx:MiniJavaParser.NEWIDContext):
        Id = str(ctx.Identifier())
        if not Id in self.ClassNames:
            # 新建不存在的类
            print('新建未定义类')
            return 'None'
        else:
            reType = self.visit(ctx.expression2())
            if reType == 'None':
                return 'None'
            # 新建的是类
            if reType[0] != 'NULL' and reType[0] != 'FUNCTION':
                # 对类进行非法操作
                print('对类进行非法操作')
                return 'None'
            if reType[0] == 'NUll':
                return Id
            functionName = reType[1]
            functionCite = ''
            for i in range(2,len(reType)):
                functionCite = functionCite + reType[i]
            VarClassParam = self.ClassParam[Id]
            if (functionName,functionCite) in VarClassParam.Funcs:
                # funcs type: {(FuncName,FuncCite) : [ClassName(May be parent),ReturnType,(ParamName,ParamType)*]}
                return VarClassParam.Funcs[(functionName,functionCite)][1]
            else:
                # 调用的函数未定义
                print('调用的函数未定义')
                return 'None'
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
        return 'INTARRAY'
    
    def visitBOOL(self, ctx:MiniJavaParser.BOOLContext):
        return 'BOOL'

    def visitINT(self, ctx:MiniJavaParser.INTContext):
        return 'INT'

    def visitID(self, ctx:MiniJavaParser.IDContext):
        return str(ctx.Identifier())