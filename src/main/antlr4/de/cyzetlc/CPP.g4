grammar CPP;

// (eform EOF | COMMENT EOF)*
cexpr   : eform EOF ;

eform   : '-' INT           #unMinusExpr
        | '(' eform ')'     #bracketExpr
        | eform '*' eform   #mulExpr
        | eform '/' eform   #divExpr
        | eform '+' eform   #addExpr
        | eform '-' eform   #subExpr
        | INT               #intExpr
        ;

ID      : [a-z][a-zA-Z]* ;
INT     : [0-9]+ ;

COMMENT : '//' ~[\r\n]* -> skip ;
WS      : [ \t\n\r] -> skip ;
