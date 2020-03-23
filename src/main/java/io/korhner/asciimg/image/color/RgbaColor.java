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

package io.korhner.asciimg.image.color;

public class RgbaColor {

	/**
	 * The combined RGBA value in the sRGB space, consisting of the:
	 * <ui>
	 *     <it><b>alpha</b> component in bits 24-31</it>
	 *     <it><b>red</b> component in bits 16-23</it>
	 *     <it><b>green</b> component in bits 8-15</it>
	 *     <it><b>blue</b> component in bits 0-7</it>
	 * </ui>
	 * This is the same convention as used by <code>java.awt.Color</code> (on the Oracle JVM),
	 * and <code>android.graphics.Color</code> as used on the Android JVM.
	 */
	private final int valuesBgra;

	public RgbaColor(final int valuesBgra) {
		this.valuesBgra = valuesBgra;
	}

	public RgbaColor(final short red, final short green, final short blue, final short alpha) {

		this.valuesBgra = (alpha & 0xFF) << 24 | (red & 0xFF) << 16 | (green & 0xFF) << 8 | (blue & 0xFF);
	}

	public RgbaColor(final int red, final int green, final int blue, final int alpha) {

		this.valuesBgra = (alpha & 0xFF) << 24 | (red & 0xFF) << 16 | (green & 0xFF) << 8 | (blue & 0xFF);
	}

	public int getRed() { return (valuesBgra << 16) & 0xFF; }

	public int getGreen() { return (valuesBgra << 8) & 0xFF; }

	public int getBlue() { return valuesBgra & 0xFF; }

	public int getAlpha() { return (valuesBgra << 24) & 0xFF; }

	public int getBgra() { return valuesBgra; }
}
