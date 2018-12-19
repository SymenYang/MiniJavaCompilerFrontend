from antlr4 import *
from MiniJavaVisitor   import MiniJavaVisitor
from MiniJavaParser import MiniJavaParser

class TypeCheckVisitor(MiniJavaVisitor):
    def __init__(self,ClassTable,FuncTable):
        super(TypeCheckVisitor,self).__init__()
        self.Types = ClassTable
        self.Types['INTARR'] = 'type'
        self.Types['INT'] = 'type'
        self.Types['BOOL'] = 'type'

        self.FuncTypes = FuncTable
        self.BigWrong = False
        for item in self.FuncTypes:
            if not self.FuncTypes[item] in self.Types:
                print('方法返回类型错误,方法：' + item[0] + '.' + item[1] + ' 得到未知类型：' + self.FuncTypes[item])
                self.BigWrong = True
        # Expression2 return (OP String,[SubOP String]*,Type0,Type1...)
        # Expression return type

        self.ClassVars = {}
        self.MethodVars = {}
        self.ClassFlag = False

    def visitClassDeclaration(self, ctx:MiniJavaParser.ClassDeclarationContext):
        if self.BigWrong:
            return None
        self.ClassVars = {}
        self.MethodVars = {}
        self.ClassFlag = True
        super(TypeCheckVisitor,self).visitClassDeclaration(ctx)

    def visitMethodDeclaration(self, ctx:MiniJavaParser.MethodDeclarationContext):
        if self.BigWrong:
            return None
        self.ClassFlag = False
        self.MethodVars = {}
        super(TypeCheckVisitor,self).visitClassDeclaration(ctx)

    def visitVarDeclaration(self, ctx:MiniJavaParser.VarDeclarationContext):
        if self.BigWrong:
            return None
        typeStr = self.visit(ctx.atype())
        varName = str(ctx.Identifier())
        if not (typeStr in self.Types):
            print('变量类型错误, ' + varName + ' 指定为未定义类型 ' + typeStr + ' ' + str(ctx.Identifier().getSymbol().line) + ':' + str(ctx.Identifier().getSymbol().column))
            return
        if self.ClassFlag:
            self.ClassVars[varName] = typeStr
        else:
            self.MethodVars[varName] = typeStr

    # Expr
    def visitTRUEFALSE(self, ctx:MiniJavaParser.TRUEFALSEContext):
        if self.BigWrong:
            return None
        reType = self.visit( ctx.expression2() )
        if reType == None:
            return reType
        if reType[0] != 'BIOP' and reType[0] != 'NULL':
            print('错误用法，Bool常量后接非法操作' + ctx.expression2().getSymbol().line + ':' + ctx.expression2().getSymbol().column)
            return None
        if reType[0] == 'BIOP':
            if reType[1] != 'And':
                print('错误用法，Bool常量后接非法操作'+ ctx.expression2().getSymbol().line + ':' + ctx.expression2().getSymbol().column)
                return None
        return 'BOOL'

    # Expr
    def visitINTLIT(self, ctx:MiniJavaParser.INTLITContext):
        if self.BigWrong:
            return None
        reType = self.visit( ctx.expression2() )
        if reType == None:
            return reType
        if reType[0] != 'BIOP' and reType[0] != 'NULL':
            print('错误用法，Int常量后接非法操作' + ctx.expression2().getSymbol().line + ':' + ctx.expression2().getSymbol().column)
            return None 
        if reType[0] == 'BIOP':
            if reType[1] == 'And':
                print('错误用法，Int常量后接非法操作' + ctx.expression2().getSymbol().line + ':' + ctx.expression2().getSymbol().column)
                return None
            if reType[1] == 'Less':
                return 'BOOL'
        return 'INT'


    # Expr
    def visitVAR(self, ctx:MiniJavaParser.VARContext):
        if self.BigWrong:
            return None
        ID = ctx.Identifier()
        reType = self.visit(ctx.expression2())
        if reType == None:
            return None
        #变量不存在
        if not (ID in self.ClassVars or ID in self.MethodVars):
            print('使用未定义变量:' + ID  + str(ctx.Identifier().getSymbol().line) + ':' + str(ctx.Identifier().getSymbol().column))
            return None
        Type = ''
        if ID in self.ClassVars:
            Type = self.ClassVars[ID]
        else:
            Type = self.MethodVars[ID]
        TypeKind = self.Types[Type]
        #如果变量是个class,检查方法存不存在
        if TypeKind == 'Class' or TypeKind == 'MainClass':
            # 类只能接 .functino()
            if reType[0] == 'FUNCTION':
                funcName = reType[1]
                # TODO 还要写参数的类别识别，需要更改table
            else:
                print('类 ' + ID + '使用非法操作' + str(ctx.Identifier().getSymbol().line) + ':' + str(ctx.Identifier().getSymbol().column))
                return None
        # 如果变量是个Type，检查后接expression2合法与否
        return self.visitChildren(ctx)


    # Expr
    def visitTHIS(self, ctx:MiniJavaParser.THISContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Expr
    def visitNEWINT(self, ctx:MiniJavaParser.NEWINTContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Expr
    def visitNEWID(self, ctx:MiniJavaParser.NEWIDContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Expr
    def visitNOT(self, ctx:MiniJavaParser.NOTContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Expr
    def visitBRACKET(self, ctx:MiniJavaParser.BRACKETContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Expr2
    def visitSQUAREBRACKET(self, ctx:MiniJavaParser.SQUAREBRACKETContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Expr2
    def visitLENGTH(self, ctx:MiniJavaParser.LENGTHContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Expr2
    def visitFUNCTION(self, ctx:MiniJavaParser.FUNCTIONContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Expr2
    def visitBIOP(self, ctx:MiniJavaParser.BIOPContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Expr2
    def visitNULL(self, ctx:MiniJavaParser.NULLContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Stat
    def visitCURLYBRACKET(self, ctx:MiniJavaParser.CURLYBRACKETContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Stat
    def visitIFELSE(self, ctx:MiniJavaParser.IFELSEContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Stat
    def visitWHILE(self, ctx:MiniJavaParser.WHILEContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Stat
    def visitPRINT(self, ctx:MiniJavaParser.PRINTContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Stat
    def visitASSIGN(self, ctx:MiniJavaParser.ASSIGNContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)


    # Stat
    def visitARRAYASSIGN(self, ctx:MiniJavaParser.ARRAYASSIGNContext):
        if self.BigWrong:
            return None
        return self.visitChildren(ctx)

    def visitINTARRAY(self,ctx:MiniJavaParser.INTARRAYContext):
        return 'INTARR'
    
    def visitBOOL(self, ctx:MiniJavaParser.BOOLContext):
        return 'BOOL'

    def visitINT(self, ctx:MiniJavaParser.INTContext):
        return 'INT'

    def visitID(self, ctx:MiniJavaParser.IDContext):
        return str(ctx.Identifier())