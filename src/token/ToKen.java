package token;
/** 

* @author ������ 

*/
public class ToKen {
	int num;//���ͱ���
	String sym;//���Ƿ�
	int pos;//��Ӧ�б���±�
	int line;//����
	ToKen(int num,String sym,int pos,int line){
		this.num=num;
		this.sym=sym;
		this.pos=pos;
		this.line=line;
	}
	public String getValue() {//ȡ�ø�token��ֵ
		if(num==1) {
			return Lex.ids.get(pos);
		}
		if(num==2) {
			return Data.reservedWord.get(pos);
		}
		if(num==3) {
			return Lex.constants.get(pos).toString();
		}
		else {
			return Data.separator.get(pos);
		}
	}
	
}
