package over;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;
import main.*;

public class GameOverPanel extends JPanel implements ActionListener{
	AppletContext ac;	//アプレットのコンテキスト
	URL cb;	//HTML ファイルが存在する URL
	Dimension size;	//アプレットの大きさ
	MainPanel mp;
	JButton bt1, bt2, bt3;

				//コントラクタ
	public GameOverPanel(AppletContext acl, URL cbl, Dimension sizel, MainPanel mpl){
		ac = acl;
		cb = cbl;
		size = sizel;
		mp = mpl;

				//レイアウトマネージャーの停止
		setLayout(null);

				//背景色の設定
		setBackground(Color.white);
				//ボタンの配置
		Font f = new Font("SansSerif", Font.BOLD, 20);
		FontMetrics fm = getFontMetrics(f);
		String strl = "終了";
		int w1 = fm.stringWidth(strl) + 40;
		int h1 = fm.getHeight() + 10;
		bt1 = new JButton(strl);
		bt1.setFont(f);
		bt1.addActionListener(this);	//アクションリスナ
		bt1.setSize(w1, h1);

		String str2 = "現在のレベルで再開";
		int w2 = fm.stringWidth(strl) + 40;
		int h2 = fm.getHeight() + 10;
		bt2 = new JButton(strl);
		bt2.setFont(f);
		bt2.addActionListener(this);	//アクションリスナ
		bt2.setSize(w2, h2);

		String str3 = "最初から再開";
		int w3 = fm.stringWidth(strl) + 40;
		int h3 = fm.getHeight() + 10;
		bt3 = new JButton(strl);
		bt3.setFont(f);
		bt3.addActionListener(this);	//アクションリスナ
		bt3.setSize(w3, h3);

		int w = size.width / 2 - (w1 + w2 + w3 + 10) / 2;
		bt1.setLocation(w, size.height-h1-20);
		add(bt1);
		w += (w1 + 5);
		bt2.setLocation(w, size.height-h1-20);
		add(bt2);
		w += (w2 + 5);
		bt3.setLocation(w, size.height-h1-20);
		add(bt3);
	}

				//描画
	public void paintComponent(Graphics g){
		super.paintComponent(g);	//親クラスの描写
		Font f = new Font("SansSerif", Font.BOLD, 40);
		FontMetrics fm = g.getFontMetrics(f);
		String str = "Game Clear!";
		int w = fm.stringWidth(str);
		g.setFont(f);
		g.drawString(str, size.width/2-w/2, size.height/2);
	}
				//ボタンがクリックされたときの処理
	public void actionPerformed(ActionEvent e){
		if (e.getSource() == bt1){
			bt1.setEnabled(false);
			bt2.setEnabled(false);
			bt3.setEnabled(false);
		}
		else if(e.getSource() == bt2)	//現在のレベルでゲーム再開
			mp.state = 1;
		else{	//最初からゲームを再開
			mp.state = 0;
			mp.level = 1;
		}
	}
}