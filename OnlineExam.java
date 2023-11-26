import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class OnlineTest extends JFrame implements ActionListener
{
	JLabel l;
	JRadioButton jb[]=new JRadioButton[5];
	JButton b1,b2;
	ButtonGroup bg;
	int count=0,current=0,x=1,y=1,now=0;
	int m[]=new int[10];	
	OnlineTest(String s)
        {
		super(s);
		l=new JLabel();
		add(l);
		bg=new ButtonGroup();
		for(int i=0;i<5;i++)
		{
			jb[i]=new JRadioButton();	
			add(jb[i]);
			bg.add(jb[i]);
		}
		b1=new JButton("Next");
		b2=new JButton("Bookmark");
		b1.addActionListener(this);
		b2.addActionListener(this);
		add(b1);add(b2);
		set();
		l.setBounds(30,40,450,20);
		jb[0].setBounds(50,80,100,20);
		jb[1].setBounds(50,110,100,20);
		jb[2].setBounds(50,140,100,20);
		jb[3].setBounds(50,170,100,20);
		b1.setBounds(100,240,100,30);
		b2.setBounds(270,240,100,30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250,100);
		setVisible(true);
		setSize(600,350);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==b1)
		{
			if(check())
				count=count+1;
			current++;
			set();	
			if(current==9)
			{
				b1.setEnabled(false);
				b2.setText("Result");
			}
		}
		if(e.getActionCommand().equals("Bookmark"))
		{
			JButton bk=new JButton("Bookmark"+x);
			bk.setBounds(480,20+30*x,100,30);
			add(bk);
			bk.addActionListener(this);
			m[x]=current;
			x++;
			current++;
			set();	
			if(current==9)
				b2.setText("Result");
			setVisible(false);
			setVisible(true);
		}
		for(int i=0,y=1;i<x;i++,y++)
		{
		if(e.getActionCommand().equals("Bookmark"+y))
		{
			if(check())
				count=count+1;
			now=current;
			current=m[y];
			set();
			((JButton)e.getSource()).setEnabled(false);
			current=now;
		}
                }
	
		if(e.getActionCommand().equals("Result"))
		{
			if(check())
				count=count+1;
			current++;
			//System.out.println("correct ans="+count);
			JOptionPane.showMessageDialog(this,"correct ans="+count);
			System.exit(0);
		}
	}
	void set()
	{
		jb[4].setSelected(true);
		if(current==0)
		{
			l.setText("Que1: What is the most common type of loop used to step through an array?");
			jb[0].setText("while");jb[1].setText("For");jb[2].setText("Dowhile");jb[3].setText("All of the these");
		}
		if(current==1)
		{
			l.setText("Que2: Dynamic Methods Dispatch means");
			jb[0].setText("Static Binding");jb[1].setText("Dynamic Binding");jb[2].setText("Early Binding");jb[3].setText("ActionEvent");
		}
		if(current==2)
		{
			l.setText("Que3: Which package is directly available to our class without importing it");
         	jb[0].setText("swing");jb[1].setText("applet");jb[2].setText("net");jb[3].setText("lang");
		}
		if(current==3)
		{
			l.setText("Que4: which keyword is used for data hiding.");
			jb[0].setText("default");jb[1].setText("private");jb[2].setText("Public");jb[3].setText("all of the above");
		}
		if(current==4)
		{
			l.setText("Que5: Constructors can be overloaded");
			jb[0].setText("True");jb[1].setText("False");
		}
		if(current==5)
		{
			l.setText("Que6: Which one among these is not a keyword");
			jb[0].setText("class");jb[1].setText("int");jb[2].setText("get");jb[3].setText("if");
		}
		if(current==6)
		{
			l.setText("Que7: Which of these is a method to clear all the data present in output buffers? ");
			jb[0].setText("clear()");jb[1].setText("flush()");jb[2].setText("fflush()");jb[3].setText("close()");
		}
		if(current==7)
		{
			l.setText("Que8: What is the default capacity of java.util.HashMap?");
			jb[0].setText("Twenty");jb[1].setText("Sixteen");jb[2].setText("Eleven");jb[3].setText("Ten");
		}
		if(current==8)
		{
			l.setText("Que9: Each tree based collection assumes its elements to be of --- type?");
			jb[0].setText("Serializable");jb[1].setText("Comparator");jb[2].setText("Comparable");jb[3].setText("Sortable");
		}
		if(current==9)
		{
			l.setText("Que10: Which of these methods is a class of Abstract Window Toolkit (AWT) ?");
			jb[0].setText("FrameWindow");jb[1].setText("Window");jb[2].setText("MessageBox");jb[3].setText("JTextArea");
		}
		l.setBounds(30,40,450,20);
		for(int i=0,j=0;i<=90;i+=30,j++)
			jb[j].setBounds(50,80+i,200,20);
	}
	boolean check()
	{
		if(current==0)
			return(jb[1].isSelected());
		if(current==1)
			return(jb[1].isSelected());
		if(current==2)
			return(jb[3].isSelected());
		if(current==3)
			return(jb[1].isSelected());
		if(current==4)
			return(jb[0].isSelected());
		if(current==5)
			return(jb[2].isSelected());
		if(current==6)
			return(jb[1].isSelected());
		if(current==7)
			return(jb[1].isSelected());
		if(current==8)
			return(jb[2].isSelected());
		if(current==9)
			return(jb[1].isSelected());
		return false;
	}
	public static void main(String s[])
	{
		new OnlineTest("Online Test Of Java");
	}


}
