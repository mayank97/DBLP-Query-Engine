/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */

package dblp;
import java.util.ArrayList;

//package testing;

public class Inproceedings extends dblp
{
	private String pages;
	private String crossref;
	private String year;
	private String author;
	ArrayList<String> othernames =new ArrayList<String>();
	private int counter;
	
	public String getPages()
	{
		return this.pages;
	}
	public String getCrossref()
	{
		return this.crossref;
	}
	public String getYear()
	{
		return this.year;
	}
	public String getAuthor()
	{
		return this.author;
	}
	void setTitle(String x){
	title=x;
	}	
	public void setYear(String year)
	{
		this.year=year;
	}
	public void setPages(String page)
	{
		this.pages = page;
	}
	public void setCrossref(String crossref)
	{
		this.crossref = crossref;
	}
	public void setAuthor(String x)
	{
		if(counter==0){
			author = x;
			counter++;
		}
	else {
	othernames.add(x);
	
	}
	}
ArrayList<String> getothernames(){
		return othernames;
	}
	
	@Override
	public String toString(){
		String s=" Inproceedings type \r\n";
		if(getTitle()!=null)
		{
			s=s+"Title:"+getTitle()+"\r\n";
		}
		if(getAuthor()!=null)
		{
			s=s+"author"+getAuthor()+"\r\n";
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
			s=s+"pages"+getPages()+"\r\n";
		}
	
		if(getCrossref()!=null)
		{
			s=s+"crossref:"+getCrossref()+"\r\n";
		}
		if(getYear()!=null)
		{
			s=s+"year:"+getYear()+"\r\n";
		}
		
		return s;
	}
	
	
}
