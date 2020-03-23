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

package io.korhner.asciimg.image.converter;

import io.korhner.asciimg.image.matrix.ImageMatrix;
import io.korhner.asciimg.image.matrix.ImageMatrixDimensions;
import io.korhner.asciimg.image.matrix.ReferencingTiledImageMatrix;
import io.korhner.asciimg.image.strategy.CharacterFinder;
import io.korhner.asciimg.image.transformer.ToGrayscaleImageTransformer;
import io.korhner.asciimg.image.transformer.TruncatingImageTransformer;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Map.Entry;

/**
 * A class used to convert an abstract 32bit ARGB image to an ASCII art.
 * Output and conversion algorithm are decoupled.
 */
//public class BufferedImageToAsciiConverter<O> extends AbstractToAsciiConverter<BufferedImage, O> {
//
//	public BufferedImageToAsciiConverter() {}
//
//	@Override
//	public void convert(final BufferedImage source) throws IOException {
//
//		getExporter().initFrames(1);
//
//		getImporter().setSource(source);
//		final ImageMatrix input = getImporter().read();
//
//		convert(input);
//
//		getExporter().finalizeFrames();
//	}
//}
