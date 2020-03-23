package io.korhner.asciimg.image.importer.android;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import io.korhner.asciimg.image.importer.RawBitmapImporter;
import io.korhner.asciimg.image.matrix.BasicInt1DImageMatrix;
import io.korhner.asciimg.image.matrix.ImageMatrix;
import io.korhner.asciimg.image.matrix.ImageMatrixDimensions;

import java.io.IOException;
import java.io.InputStream;

/**
 * A class used to read/import an image on an Android JVM (uses Bitmap).
 */
public class AndroidImageImporter implements RawBitmapImporter<Bitmap> {

    @Override
    public ImageMatrix<Integer> readFromStream(final InputStream source) throws IOException {

        return readFromPlatformSpecificFormat(BitmapFactory.decodeStream(source));
    }

    @Override
    public ImageMatrix<Integer> readFromPlatformSpecificFormat(final Bitmap source) throws IOException {

        if (source == null) {
            throw new IOException("Input source not set");
        }

        final ImageMatrixDimensions sourcePixelsSize = new ImageMatrixDimensions(source.getWidth(), source.getHeight());

        // extract pixels from source image
        final int[] imagePixels = new int[source.getWidth() * source.getHeight()];
        source.getPixels(
                imagePixels,
                0, source.getWidth(),
                0, 0,
                source.getWidth(), source.getHeight());

        // process the pixels to a gray-scale matrix
        return new BasicInt1DImageMatrix(META_DATA, imagePixels, sourcePixelsSize.getWidth());
    }
}
