grammar MiniJava;

goal : mainClass (classDeclaration)* ;
mainClass : 'class' Identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '{' statement '}' '}' ;
classDeclaration: 'class' Identifier ( 'extends' Identifier )? '{' ( varDeclaration )* ( methodDeclaration )* '}' ;
statement : '{' ( statement )* '}'
|   'if' '(' expression ')' statement 'else' statement
|   'while' '(' expression ')' statement
|   'System.out.println' '(' expression ')' ';'
|   Identifier '=' expression ';'
|   Identifier '[' expression ']' '=' expression ';';
varDeclaration: type Identifier ';';
methodDeclaration: 'public' type Identifier '(' ( type Identifier ( ',' type Identifier )* )? ')' '{' ( varDeclaration )* ( statement )* 'return' expression ';' '}' ;
type: 'int' '[' ']'
|   'boolean'
|   'int'
|   Identifier;
//fragment
//expression: 
//| expression '[' expression ']'
//| expression '.' 'length'
//| expression '.' Identifier '(' ( expression ( ',' expression )* )? ')'
//| expression ( '&&' | '<' | '+' | '-' | '*' ) expression
// 'true'
//|   IntergerLiteral
//|   'false'
//|   Identifier
//|   'this'
//|   'new' 'int' '[' expression ']'
//|   'new' Identifier '(' ')'
//|   '!' expression
//|   '(' expression ')' ;
expression: 'true' expression2
|   'false' expression2
|   Identifier expression2
|   'this' expression2
|   'new' 'int' '[' expression ']' expression2
|   'new' Identifier '(' ')' expression2
|   '!' expression expression2
|   '(' expression ')' expression2;

expression2: '[' expression ']' expression2
|   '.' 'length' expression2
|   '.' Identifier '(' ( expression ( ',' expression )* )? ')' expression2
|   ( '&&' | '<' | '+' | '-' | '*' ) expression expression2 
|   ;

IntergerLiteral : [+-]?[[1-9][0-9]*;
Identifier : [a-zA-Z_] [a-zA-Z0-9_]*;

WS : [ \t\r\n]+ -> skip ;
Comment : '/*' .*? '*/' -> skip ;
LineComment : '//' ~[\r\n]* -> skip ; 