grammar CPP;

cexpr   : (expr EOF | COMMENT EOF)* ;

expr    : '-' INT           #unMinusExpr
        | '(' expr ')'      #bracketExpr
        | expr '*' expr     #mulExpr
        | expr '/' expr     #divExpr
        | expr '+' expr     #addExpr
        | expr '-' expr     #subExpr
        | INT               #intExpr
        ;

ID      : [a-z][a-zA-Z]* ;
INT     : [0-9]+ ;

COMMENT : '//' ~[\r\n]* -> skip ;
WS      : [ \t\n\r] -> skip ;
