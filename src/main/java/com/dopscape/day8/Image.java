package com.dopscape.day8;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Image {

    private final Layer[] layers;
    private final int width;
    private final int height;

    public Image(int width, int height, Layer... layers) {
        this.layers = layers;
        this.width = width;
        this.height = height;
    }

    public static Image load(byte[] input, int width, int height) {
        Layer[] layers = new Layer[input.length / (width * height)];
        for (int i = 0; i < layers.length;i ++) {
            layers[i] = new Layer(width, height);
        }
        for (int i = 0; i < input.length; i++) {
            int x = i % width;
            int y = (i / width) % height;
            int layer = i / (width * height);

            layers[layer].set(x, y, input[i]);
        }
        return new Image(width, height, layers);
    }

    public static Image load(String filename, int width, int height) throws URISyntaxException, IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(ClassLoader.getSystemClassLoader().getResource(filename).toURI()));
        for (int i = 0; i < bytes.length; i++) {
            bytes[i] -= 48;
        }
        return Image.load(bytes, width, height);
    }

    public Image merge() {
        Layer layer = new Layer(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                int color = 2;

                for (int z = 0; z < layers.length; z++) {
                    if (layers[z].get(x, y) != 2) {
                        color = layers[z].get(x, y);
                        break;
                    }
                }

                if (color == 2) {
                    color = 0;
                }
                layer.set(x, y, color);
            }
        }

        return new Image(width, height, layer);
    }

    public Layer getLayer(int index) {
        return layers[index];
    }

    public Layer[] getLayers() {
        return layers;
    }

}
