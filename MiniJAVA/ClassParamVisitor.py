from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser

class ClassParam:
    def __init__(self,FuncTable,ParentTable,ClassName):
        '''
        self.Funcs type: {(funcName,funcStr):[returnType,(param name,param type)* ]}
        self.Vars type: { varName : varType}
        '''
        self.Funcs = {}
        self.Vars = {} 
        self.name = ClassName
        if not ClassName in ParentTable:
            return
        parent = ParentTable[ClassName]
        while (parent != 'None'):
            for func in FuncTable:
                if func[0] == parent:
                    self.Funcs[(func[1],func[2])] = FuncTable[func]
            parent = ParentTable[parent]
        for func in FuncTable:
            if func[0] == ClassName:
                self.Funcs[(func[1],func[2])] = FuncTable[func]

    def extractVars(self,Classes,ParentTable):
        if not self.name in ParentTable:
            return
        parent = ParentTable[self.name]
        while (parent != 'None'):
            pClass= Classes[parent]
            for varname in pClass.Vars:
                if varname in self.Vars:
                    pass
                else:
                    self.Vars[varname] = pClass.Vars[varname]
            parent = ParentTable[parent]

    # debug use
    def __str__(self):
        return self.name + ':\n' + self.Funcs.__str__() + '\n' + self.Vars.__str__()

class ClassParamVisitor(MiniJavaVisitor):
    def __init__(self,ClassTable,FuncTable,ParentTable):
        super(ClassParamVisitor,self).__init__()
        self.Types = ClassTable.copy()
        self.Types['INT'] = 'type'
        self.Types['INTARRAY'] = 'type'
        self.Types['BOOL'] = 'type'
        print(ClassTable)
        self.Classes = {}
        self.ParentTable = ParentTable
        for className in ClassTable:
            self.Classes[className] = ClassParam(FuncTable,ParentTable,className)
        
        self.nowClass = ''
        self.HasError = False
    
    def visitGoal(self,ctx:MiniJavaParser.GoalContext):
        super(ClassParamVisitor,self).visitGoal(ctx)
        for item in self.Classes:
            self.Classes[item].extractVars(self.Classes,self.ParentTable)

    def visitClassDeclaration(self, ctx:MiniJavaParser.ClassDeclarationContext):
        self.nowClass = str(ctx.Identifier(0))
        super(ClassParamVisitor,self).visitClassDeclaration(ctx)
    
    def visitMethodDeclaration(self,ctx:MiniJavaParser.MethodDeclarationContext):
        typeStr = self.visit(ctx.atype(0))
        IDs = ctx.Identifier()[1:]
        typeList = [('\\RETURN',typeStr)]
        for i in range(len(IDs)):
            typeList.append((str(IDs[i]),self.visit(ctx.atype(i + 1))))
        for i in range(len(typeList)):
            if not typeList[i][1] in self.Types:
                if typeList[i][0] == '\\RETURN':
                    print('类型错误 ' + self.nowClass + ' 类中方法 ' + str(ctx.Identifier()[0]) + '返回未定义类型' + typeList[i][1] + '位置 ' + str(ctx.atype(0).start.line) + ':' + str(ctx.atype(0).start.column))
                else:
                    print('类型错误 ' + self.nowClass + ' 类中方法 ' + str(ctx.Identifier()[0]) + ' 参数 ' + typeList[i][0] + '使用未定义类型' + typeList[i][1] + '位置 ' + str(ctx.atype(i).start.line) + ':' + str(ctx.atype(i).start.column))
                self.HasError = True

    def visitVarDeclaration(self,ctx:MiniJavaParser.VarDeclarationContext):
        typeStr = self.visit(ctx.atype())
        varName = str(ctx.Identifier())
        if not typeStr in self.Types:
            print('类型错误，' + self.nowClass + ' 类中变量：' + varName + '得到未定义类型：' + typeStr + '位置 ' + str(ctx.atype().start.line) + ':' + str(ctx.atype().start.column))
            self.HasError = True
            return
        if self.nowClass != '':
            self.Classes[self.nowClass].Vars[varName] = typeStr
    

    # return type string
    def visitINTARRAY(self,ctx:MiniJavaParser.INTARRAYContext):
        return 'INTARR'
    
    def visitBOOL(self, ctx:MiniJavaParser.BOOLContext):
        return 'BOOL'

    def visitINT(self, ctx:MiniJavaParser.INTContext):
        return 'INT'

    def visitID(self, ctx:MiniJavaParser.IDContext):
        return str(ctx.Identifier())