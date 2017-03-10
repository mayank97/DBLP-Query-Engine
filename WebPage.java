/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;
import java.util.ArrayList;

//package testing;

public class WebPage extends dblp
{
	private String note;
	private String year;
	private String author;
	ArrayList<String> othernames =new ArrayList<String>();
	private int counter;
	
	public String getNote()
	{
		return this.note;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public String getYear(){
		return this.year;
	}
	public void setNote(String note)
	{
		this.note = note;
	}
	public void setYear(String year)
	{
		this.year=year;
	}
	public void setAuthor(String x)
	{
		if(counter==0){
			author = x;
			counter++;
		}
	else {
	othernames.add(x);
	
	}}
	ArrayList<String> getothernames(){
		return othernames;
	}
	
	public void setTitle(String x)
	{
		title=x;
	}
	@Override
	public String toString() {
		String s="webpage \r\n ";
		if (getTitle() != null) {
			s=s+"title: "+getTitle()+"\r\n";
		}
		if (getAuthor() != null) {
			s=s+"Author: "+getAuthor()+"\r\n";
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
		if (getNote() != null) {
			s="ee :"+getNote()+"\r\n";
		}
		if (getYear() != null) {
			s="year :"+getYear()+"\r\n";
		}
		return s;
	}
}
