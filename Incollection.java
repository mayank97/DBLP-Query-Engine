/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;
import java.util.ArrayList;

//package testing;

public class Incollection extends dblp
{
	private String pages;
	private String crossref;
	private String ee;
	private String year;
	private String author;
	ArrayList<String> othernames =new ArrayList<String>();
	private int counter;
		
	public void setTitle(String x){
	title=x;
	}
	public void setAuthor(String x){
	if(counter==0){
			author = x;
			counter++;
		}
	else {
	othernames.add(x);
	
	}
	}
	public void setYear(String year)
	{
		this.year=year;
	}
	public void setPages(String pages)
	{
		this.pages=pages;
	}
	public void setCrossref(String crossref)
	{
		this.crossref=crossref;
	}
	public void setEE(String ee)
	{
		this.ee=ee;
	}
	public String getYear()
	{
		return this.year;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public String getPages()
	{
		return this.pages;
	}
	public String getCrossref()
	{
		return this.crossref;
	}
	public String getEE()
	{
		return this.ee;
	}
ArrayList<String> getothernames(){
		return othernames;
	}
	@Override
	public String toString(){
		String s="Incollection type\r\n";
		if(getTitle()!=null)
		{
			s=s+"Title:"+getTitle()+"\r\n";
		}
		if(getAuthor()!=null)
		{
			s=s+"Author:"+getAuthor()+"\r\n";
		}
		if (getothernames() != null) {
			ArrayList <String>l=getothernames();
			System.out.println("backoff");
			for(String temp:l)
			{
			s = s + ","+ temp+"\r\n";
			}
			s=s+"\r\n";
		}
		if(getPages()!=null)
		{
			s=s+"Pages:"+getPages()+"\r\n";
		}
		if(getEE()!=null)
		{
			s=s+"EE"+getEE()+"\r\n";
		}
		if(getCrossref()!=null)
		{
			s=s+"Crossref"+getCrossref()+"\r\n";
		}
		if(getYear()!=null)
		{
			s=s+"year"+getYear()+"\r\n";
		}
		return s;
	}
	
}
