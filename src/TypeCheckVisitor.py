from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser
from MiniJavaLexer import MiniJavaLexer
import ClassParamVisitor

class TypeCheckVisitor(MiniJavaVisitor):
    def __init__(self,TypeTable,ClassParamTable):
        '''
        Expression 返回这个表达式最终的type
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
        # 将函数参数也计入method的vars
        atypes = [self.visit(item) for item in ctx.atype()[1:]]
        Ids = [str(item) for item in ctx.Identifier()[1:]]
        for i in range(len(Ids)):
            self.methodVars[Ids[i]] = atypes[i]
        
        for item in ctx.varDeclaration():
            self.visit(item)
        for item in ctx.statement():
            self.visit(item)
        retType = self.visit(ctx.atype(0))
        retValueType = self.visit(ctx.expression())
        if retValueType == 'None':
            return 'None'
        elif retValueType != retType:
            self.HasError = True
            print('函数返回值类型不匹配 位置' + str(ctx.expression().start.line) + ':' + str(ctx.expression().start.column))
            return 'None'
        return

    def visitVarDeclaration(self, ctx:MiniJavaParser.VarDeclarationContext):
        vartype = self.visit(ctx.atype())
        if not vartype in self.Types:
            self.HasError = True
            # TODO: 变量定义类型错误提示
            print('变量定义类型错误 位置' + str(ctx.atype().start.line) + ':' + str(ctx.atype().start.column))
            return
        varname = str(ctx.Identifier())
        self.methodVars[varname] = vartype
        return
    

    # Visit a parse tree produced by MiniJavaParser#NEWID.
    def visitNEWID(self, ctx:MiniJavaParser.NEWIDContext):
        Id = str(ctx.Identifier())
        if Id in self.ClassNames:
            return Id
        else:
            # 新建未定义类
            self.HasError = True
            print('新建未定义类 位置' + str(ctx.Identifier().getSymbol().line) + ':' + str(ctx.Identifier().getSymbol().column))
            return 'None'
        
        return 'None'


    # Visit a parse tree produced by MiniJavaParser#NEWINT.
    def visitNEWINT(self, ctx:MiniJavaParser.NEWINTContext):
        reType = self.visit(ctx.expression())
        if reType == 'None':
            return 'None'
        if reType == 'INT':
            return 'INTARRAY'
        else:
            # 使用非整数申明数组
            self.HasError = True
            print('使用非整数申明数组 位置' + str(ctx.expression().start.line) + ':' + str(ctx.expression().start.column))
            return 'None'
        
        return 'None'


    # Visit a parse tree produced by MiniJavaParser#NOT.
    def visitNOT(self, ctx:MiniJavaParser.NOTContext):
        reType = self.visit(ctx.expression())
        if reType == 'None':
            return 'None'
        if reType == 'BOOL':
            return 'BOOL'
        else:
            # 取反非Bool值
            self.HasError = True
            print('取反非Bool值 位置' + str(ctx.expression().start.line) + ':' + str(ctx.expression().start.column))
            return 'None'

        return 'None'


    # Visit a parse tree produced by MiniJavaParser#BRACKET.
    def visitBRACKET(self, ctx:MiniJavaParser.BRACKETContext):
        reType = self.visit(ctx.expression())
        if reType == 'None':
            return 'None'
        return reType


    # Visit a parse tree produced by MiniJavaParser#VAR.
    def visitVAR(self, ctx:MiniJavaParser.VARContext):
        Id = str(ctx.Identifier())
        # 判断变量是否定义
        if Id in self.classVars or Id in self.methodVars:
            if Id in self.classVars:
                return self.classVars[Id]
            else:
                return self.methodVars[Id]
        else:
            # 使用未定义变量
            self.HasError = True
            print('使用未定义变量 位置' + str(ctx.Identifier().getSymbol().line) + ':' + str(ctx.Identifier().getSymbol().column))
            return 'None'
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#ARRAYSEARCH.
    def visitARRAYSEARCH(self, ctx:MiniJavaParser.ARRAYSEARCHContext):
        reType = self.visit(ctx.expression(0))
        if reType == 'None':
            return 'None'
        if reType != 'INTARRAY':
            # 对非数组使用下标访问
            self.HasError = True
            print('对非数组使用下标访问 位置' + str(ctx.expression(0).start.line) + ':' + str(ctx.expression(0).start.column))
            return 'None'

        reType = self.visit(ctx.expression(1))
        if reType == 'None':
            return 'None'
        if reType != 'INT':
            # 使用非整数作为下标
            self.HasError = True
            print('使用非整数作为下标 位置' + str(ctx.expression(1).start.line) + ':' + str(ctx.expression(1).start.column))
            return 'None'
        else:
            return 'INT'
        
        return 'None'

    def getOP(self,ops):
        if ops.type == MiniJavaLexer.And:
            return 'And'
        if ops.type == MiniJavaLexer.Add:
            return 'Add'
        if ops.type == MiniJavaLexer.Min:
            return 'Min'
        if ops.type == MiniJavaLexer.Mul:
            return 'Mul'
        if ops.type == MiniJavaLexer.Less:
            return 'Less'

    # Visit a parse tree produced by MiniJavaParser#BIOP.
    def visitBIOP(self, ctx:MiniJavaParser.BIOPContext):
        Type1 = self.visit(ctx.expression(0))
        Type2 = self.visit(ctx.expression(1))
        if Type1 == 'None' or Type2 == 'None':
            return 'None'
        op = self.getOP(ctx.op)
        if op == 'And':
            if Type1 == 'BOOL' and Type2 == 'BOOL':
                return 'BOOL'
            else:
                # 使用非BOOL值进行&&运算
                self.HasError = True
                print('使用非BOOL值进行&&运算 位置' + str(ctx.op.line) + ':' + str(ctx.op.column))
                return 'None'
        elif op == 'Less':
            if Type1 == 'INT' and Type2 == 'INT':
                return 'BOOL'
            else:
                # 使用非整数进行比较运算
                self.HasError = True
                print('使用非整数进行比较运算 位置' + str(ctx.op.line) + ':' + str(ctx.op.column))
                return 'None'
        else:
            if Type1 == 'INT' and Type2 == 'INT':
                return 'INT'
            else:
                # 使用非整数进行整数运算
                self.HasError = True
                print('使用非整数进行整数运算 位置' + str(ctx.op.line) + ':' + str(ctx.op.column))
                return 'None'
        return 'None'
        #return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#LENGTH.
    def visitLENGTH(self, ctx:MiniJavaParser.LENGTHContext):
        reType = self.visit(ctx.expression())
        if reType == 'None':
            return 'None'
        if reType != 'INTARRAY':
            # 获取非数组的length
            self.HasError = True
            print('获取非数组的length 位置' + str(ctx.expression().start.line) + ':' + str(ctx.expression().start.column))
            return 'None'
        return 'INT'
        return self.visitChildren(ctx)


    # Visit a parse tree produced by MiniJavaParser#THIS.
    def visitTHIS(self, ctx:MiniJavaParser.THISContext):
        return self.nowClass


    # Visit a parse tree produced by MiniJavaParser#BOOLLIT.
    def visitBOOLLIT(self, ctx:MiniJavaParser.BOOLLITContext):
        return 'BOOL'


    # Visit a parse tree produced by MiniJavaParser#INTLIT.
    def visitINTLIT(self, ctx:MiniJavaParser.INTLITContext):
        return 'INT'

    def checkFunctions(self,funcID,classParam):
        funcName = funcID[0]
        FuncReturn = 'None'
        FuncBelongs = []
        for item in classParam.Funcs:
            if item[0] == funcName:
                paramTuple = item[1]
                funcTuple = funcID[1]
                if len(paramTuple) != len(funcTuple):
                    continue
                sameFlag = True
                hasDistance = False
                for i in range(len(paramTuple)):
                    if paramTuple[i] == funcTuple[i]:
                        # 对应类型相等
                        continue
                    elif funcTuple[i] in self.ClassNames:
                        # 对应类型是一个类
                        if paramTuple[i] in self.ClassParam[funcTuple[i]].Parents:
                            # 模版函数该参数类型是调用参数的父类
                            hasDistance = True
                            continue
                        else:
                            # 模版函数该参数类型不是调用参数的父类
                            sameFlag = False
                            break
                    else:
                        # 不对应且不是一个类
                        sameFlag = False
                        break
                if sameFlag:
                    #return classParam.Funcs[item][1]
                    # 记录为一个可能的retFunc
                    # 更改加入功能：若参数完全匹配，则直接返回，否则查看是否有都满足的可能
                    FuncReturn = classParam.Funcs[item][1]
                    if not hasDistance:
                        return FuncReturn,[]
                    FuncBelongs.append(classParam.Funcs[item][0])
                    if len(FuncBelongs) > 1:
                        # 有一个冲突问题
                        return 'COLLISION',FuncBelongs
            else:
                continue
        return FuncReturn,FuncBelongs

    # Visit a parse tree produced by MiniJavaParser#FUNCTION.
    def visitFUNCTION(self, ctx:MiniJavaParser.FUNCTIONContext):
        varType = self.visit(ctx.expression(0))
        if varType == 'None':
            return 'None'

        if not varType in self.ClassNames:
            # 使用不是类的变量调用函数
            self.HasError = True
            print('使用不是类的变量调用函数 位置' + str(ctx.expression(0).start.line) + ':' + str(ctx.expression(0).start.column))
            return 'None'

        funcName = str(ctx.Identifier())
        expressions = ctx.expression()[1:]
        reTypes = [self.visit(item) for item in expressions]
        if 'None' in reTypes:
            return 'None'

        funcCite = []
        for item in reTypes:
            funcCite.append(item)
        funcCite = tuple(funcCite)
        
        classParam = self.ClassParam[varType]
        funcID = (funcName,funcCite)
        funcCheck,Belongs = self.checkFunctions(funcID,classParam)
        if funcCheck == 'None':
            # 使用未定义函数
            self.HasError = True
            print('使用未定义函数 位置' + str(ctx.Identifier().getSymbol().line) + ':' + str(ctx.Identifier().getSymbol().column))
            return 'None'
            
        elif funcCheck == 'COLLISION':
            # 函数冲突
            print('使用的函数有多于一个满足的解释：位置' + str(ctx.Identifier().getSymbol().line) + ':' + str(ctx.Identifier().getSymbol().column) + ' 分别为',end = '')
            for item in Belongs:
                print(item + '.' + funcName + ' , ',end = '')
            print('')
            self.HasError = True
            return 'None'
        else:
            return funcCheck
        
        return 'None'

    # Visit a parse tree produced by MiniJavaParser#IFELSE.
    def visitIFELSE(self, ctx:MiniJavaParser.IFELSEContext):
        reType = self.visit(ctx.expression())
        if reType == 'None':
            pass
        elif reType != 'BOOL':
            # if()中使用非bool值
            self.HasError = True
            print('if()中使用非bool值 位置' + str(ctx.expression().start.line) + ':' + str(ctx.expression().start.column))
        self.visit(ctx.statement(0))
        self.visit(ctx.statement(1))
        return 'None'


    # Visit a parse tree produced by MiniJavaParser#WHILE.
    def visitWHILE(self, ctx:MiniJavaParser.WHILEContext):
        reType = self.visit(ctx.expression())
        if reType != 'BOOL':
            # while()中使用非bool值
            self.HasError = True
            print('while()中使用非bool值 位置' + str(ctx.expression().start.line) + ':' + str(ctx.expression().start.column))
        self.visit(ctx.statement())
        return 'None'


    # Visit a parse tree produced by MiniJavaParser#PRINT.
    def visitPRINT(self, ctx:MiniJavaParser.PRINTContext):
        reType = self.visit(ctx.expression())
        if reType == 'None':
            return 'None'
        if reType != 'INT':
            # println()中使用非int值
            self.HasError = True
            print('println()中使用非int值 位置' + str(ctx.expression().start.line) + ':' + str(ctx.expression().start.column))
        return 'None'


    # Visit a parse tree produced by MiniJavaParser#ASSIGN.
    def visitASSIGN(self, ctx:MiniJavaParser.ASSIGNContext):
        Id = str(ctx.Identifier())
        if not (Id in self.methodVars or Id in self.classVars):
            # 使用未定义变量
            self.HasError = True
            print('使用未定义变量 位置' + str(ctx.Identifier().getSymbol().line) + ':' + str(ctx.Identifier().getSymbol().column))
            self.visit(ctx.expression())
            return 'None'
        
        IdType = ''
        if Id in self.methodVars:
            IdType = self.methodVars[Id]
        else:
            IdType = self.classVars[Id]
        
        reType = self.visit(ctx.expression())
        if reType == 'None':
            return 'None'
        if reType != IdType:
            if IdType in self.ClassNames and reType in self.ClassNames:
                if IdType in self.ClassParam[reType].Parents:
                    # 子类赋值给父类变量
                    pass
                else:
                    self.HasError = True
                    print('赋值类型错误 位置' + str(ctx.expression().start.line) + ':' + str(ctx.expression().start.column))
            else:
                # 赋值类型错误
                self.HasError = True
                print('赋值类型错误 位置' + str(ctx.expression().start.line) + ':' + str(ctx.expression().start.column))
            return 'None'

        return 'None'


    # Visit a parse tree produced by MiniJavaParser#ARRAYASSIGN.
    def visitARRAYASSIGN(self, ctx:MiniJavaParser.ARRAYASSIGNContext):
        reType = self.visit(ctx.expression(0))
        if reType == 'None':
            self.visit(ctx.expression(1))
            return 'None'
        if reType != 'INT':
            # 使用非int作为下标
            self.HasError = True
            print('使用非int作为下标 位置' + str(ctx.expression(0).start.line) + ':' + str(ctx.expression(0).start.column))
            self.visit(ctx.expression(1))
            return 'None'
        
        reType = self.visit(ctx.expression(1))
        if reType == 'None':
            return 'None'
        if reType != 'INT':
            # 使用非int给数组中元素赋值
            self.HasError = True
            print('使用非int给数组中元素赋值 位置' + str(ctx.expression(1).start.line) + ':' + str(ctx.expression(1).start.column))
            return 'None'
    

    # return type string
    def visitINTARRAY(self,ctx:MiniJavaParser.INTARRAYContext):
        return 'INTARRAY'
    
    def visitBOOL(self, ctx:MiniJavaParser.BOOLContext):
        return 'BOOL'

    def visitINT(self, ctx:MiniJavaParser.INTContext):
        return 'INT'

    def visitID(self, ctx:MiniJavaParser.IDContext):
        return str(ctx.Identifier())
