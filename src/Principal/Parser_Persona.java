package parser_persona;

public class Parser_Persona {

	public static void main(String[] args) {
				
		Parser parser=new Parser();
		parser.parseFicheroXml("personas.xml");
		parser.parseDocument();
		parser.print();
		
		
		
		
		

	}

}