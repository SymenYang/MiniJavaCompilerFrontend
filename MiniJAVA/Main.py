import sys

from antlr4 import *
from MiniJavaLexer    import MiniJavaLexer   
from MiniJavaListener import MiniJavaListener
from MiniJavaParser   import MiniJavaParser  
from MiniJavaVisitor   import MiniJavaVisitor  
from ClassGetVisitor import ClassGetVisitor
from ClassParamVisitor import ClassParamVisitor
from TypeCheckVisitor import TypeCheckVisitor
from Interpreter import Interpreter

def mainFunc(argv):
    input = FileStream(argv[1])
    lexer = MiniJavaLexer(input=input)
    stream = CommonTokenStream(lexer)
    parser = MiniJavaParser(stream)
    tree = parser.goal()
    v = ClassGetVisitor()
    v.visit(tree)
    ClassParam = ClassParamVisitor(v.ClassTable,v.FuncTable,v.ParentTable)
    ClassParam.visit(tree)
    print(ClassParam.Classes['Fac'].Funcs)
    if ClassParam.HasError:
        return
    TypeChecker = TypeCheckVisitor(v.ClassTable,ClassParam.Classes)
    TypeChecker.visit(tree)
    if TypeChecker.HasError:
        return
    print('success')

if __name__ == '__main__':
    mainFunc(sys.argv)
