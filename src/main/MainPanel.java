package main;

import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;
import start.*;
import game.*;
import clear.*;
import over.*;

public class MainPanel extends JPanel implements Runnable{
	AppletContext ac;	//繧｢繝励Ξ繝�繝医�ｮ繧ｳ繝ｳ繝�繧ｭ繧ｹ繝�
	URL cb;	//HTML 繝輔ぃ繧､繝ｫ縺悟ｭ伜惠縺吶ｋ URL
	Dimension size;	//繧｢繝励Ξ繝�繝医�ｮ螟ｧ縺阪＆
	boolean in_game = true;	//繧ｲ繝ｼ繝�螳溯｡御ｸｭ縺ｯtrue
	public int state = 0;	//繧ｲ繝ｼ繝�迥ｶ諷� 0:陦ｨ邏�, 1:繧ｲ繝ｼ繝�, 2:繧ｯ繝ｪ繧｢, 3:繧ｪ繝ｼ繝舌�ｼ, 4:邨ゆｺ�)
	public int level = 1;	//繧ｲ繝ｼ繝�縺ｮ繝ｬ繝吶Ν
	int old_state = 0;	//逶ｴ蜑阪�ｮ繧ｲ繝ｼ繝�迥ｶ諷�
	StartPanel sp;
	GamePanel gp;
	GameClearPanel gcp;
	GameOverPanel gop;
	Thread td;


			//繧ｳ繝ｳ繧ｹ繝医Λ繧ｯ繧ｿ
	public MainPanel(AppletContext acl, URL cbl, Dimension sizel){
		ac = acl;
		cb = cbl;
		size = sizel;

			//繧ｰ繝ｪ繝�繝峨Ξ繧､繧｢繧ｦ繝�
		setLayout(new GridLayout(1, 1, 0, 0));

			//繧ｲ繝ｼ繝�繝代ロ繝ｫ縺ｮ逕滓��
		sp = new StartPanel(ac, cb, size, this);//繧ｹ繧ｿ繝ｼ繝�(繧ｿ繧､繝医Ν)
		add(sp);

			//繧ｹ繝ｬ繝�繝峨�ｮ逕滓��
		td = new Thread(this);
		td.start();
	}

			//繧ｲ繝ｼ繝�縺ｮ迥ｶ諷九ｒ螟画峩
	public void run(){

		while (in_game){
			try{
				td.sleep(100);	//100 ms 豈弱�ｮ螳滓命
			}

			catch (InterruptedException e){
			}

			if (state != old_state){

				//蜑阪�ｮ繝代ロ繝ｫ縺ｮ蜑企勁
				if (old_state == 0)
					remove(sp);
				else if (old_state == 1)
					remove(gp);
				else if (old_state == 2)
					remove(gcp);
				else
					remove(gop);

				//譁ｰ縺励＞繝代ロ繝ｫ縺ｮ霑ｽ蜉�
				if (state == 4)	//繧ｲ繝ｼ繝�邨ゆｺ�
					in_game = false;
				else{
					if (state == 0){	//StartPanel
						sp = new StartPanel(ac, cb, size, this);
						add(sp);
					}
					else if (state == 1){	//GamePanel
						gp = new GamePanel(ac, cb, size, this);
						add(gp);
					}
					else if (state == 2){	//GameClearPanel
						gcp = new GameClearPanel(ac, cb, size, this);
						add(gcp);
					}
					else{	//GameOverPanel
						gop = new GameOverPanel(ac, cb, size, this);
						add(gop);
					}

					validate();
					old_state = state;
				}
			}
		}
	}
}
