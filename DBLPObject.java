/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;

public class DBLPObject extends dblp
{
	protected String mdate;
	protected String key;
	protected String author;
	protected String title;
	protected String url;
	protected String year;
	
	public String getMDate()
	{
		return this.mdate;
	}
	public String getKey()
	{
		return this.key;
	}
	public String getAuthor()
	{
		return this.author;
	}
	public String getTitle()
	{
		return this.title;
	}
	public String getURL()
	{
		return this.url;
	}
	public String getYear()
	{
		return this.year;
	}
	
	public void setYear(String yr)
	{
		this.year = yr;
	}
	public void setAuthor(String au)
	{
		this.author = au;
	}
	public void setURL(String url)
	{
		this.url = url;
	}
	
}
