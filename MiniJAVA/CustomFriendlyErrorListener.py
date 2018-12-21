from antlr4.error import ErrorListener

class CustomFriendlyErrorListener(ErrorListener.ErrorListener):
    def __init__(self):
        super(CustomFriendlyErrorListener,self).__init__()
        self.HasError = False

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        self.HasError = True
        print('编译器解析错误，行:' + str(line) + ' 列:' + str(column) + ' 错误信息是:' + msg)
        #print(recognizer,offendingSymbol,line,column,msg,e)