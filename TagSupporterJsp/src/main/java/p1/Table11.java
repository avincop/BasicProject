package p1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import javax.servlet.jsp.tagext.TagSupport;

public class Table11 extends TagSupport{
//	private int var1;
//	
//	public void setVar1(int var1) {
//		this.var1=var1;
//		
//	}
	@Override
	public int doStartTag() throws JspException {
		JspWriter out=pageContext.getOut();
		try {
			out.println("TagSupporter");
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		//return SKIP_BODY;//if you skip body part of jsp
		//if you want show body of jsp
		return EVAL_BODY_AGAIN;
		
	}


}
