grammar Expr;		
prog:	expr ;
expr:	'class' ID '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' ID ')' '{' Statement '}' '}'
    ;
Statement : 'true' ;
ID : [a-zA-Z_] [a-zA-Z0-9_]*;
NEWLINE : [\r\n]+ ;
INT     : [0-9]+ ;
WS : [ \t\r\n]+ -> skip ;