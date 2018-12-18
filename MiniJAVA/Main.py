import sys

from antlr4 import *

from MiniJavaLexer    import MiniJavaLexer   
from MiniJavaListener import MiniJavaListener
from MiniJavaParser   import MiniJavaParser  
from MiniJavaVisitor   import MiniJavaVisitor  
from ClassGetVisitor import ClassGetVisitor
from TypeCheckVisitor import TypeCheckVisitor

def mainFunc(argv):
    input = FileStream(argv[1])
    lexer = MiniJavaLexer(input=input)
    stream = CommonTokenStream(lexer)
    parser = MiniJavaParser(stream)
    tree = parser.goal()
    v = ClassGetVisitor()#MiniJavaVisitor()
    print(v.visit(tree))
    print(v.ClassTable)
    print(v.FuncTable)
    TypeChecker = TypeCheckVisitor(v.ClassTable,v.FuncTable)

if __name__ == '__main__':
    mainFunc(sys.argv)
