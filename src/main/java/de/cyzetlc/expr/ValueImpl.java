package de.cyzetlc.expr;

public class ValueImpl {
    public interface Value {}
    public record IntVal(int v) implements Value {}
}
