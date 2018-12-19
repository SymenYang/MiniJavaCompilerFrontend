import sys

from antlr4 import *

from MiniJavaLexer    import MiniJavaLexer   
from MiniJavaListener import MiniJavaListener
from MiniJavaParser   import MiniJavaParser  
from MiniJavaVisitor   import MiniJavaVisitor  
from ClassGetVisitor import ClassGetVisitor
from ClassParamVisitor import ClassParamVisitor
from GrammarCheckVisitor import GrammarCheckVisitor
from TypeCheckVisitor import TypeCheckVisitor

def mainFunc(argv):
    input = FileStream(argv[1])
    lexer = MiniJavaLexer(input=input)
    stream = CommonTokenStream(lexer)
    parser = MiniJavaParser(stream)
    tree = parser.goal()
    v = ClassGetVisitor()#MiniJavaVisitor()
    v.visit(tree)
    print(v.ParentTable)
    #print(v.FuncTable)
    ClassParam = ClassParamVisitor(v.ClassTable,v.FuncTable,v.ParentTable)
    ClassParam.visit(tree)
    for c in ClassParam.Classes:
        print(ClassParam.Classes[c])
    GrammarChecker = GrammarCheckVisitor()
    GrammarChecker.visit(tree)
    if GrammarChecker.HasError:
        return
    print('Countinue')
    #TypeChecker = TypeCheckVisitor(v.ClassTable,v.FuncTable,v.ParentTable)
    #TypeChecker.visit(tree)

if __name__ == '__main__':
    mainFunc(sys.argv)
