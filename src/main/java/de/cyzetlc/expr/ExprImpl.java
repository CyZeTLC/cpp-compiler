package de.cyzetlc.expr;

public class ExprImpl {
    public interface Expr {}
    public record IntLiteral(int value) implements Expr {}
    public record AddExpr(Expr left, Expr right) implements Expr {}
    public record SubExpr(Expr left, Expr right) implements Expr {}
    public record MulExpr(Expr left, Expr right) implements Expr {}
    public record DivExpr(Expr left, Expr right) implements Expr {}
}
