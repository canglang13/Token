package token;
/** 

* @author 赖晨朗 

*/
public class ToKen {
	int num;//类型编码
	String sym;//助记符
	int pos;//对应列表的下标
	int line;//行数
	ToKen(int num,String sym,int pos,int line){
		this.num=num;
		this.sym=sym;
		this.pos=pos;
		this.line=line;
	}
	public String getValue() {//取得该token的值
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
