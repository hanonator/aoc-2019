package com.dopscape.day8;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PictureTest {

    @Test
    public void testBasicPicture() {
        byte[] picture = {
                1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 1, 2
        };

        Image image = Image.load(picture, 3, 2);

        assertThat(image.getLayers().length).isEqualTo(2);
    }

    @Test
    public void testMerge() {
        byte[] picture = {
                0, 2, 2, 2, 1, 1, 2, 2, 2, 2, 1, 2, 0, 0, 0, 0
        };

        Image image = Image.load(picture, 2, 2);
        Image merge = image.merge();

        assertThat(merge.getLayer(0).get(0, 0)).isEqualTo(0);
        assertThat(merge.getLayer(0).get(1, 0)).isEqualTo(1);
        assertThat(merge.getLayer(0).get(0, 1)).isEqualTo(1);
        assertThat(merge.getLayer(0).get(1, 1)).isEqualTo(0);
    }

}
