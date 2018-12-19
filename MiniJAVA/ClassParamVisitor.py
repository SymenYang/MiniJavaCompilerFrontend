from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser

class ClassParam:
    def __init__(self,FuncTable,ParentTable,ClassName):
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
        self.Types = ClassTable
        print(ClassTable)
        self.Classes = {}
        self.ParentTable = ParentTable
        for className in ClassTable:
            self.Classes[className] = ClassParam(FuncTable,ParentTable,className)
        
        self.nowClass = ''
    
    def visitGoal(self,ctx:MiniJavaParser.GoalContext):
        super(ClassParamVisitor,self).visitGoal(ctx)
        for item in self.Classes:
            self.Classes[item].extractVars(self.Classes,self.ParentTable)

    def visitClassDeclaration(self, ctx:MiniJavaParser.ClassDeclarationContext):
        self.nowClass = str(ctx.Identifier(0))
        super(ClassParamVisitor,self).visitClassDeclaration(ctx)
    
    def visitMethodDeclaration(self,ctx:MiniJavaParser.MethodDeclarationContext):
        self.nowClass = ''
    
    def visitVarDeclaration(self,ctx:MiniJavaParser.VarDeclarationContext):
        typeStr = self.visit(ctx.atype())
        print(typeStr)
        varName = str(ctx.Identifier())
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