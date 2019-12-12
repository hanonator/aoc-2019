package com.dopscape.day8;

import java.io.IOException;
import java.net.URISyntaxException;

public class PictureApplication {

    public static void main(String[] args) throws IOException, URISyntaxException {
        Image image = Image.load("day8-input", 25, 6);

        int lowestZeroLayer = -1;
        int lowestZeroCount = Integer.MAX_VALUE;

        for (int layer = 0; layer < image.getLayers().length; layer++) {
            if (image.getLayer(layer).count(0) < lowestZeroCount) {
                lowestZeroLayer = layer;
                lowestZeroCount = image.getLayer(layer).count(0);
            }
        }

        System.out.println(image.getLayer(lowestZeroLayer).count(1) * image.getLayer(lowestZeroLayer).count(2));
        image.merge().getLayer(0).print();
    }

}
