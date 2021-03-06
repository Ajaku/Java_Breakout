package clear;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;
import main.*;

public class GameClearPanel extends JPanel implements ActionListener{
	AppletContext ac;	//アプレットのコンテキスト
	URL cb;	//HTML ファイルが存在する URL
	Dimension size;	//アプレットの大きさ
	MainPanel mp;
	JButton bt1, bt2;

				//コントラクタ
	public GameClearPanel(AppletContext acl, URL cbl, Dimension sizel, MainPanel mpl){
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
		String strl = "ゲーム終了";
		int w1 = fm.stringWidth(strl) + 40;
		int h1 = fm.getHeight() + 10;
		bt1 = new JButton(strl);
		bt1.setFont(f);
		bt1.addActionListener(this);	//アクションリスナ
		bt1.setSize(w1, h1);
		bt1.setLocation(size.width/2-w1-5, size.height-h1-20);
		add(bt1);

		String str2;
		if (mp.level == 2)
			str2 = "最初から再開";
		else
			str2 = "次のレベル";
		int w2 = fm.stringWidth(str2) + 40;
		int h2 = fm.getHeight() + 10;
		bt2 = new JButton(str2);
		bt2.setFont(f);
		bt2.addActionListener(this);	//アクションリスナ
		bt2.setSize(w2, h2);
		bt2.setLocation(size.width/2+5, size.height-h2-20);
		add(bt2);
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
			mp.state = 4;
			bt1.setEnabled(false);
			bt2.setEnabled(false);
		}
		else{
			mp.level++;
			if(mp.level > 2){	//最初からゲーム再開
				mp.state = 0;
				mp.level = 1;
			}
			else	//rベルアップ
				mp.state = 1;
		}
	}
}
