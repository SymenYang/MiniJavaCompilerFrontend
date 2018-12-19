grammar MiniJava;

goal : mainClass (classDeclaration)* ;

mainClass : 'class' Identifier '{' 'public' 'static' 'void' 'main' '(' 'String' '[' ']' Identifier ')' '{' statement '}' '}' ;

classDeclaration: 'class' Identifier ( 'extends' Identifier )? '{' ( varDeclaration )* ( methodDeclaration )* '}' ;

varDeclaration: atype Identifier ';';

methodDeclaration: 'public' atype Identifier '(' ( atype Identifier ( ',' atype Identifier )* )? ')' '{' ( varDeclaration )* ( statement )* 'return' expression ';' '}' ;

atype: 'int' '[' ']' #INTARRAY
|   'boolean' #BOOL
|   'int' #INT
|   Identifier #ID
    ;

//fragment
expression:    expression '[' expression ']' # ARRAYSEARCH
|   expression '.' 'length' # LENGTH
|   expression '.' Identifier '(' ( expression ( ',' expression )* )? ')' # FUNCTION
|   expression ( '&&' | '<' | '+' | '-' | '*' ) expression # BIOP
|   ('true' | 'false') # BOOLLIT
|   IntergerLiteral # INTLIT
|   Identifier # VAR
|   'this' # THIS
|   'new' 'int' '[' expression ']' # NEWINT
|   'new' Identifier '(' ')' # NEWID
|   '!' expression #NOT
|   '(' expression ')' #BRACKET
;

//expression: BOOL=('true'|'false') expression2 #TRUEFALSE
//|   IntergerLiteral expression2 #INTLIT
//|   Identifier expression2 #VAR
//|   'this' expression2 #THIS
//|   'new' 'int' '[' expression ']' expression2 #NEWINT
//|   'new' Identifier '(' ')' expression2 #NEWID
//|   '!' expression expression2 #NOT
//|   '(' expression ')' expression2 #BRACKET
//    ;
//expression2: '[' expression ']' expression2 #SQUAREBRACKET
//|   '.' 'length' expression2 #LENGTH
//|   '.' Identifier '(' ( expression ( ',' expression )* )? ')' expression2 #FUNCTION
//|   op=( '&&' | '<' | '*' | '-' | '+' ) expression #BIOP
//|   #NULL
//    ;

statement : '{' ( statement )* '}' #CURLYBRACKET
|   'if' '(' expression ')' statement 'else' statement #IFELSE
|   'while' '(' expression ')' statement #WHILE
|   'System.out.println' '(' expression ')' ';' #PRINT
|   Identifier '=' expression ';' #ASSIGN
|   Identifier '[' expression ']' '=' expression ';' #ARRAYASSIGN
    ;

IntergerLiteral : ([1-9][0-9]*|[0]);

Identifier : [a-zA-Z_] [a-zA-Z0-9_]*;


WS : [ \t\r\n]+ -> skip ;
Comment : '/*' .*? '*/' -> skip ;
LineComment : '//' ~[\r\n]* -> skip ; 
And : '&&' ;
Mul : '*' ;
Less : '<' ;
Add : '+' ;
Min : '-' ;

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