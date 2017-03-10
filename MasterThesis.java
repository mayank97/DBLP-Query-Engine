/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;
import java.util.ArrayList;

//package testing;

public class MasterThesis extends dblp 
{
	private String school;
	private String year;
	private String author;
	ArrayList<String> othernames =new ArrayList<String>();
	private int counter;
	
	public String getSchool()
	{
		return this.school;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public String getYear()
	{
		return this.year;
	}
	
	//setters
	public void setSchool(String School)
	{
		this.school = School;
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
	public void setYear(String year)
	{
		this.year=year;
	}
	public void setTitle(String x){
		title=x;
	}
ArrayList<String> getothernames(){
		return othernames;
	}

	@Override
	public String toString(){
		String s=" masterthesis \r\n";
		if(getTitle()!=null)
		{
			s=s+"Title:"+getTitle()+"\r\n";
		}
		if(getAuthor()!=null)
		{
			s=s+"Author: "+getSchool()+"\r\n";
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
			s=s+"School: "+getSchool()+"\r\n";
		}
		if(getYear()!=null)
		{
			s=s+"year: "+getYear()+"\r\n";
		}
		
		return s;
	}
	
}
