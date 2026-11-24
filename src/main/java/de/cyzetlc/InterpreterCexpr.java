package de.cyzetlc;

import de.cyzetlc.expr.ExprImpl.*;
import de.cyzetlc.expr.ValueImpl.*;

public class InterpreterCexpr extends InterpreterCint {
    @Override
    public Value eval(Expr expr) {
        return switch (expr) {
            case MulExpr(var l, var r) -> {
                int a = asInt(eval(l));
                int b = asInt(eval(r));
                yield new IntVal(a * b);
            }

            // TODO: DivExpr
            case DivExpr(var l, var r) -> {
                int a = asInt(eval(l));
                int b = asInt(eval(r));
                yield new IntVal(a / b);
            }

            default -> super.eval(expr);
        };
    }

    protected int asInt(Value v) {
        if (v instanceof IntVal(var val)) return val;
        throw new RuntimeException("number expected");
    }
}
