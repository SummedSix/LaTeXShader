package latexToGLSL;

import latexToGLSL.analysis.*;
import latexToGLSL.lexer.*;
import latexToGLSL.node.*;
import latexToGLSL.parser.*;


public class ASTPrinter extends DepthFirstAdapter {
	
	int indent;
	
	public void printIndent(){
		for (int i = 0; i < indent; i++) {
			System.out.print("\u0009");
		}
	}
	
	public void printNode(Node node){
		printIndent();
		System.out.print(node.getClass().getSimpleName().toString().replaceAll("class node\\.T?", ""));
		System.out.println(" | "+node.toString() );
	}
	
	@Override
	public void defaultIn(Node node){
		printNode(node);
		indent++;
	}
	
	@Override
	public void defaultOut(Node node){
		indent--;
	}
}