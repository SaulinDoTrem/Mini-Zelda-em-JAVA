package zeldaminiclone;

import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;

public class World {

    public List<Blocks> blocos = new ArrayList<Blocks>();

    public World() {
        for(int xx = 0; xx < 15; xx++){
            blocos.add(new Blocks(xx*32, 0));
        }
    }

    public void render(Graphics g){
        for(int i = 0; i < blocos.size(); i++){
            blocos.get(i).render(g);
        }
    }   

}
