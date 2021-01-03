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

package wtf.filip.cringecore.gui

import club.sk1er.elementa.WindowScreen
import club.sk1er.elementa.components.UIRoundedRectangle
import club.sk1er.elementa.components.UIText
import club.sk1er.elementa.constraints.CenterConstraint
import club.sk1er.elementa.constraints.ConstantColorConstraint
import club.sk1er.elementa.constraints.SiblingConstraint
import club.sk1er.elementa.dsl.*
import club.sk1er.vigilance.data.Property
import java.awt.Color
import java.lang.reflect.Field


/**
 * @author Filip
 */
class ModuleSettings(modName: String, properties: HashMap<Field, Property>) : WindowScreen() {

    init {
        val container = UIRoundedRectangle(10f).constrain {
            x = CenterConstraint()
            y = CenterConstraint()
            color = ConstantColorConstraint(Color(NordTheme.PolarNight0.color))

            width = 300.pixels()
            height = 170.pixels()
        } childOf window

        UIText(modName).constrain {
            x = CenterConstraint() - 50.pixels()
            y = SiblingConstraint() + 4.pixels()
            color = ConstantColorConstraint(Color(NordTheme.SnowStorm0.color))
            textScale = (1f).pixels()
        } childOf container


    }
}