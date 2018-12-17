import java.io.FileInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TestMain {
    public static void main(String[] args) throws Exception {
        String inputFile = null;
        
        if (args.length == 0) {
            System.out.println("Usage:\n\tjava -jar Expr.jar [sourceFile]");
        } else if (args.length == 1) {
            inputFile = args[0];
        } else {
            System.err.println("The file path cannot be recognized");
        }
        InputStream instream = System.in;
        
        if(inputFile != null)
            instream = new FileInputStream(inputFile);
        @SuppressWarnings("deprecation")

        // init Antlr object
        ANTLRInputStream input = new ANTLRInputStream(instream);
        ExprLexer lexer = new ExprLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExprParser parser = new ExprParser(tokens);

        // normal main
        ParseTree tree = parser.prog();
        System.out.println(tree.toStringTree(parser));
    }
}