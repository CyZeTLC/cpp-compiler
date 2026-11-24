package de.cyzetlc;

import de.cyzetlc.expr.ExprImpl.*;

public class CppCexprAstBuilder extends CPPBaseVisitor<Object>{
    @Override
    public Expr visitCexpr(CPPParser.CexprContext ctx) {
        return asExpr(visit(ctx.eform()));
    }

    @Override
    public Expr visitMulExpr(CPPParser.MulExprContext ctx) {
        return ctx.eform().stream().map(this::visit).map(this::asExpr).reduce(MulExpr::new).orElseThrow();
    }

    @Override
    public Expr visitDivExpr(CPPParser.DivExprContext ctx) {
        return ctx.eform().stream().map(this::visit).map(this::asExpr).reduce(DivExpr::new).orElseThrow();
    }

    @Override
    public Expr visitAddExpr(CPPParser.AddExprContext ctx) {
        return ctx.eform().stream().map(this::visit).map(this::asExpr).reduce(AddExpr::new).orElseThrow();
    }

    @Override
    public Expr visitSubExpr(CPPParser.SubExprContext ctx) {
        return ctx.eform().stream().map(this::visit).map(this::asExpr).reduce(SubExpr::new).orElseThrow();
    }

    @Override
    public Object visitBracketExpr(CPPParser.BracketExprContext ctx) {
        return asExpr(visit(ctx.eform()));
    }

    @Override
    public Object visitUnMinusExpr(CPPParser.UnMinusExprContext ctx) {
        return new UnMinusExpr(asExpr(visit(ctx.eform())));
    }

    @Override
    public Expr visitIntExpr(CPPParser.IntExprContext ctx) {
        return new IntLiteral(Integer.parseInt(ctx.INT().getText()));
    }

    private Expr asExpr(Object o) {
        if (o instanceof Expr) return (Expr) o;
        throw new RuntimeException("expected expr, got " + o.getClass().getName());
    }
}
