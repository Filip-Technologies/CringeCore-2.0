/*
 * MIT License
 *
 * Copyright (c) 2020 Filip Technologies
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
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package wtf.filip.cringecore.gui;

/**
 * https://www.nordtheme.com/
 * 
 * @author Filip
 */
public enum Theme {
    PolarNight0(0x2E3440),
    PolarNight1(0x3B4252),
    PolarNight2(0x434C5E),
    PolarNight3(0x4C566A),
    SnowStorm0(0xD8DEE9),
    SnowStorm1(0xE5E9F0),
    SnowStorm2(0xECEFF4);

    public int color;

    Theme(int color) {
        this.color = color;
    }
}
