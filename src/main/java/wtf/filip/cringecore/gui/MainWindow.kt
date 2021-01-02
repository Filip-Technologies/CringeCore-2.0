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
import club.sk1er.elementa.components.ScrollComponent
import club.sk1er.elementa.components.UIRoundedRectangle
import club.sk1er.elementa.components.UIText
import club.sk1er.elementa.constraints.CenterConstraint
import club.sk1er.elementa.constraints.ConstantColorConstraint
import club.sk1er.elementa.constraints.SiblingConstraint
import club.sk1er.elementa.dsl.*
import wtf.filip.cringecore.CringeCore
import wtf.filip.cringecore.Reflection
import java.awt.Color

/**
 * @author Filip
 */
class MainWindow : WindowScreen() {

    init {
        val container = UIRoundedRectangle(10f).constrain {
            x = CenterConstraint()
            y = CenterConstraint()
            color = ConstantColorConstraint(Color(NordTheme.PolarNight0.color))

            width = 300.pixels()
            height = 170.pixels()
        } childOf window

        val title = UIText("${CringeCore.MOD_NAME} ${CringeCore.MOD_VERSION}").constrain {
            x = CenterConstraint() - 50.pixels()
            y = SiblingConstraint() + 4.pixels()
            color = ConstantColorConstraint(Color(NordTheme.SnowStorm0.color))
            textScale = (1f).pixels()
        } childOf container

        val searchContainer = UIRoundedRectangle(2f).constrain {
            x = SiblingConstraint() + 70.pixels()
            y = 3.pixels()
            color = ConstantColorConstraint(Color(NordTheme.SnowStorm0.color))
            width = 70.pixels()
            height = 10.pixels()
        } childOf container

//        val searchInput = UITextInput("Testing").constrain {
//            x = 2.pixels()
//            y = 2.pixels()
//
//            width = RelativeConstraint(1f) - 6.pixels()
//        } childOf searchContainer


        val scrollContainer = ScrollComponent("TEST").constrain {
            color = ConstantColorConstraint(Color(NordTheme.PolarNight1.color))
            x = 2.pixels()
            y = 2.pixels()
            width = container.getWidth().pixels()
            height = container.getHeight().pixels() - 4.pixels()
        } childOf container

        var initialX = 10
        val initialY = 15
        for (module in CringeCore.INSTANCE.data.entries) {
            val clazz = module.key
            val modName = Reflection.getInstance().getModName(clazz)
            Module(modName, module.value, initialX.pixels(), initialY.pixels()).childOf(scrollContainer)
            initialX += 75
        }


    }
}