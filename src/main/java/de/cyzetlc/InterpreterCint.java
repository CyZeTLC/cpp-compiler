package de.cyzetlc;

import de.cyzetlc.expr.ExprImpl.*;
import de.cyzetlc.expr.ValueImpl.*;

public class InterpreterCint {
    public Value eval(Expr expr) {
        return switch (expr) {
            case IntLiteral(var v) -> new IntVal(v);

            case AddExpr(var l, var r) -> {
                int a = asInt(eval(l));
                int b = asInt(eval(r));
                yield new IntVal(a + b);
            }

            // TODO: SubExpr
            case SubExpr(var l, var r) -> {
                int a = asInt(eval(l));
                int b = asInt(eval(r));
                yield new IntVal(a - b);
            }

            default -> throw new RuntimeException("unexpected expression: " + expr);
        };
    }

    protected int asInt(Value v) {
        if (v instanceof IntVal(var val)) return val;
        throw new RuntimeException("number expected");
    }
}
