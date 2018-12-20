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
                retDict[key] = self.newClass(ClassParam.Vars[key])
        return retDict
    
    def pushStack(self):
        self.ClassVarStack.append(self.ClassVars)
        self.MethodVarStack.append(self.MethodVars)
        self.ClassVars = {}
        self.MethodVars = {}
    
    def popStack(self):
        self.ClassVars = self.ClassVarStack.pop()
        self.MethodVars = self.MethodVarsStack.pop()

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
                    return classParam.Funcs[item][1]
            else:
                continue
        return 'None'

    def callFunc(self,targetClass,funcName,paramValues):
        # target Class: string, funcName: string, paramValues : []
        ClassParam = self.ClassParamTable[targetClass['\\TYPE']]
        
        # 得到funcCite
        funcCite = []
        for item in paramValues:
            if isinstance(item,int):
                funcCite.append('INT')
            elif isinstance(item,bool):
                funcCite.append('BOOL')
            elif isinstance(item,list):
                funcCite.append('INTARRAY')
            elif isinstance(item,dict):
                funcCite.append(item['\\TYPE'])
        funcID = (funcName,tuple(funcCite))
        # 得到对应的function 信息
        # [代码所属类名，返回类型，(参数名，参数类型)*，ctx]
        funcParams = self.checkFunctions(funcID,ClassParam)

        # 压栈，设置函数参数传入，调用函数，出栈，返回值
        self.pushStack()
        self.CallValues = paramValues
        retValue = self.visit(funcParams[-1])
        self.popStack()
        return retValue

    # 函数调用相关 函数 结束

    def visitMethodDeclaration(self, ctx:MiniJavaParser.MethodDeclarationContext):
        IDs = [self.visit(item) for item in ctx.Identifier()[1:]]
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
        pass


    # return type string
    def visitINTARRAY(self,ctx:MiniJavaParser.INTARRAYContext):
        return 'INTARRAY'
    
    def visitBOOL(self, ctx:MiniJavaParser.BOOLContext):
        return 'BOOL'

    def visitINT(self, ctx:MiniJavaParser.INTContext):
        return 'INT'

    def visitID(self, ctx:MiniJavaParser.IDContext):
        return str(ctx.Identifier())
