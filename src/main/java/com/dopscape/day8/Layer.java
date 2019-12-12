package com.dopscape.day8;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class Layer {

    private final int[][] bitmap;

    public Layer(int[][] bitmap) {
        this.bitmap = bitmap;
    }

    public Layer(int width, int height) {
        this(new int[width][height]);
    }

    public void set(int x, int y, int color) {
        this.bitmap[x][y] = color;
    }

    public int get(int x, int y) {
        return this.bitmap[x][y];
    }

    public void print() {
        for (int y = 0; y < bitmap[0].length; y++) {
            for (int x = 0; x < bitmap.length; x++) {
                System.out.print(get(x, y));
            }
            System.out.println();
        }
    }

    public int count(int qualifier) {
        int count = 0;
        for (int x = 0; x < bitmap.length; x++) {
            for (int y = 0; y < bitmap[x].length; y++) {
                if (bitmap[x][y] == qualifier)
                    count++;
            }
        }
        return count;
    }
}
