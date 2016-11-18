package game;

import java.awt.*;
import java.util.Random;

public class Ball {
	Color color = new Color(255, 0, 0);	//繝懊�ｼ繝ｫ縺ｮ濶ｲ
	int r = 7;	//繝懊�ｼ繝ｫ縺ｮ蜊雁ｾ�
	int x;	//繝懊�ｼ繝ｫ縺ｮ讓ｪ菴咲ｽｮ
	int y;	//繝懊�ｼ繝ｫ縺ｮ邵ｦ菴咲ｽｮ
	int vx;	//繝懊�ｼ繝ｫ縺ｮ讓ｪ譁ｹ蜷鷹�溷ｺｦ謌仙�
	int vy;	//繝懊�ｼ繝ｫ縺ｮ邵ｦ譁ｹ蜷鷹�溷ｺｦ謌仙�

			//繧ｳ繝ｳ繝医Λ繧ｯ繧ｹ繧ｿ
	public Ball(Block blk, Dimension size, Random rn){
		x = rn.nextInt(size.width - 2 *r);
		y = blk.height * blk.row + 10;
		vx = 0;
		vy = 0;
	}
}
