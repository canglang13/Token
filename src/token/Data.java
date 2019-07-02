package token;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Data {
	public static List<ToKen> token; // token列表
	public static List<String> separator; // 分隔符列表
	public static List<String> reservedWord; // 保留字列表
	public static List<Character> L; // 大小写字母表
	public static List<Character> D; // 0-9
	public static List<Character> D1; // 1-9
	public static List<Character> C;//控制字符
	public static void initialize() { // 初始化各个列表

		token=new ArrayList<ToKen>();
		separator = new ArrayList<String>();
		reservedWord = new ArrayList<String>();
		separator.add(",");
		separator.add(";");
		separator.add("+");
		separator.add("-");
		separator.add("*");
		separator.add("/");
		separator.add("<");
		separator.add("=");
		separator.add("(");
		separator.add(")");
		separator.add("[");
		separator.add("]");
		separator.add(":=");
		separator.add(".");
		separator.add("..");
		separator.add(":");
		reservedWord.add("program");
		reservedWord.add("type");
		reservedWord.add("var");
		reservedWord.add("integer");
		reservedWord.add("char");
		reservedWord.add("array");
		reservedWord.add("of");
		reservedWord.add("procedure");
		reservedWord.add("begin");
		reservedWord.add("while");
		reservedWord.add("do");
		reservedWord.add("if");
		reservedWord.add("then");
		reservedWord.add("else");
		reservedWord.add("fi");
		reservedWord.add("endwh");
		reservedWord.add("end");
		reservedWord.add("read");
		reservedWord.add("write");
		reservedWord.add("return");
		
		L = new ArrayList<Character>();
		D = new ArrayList<Character>();
		D1 = new ArrayList<Character>();
		C = new ArrayList<Character>();
		L.add('A');
		L.add('B');
		L.add('C');
		L.add('D');
		L.add('E');
		L.add('F');
		L.add('G');
		L.add('H');
		L.add('I');
		L.add('J');
		L.add('K');
		L.add('L');
		L.add('M');
		L.add('N');
		L.add('O');
		L.add('P');
		L.add('Q');
		L.add('R');
		L.add('S');
		L.add('T');
		L.add('U');
		L.add('V');
		L.add('W');
		L.add('X');
		L.add('Y');
		L.add('Z');
		L.add('a');
		L.add('b');
		L.add('c');
		L.add('d');
		L.add('e');
		L.add('f');
		L.add('g');
		L.add('h');
		L.add('i');
		L.add('j');
		L.add('k');
		L.add('l');
		L.add('m');
		L.add('n');
		L.add('o');
		L.add('p');
		L.add('q');
		L.add('r');
		L.add('s');
		L.add('t');
		L.add('u');
		L.add('v');
		L.add('w');
		L.add('x');
		L.add('y');
		L.add('z');
		D.add('0');
		D.add('1');
		D.add('2');
		D.add('3');
		D.add('4');
		D.add('5');
		D.add('6');
		D.add('7');
		D.add('8');
		D.add('9');
		D1.add('1');
		D1.add('2');
		D1.add('3');
		D1.add('4');
		D1.add('5');
		D1.add('6');
		D1.add('7');
		D1.add('8');
		D1.add('9');
		C.add(' ');
		C.add('\n');
		C.add('\t');
		C.add('\r');
}
	}
