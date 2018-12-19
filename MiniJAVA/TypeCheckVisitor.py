from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser
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