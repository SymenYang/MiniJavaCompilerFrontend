import sys

from antlr4 import *

from MiniJavaLexer    import MiniJavaLexer   
from MiniJavaListener import MiniJavaListener
from MiniJavaParser   import MiniJavaParser  
from MiniJavaVisitor   import MiniJavaVisitor  

def mainFunc(argv):
    input = FileStream(argv[1])
    lexer = MiniJavaLexer(input=input)
    stream = CommonTokenStream(lexer)
    parser = MiniJavaParser(stream)
    tree = parser.goal()
    v = MiniJavaVisitor()
    print(v.visit(tree))

if __name__ == '__main__':
    mainFunc(sys.argv)
