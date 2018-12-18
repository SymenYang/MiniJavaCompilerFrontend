from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser

class ClassGetVisitor(MiniJavaVisitor):
    def __init__(self):
        super(ClassGetVisitor,self).__init__()
        self.ClassTable = {}
        self.FuncTable = {}
        self.nowClass = ''

    def visitMainClass(self, ctx:MiniJavaParser.MainClassContext):
        print('visited main class, name:',str(ctx.Identifier()[0]))
        self.ClassTable[str(ctx.Identifier()[0])] = 'MainClass'
        self.nowClass = str(ctx.Identifier()[0])
        super(ClassGetVisitor,self).visitMainClass(ctx)
    
    def visitClassDeclaration(self, ctx:MiniJavaParser.ClassDeclarationContext):
        print('visited class, name:',str(ctx.Identifier()[0]))
        self.ClassTable[str(ctx.Identifier()[0])] = 'Class'
        self.nowClass = str(ctx.Identifier()[0])
        super(ClassGetVisitor,self).visitClassDeclaration(ctx)
    
    def visitMethodDeclaration(self, ctx:MiniJavaParser.MethodDeclarationContext):
        typeStr = self.visit(ctx.atype(0))
        print('visited method, name:',self.nowClass,str(ctx.Identifier()[0]),'type:',typeStr)
        self.FuncTable[(self.nowClass,str(ctx.Identifier()[0]))] = typeStr
    
    def visitINTARRAY(self,ctx:MiniJavaParser.INTARRAYContext):
        return 'INTARR'
    
    def visitBOOL(self, ctx:MiniJavaParser.BOOLContext):
        return 'BOOL'

    # Visit a parse tree produced by MiniJavaParser#INT.
    def visitINT(self, ctx:MiniJavaParser.INTContext):
        return 'INT'

    # Visit a parse tree produced by MiniJavaParser#ID.
    def visitID(self, ctx:MiniJavaParser.IDContext):
        return str(ctx.Identifier())