grammar MiniJava;

goal : mainClass (classDeclaration)* ;

mainClass : 'class' Identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '{' statement '}' '}' ;

classDeclaration: 'class' Identifier ( 'extends' Identifier )? '{' ( varDeclaration )* ( methodDeclaration )* '}' ;

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
|   IntergerLiteral expression2
|   Identifier expression2
|   'this' expression2
|   'new' 'int' '[' expression ']' expression2
|   'new' Identifier '(' ')' expression2
|   '!' expression expression2
|   '(' expression ')' expression2;

expression2: '[' expression ']' expression2
|   '.' 'length' expression2
|   '.' Identifier '(' ( expression ( ',' expression )* )? ')' expression2
|   ( '&&' | '<' | '+' | '-' | '*' ) expression 
|   ;

statement : '{' ( statement )* '}'
|   'if' '(' expression ')' statement 'else' statement
|   'while' '(' expression ')' statement
|   'System.out.println' '(' expression ')' ';'
|   Identifier '=' expression ';'
|   Identifier '[' expression ']' '=' expression ';';

IntergerLiteral : ([1-9][0-9]*|[0]);

Identifier : [a-zA-Z_] [a-zA-Z0-9_]*;


WS : [ \t\r\n]+ -> skip ;
Comment : '/*' .*? '*/' -> skip ;
LineComment : '//' ~[\r\n]* -> skip ; 
/*
class Factorial{
    public static void main(String[] a){
        System.out.println(new Fac().ComputeFac(10));
    }
}

class Fac {
    public int ComputeFac(int num){
        int num_aux ;
        if (num < 1)
            num_aux = 1 ;
        else
            num_aux = num * (this.ComputeFac(num - 1)) ;
        return num_aux ;
    }
} 
*/