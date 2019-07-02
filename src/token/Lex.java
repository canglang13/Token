package token;

import java.io.*;
import java.util.*;

/** 

* @author ������ �������ġ�������

*/
public class Lex {
	public static final String FILE_IN="F:\\workspace\\token\\src\\token\\source.txt";
	public static String source=getSource();//Դ����
	public static int ans=0;//��ǰ�±�
	public static int line=1;//����
	public static List<String> ids=new ArrayList<String>();//��ʶ����
	public static List<Integer> constants=new ArrayList<Integer>();//������
	
	public static String getSource(){
		StringBuffer str=new StringBuffer("");
		File file=new File(FILE_IN);
		try {	  
			FileReader fr=new FileReader(file);
			int ch = 0;
			while((ch = fr.read())!=-1 ){
			str.append((char)ch);
			//System.out.print((char)ch+" "); 
			}
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
			//System.out.println("File reader����");
		}
		return str.toString();
	}

	/**
	 * �ʷ���������
	 */
	public static void analysis() {
		while(ans<=source.length()-1){
			//System.out.print(source.charAt(ans));
			//ans++;
			if(Data.L.contains(source.charAt(ans))) {
				//System.out.println("1111111");
				isIdentifier();
				continue;
				//��ʶ��״̬
			}
			else if(Data.D.contains(source.charAt(ans))) {
				//System.out.println("22222222");
				constantAnalysis();
				continue;
				//���ֳ���
			}
			else if(Data.separator.contains(String.valueOf(source.charAt(ans)))) {
				//System.out.println("3333333");
				whichSeparator();
				continue;
				//�����ַ�
			}
			else if(Data.C.contains(source.charAt(ans))){
				//System.out.println("��������ַ�ѡ��");
				if(source.charAt(ans)=='\r') {
					line++;
					}//���������з���line+1
				ans++;//�����ַ�������
				//System.out.println(ans);
				continue;
			}
			System.out.println("��������δ��ʶ����ַ���Line:"+line);
			ans++;
			
			//ans++;
		}
	}
	
	/**
	 * ��ʶ��������
	 */
	public static void isIdentifier() {
		String s = "";
		ToKen t=null;
		while (Data.L.contains(source.charAt(ans)) || Data.D.contains(source.charAt(ans))) {
			s = s + source.charAt(ans);
			//System.out.println(ans);
			ans++;
			if(ans==source.length()) break;
		}
			if (Data.reservedWord.contains((s))) {
				t = new ToKen(2, "$ID", Data.reservedWord.indexOf(s), line);
				//System.out.println(t.getNum()+t.getSym()+t.getPos()+t.getLine());
				Data.token.add(t);
			} else {
				if (ids.contains(s)) {
				
					t = new ToKen(1, "$id", ids.indexOf(s), line);
					Data.token.add(t);
				} else {
					ids.add(s);
					t = new ToKen(1, "$id", ids.indexOf(s), line);
					Data.token.add(t);
				}
			}
	}

	
	
	/**
	 * ���ֳ���������
	 * 
	 */
	public static void constantAnalysis() {
		String current="";
		while(Data.D.contains(source.charAt(ans))) {
			current=current+source.charAt(ans);
			ans++;
		}
		if(!(Data.C.contains(source.charAt(ans))||Data.separator.contains(String.valueOf(source.charAt(ans))))) {
			//������ǿ����ַ��������ַ�����������
			System.out.println("�������󣬵����޷�ʶ��Line:"+line);
			//������ǿ����ַ��������ַ��������ڴ���ǰ��
			while(!(Data.C.contains(source.charAt(ans))||Data.separator.contains(String.valueOf(source.charAt(ans))))) {
				ans++;
			}
		}
		else {//δ��������
			int temp=Integer.parseInt(current);
			int p=0;
			if(!constants.contains(temp)) constants.add(temp);
			p=constants.indexOf(temp);
			ToKen t=new ToKen(3,"$int",p,line);
			Data.token.add(t);
		}
	}

	
	/**
	 * 
	 * �����ַ�������
	 */
	public static void whichSeparator() {
		if (source.charAt(ans) == ':') {
			if (ans + 1 < source.length()) {
				if (source.charAt(ans + 1) == '=') {
					Data.token.add(new ToKen(32, "$assi", Data.separator.indexOf(":="), line));
					ans = ans + 1;
				} else
					Data.token.add(new ToKen(35, "$colon", Data.separator.indexOf(":"), line));
			} else
				Data.token.add(new ToKen(35, "$colon", Data.separator.indexOf(":"), line));
		} else if (source.charAt(ans) == '.') {
			if (ans + 1 < source.length()) {
				if (source.charAt(ans + 1) == '.') {
					Data.token.add(new ToKen(34, "$arraydown", Data.separator.indexOf(".."), line));
					ans = ans + 1;
				} else
					Data.token.add(new ToKen(33, "$dot", Data.separator.indexOf("."), line));
			} else
				Data.token.add(new ToKen(33, "$dot", Data.separator.indexOf("."), line));
		} else {
			switch (Data.separator.indexOf(String.valueOf(source.charAt(ans)))) {
			case 0:
				Data.token.add(new ToKen(20, "$comma", Data.separator.indexOf(","), line));
				break;
			case 1:
				Data.token.add(new ToKen(21, "$semi", Data.separator.indexOf(";"), line));
				break;
			case 2:
				Data.token.add(new ToKen(22, "$plus", Data.separator.indexOf("+"), line));
				break;
			case 3:
				Data.token.add(new ToKen(23, "$minus", Data.separator.indexOf("-"), line));
				break;
			case 4:
				Data.token.add(new ToKen(24, "$multi", Data.separator.indexOf("*"), line));
				break;
			case 5:
				Data.token.add(new ToKen(25, "$divide", Data.separator.indexOf("/"), line));
				break;
			case 6:
				Data.token.add(new ToKen(26, "$lt", Data.separator.indexOf("<"), line));
				break;
			case 7:
				Data.token.add(new ToKen(27, "$equal", Data.separator.indexOf("="), line));
				break;
			case 8:
				Data.token.add(new ToKen(28, "$lsbra", Data.separator.indexOf("("), line));
				break;
			case 9:
				Data.token.add(new ToKen(29, "$rsbra", Data.separator.indexOf(")"), line));
				break;
			case 10:
				Data.token.add(new ToKen(30, "$lmbra", Data.separator.indexOf("["), line));
				break;
			case 11:
				Data.token.add(new ToKen(31, "$rmbra", Data.separator.indexOf("]"), line));
				break;
			}
		}
		ans++;
		
	}
	
	public static void main(String[] args) {
		Data.initialize();
		
		analysis();
		//System.out.println(line);
		//System.out.print(source.charAt(14));
		//System.out.print(source.charAt(15));
		//System.out.println(Data.D.toString());
		//System.out.println(Data.reservedWord.toString());
		for(ToKen t:Data.token) {
			System.out.println("("+t.num+" "+t.sym+" "+t.getValue()+")");
		}
	}
	
}
