/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;
import java.util.ArrayList;

//package testing;

public class Proceedings extends dblp
{
	private String editor;
	private String volume;
	private String ee;
	private String isbn;
	private String series;
	private String publisher;
	private String year;
	private String author;
	ArrayList<String> othernames =new ArrayList<String>();
	private int counter;

	public String getEditor()
	{
		return this.editor;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public String getYear()
	{
		return this.year;
	}
	public String getVolume()
	{
		return this.volume;
	}
	public String getEE()
	{
		return this.ee;
	}
	public String getISBN()
	{
		return this.isbn;
	}
	public String getSeries()
	{
		return this.series;
	}
	public String getPublisher()
	{
		return this.publisher;
	}
	
	public void setEditor(String editor)
	{
		this.editor = editor;
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
	public void setYear(String year){
		this.year=year;
	}
	public void setVolume(String volume)
	{
		this.volume = volume;
	}
	public void setEE(String ee)
	{
		this.ee = ee;
	}
	public void setISBN(String ISBN)
	{
		this.isbn = ISBN;
	}
	public void setSeries(String series)
	{
		this.series = series;
	}
	public void setPublisher(String publisher)
	{
		this.publisher = publisher;
	}
	public void setTitle(String x)
	{
		this.title = x;
	}
ArrayList<String> getothernames(){
		return othernames;
	}
	@Override
	public String toString() {
		String s="BOOK \r\n ";
		if (getTitle() != null) {
			s=s+"title: "+getTitle()+"\r\n";
		}
		if (getAuthor() != null) {
			s=s+"author: "+getAuthor()+"\r\n";
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
		if (getYear() != null) {
			s=s+"Year: "+getYear()+"\r\n";
		}
		if (getEE() != null) {
			s="ee :"+getEE()+"\r\n";
		}
		if (getEditor() != null) {
			s=s+"Editor: "+getEditor()+"\r\n";
		}
		if (getISBN() != null) {
			s=s+"ISBn: "+getISBN()+"\r\n";
		}
		if (getPublisher() != null) {
			s=s+"Publissher: "+getPublisher()+"\r\n";
		}
		if (getVolume() != null) {
			s=s+"volume: "+getVolume()+"\r\n";
		}
		if (getSeries() != null) {
			s=s+"series: "+getSeries()+"\r\n";
		}
		if (getEditor() != null) {
			s=s+"editor: "+getEditor()+"\r\n";
		}
		
		return s;
	}
	
}
