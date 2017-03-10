/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;
import java.util.ArrayList;

//package testing;

public class Article extends dblp {
	String author;
	int counter;
	ArrayList<String> othernames =new ArrayList<String>();
	String pages;
	String year;
	String volume;
	String journal;
	String number;
	String url;
	String ee;

	Article() {
		super();
		counter=0;		
	author = null;
	}
	

	void setAuthor(String x) {
		if(counter==0){
			author = x;
			counter++;
		}
	else {
	othernames.add(x);
	
	}
	}

	void setPages(String x) {
		pages = x;
	}

	void setYear(String x) {
		year = x;
	}

	void setVolume(String x) {
		volume = x;
	}

	void setJournal(String x) {
		journal = x;
	}

	void setNumber(String x) {
		number = x;
	}

	void setUrl(String x) {
		url = x;
	}

	void setEE(String x) {
		ee = x;
	}
	void setTitle(String x){
		title=x;
	}
	public String getAuthor() {
		return author;
	}

	public String getPages() {
		return pages;
	}

	public String getYear() {
		return year;
	}

	public String getVolume() {
		return volume;
	}

	public String getJournal() {
		return journal;
	}

	String getNumber() {
		return number;
	}

	public String getUrl() {
		return url;
	}

	String getEE() {
		return ee;
	}
	ArrayList<String> getothernames(){
		return othernames;
	}

	@Override
	public String toString() {
		String s = "article \r\n ";
		
		if (getTitle() != null) {
			s = "Title =" + getTitle()+"\r\n";
		}
		if (getAuthor() != null) {
			s = s + "Autor: " + getAuthor()+"\r\n";
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
		if (getPages() != null) {
			s = s + "Pages: " + getPages()+"\r\n";
		}
		if (getYear() != null) {
			s = s + "Year: " + getYear()+"\r\n";
		}
		if (getVolume() != null) {
			s = s + "volume: " + getVolume()+"\r\n";
		}
		if (getJournal() != null) {
			s = s + "journal: " + getJournal()+"\r\n";
		}
		if (getNumber() != null) {
			s = s + "number: " + getNumber()+"\r\n";
		}
		if (getUrl() != null) {
			s = s + "url:" + getUrl()+"\r\n";
		}
		if (getEE() != null) {
			s = s + "EE:" + getEE()+"\r\n";
		}
		return s;
	}

}
