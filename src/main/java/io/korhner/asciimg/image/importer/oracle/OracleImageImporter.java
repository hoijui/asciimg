/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 korhner <korhner@gmail.com>
 * Copyright (c) 2018 hoijui <hoijui.quaero@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.korhner.asciimg.image.importer.oracle;

import io.korhner.asciimg.image.importer.RawBitmapImporter;
import io.korhner.asciimg.image.matrix.BasicInt1DImageMatrix;
import io.korhner.asciimg.image.matrix.ImageMatrix;
import io.korhner.asciimg.image.matrix.ImageMatrixDimensions;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * A class used to read/import an image on an Oracle JVM (uses AWT).
 */
public class OracleImageImporter implements RawBitmapImporter<BufferedImage> {

	//@Override
	public ImageMatrix<Integer> readFromURL(final URL resourceUrl) throws IOException {

		return readFromStream(resourceUrl.openStream());
	}

	//@Override
	public ImageMatrix<Integer> readFromResource(final String resourcePath) throws IOException {

		return readFromStream(OracleImageImporter.class.getResourceAsStream(resourcePath));
	}

	@Override
	public ImageMatrix<Integer> readFromStream(final InputStream source) throws IOException {

		final BufferedImage sourceImg = ImageIO.read(source);

		return readFromPlatformSpecificFormat(sourceImg);
	}

	@Override
	public ImageMatrix<Integer> readFromPlatformSpecificFormat(final BufferedImage source) throws IOException {

		if (source == null) {
			throw new IOException("Input source not set");
		}

		final ImageMatrixDimensions sourcePixelsSize = new ImageMatrixDimensions(source.getWidth(), source.getHeight());

		// extract pixels from source image
		final int[] imagePixels = source.getRGB(
				0, 0,
				sourcePixelsSize.getWidth(), sourcePixelsSize.getHeight(),
				null, 0, sourcePixelsSize.getWidth());

		// process the pixels to a gray-scale matrix
		return new BasicInt1DImageMatrix(META_DATA, imagePixels, sourcePixelsSize.getWidth());
	}
}
