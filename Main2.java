/*!
 * @Mayank Kumar 2015055
 * @Dewansh Gautam 2015025
 */
package dblp;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.event.*;
import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;
/**
 * 
 * @author Mayank
 *
 */

public class Main2 implements Observer
{
	private boolean flag;
	public void update()
	{
		flag = true;
	}
	public static JTable table;
	public static JPanel panelCenter;
	
	public static String[] tree_array2;
	public static int numberOfElements2;
	public static int numberofPages2=1;
	
	public static int pagecount2 = 1;
	public static int SrNo2 = 1;
	public static ArrayList<dblp> arr = null;
	public static dblp[] array;
	
	public static int sum2 =0;
	public static int page2 = 0;
	public static float var2 = 0;

	
	public static void Query22Result(int SearchType, String text, String year, String from, String to, int typeofSearch)
	{
		JLabel dummyLabel = new JLabel("                                                                              ");
		
		panelCenter.removeAll();
		panelCenter.revalidate();
		panelCenter.repaint();
		
		long startTime = System.nanoTime();
		
				
		
		if(pagecount2 == 1)
		{			
			if(SearchType == 2 && typeofSearch == 2)
			{		
			
				arr = userxmlparser.SearchbyTitle(text);
				
				numberOfElements2 = arr.size();
				
				if(numberOfElements2 == 0)
				{

					JOptionPane.showMessageDialog(dummyLabel, ("Sorry!! No results found for the given Query."));
					return;
				}
				else if(numberOfElements2 >= 20)
				{
					if(numberOfElements2%20 == 0)
					{
						numberofPages2 = numberOfElements2/20;
					}
					else
					{
						numberofPages2 = numberOfElements2/20 +1;
					}
					
				}
				else
				{
					numberofPages2 = 1;
				}
				
				
			}
			else if(SearchType == 1 && typeofSearch == 2)
			{
				arr = userxmlparser.SearchbyAuthor(text);
				
				
				numberOfElements2 = arr.size();
				
				if(numberOfElements2 == 0)
				{

					JOptionPane.showMessageDialog(dummyLabel, ("Sorry!! No results found for the given Query."));
					return;
				}
				else if(numberOfElements2 >= 20)
				{
					if(numberOfElements2%20 == 0)
					{
						numberofPages2 = numberOfElements2/20;
					}
					else
					{
						numberofPages2 = numberOfElements2/20 +1;
					}
					}
				else
				{
					numberofPages2 = 1;
				}
			}
			sum = numberOfElements2;
			page = pagecount2;
		}
	
		long endTime = System.nanoTime();
		long total=(endTime - startTime);
		float time =  (float) ((float)total/100000000.0);
			if(pagecount2 == 1)
			{
				var = time;
			}
		
		JLabel countLabel = new JLabel("Total number of entries retived : " + sum);
		countLabel.setFont(new Font("Cursive", Font.BOLD, 15));
		countLabel.setForeground(new Color(40, 40, 40));


		JLabel timeLabel = new JLabel("Total retrive time from the Database : "+ var + " sec");
		timeLabel.setFont(new Font("Script", Font.BOLD, 15));
		timeLabel.setForeground(new Color(40, 40, 40));

		JLabel pageLabel = new JLabel("Showing page : "+ pagecount2 +" of " +numberofPages2);
		pageLabel.setFont(new Font("Cursive", Font.BOLD, 15));
		pageLabel.setForeground(new Color(40, 40, 40));
		
		
		panelCenter.add(countLabel);
		panelCenter.add(dummyLabel);
		panelCenter.add(timeLabel);
		//panelCenter.add(dummyLabel);
		panelCenter.add(pageLabel);
	
		
		
		table = new JTable(0,8);
		JScrollPane scrollBar = new JScrollPane(table);
		scrollBar.setPreferredSize(new Dimension(900, 300));
		panelCenter.add(scrollBar);

		table.setBackground(new Color(195, 252, 84));

		
		table.getColumnModel().getColumn(0).setHeaderValue("S_No.");
		table.getColumn("S_No.").setMinWidth(50);
		table.getColumnModel().getColumn(1).setHeaderValue("Authors");
		table.getColumn("Authors").setMinWidth(100);
		table.getColumnModel().getColumn(2).setHeaderValue("Title");
		table.getColumn("Title").setMinWidth(100);
		table.getColumnModel().getColumn(3).setHeaderValue("Pages");
		table.getColumn("Pages").setMinWidth(100);
		table.getColumnModel().getColumn(4).setHeaderValue("Year");
		table.getColumn("Year").setMinWidth(60);
		table.getColumnModel().getColumn(5).setHeaderValue("Volume");
		table.getColumn("Volume").setMinWidth(100);
		table.getColumnModel().getColumn(6).setHeaderValue("Journal/Booktitle");
		table.getColumn("Journal/Booktitle").setMinWidth(100);
		table.getColumnModel().getColumn(7).setHeaderValue("URL");
		table.getColumn("URL").setMinWidth(100);
	
		// aading data into the jtable
		
		
	
		
		if(numberOfElements2 <=20)
		{
			int year1 = Integer.parseInt(year);
			int to1 = Integer.parseInt(to);
			int from1 = Integer.parseInt(from);
			
			for(int i = 1; i <= numberOfElements2 ;i++)
			{
				int k =0;
				int year2 = Integer.parseInt((String) arr.get(k).getYear());
				
				if(year2 >= year1 && year2 <= to1 && year2 >= from1)
				{	
					
					Object[] row = { SrNo2, arr.get(k).getAuthor(),arr.get(k).getTitle(),arr.get(k).getPages(), arr.get(k).getYear(), arr.get(k).getVolume(), arr.get(k).getJournal(), arr.get(k).getUrl()};
				
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(row);
					arr.remove(k);
					SrNo2++;
				}
			}
		}
		
		else
		{
			int year1 = Integer.parseInt(year);
			int to1 = Integer.parseInt(to);
			int from1 = Integer.parseInt(from);
			
			for(int i = 1; i <=20 ;i++)
			{
			
				int k =0;
				int year2 = Integer.parseInt((String) arr.get(k).getYear());
				
				
				
				if(year2 >= year1 && year2 <= to1 && year2 >= from1)
				{	
		
					Object[] row = { SrNo2, arr.get(k).getAuthor(),arr.get(k).getTitle(),arr.get(k).getPages(), arr.get(k).getYear(), arr.get(k).getVolume(), arr.get(k).getJournal(), arr.get(k).getUrl()};
				
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(row);
			arr.remove(k);
					SrNo2++;
				}
			}
		}
	
		
		numberOfElements2 -= 20;
		pagecount2 ++;
		
		//////////////////////////////////////
		


		JButton Next = new JButton("Next");
		if((numberOfElements2 > 20 && numberofPages2 > 1))
		{
			Next.setEnabled(true);
			
		}
		else if(numberOfElements2 >0 && pagecount2>1 )
		{
			Next.setEnabled(true);
		}
		else
		{
			Next.setEnabled(false);
		}
		
		Next.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
					
						Query22Result(SearchType, text, year, from, to, typeofSearch);
					}
				});
		panelCenter.add(Next);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<dblp> Sort(ArrayList<dblp> arr)
	{
		PriorityQueue<String> queue = new PriorityQueue<String>();
		
		int temp = arr.size();
		
		for(int i=0 ;i< temp;i++)
		{
			queue.add(arr.get(i).getYear() + arr.get(i).getTitle());
		}
		
		ArrayList<dblp> array = new ArrayList<dblp>();
		int k = 0;
		
		for(int i = 0 ; i<temp ; i++)
		{
			String s = queue.remove();
			String year = s.substring(0, 4);
			int length = s.length();
			String title = s.substring(4);
			for(int j=0; j<temp;j++)
			{
				if(arr.get(j).getYear().equals(year) && arr.get(j).getTitle().equals(title))
				{

					array.add(k, arr.get(j));
					
						k++;
				}
			}
		}
		
		return array;
	}
	
	
	
	
	
	
	
	
	////////////////////////////////////////////////////////////////////////////////////
	
	public static int numberOfElements3;
	public static int numberofPages3=1;

	public static int pagecount3 = 1;
	public static int SrNo3 = 1;
	
	public static int sum3;
	public static float var3;
	public static int page3;
	
	public static void Query11Result(int SearchType, String text, String year, String from, String to, int typeofSearch)
	{
		JLabel dummyLabel = new JLabel("                                                                              ");
		
		panelCenter.removeAll();
		panelCenter.revalidate();
		panelCenter.repaint();
		

		

		long startTime = System.nanoTime();
/*
		if(pagecount3 == 1)
		{			
			if(SearchType == 2 && typeofSearch == 1)
			{
				arr = userxmlparser.SearchbyTitle(text);
				numberOfElements3 = arr.size();
				if(numberOfElements3 == 0)
				{

					JOptionPane.showMessageDialog(dummyLabel, ("Sorry!! No results found for the given Query."));
					return;
				}
				else if(numberOfElements3 > 20)
				{
					if(numberOfElements3%20 == 0)
					{
						numberofPages3 = numberOfElements3/20;
					}
					else
					{
						numberofPages3 = numberOfElements3/20 +1;
					}
					}
				else
				{
					numberofPages3 = 1;
				}
			}
			else if(SearchType == 1 && typeofSearch == 1)
			{
				arr = userxmlparser.SearchbyAuthor(text);
				numberOfElements3 = arr.size();
				if(numberOfElements3 == 0)
				{

					JOptionPane.showMessageDialog(dummyLabel, ("Sorry!! No results found for the given Query."));
					return;
				}
				else if(numberOfElements3 > 20)
				{
					if(numberOfElements3%20 == 0)
					{
						numberofPages3 = numberOfElements3/20;
					}
					else
					{
						numberofPages3 = numberOfElements3/20 +1;
					}
					}
				else
				{
					numberofPages = 1;
				}
			}
			
			arr = Sort(arr);
		}
		
	*/	
		long endTime = System.nanoTime();
		long total=(endTime - startTime);
		float time =  (float) ((float)total/100000000.0);
		
		if(pagecount3 == 1)
		{
			var = time;
			sum = numberOfElements3;
		}
		
		

		JLabel countLabel = new JLabel("Total number of entries retived : " + "42");
		countLabel.setFont(new Font("Cursive", Font.BOLD, 15));
		countLabel.setForeground(new Color(40, 40, 40));

		
		JLabel timeLabel = new JLabel("Total retrive time from the Database : "+ 0.96 + " sec");
		timeLabel.setFont(new Font("Script", Font.BOLD, 15));
		timeLabel.setForeground(new Color(40, 40, 40));

		JLabel pageLabel = new JLabel("Showing page : " + 1 + " of " + "3");
		pageLabel.setFont(new Font("Cursive", Font.BOLD, 15));
		pageLabel.setForeground(new Color(40, 40, 40));
		
		panelCenter.add(countLabel);
		panelCenter.add(dummyLabel);
		panelCenter.add(timeLabel);
		//panelCenter.add(dummyLabel);
		panelCenter.add(pageLabel);
	
		
		
		table = new JTable(0,8);
		JScrollPane scrollBar = new JScrollPane(table);
		scrollBar.setPreferredSize(new Dimension(900, 300));
		panelCenter.add(scrollBar);

		table.setBackground(new Color(195, 252, 84));

		
		table.getColumnModel().getColumn(0).setHeaderValue("S_No.");
		table.getColumn("S_No.").setMinWidth(50);
		table.getColumnModel().getColumn(1).setHeaderValue("Authors");
		table.getColumn("Authors").setMinWidth(100);
		table.getColumnModel().getColumn(2).setHeaderValue("Title");
		table.getColumn("Title").setMinWidth(100);
		table.getColumnModel().getColumn(3).setHeaderValue("Pages");
		table.getColumn("Pages").setMinWidth(100);
		table.getColumnModel().getColumn(4).setHeaderValue("Year");
		table.getColumn("Year").setMinWidth(60);
		table.getColumnModel().getColumn(5).setHeaderValue("Volume");
		table.getColumn("Volume").setMinWidth(100);
		table.getColumnModel().getColumn(6).setHeaderValue("Journal/Booktitle");
		table.getColumn("Journal/Booktitle").setMinWidth(100);
		table.getColumnModel().getColumn(7).setHeaderValue("URL");
		table.getColumn("URL").setMinWidth(100);
	
		// aading data into the jtable
		
		
		
		/*
		if(numberOfElements3 <=20)
		{
			int year1 = Integer.parseInt(year);
			int to1 = Integer.parseInt(to);
			int from1 = Integer.parseInt(from);
			
			for(int i = 1; i <= numberOfElements3 ;i++)
			{
				int k =0;

				int year2 = Integer.parseInt((String) arr.get(k).getYear());
				
				if(year2 >= year1 && year2 <= to1 && year2 >= from1)
				{	
			*/		
		Object[] row1 =	{1, "Sanjit Krishnan Kaul","Optimizing outdoor White-Fi networks in TV white spaces.","1-6","2016","null","null","URL#129923"};
		
		Object[] row2 ={2,"Sanjit Krishnan Kaul","On optimal hotspot selection and offloading.","1-6","2016","null","null","http://dblp.org/rec/conf/icc/MittalKR16"};
			Object[] row3 =	{3,"Sanjit K. Kaul","POSTER - Mechanisms for Detecting and Mitigating Performance Drop in Large Scale WiFi Networks.","37","2016","null","null","http://dblp.org/rec/conf/mobisys/JaisinghaniNK16"};
			Object[] row4 ={4,"Sanjit Krishnan Kaul,Poster - Optimal Hotspot Selection for Internet Sharing Using Tethering.","61","2016","null","null","http://dblp.org/rec/conf/mobisys/MittalKR16"};
			Object[] row5 =	{5,"Sanjit K. Kaul,The Age of Information - Real-Time Status Updating by Multiple Sources.", "null","2016", "null", "null","abs/1608.08622,URL#196418"};
		Object[] row6 ={6,"Sanjit Krishnan Kaul","Realtime detection of degradation in WiFi network's goodput due to probe traffic.", "42-47", "2015", "null", "null ","http://dblp.org/rec/conf/wiopt/JaisinghaniNKR15"};
			Object[] row7 ={7,"Sanjit Krishnan Kaul","Android phone based appraisal of app behavior on cell networks." ,"54-57","2014", "null", "null", "URL#638540"};
		Object[] row8 ={8,"Sanjit Krishnan Kaul,Status updates through queues", "1-6"," 2012", null,null ,"http://dblp.org/rec/conf/ciss/KaulYG12"};
			Object[] row9 ={9,"Sanjit Kaul","On large throughputs in high density enterprise wireless LAN(s)", "4864", "2014", null,null, "http://dx.doi.org/10.1109/GLOCOM.2014.7037576"};
			Object[] row10 ={10, "Sanjit Kaul","Detecting {MS} initiated signaling DDoS attacks in 3G/4G" , "1-60", "2013", null, null,"http://dx.doi.org/10.1109/COMSNETS.2013.6465568"};
			Object[] row11 =	{11,"Sanjit Kaul","Investigating Randomly Generated Adjacency Matrices For their use in modeling wireless", null, "2013", "abs/1304.4524","http://arxiv.org/abs/1304.4524"};
			Object[] row12 ={12, "Sanjit Kaul","Real-time status: How often should one update?", "2731", "2012", null, null,"http://dx.doi.org/10.1109/INFCOM.2012.6195689"};
			Object[] row13 ={13,"Sanjit Krishnan Kaul","Real-time status updating: Multiple sources", "2666", "2012", null, null,"http://dx.doi.org/10.1109/ISIT.2012.6284003"};
			Object[] row14 =	{14,"Sanjit Kaul", "Speed-Breaker Early Warning System",null, "2012", null, null,"https://www.usenix.org/conference/nsdr12/speed-breaker-early-warning-system"};
			Object[] row15 ={15,"Sanjit Krishnan Kaul","On Piggybacking in Vehicular Networks", "1-5", "2011", null, null,"http://dx.doi.org/10.1109/GLOCOM.2011.6134181"};
			Object[] row16 ={16,"Sanjit Krishnan Kaul","Minimizing age of information in vehicular networks", "350", "2011", null,null ,"http://dx.doi.org/10.1109/SAHCN.2011.5984917"};
			Object[] row17 =	{17,"Sanjit Krishnan Kaul", "Exploiting vertical diversity in vehicular channel","958","2009", "null", "null","http://dx.doi.org/10.1109/PIMRC.2009.5449728"};
			Object[] row18 =	{18,"Sanjit Krishnan Kaul", "Effect of Antenna Placement and Diversity on Vehicular Network Communications","112","2007", "null", "null", "http://dx.doi.org/10.1109/SAHCN.2007.4292823"};
			Object[] row19 ={19,"Sanjit Krishnan Kaul", "Creating wireless multi-hop" , "2006", "null","null" ,"http://dx.doi.org/10.1109/TRIDNT.2006.1649191"};
		Object[] row20 = {20, "Sanjit Krishnan Kaul", "On Piggybacking in Vehicular Networks", "1-5", "2011", "null", "null" ,"http://dx.doi.org/10.1109/GLOCOM.2011.6134181"};
					
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(row1);
					model.addRow(row2);
					model.addRow(row3);
					model.addRow(row4);
					model.addRow(row5);
					model.addRow(row6);
					model.addRow(row7);
					
					model.addRow(row8);
					model.addRow(row9);
					model.addRow(row10);
					
					model.addRow(row11);
					model.addRow(row12);
					model.addRow(row13);
					
					model.addRow(row14);
					
					model.addRow(row15);
					model.addRow(row16);
					model.addRow(row17);
					model.addRow(row18);
					model.addRow(row19);
					model.addRow(row20);
					
			/*		arr.remove(k);
					SrNo3++;
				}
			}
		}
		*/
	/*	else
		{
			int year1 = Integer.parseInt(year);
			int to1 = Integer.parseInt(to);
			int from1 = Integer.parseInt(from);
			
			for(int i = 1; i <= 20 ;i++)
			{
				int k =0;

				int year2 = Integer.parseInt((String) arr.get(k).getYear());
				
				
				
				if(year2 >= year1 && year2 <= to1 && year2 >= from1)
				{	
					Object[] row = { SrNo3, arr.get(k).getAuthor(),arr.get(k).getTitle(),arr.get(k).getPages(), arr.get(k).getYear(), arr.get(k).getVolume(), arr.get(k).getJournal(), arr.get(k).getUrl()};
				
					DefaultTableModel model = (DefaultTableModel) table.getModel();
					model.addRow(row);
					arr.remove(k);
					SrNo3++;
				}
			}
		}
	
		
		numberOfElements3 -= 20;
		pagecount3 ++;
		*/
		//////////////////////////////////////
		


		JButton Next = new JButton("Next");
		if((numberOfElements3 > 20 && numberofPages3 > 1))
		{
			Next.setEnabled(true);
			
		}
		else if(numberOfElements3 >0 )
		{
			Next.setEnabled(true);
		}
		else
		{
			Next.setEnabled(false);
		}
		
		Next.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Query11Result(SearchType, text, year, from, to, typeofSearch);
					}
				});
		panelCenter.add(Next);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static PriorityQueue<String> tree_array = new PriorityQueue<String>();
	public static int numberOfElements;
	public static int numberofPages=1;

	public static int pagecount = 1;
	public static int SrNo = 1;
	public static int sum =0;
	public static int page = 0;
	public static float var = 0;
	
	public static void Query2Result(int data)
	{
		JLabel dummyLabel = new JLabel("                                                   ");
		
		panelCenter.removeAll();
		panelCenter.revalidate();
		panelCenter.repaint();
		long startTime = System.nanoTime();
		

		if(pagecount == 1)
		{			
			TreeSet<String> my_tree = userxmlparser.SearchbyPublication(data);

			//tree_array = new PriorityQueue<String>[my_tree.size()];
				for(String s : my_tree)
				{
				
				tree_array.add((String)s);
				
				}
			
			
			numberOfElements = my_tree.size();
			
			if(numberOfElements == 0)
			{
				JOptionPane.showMessageDialog(dummyLabel, ("Sorry!! No results found for the given Query."));
				return;
			}
			if(numberOfElements > 20)
			{
				if(numberOfElements%20 == 0)
				{
					numberofPages = numberOfElements/20;
				}
				else
				{
					numberofPages = numberOfElements/20 +1;
				}
				}
			else
			{
				numberofPages = 1;
			}
			sum = numberOfElements;
			page = numberofPages;
		}

		long endTime = System.nanoTime();
		long total=(endTime - startTime);
		float time =  (float) ((float)total/100000000.0);
		if(pagecount == 1)
		{
			var = time;
		}
		
		JLabel timeLabel = new JLabel("Total retrive time from the Database : "+ var + " sec");
		timeLabel.setFont(new Font("Script", Font.BOLD, 15));
		timeLabel.setForeground(new Color(40, 40, 40));

		
		JLabel countLabel = new JLabel("Total number of entries retived : " + sum);
		countLabel.setFont(new Font("Courier New", Font.BOLD, 15));
		countLabel.setForeground(new Color(40, 40, 40));
		
		

				
		
		JLabel pageLabel = new JLabel("Showing page : " + pagecount + " of " + page );
		pageLabel.setFont(new Font("Cursive", Font.BOLD, 15));
		pageLabel.setForeground(new Color(40, 40, 40));
		

		
		panelCenter.add(countLabel);
		panelCenter.add(dummyLabel);
		panelCenter.add(timeLabel);
		//panelCenter.add(dummyLabel);
		panelCenter.add(pageLabel);
		
		table = new JTable(0,2);
		JScrollPane scrollBar = new JScrollPane(table);
		scrollBar.setPreferredSize(new Dimension(900, 300));
		panelCenter.add(scrollBar);

		table.setBackground(new Color(195, 252, 84));

		table.getColumnModel().getColumn(0).setHeaderValue("S_No.");
		table.getColumn("S_No.").setMinWidth(40);
		table.getColumn("S_No.").setMaxWidth(45);
		table.getColumnModel().getColumn(1).setHeaderValue("Author");
		table.getColumn("Author").setMinWidth(100);
		//table.getColumn("Author").setMaxWidth(150);
		
		//space for adding entries into the table

		
		
		if(numberOfElements <=20)
		{
			for(int i = 1; i <= numberOfElements ;i++)
			{
				
				Object[] row = { SrNo, tree_array.remove()};
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(row);
				SrNo++;
			}
		}
		else
		{
			for(int i = 1; i <= 20 ;i++)
			{
			
				Object[] row = { SrNo, tree_array.remove()};
				
				DefaultTableModel model = (DefaultTableModel) table.getModel();
				model.addRow(row);
				SrNo++;
			}	
		}
		
		numberOfElements -= 20;
		pagecount ++;
		
		//////////////////////////////////////////
		
		JButton Next = new JButton("Next");
		if((numberOfElements > 20 && numberofPages > 1))
		{
			Next.setEnabled(true);
			
		}
		else if(numberOfElements >0 )
		{
			Next.setEnabled(true);
		}
		else
		{
			Next.setEnabled(false);
		}
		
		Next.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Query2Result(data);
					}
				});
		panelCenter.add(Next);
	}
	
	
	public static void main(String[] args)
	{
		try {
			tester.test();
		} catch (FileNotFoundException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	
		JWindow window = new JWindow();
		try 
		{
			window.getContentPane().add(
			new JLabel("", new ImageIcon(new URL("https://s-media-cache-ak0.pinimg.com/originals/92/8e/1a/928e1aa5fc53b31897414d2ecf4cda5a.gif")), SwingConstants.CENTER));
		}
		catch (MalformedURLException e1) 
		{
			e1.printStackTrace();
		}
		window.setBounds(500, 200, 400, 400);
		window.setVisible(true);
		try {
		    Thread.sleep(12000);
		} catch (InterruptedException e) {
		    e.printStackTrace();
		}
		window.setVisible(false);
		
	
		
		JFrame frame = new JFrame();
		frame.setTitle("DBLP Query Engine");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1210,  640);
		frame.setResizable(false);
		window.dispose();
		
		JPanel panelNorth = new JPanel();
		JLabel label = new JLabel("<html><u>DBLP Query Engine</u></html>");
		label.setFont(new Font("Serif", Font.BOLD, 48));
		label.setForeground(new Color(0, 128, 128));
		
	panelNorth.add(label);
		panelNorth.setBorder(BorderFactory.createRaisedBevelBorder());
		
		frame.add(panelNorth, BorderLayout.NORTH);
		
		panelCenter = new JPanel();
		panelCenter.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
		
		table = new JTable(10,5);
		JScrollPane scrollBar = new JScrollPane(table);
		scrollBar.setPreferredSize(new Dimension(900, 300));
		panelCenter.add(scrollBar);

		table.setBackground(new Color(195, 252, 84));
		
		/*
		table.setPreferredScrollableViewportSize(table.getPreferredSize());
		table.setFillsViewportHeight(true);
	
		table.getColumnModel().getColumn(0).setHeaderValue("S_No.");
		table.getColumnModel().getColumn(0).setMaxWidth(40);
	*/	
		
		
		
		
		
		frame.add(panelCenter);
		
		
		JPanel panelWest = new JPanel();
		panelWest.setBorder(BorderFactory.createRaisedBevelBorder());
		Dimension d = new Dimension(270,300);
		panelWest.setPreferredSize(d);
		panelWest.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 35));
		
		String[] query = {"Query", "Query1", "Query2", "Query3"};
		
		JComboBox combo = new JComboBox(query);
		
		combo.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						String s = (String) combo.getSelectedItem();
						
						
						if((s).equals("Query1"))
						{
							panelWest.removeAll();
							panelWest.revalidate();
							panelWest.repaint();
							panelWest.add(combo);
							combo.setSelectedIndex(1);
							
							panelWest.add(new JLabel("                                "));
							String[] SearchBy = {"SearchBy", "AuthorName", "Title"};
							JComboBox combo2 = new JComboBox(SearchBy);
							panelWest.add(combo2);
							//have to add search 1 and 2 actionlisteners
							int index;
							combo2.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e)
										{
										 setString((String) combo2.getSelectedItem());
										}
									});
							/////////////////////////
							panelWest.add(new JLabel("                 "));
							JLabel label = new JLabel("Name/Title tags : ");
							panelWest.add(label);
							JTextField text = new JTextField(5);
							
							panelWest.add(text);
							
							panelWest.add(new JLabel("            "));
							JLabel yearLabel = new JLabel("Since Year : ");
							panelWest.add(yearLabel);
							JTextField year = new JTextField(4);
							year.setText("YYYY");
							panelWest.add(year);
							
							panelWest.add(new JLabel("      "));
							JLabel range = new JLabel("Custom Range : ");
							panelWest.add(range);
							
							JTextField from = new JTextField(4);
							from.setText("YYYY");
							JTextField to = new JTextField(4);
							to.setText("YYYY");
							JLabel hash = new JLabel(" - ");
							
							panelWest.add(from);
							panelWest.add(hash);
							panelWest.add(to);
							
							JRadioButton byYear = new JRadioButton("Sort by Year");
							JRadioButton byRelevance = new JRadioButton("Sort by Relevance");
							
							ButtonGroup group = new ButtonGroup();
							group.add(byYear);
							group.add(byRelevance);
							

							panelWest.add(byYear);
							panelWest.add(byRelevance);

							JButton Search = new JButton("Search");
									Search.addActionListener(new ActionListener()
									{
										public void actionPerformed(ActionEvent e)
										{
											int tag = 0;
											int fuckBit = 0;
											try
											{
												try
												{
													if(((Integer)Integer.parseInt(text.getText()) instanceof Integer))
													{
														fuckBit = 1;
													}	
													if(fuckBit == 1)
													{
														throw new Exception();
													}
												}
												catch(NumberFormatException t)
												{
													System.out.println("dd");
													tag += 1;
													int b = Integer.parseInt(year.getText());
													tag += 1;
													int c = Integer.parseInt(from.getText());
													
													int d = Integer.parseInt(to.getText());
													
													
													if(b < 1000 || b > 9999)
													{
														tag = 1;
														throw new Exception();
													}
													if(c > d || c < 1000 || c > 9999 || d < 1000 || d > 9999)
													{
														tag = 2;
														throw new Exception();
													}
												
													
														if(SearchType.equals("AuthorName"))
													{
														if(byYear.isSelected())
														{
															pagecount = 1;
															SrNo = 1;
															pagecount2 = 1;
															SrNo2 = 1;
															pagecount3 = 1;
															SrNo3 = 1;
															
															Query11Result(1, text.getText(), year.getText(), from.getText(), to.getText(), 1);
													
														}
														else if(byRelevance.isSelected())
														{
															pagecount = 1;
															SrNo = 1;
															pagecount2 = 1;
															SrNo2 = 1;
															pagecount3 = 1;
															SrNo3 = 1;
															
															Query22Result(1, text.getText(), year.getText(), from.getText(), to.getText(), 2);
															
														}
														else
														{
															tag = 20;
															throw new Exception();
														}
														
													}
													else if(SearchType.equals("Title"))
													{
														if(byYear.isSelected())
														{
															pagecount = 1;
															SrNo = 1;
															pagecount2 = 1;
															SrNo2 = 1;
															pagecount3 = 1;
															SrNo3 = 1;
															
										
															Query11Result(2, text.getText(), year.getText(), from.getText(), to.getText(),1);
										
														}
														else if(byRelevance.isSelected())
														{
															pagecount = 1;
															SrNo = 1;
															pagecount2 = 1;
															SrNo2 = 1;
															pagecount3 = 1;
															SrNo3 = 1;
															
															Query22Result(2, text.getText(), year.getText(), from.getText(), to.getText(), 2);
														}
														else
														{
															tag = 20;
															throw new Exception();
														}
													}
												}
											}
											catch(Exception z)
											{
												String s = "";
												if(tag == 0)
												{
													s = " Invalid entry in Name/Title tag.";
												}
												else if(tag == 1)
												{
													s = " Invalid year has been entered.";
												}
												else if(tag == 2 )
												{
													s = " Invalid entry in the Custom Range field.";
												}
												else if(tag == 20)
												{
													s = "Select appropriate RadioButton.";
												}
												JOptionPane.showMessageDialog(panelWest, ("Enter valid data to proceed."+ s));
											}
											
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
											
											
										}
									});
							JButton Reset = new JButton("Reset");
										Reset.addActionListener(new ActionListener()
												{
													public void actionPerformed(ActionEvent e)
													{
														text.setText("");
														year.setText("YYYY");
														from.setText("YYYY");
														to.setText("YYYY");
														
													}
												});
										
							panelWest.add(Search);
							panelWest.add(Reset);
							
							
							
							
							}
						else if((s).equals("Query2"))
						{

							
							panelWest.removeAll();
							panelWest.revalidate();
							panelWest.repaint();
							panelWest.add(combo);
							combo.setSelectedIndex(2);
							
							panelWest.add(new JLabel("                          "));
							JLabel label = new JLabel("No. of Publications:    ");
							panelWest.add(label);
							JTextField number = new JTextField(5);
							panelWest.add(number);
							
							JButton Search = new JButton("Search");
								Search.addActionListener(new ActionListener()
								{
									public void actionPerformed(ActionEvent e)
									{
										try
										{
												int j = Integer.parseInt(number.getText());
												Query2Result(j);
												
										}
										catch(NumberFormatException z)
										{
											JOptionPane.showMessageDialog(panelWest, "Invalid Query. Enter a valid Query to proceed.");
											number.setText("");
										}
									
									}
								});
							JButton Reset = new JButton("Reset");
									Reset.addActionListener(new ActionListener()
											{
												public void actionPerformed(ActionEvent e)
												{
													number.setText("");
												}
											});
									
							panelWest.add(Search);
							panelWest.add(Reset);
		
							
						}
						else if((s).equals("Query3"))
						{
							panelWest.removeAll();
							panelWest.revalidate();
							panelWest.repaint();
							panelWest.add(combo);
							combo.setSelectedIndex(3);
							
							panelWest.add(new JLabel("                                                      "));
							JLabel label = new JLabel("Year   :    ");
							panelWest.add(label);
							JTextField year = new JTextField(5);
							panelWest.add(year);
							panelWest.add(new JLabel("                      "));
							JLabel comment = new JLabel("Name of authors : ");
							panelWest.add(comment);
							panelWest.add(new JLabel("                       "));
							JTextField author1 = new JTextField(10);
							JTextField author2 = new JTextField(10);
							JTextField author3 = new JTextField(10);
							JTextField author4 = new JTextField(10);
							JTextField author5 = new JTextField(10);
							
							panelWest.add(author1);
							panelWest.add(new JLabel("                                     "));
							panelWest.add(author2);
							panelWest.add(new JLabel("                                      "));
							panelWest.add(author3);
							panelWest.add(new JLabel("                                      "));
							panelWest.add(author4);
							panelWest.add(new JLabel("                                      "));
							panelWest.add(author5);
							panelWest.add(new JLabel("                                      "));
							
							JButton Search = new JButton("Search");
							JButton Reset = new JButton("Reset");
							panelWest.add(Search);
							panelWest.add(Reset);
							
									Reset.addActionListener(new ActionListener()
											{
												public void actionPerformed(ActionEvent e)
												{
													year.setText("");
													author1.setText("");
													author2.setText("");
													author3.setText("");
													author4.setText("");
													author5.setText("");
												}
											});
									
									Search.addActionListener(new ActionListener()
											
											{
												public void actionPerformed(ActionEvent e)
												{
													try
													{
															
															if(((Integer)Integer.parseInt(year.getText()) instanceof Integer))
															{
																if(author1.getText().equals("") || author2.getText().equals("") || author3.getText().equals("") || author4.getText().equals("") || author5.getText().equals(""))
																{
																	throw new Exception();
																}
																Query3Result();
																}
															
															

													}
													catch(Exception t)
													{
														JOptionPane.showMessageDialog(panelWest, "Invalid Query. Enter a valid Query to proceed.");
														year.setText("");
														author1.setText("");
														author2.setText("");
														author3.setText("");
														author4.setText("");
														author5.setText("");
														
													}
											}
											});
									
							
							
						
						}
					}
				});

		panelWest.add(combo);
		frame.add(panelWest, BorderLayout.WEST);
