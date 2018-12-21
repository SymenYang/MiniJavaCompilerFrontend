import sys

from antlr4 import *
from MiniJavaLexer    import MiniJavaLexer   
from MiniJavaListener import MiniJavaListener
from MiniJavaParser   import MiniJavaParser  
from MiniJavaVisitor   import MiniJavaVisitor  
from CustomFriendlyErrorListener import CustomFriendlyErrorListener
from ClassGetVisitor import ClassGetVisitor
from ClassParamVisitor import ClassParamVisitor
from TypeCheckVisitor import TypeCheckVisitor
from Interpreter import Interpreter

def mainFunc(argv):
    input = FileStream(argv[1])
    lexer = MiniJavaLexer(input=input)
    stream = CommonTokenStream(lexer)
    parser = MiniJavaParser(stream)
    parser.removeErrorListeners()
    ErrorListener = CustomFriendlyErrorListener()
    parser.addErrorListener(ErrorListener)
    tree = parser.goal()
    
    if ErrorListener.HasError:
        print('语法解析错误，退出编译')
        return


    v = ClassGetVisitor()
    v.visit(tree)
    ClassParam = ClassParamVisitor(v.ClassTable,v.FuncTable,v.ParentTable)
    ClassParam.visit(tree)
    if ClassParam.HasError:
        print('类解析错误，退出编译')
        return
    

    TypeChecker = TypeCheckVisitor(v.ClassTable,ClassParam.Classes)
    TypeChecker.visit(tree)
    if TypeChecker.HasError:
        print('类型匹配错误，退出编译')
        return
    
    print('无词法语法错误，开始运行')
    try:
        Intrprtr = Interpreter(ClassParam.Classes,v.ClassTable)
        Intrprtr.visit(tree)
    except Exception as e:
        print('运行错误',e)
    return

if __name__ == '__main__':
    mainFunc(sys.argv)
