from antlr4.error import ErrorListener

class CustomFriendlyErrorListener(ErrorListener.ErrorListener):
    def __init__(self,idStr = '词法'):
        super(CustomFriendlyErrorListener,self).__init__()
        self.HasError = False
        self.idStr = idStr

    def syntaxError(self, recognizer, offendingSymbol, line, column, msg, e):
        self.HasError = True
        print('编译器' + self.idStr + '解析错误，行:' + str(line) + ' 列:' + str(column) + ' 错误信息是:' + msg)
        #print(recognizer,offendingSymbol,line,column,msg,e)