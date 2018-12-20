from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser
from MiniJavaLexer import MiniJavaLexer
import ClassParamVisitor

class Interpreter(MiniJavaVisitor):
    def __init__(self,ClassParamTable,ClassNames):
        self.ClassNames = ClassNames
        self.ClassParamTable = ClassParamTable
        self.ClassVarStack = []
        self.MethodVarStack = []
        self.ClassVars = {}
        self.MethodVars = {}
        self.CallValues = []

    def visitGoal(self,ctx:MiniJavaParser.GoalContext):
        self.visit(ctx.mainClass())

    def visitMainClass(self, ctx:MiniJavaParser.MainClassContext):
        self.visit(ctx.statement())

    def visitClassDeclaration(self, ctx:MiniJavaParser.ClassDeclarationContext):
        print('不该visit这里')

    # 函数调用相关 函数
    def newClass(self,className):
        # 新建一个className类的类并返回初始化好的内部变量表
        retDict = {}
        retDict['\\TYPE'] = className
        ClassParam = self.ClassParamTable[className]
        for key in ClassParam.Vars:
            if ClassParam.Vars[key] == 'INT':
                retDict[key] = 0
            elif ClassParam.Vars[key] == 'BOOL':
                retDict[key] = False
            elif ClassParam.Vars[key] == 'INTARRAY':
                retDict[key] = []
            else:
                retDict[key] = {}#self.newClass(ClassParam.Vars[key])
                retDict[key]['\\TYPE'] = ClassParam.Vars[key]
        return retDict
    
    def pushStack(self):
        self.ClassVarStack.append(self.ClassVars)
        self.MethodVarStack.append(self.MethodVars)
        self.ClassVars = {}
        self.MethodVars = {}
    
    def popStack(self):
        self.ClassVars = self.ClassVarStack.pop()
        self.MethodVars = self.MethodVarStack.pop()

    def checkFunctions(self,funcID,classParam):
        funcName = funcID[0]
        for item in classParam.Funcs:
            if item[0] == funcName:
                paramTuple = item[1]
                funcTuple = funcID[1]
                if len(paramTuple) != len(funcTuple):
                    continue
                sameFlag = True
                for i in range(len(paramTuple)):
                    if paramTuple[i] == funcTuple[i]:
                        # 对应类型相等
                        continue
                    elif funcTuple[i] in self.ClassNames:
                        # 对应类型是一个类
                        if paramTuple[i] in self.ClassParamTable[funcTuple[i]].Parents:
                            # 模版函数该参数类型是调用参数的父类
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
                    return classParam.Funcs[item]
            else:
                continue
        return 'None'

    def callFunc(self,targetClass,funcName,paramValues):
        # target Class: {Class Param}, funcName: string, paramValues : []
        ClassParam = self.ClassParamTable[targetClass['\\TYPE']]
        
        # 得到funcCite
        funcCite = []
        for item in paramValues:
            if isinstance(item,bool):
                funcCite.append('BOOL')
            elif isinstance(item,int):
                funcCite.append('INT')
            elif isinstance(item,list):
                funcCite.append('INTARRAY')
            elif isinstance(item,dict):
                funcCite.append(item['\\TYPE'])
        funcID = (funcName,tuple(funcCite))
        # 得到对应的function 信息
        # [代码所属类名，返回类型，(参数名，参数类型)*，ctx]
        funcParams = self.checkFunctions(funcID,ClassParam)

        # 压栈，设置新类的参数，设置函数参数传入，调用函数，出栈，返回值
        self.pushStack()
        self.ClassVars = targetClass
        self.CallValues = paramValues
        retValue = self.visit(funcParams[-1])
        self.popStack()
        return retValue

    # 函数调用相关 函数 结束

    def visitMethodDeclaration(self, ctx:MiniJavaParser.MethodDeclarationContext):
        IDs = [str(item) for item in ctx.Identifier()[1:]]
        for i in range(len(IDs)):
            self.MethodVars[IDs[i]] = self.CallValues[i]
        varDeclarations = ctx.varDeclaration()
        statements = ctx.statement()
        expression = ctx.expression()
    
        for item in varDeclarations:
            self.visit(item)
        for item in statements:
            self.visit(item)

        return self.visit(expression)
    
    def visitVarDeclaration(self, ctx:MiniJavaParser.VarDeclarationContext):
        atype = self.visit(ctx.atype())
        name = str(ctx.Identifier())

        if atype == 'INT':
            self.MethodVars[name] = 0
        elif atype == 'BOOL':
            self.MethodVars[name] = False
        elif atype == 'INTARRAY':
            self.MethodVars[name] = []
        else:
            self.MethodVars[name] = {}#self.newClass(atype)

        return self.MethodVars[name]

    def visitARRAYSEARCH(self, ctx:MiniJavaParser.ARRAYSEARCHContext):
        array = self.visit(ctx.expression(0))
        pos = self.visit(ctx.expression(1))
        return array[pos]

    def visitLENGTH(self, ctx:MiniJavaParser.LENGTHContext):
        array = self.visit(ctx.expression())
        return len(array)

    def visitFUNCTION(self, ctx:MiniJavaParser.FUNCTIONContext):
        classVar = self.visit(ctx.expression(0))
        funcName = str(ctx.Identifier())
        callValues = []
        expressions = ctx.expression()[1:]
        for item in expressions:
            callValues.append(self.visit(item))
        
        return self.callFunc(classVar,funcName,callValues)

    def visitBIOP(self, ctx:MiniJavaParser.BIOPContext):
        var1 = self.visit(ctx.expression(0))
        var2 = self.visit(ctx.expression(1))
        op = ctx.op
        if op.type == MiniJavaLexer.And:
            return var1 and var2
        if op.type == MiniJavaLexer.Less:
            return var1 < var2
        if op.type == MiniJavaLexer.Add:
            return var1 + var2
        if op.type == MiniJavaLexer.Min:
            return var1 - var2
        if op.type == MiniJavaLexer.Mul:
            return var1 * var2
        
        print('bug了，运算不该运行到这里')

    def visitBOOLLIT(self, ctx:MiniJavaParser.BOOLLITContext):
        boolv = ctx.BOOL
        if boolv.type == MiniJavaLexer.TRUE:
            return True
        else:
            return False
    
    def visitINTLIT(self,ctx:MiniJavaParser.INTLITContext):
        intstr = str(ctx.IntergerLiteral())
        return int(intstr)

    def visitVAR(self, ctx:MiniJavaParser.VARContext):
        Id = str(ctx.Identifier())
        if Id in self.MethodVars:
            return self.MethodVars[Id]
        if Id in self.ClassVars:
            return self.ClassVars[Id]
        print('bug了 不该找变量到这里')

    def visitTHIS(self,ctx:MiniJavaParser.THISContext):
        return self.ClassVars

    def visitNEWINT(self, ctx:MiniJavaParser.NEWINTContext):
        nums = self.visit(ctx.expression())
        return [0 for i in range(nums)]
    
    def visitNEWID(self, ctx:MiniJavaParser.NEWIDContext):
        Id = str(ctx.Identifier())
        return self.newClass(Id)

    def visitNOT(self, ctx:MiniJavaParser.NOTContext):
        value = self.visit(ctx.expression())
        return not value

    def visitBRACKET(self,ctx:MiniJavaParser.BRACKETContext):
        return self.visit(ctx.expression())
    
    def visitCURLYBRACKET(self,ctx:MiniJavaParser.CURLYBRACKETContext):
        statements = ctx.statement()
        for item in statements:
            self.visit(item)
    
    def visitIFELSE(self,ctx:MiniJavaParser.IFELSEContext):
        condition = self.visit(ctx.expression())
        if condition:
            self.visit(ctx.statement(0))
        else:
            self.visit(ctx.statement(1))
    
    def visitWHILE(self,ctx:MiniJavaParser.WHILEContext):
        while(self.visit(ctx.expression())):
            self.visit(ctx.statement())
    
    def visitPRINT(self,ctx:MiniJavaParser.PRINTContext):
        intValue = self.visit(ctx.expression())
        print(intValue)
    
    def visitASSIGN(self, ctx:MiniJavaParser.ASSIGNContext):
        Id = str(ctx.Identifier())
        value = self.visit(ctx.expression())
        if Id in self.MethodVars:
            self.MethodVars[Id] = value
            return
        if Id in self.ClassVars:
            self.ClassVars[Id] = value
            return
        
        print(Id,value,self.ClassVars,self.MethodVars)
        print('Bug了 赋值不该运行到这里')
    
    def visitARRAYASSIGN(self, ctx:MiniJavaParser.ARRAYASSIGNContext):
        Id = str(ctx.Identifier())
        pos = self.visit(ctx.expression(0))
        value = self.visit(ctx.expression(1))
        array = None
        if Id in self.MethodVars:
            array = self.MethodVars[Id]
        if Id in self.ClassVars:
            array = self.ClassVars[Id]
        
        if pos >= len(array):
            print('数组访问越界 位置 ' + ctx.expression(0).start.line + ':' + ctx.expression(0).start.column)
            exit(0)
        
        array[pos] = value

    # return type string
    def visitINTARRAY(self,ctx:MiniJavaParser.INTARRAYContext):
        return 'INTARRAY'
    
    def visitBOOL(self, ctx:MiniJavaParser.BOOLContext):
        return 'BOOL'

    def visitINT(self, ctx:MiniJavaParser.INTContext):
        return 'INT'

    def visitID(self, ctx:MiniJavaParser.IDContext):
        return str(ctx.Identifier())
