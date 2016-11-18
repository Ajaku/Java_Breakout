package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;
import java.util.Random;
import main.*;

public class GamePanel extends JPanel implements ActionListener, Runnable{
	AppletContext ac;	//繧｢繝励Ξ繝�繝医�ｮ繧ｳ繝ｳ繝�繧ｭ繧ｹ繝�
	URL cb;	//HTML 繝輔ぃ繧､繝ｫ縺悟ｭ伜惠縺吶ｋ URL
	Dimension size;	//繧｢繝励Ξ繝�繝医�ｮ螟ｧ縺阪＆
	MainPanel mp;
	JButton left, right;
	Racket rk;
	Ball bl;
	Block blk;	//繝悶Ο繝�繧ｯ
	Random rand;
	Thread td;
	boolean in_game = true;

			//繧ｳ繝ｳ繝医Λ繧ｯ繧ｿ
	public GamePanel(AppletContext acl, URL cbl, Dimension sizel, MainPanel mpl){
		ac = acl;
		cb = cbl;
		size = sizel;
		mp = mpl;

			//繝ｬ繧､繧｢繧ｦ繝医�槭ロ繝ｼ繧ｸ繝｣繝ｼ縺ｮ蛛懈ｭ｢
		setLayout(null);

			//閭梧勹濶ｲ縺ｮ險ｭ螳�
		setBackground(Color.white);

			//繝悶Ο繝�繧ｯ縺ｮ驟咲ｽｮ
		blk = new Block(ac, cb);

			//繝懊ち繝ｳ縺ｮ驟咲ｽｮ
		Font f = new Font("SansSerif", Font.BOLD, 15);
		FontMetrics fm = getFontMetrics(f);
		String strl = ("繧ｲ繝ｼ繝�繧ｯ繝ｪ繧｢");
		int w1 = fm.stringWidth(strl) + 40;
		int h1 = fm.getHeight() + 10;
		left.addActionListener(this);	//繧｢繧ｯ繧ｷ繝ｧ繝ｳ繝ｪ繧ｹ繝�
		left.setSize(w1, h1);

		String str2 = "繧ｲ繝ｼ繝�繧ｪ繝ｼ繝舌�ｼ";
		int w2 = fm.stringWidth(str2) + 40;
		int h2 = fm.getHeight() + 10;
		right = new JButton(str2);
		right.setFont(f);
		right.addActionListener(this);	//繧｢繧ｯ繧ｷ繝ｧ繝ｳ繝ｪ繧ｹ繝�
		right.setSize(w2, h2);

		int w = size.width / 2 - (w1 + w2 + 5) / 2;
		int h = size.height - h1 - 10;
		left.setLocation(w, h);
		add(left);
		right.setLocation(w+w1+5, h);
		add(right);

			//繝ｩ繝ｳ繝�繝�螟画焚縺ｮ蛻晄悄蛹�
		rand = new Random();

			//繝懊�ｼ繝ｫ蜿翫�ｳ繝ｩ繧ｱ繝�繝医�ｮ驟咲ｽｮ
		rk = new Racket(h-10, size, mp);
		bl = new Ball(blk, size, rand);

			//繧ｹ繝ｬ繝�繝峨�ｮ逕滓��
		td = new Thread(this);
		td.start();
	}

			//繧ｹ繝ｬ繝�繝峨�ｮ螳溯｡�
	public void run(){
		while (in_game){
			try{
				td.sleep(50);
			}
			catch (InterruptedException e){
			}
			bl.x += bl.vx;
			bl.y += bl.vy;
			repaint();
		}
	}

			//謠冗判
	public void paintComponent(Graphics g){
		super.paintComponent(g);	//隕ｪ繧ｯ繝ｩ繧ｹ縺ｮ謠冗判

			//繝悶Ο繝�繧ｯ
		for (int i1 = 0; i1 < blk.row; i1++){
			for (int i2 = 0; i2 < blk.col; i2++ ){
				if (blk.ex[i1][i2])
					g.drawImage(blk.block, blk.width*i2, blk.height*i1, this);
			}
		}

			//繝ｩ繧ｱ繝�繝�
		g.setColor(bl.color);
		g.fillOval(bl.x, bl.y, rk.width, rk.height);

			//繝懊�ｼ繝ｫ
		g.setColor(bl.color);
		g.fillOval(bl.x, bl.y, bl.r*2, bl.r*2);
	}

			//繝懊ち繝ｳ縺後け繝ｪ繝�繧ｯ縺輔ｌ縺溘→縺阪�ｮ蜃ｦ逅�
	public void actionPerformed(ActionEvent e){
		in_game = false;
		if(e.getSource() == left)	//繧ｲ繝ｼ繝�繧ｯ繝ｪ繧｢
			mp.state = 2;
		else	//繧ｲ繝ｼ繝�繧ｪ繝ｼ繝舌�ｼ
			mp.state = 3;
	}
}
