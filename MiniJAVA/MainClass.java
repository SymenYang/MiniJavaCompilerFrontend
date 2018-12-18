import java.io.FileInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.Trees;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass {
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
        MiniJavaLexer lexer = new MiniJavaLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MiniJavaParser parser = new MiniJavaParser(tokens);

        // normal main
        ParseTree tree = parser.goal();
        System.out.println(tree.toStringTree(parser));

        // show tree
        Trees.inspect(tree, parser);
    }
}