grammar CDL;

@header{
    package cdl;
}

program
    : cmd* EOF
    ;

cmd
    : circuit_definition
    | circuit_assignment
    | exp_assignment
    ;

circuit_definition
    : 'circuit' ID '(' entradas=var_list ')' ':' saidas=var_list '{' exp_assignment* '}'
    ;

var_list
    : ID (',' ID)*
    ;

exp_assignment
    : ID '=' exp
    ;

circuit_assignment
    : ID '=' 'new' ID '(' var_list ')'
    ;

exp: term_or ('|' term_or)* ;

term_or: term_xor ('^' term_xor)* ;

term_xor: term_and ('&' term_and)* ;

term_and: (not+='~')* term_not ;

term_not
    : 'true'
    | 'false'
    | ID ('.' ID)*
    | '(' exp ')'
    ;

fragment
LETTER: 'a'..'z' | 'A'..'Z' ;

fragment
DIGIT: '0'..'9' ;

ID: (LETTER | '_') (LETTER | '_' | DIGIT)* ;

NUMBER: DIGIT+;

COMMENT
    : ('//' ~('\r' | '\n')*
    | '/*' .*? '*/') -> skip
    ;

WHITE_SPACE
    : (' ' | '\t' | '\r' | '\n') -> skip
    ;

WRONG_CHAR: . ;