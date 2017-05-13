package com.tfr.collections.recursion;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Create and save a TSquare fractal pattern to a jpg file
 *
 * Created by Erik on 4/28/2017.
 */
public class TSquareFractal {

    private final int SIDE = 1000;
    private final int COLOR1 = Color.RED.getRGB();
    private final int COLOR2 = Color.BLACK.getRGB();

    BufferedImage image = new BufferedImage(SIDE, SIDE, BufferedImage.TYPE_INT_RGB);

    public TSquareFractal() {
    }

    private void drawSquare(int x, int y, int s) {
        if(s > 0) {
            int left = x - s/2;
            int right = x + s/2;
            int top = y - s/2;
            int bottom = y + s/2;

            for(int i=left; i<right; i++) {
                for(int j=top; j<bottom; j++) {
                    image.setRGB(i, j, COLOR1);
                }
            }

            drawSquare(left, top, s/2);
            drawSquare(left, bottom, s/2);
            drawSquare(right, top, s/2);
            drawSquare(right, bottom, s/2);
        }
    }

    public void save(String filename) throws IOException {
        for(int i=0; i<SIDE; i++) {
            for(int j=0; j<SIDE; j++) {
                image.setRGB(i, j, COLOR2);
            }
        }

        drawSquare(SIDE/2, SIDE/2, SIDE/2);

        File outputFile = new File(filename);
        ImageIO.write(image, "jpg", outputFile);
    }

}
