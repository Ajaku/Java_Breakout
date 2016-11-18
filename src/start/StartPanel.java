package start;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;
import main.*;

public class StartPanel extends JPanel implements ActionListener{
	boolean in_game = true;
	AppletContext ac;	//繧｢繝励Ξ繝�繝医�ｮ繧ｳ繝ｳ繝�繧ｭ繧ｹ繝�
	URL cb;	//HTML 繝輔ぃ繧､繝ｫ縺檎ｴ�譚舌☆繧� URL
	Dimension size;	//繧｢繝励Ξ繝�繝医�ｮ螟ｧ縺阪＆
	MainPanel mp;
	JButton bt;

			//繧ｳ繝ｳ繝医Λ繧ｯ繧ｿ
	public StartPanel(AppletContext acl, URL cbl, Dimension sizel, MainPanel mpl){
		ac = acl;
		cb = cbl;
		size = sizel;
		mp = mpl;

			//繝ｬ繧､繧｢繧ｦ繝医�槭ロ繝ｼ繧ｸ繝｣繝ｼ縺ｮ蛛懈ｭ｢
		setLayout(null);

			//閭梧勹濶ｲ縺ｮ險ｭ螳�
		setBackground(Color.white);

			//繝懊ち繝ｳ縺ｮ驟咲ｽｮ
		Font f = new Font("SansSerif", Font.BOLD, 20);
		FontMetrics fm = getFontMetrics(f);
		String str = "遊び方";
		int w = fm.stringWidth(str) + 40;
		int h = fm.getHeight() + 10;
		bt = new JButton(str);
		bt.setFont(f);
		bt.addActionListener(this);
		bt.setSize(w, h);
		bt.setLocation(size.width/2-w/2, 5);
		add(bt);

			//繝槭え繧ｹ繝ｪ繝翫�ｮ霑ｽ蜉�
		addMouseListener(new Mouse());
	}

			//謠冗判
	public void paintComponent(Graphics g){
		super.paintComponent(g);	//隕ｪ繧ｯ繝ｩ繧ｹ縺ｮ謠丞��
		FontMetrics fm;
		Font f;
		String str;
		int w, h;

		f	= new Font("SansSerif", Font.BOLD, 40);
		fm 	= g.getFontMetrics(f);
		str = "ブロック崩し";
		w 	= fm.stringWidth(str);
		h 	= fm.getHeight();
		g.setFont(f);
		g.drawString(str, size.width/2-w/2, size.height/2);

		f 	= new Font("Serif", Font.PLAIN, 20);
		fm 	= g.getFontMetrics(f);
		str = "ゲーム開始：ダブルクリック";
		w 	= fm.stringWidth(str);
		h 	= size.height - fm.getHeight() - 10;
		g.setFont(f);
		g.drawString(str, size.width/2-w/2, h);
	}

			//繝懊ち繝ｳ縺後け繝ｪ繝�繧ｯ縺輔ｌ縺溘→縺阪�ｮ蜃ｦ逅�
	public void actionPerformed(ActionEvent e){
		URL url;
		if (e.getSource() == bt){
			try{
				url = new URL(cb + "start/method.htm");
				ac.showDocument(url, "method");
				requestFocusInWindow();
			}

			catch (MalformedURLException me){
				System.out.println("Bad URL: method.htm");
			}
		}
	}
			//繝�繝悶Ν繧ｯ繝ｪ繝�繧ｯ縺輔ｌ縺溘→縺阪�ｮ蜃ｦ逅�
	class Mouse extends MouseAdapter{
		public void mouseClicked(MouseEvent e){
			if (e.getClickCount() == 2)
				mp.state = 1;
		}
	}
}