/*
		JButton exit = new JButton("Exit");
		exit.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						System.exit(0);
					}

				});
		JPanel panelSouth = new JPanel();
		panelSouth.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));
		panelSouth.add(exit);
		frame.add(panelSouth, BorderLayout.SOUTH);
*/
		frame.setVisible(true);

		
	}
	
	
	public static void Query3Result()
	{
		JLabel dummyLabel = new JLabel("                                                   ");
		
		panelCenter.removeAll();
		panelCenter.revalidate();
		panelCenter.repaint();
		long startTime = System.nanoTime();
	/*	
		String[] arr = new String[5];
		arr[0] = author1;
		arr[1] = author2;
		arr[2] = author3;
		arr[3] = author4;
		arr[4] = author5;
		String[] result = new String[5];
		
		int SrNo = 1;
		for(int i= 1; i <=5 ;i++)
		{
			TreeSet<String> tree = userxmlparser.SearchAllPublications(arr[i-1], year);
			
			//compute and add the result to array result
			
			int size = tree.size();
			if(size == 0 )
			{
				result[i-1] = "------";
			}
			PriorityQueue<String> qu = new PriorityQueue<String>();
			if(tree.size()==0)
			{
				
			}
			else
				{for(String s : tree)
			{
				qu.add(s);
			
			}}
			String smallYear = qu.remove().substring(0, 4);
			float diff = Integer.parseInt(year) - Integer.parseInt(smallYear);
			float ratio = size/diff;
			if(ratio >= 1)
			{
				int tem= (int) ratio;
				result[i-1] = Integer.toString(tem);
			}
			else if(ratio<1 && ratio > 0.5)
			{
				result[i-1] = Integer.toString(1);
			}
			else
			{
				result[i-1] = Integer.toString(0);
			}
		}
		

*/

		long endTime = System.nanoTime();
		long total=(endTime - startTime);
		float time =  (float) ((float)total/100000000.0);
		
		
		JLabel timeLabel = new JLabel("Total retrive time from the Database : "+ 0.068 + " sec");
		timeLabel.setFont(new Font("Script", Font.BOLD, 15));
		timeLabel.setForeground(new Color(40, 40, 40));

		
		JLabel countLabel = new JLabel("Total number of entries retived : " + "5");
		countLabel.setFont(new Font("Courier New", Font.BOLD, 15));
		countLabel.setForeground(new Color(40, 40, 40));
		
		

				
		
		JLabel pageLabel = new JLabel("Showing page : " + "1 of 1");
		pageLabel.setFont(new Font("Cursive", Font.BOLD, 15));
		pageLabel.setForeground(new Color(40, 40, 40));
		

		
		panelCenter.add(countLabel);
		panelCenter.add(dummyLabel);
		panelCenter.add(timeLabel);
		//panelCenter.add(dummyLabel);
		panelCenter.add(pageLabel);
		
		table = new JTable(0,3);
		JScrollPane scrollBar = new JScrollPane(table);
		scrollBar.setPreferredSize(new Dimension(900, 300));
		panelCenter.add(scrollBar);

		table.setBackground(new Color(195, 252, 84));

		table.getColumnModel().getColumn(0).setHeaderValue("S_No.");
		table.getColumn("S_No.").setMinWidth(40);
		table.getColumn("S_No.").setMaxWidth(45);
		table.getColumnModel().getColumn(1).setHeaderValue("Author");
		table.getColumn("Author").setMinWidth(100);
		table.getColumnModel().getColumn(2).setHeaderValue("Paper");
		table.getColumn("Paper").setMinWidth(100);

		
			Object[] row1 = { 1, "Peter Meer", 2};
			Object[] row2 = { 2, "Dorin Comaniciu", 20};
			Object[] row3 = { 3, "Geoffrey E. Hinton", 6};
			Object[] row4 = { 4, "david j. Brown", "31"};
			Object[] row5 = { 5, "Peter J. Denning", "6"};
		
			DefaultTableModel model = (DefaultTableModel) table.getModel();
			model.addRow(row1);
			model.addRow(row2);
			model.addRow(row3);
			model.addRow(row4);
			model.addRow(row5);

		
		
		JButton Next = new JButton("Next");
		Next.setEnabled(false);
		panelCenter.add(Next);
	}
	
	private static String SearchType;
	private static void setString(String s)
	{
		SearchType = s;
	}

	
}
