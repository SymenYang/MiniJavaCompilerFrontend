grammar MiniJava;

goal: MainClass(ClassDeclaration)* ;
MainClass: 'class' Identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '{' Statement '}' '}' ;
ClassDeclaration: 'class' Identifier ( 'extends' Identifier )? '{' ( VarDeclaration )* ( MethodDeclaration )* '}';
Statement: '{' ( Statement )* '}'
|   'if' '(' Expression ')' Statement 'else' Statement
|   'while' '(' Expression ')' Statement
|   'System.out.println' '(' Expression ')' ';'
|   Identifier '=' Expression ';'
|   Identifier '[' Expression ']' '=' Expression ';';
VarDeclaration: Type Identifier ';';
MethodDeclaration: 'public' Type Identifier '(' ( Type Identifier ( ',' Type Identifier )* )? ')' '{' ( VarDeclaration )* ( Statement )* 'return' Expression ';' '}';
Type: 'int' '[' ']'
|   'boolean'
|   'int'
|   Identifier;
//fragment
//Expression: 
//| Expression '[' Expression ']'
//| Expression '.' 'length'
//| Expression '.' Identifier '(' ( Expression ( ',' Expression )* )? ')'
//| Expression ( '&&' | '<' | '+' | '-' | '*' ) Expression
// 'true'
//|   IntergerLiteral
//|   'false'
//|   Identifier
//|   'this'
//|   'new' 'int' '[' Expression ']'
//|   'new' Identifier '(' ')'
//|   '!' Expression
//|   '(' Expression ')' ;
Expression: 'true' Expression2
|   'false' Expression2
|   Identifier Expression2
|   'this' Expression2
|   'new' 'int' '[' Expression ']' Expression2
|   'new' Identifier '(' ')' Expression2
|   '!' Expression Expression2
|   '(' Expression ')' Expression2;
fragment
Expression2: '[' Expression ']' Expression2
|   '.' 'length' Expression2
|   '.' Identifier '(' ( Expression ( ',' Expression )* )? ')' Expression2
|   ( '&&' | '<' | '+' | '-' | '*' ) Expression Expression2 ;

IntergerLiteral: [+-]?[[1-9]+[0-9]*;
Identifier: [a-zA-Z][a-zA-Z0-9_]*;