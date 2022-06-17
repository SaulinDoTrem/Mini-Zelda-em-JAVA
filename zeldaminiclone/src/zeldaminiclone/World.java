package zeldaminiclone;

import java.awt.Graphics;
import java.util.List;
import java.util.ArrayList;
import java.awt.Rectangle;

public class World {
    
    public int alturaTela = Game.HEIGHT, larguraTela = Game.WIDTH;
    public static int ladoBloco = Blocks.LADO;
    public static List<Blocks> blocos = new ArrayList<Blocks>();

    public World() {
        // blocos de cima
        for(int xx = 0; xx < larguraTela/ladoBloco; xx++){
            blocos.add(new Blocks(xx*ladoBloco, 0));
        }
        // blocos de baixo
        for(int xx = 0; xx < larguraTela/ladoBloco; xx++){
            blocos.add(new Blocks(xx*ladoBloco, alturaTela - ladoBloco));
        }

        // blocos da esquerda
        for(int xx = 0; xx < alturaTela/ladoBloco; xx++){
            blocos.add(new Blocks(0, xx*ladoBloco));
        }

        // blocos da direita
        for(int xx = 0; xx < alturaTela/ladoBloco ; xx++){
            blocos.add(new Blocks(larguraTela - ladoBloco, xx*ladoBloco));
        }

        blocos.add(new Blocks(200,100));
    }

    public static boolean isFree(int x, int y){
        for(int i = 0; i < blocos.size(); i++){
            Blocks blocoAtual = blocos.get(i);
            if(blocoAtual.intersects(new Rectangle(x,y,ladoBloco,ladoBloco))){
                return false;
            }
        }
        return true;
    }

    public void render(Graphics g){
        for(int i = 0; i < blocos.size(); i++){
            blocos.get(i).render(g);
        }
    }   

}
