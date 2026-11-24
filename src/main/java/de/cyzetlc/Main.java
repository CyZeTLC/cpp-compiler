package de.cyzetlc;

import de.cyzetlc.expr.ExprImpl.*;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

public class Main {
    static void main() {
        InterpreterCexpr cexpr = new InterpreterCexpr();
        IO.println(cexpr.eval(new MulExpr(new IntLiteral(5), new IntLiteral(3))));

        String input = IO.readln("expr?> ");

        CPPLexer lexer = new CPPLexer(CharStreams.fromString(input));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        CPPParser parser = new CPPParser(tokens);
        CPPParser.CexprContext tree = parser.cexpr(); // Start-Regel
        CppCexprAstBuilder astBuilder = new CppCexprAstBuilder();
        Expr ast = astBuilder.visitCexpr(tree);

        IO.println(tree.toStringTree(parser));
        InterpreterCexpr interpreterCexpr = new InterpreterCexpr();
        IO.println(interpreterCexpr.eval(ast));
    }
}
