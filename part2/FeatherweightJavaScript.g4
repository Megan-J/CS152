grammar FeatherweightJavaScript;


@header { package edu.sjsu.fwjs.parser; }

// Reserved words
IF        : 'if' ;
ELSE      : 'else' ;
WHILE     : 'while' ;
FUNCTION  : 'function' ;
VAR       : 'var' ;
PRINT     : 'print' ;

// Literals
INT       : [1-9][0-9]* | '0' ;
BOOL      : ('true' | 'false');
NULL      : 'null'            ;

// Symbols
MUL       : '*' ;
DIV       : '/' ;
ADD       : '+' ;
SUB       : '-' ;
MOD       : '%' ;
GT        : '>' ;
LT        : '<' ;
GE        : '>=' ;
LE        : '<=' ;
EQ        : '==' ;
SEPARATOR : ';' ;

// Identifiers/Variable names
ASSIGN    : '=' ;
ID: [a-zA-Z_][a-zA-Z0-9_]*;

// Whitespace and comments
NEWLINE   : '\r'? '\n' -> skip ;
LINE_COMMENT  : '//' ~[\n\r]* -> skip ;
WS            : [ \t]+ -> skip ; // ignore whitespace
BLOCK_COMMENT : '/*' .*? '*/' -> skip ;

// ***Parsing rules ***

/** The start rule */
prog: stat+ ;

// Statements
stat: expr SEPARATOR                                    # bareExpr
    | IF '(' expr ')' block ELSE block                  # ifThenElse
    | IF '(' expr ')' block                             # ifThen
    | PRINT '(' expr ')' SEPARATOR                      # print
    | WHILE '(' expr ')' block                          # while
    | SEPARATOR                                         # emptyStmt
    ;

// Expression
expr: expr op=( '*' | '/' | '%' ) expr                  # MulDivMod
    | expr op=(ADD | SUB) expr                          # AddSub
    | expr op=(GT | LT | GE | LE | EQ) expr             # Comparison
    | INT                                               # int
    | BOOL                                              # bool
    | NULL                                              # null
    | '(' expr ')'                                      # parens
    | FUNCTION '(' params ')' block                     # funcDecl
    | ID '(' args ')'                                   # funcApp
    | VAR ID ASSIGN expr SEPARATOR                      # varDecl
    | ID                                                # varRef
    | ID ASSIGN expr SEPARATOR                          # varAssign
    ;

/** Parameters for function declarations */
params: ID (',' ID)* ;

/** Arguments for function applications */
args: expr (',' expr)* ;

block: '{' stat* '}'                                    # fullBlock
     | stat                                             # simpBlock
     ;


