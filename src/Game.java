import java.awt.*;
import javax.swing.*;
import java.applet.*;
import java.net.*;
import main.*;


public class Game extends JApplet {

	//蛻晄悄險ｭ螳�

	public void init(){
		Dimension size = getSize();	//郢ｧ�ｽ｢郢晏干ﾎ樒ｹ晢ｿｽ郢晏現�ｿｽ�ｽｮ陞滂ｽｧ邵ｺ髦ｪ�ｼ�郢ｧ雋槫徐陟包ｿｽ
		size.width -= 10;
		size.height -= 10;
		Container CP = getContentPane();	//ContentPane 繧貞叙蠕�
		CP.setLayout(null);	//郢晢ｽｬ郢ｧ�ｽ､郢ｧ�ｽ｢郢ｧ�ｽｦ郢晏現�ｿｽ讒ｭ繝ｭ郢晢ｽｼ郢ｧ�ｽｸ郢晢ｽ｣邵ｺ�ｽｮ陋帶㊧�ｽｭ�ｽ｢
		CP.setBackground(new Color(220, 255, 220));	//髢ｭ譴ｧ蜍ｹ豼ｶ�ｽｲ
		AppletContext AC = getAppletContext(); //郢ｧ�ｽ｢郢晏干ﾎ樒ｹ晢ｿｽ郢晏現�ｿｽ�ｽｮ郢ｧ�ｽｳ郢晢ｽｳ郢晢ｿｽ郢ｧ�ｽｭ郢ｧ�ｽｹ郢晏現�ｽ定愾髢��ｽｾ�ｿｽ
		URL CB = getCodeBase();	//HTML 郢晁ｼ斐＜郢ｧ�ｽ､郢晢ｽｫ邵ｺ謔滂ｽｭ莨懈Β邵ｺ蜷ｶ�ｽ� URL
		MainPanel pn = new MainPanel(AC, CB, size);	//MainPanel郢ｧ�ｽｪ郢晄じ縺夂ｹｧ�ｽｧ郢ｧ�ｽｯ郢晏現�ｿｽ�ｽｮ騾墓ｻ難ｿｽ�ｿｽ
		CP.add(pn);	//MainPanel郢ｧ�ｽｪ郢晄じ縺夂ｹｧ�ｽｧ郢ｧ�ｽｯ郢晏現�ｽ辰ontentPane邵ｺ�ｽｫ髴托ｽｽ陷会ｿｽ
		pn.setSize(size.width, size.height);
		pn.setLocation(5, 5);
	}

}
