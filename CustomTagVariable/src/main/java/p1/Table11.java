package p1;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class Table11 extends SimpleTagSupport{
	private int var1;
	
	public void setVar1(int var1) {
		this.var1=var1;
	}
@Override
public void doTag() throws JspException, IOException {
	JspWriter out= getJspContext().getOut();
	for(int i=1;i<=10;i++) {
		out.println(var1*i);
		out.println("<br>");
	}
}
}
