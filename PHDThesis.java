/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;
import java.util.ArrayList;

//package testing;

public class PHDThesis extends dblp
{
	private String school;
	private String ee;
	private String note;
	private String year;
	private String author;
	ArrayList<String> othernames =new ArrayList<String>();
	private int counter;

	public String getYear()
	{
		return this.year;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public String getSchool()
	{
		return this.school;
	}
	public String getEE()
	{
		return this.ee;
	}
	public String getNote()
	{
		return this.note;
	}
	public void setYear(String Year)
	{
		this.year=year;
	}
	public void setSchool(String school)
	{
		this.school  = school;
	}
	public void setEE(String ee)
	{
		this.ee = ee;
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
	public void setNote(String note)
	{
		this.note = note;
	}
	public void setTitle(String x)
	{
		this.title= x;
	}
ArrayList<String> getothernames(){
		return othernames;
	}
	@Override
	public String toString(){
		String s=" Phd Thesis \r\n";
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
		if(getSchool()!=null)
		{
			s=s+"School:"+getSchool()+"\r\n";
		}
	
		if(getEE()!=null)
		{
			s=s+"EE:"+getEE()+"\r\n";
		}
		if(getNote()!=null)
		{
			s=s+"note: "+getNote()+"\r\n";
		}
		if(getYear()!=null){
			s=s+"Year:"+getYear()+" \r\n";
		}
		
		return s;
	}
	
}
