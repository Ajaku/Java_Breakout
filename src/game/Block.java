package game;

import java.awt.*;
import java.applet.*;
import java.net.*;

class Block{
	Image block;	//ブロックの画像
	int width = 75;	//ブロックの幅
	int height = 38;	//ブロックの高さ
	int row = 2;	//ブロックの行数
	int col = 4;	//ブロックの列数
	int number = row * col;	//ブロックの数
	boolean ex[][];	//ブロックの状態（存在するか否か）
			//コントラクタ
	public Block(AppletContext ac, URL cb){

			//ブロックの読み込み
		try{
			URL url = new URL(cb + "game/image/block.jpg");
			block = ac.getImage(url);
		}

		catch (MalformedURLException me){
			System.out.println("Bad URL");
		}

			//ブロックの状態（存在するか否か）の設定
		ex = new boolean [row][col];
		for (int i1 = 0; i1 <row; i1++){
			for (int i2 = 0; i2 < col; i2++){
				ex[i1][i2] = true;
			}
		}
	}

}
