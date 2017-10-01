/*
 * Copyright (c) 2014-present, Facebook, Inc.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package org.lwjgl.util.yoga;

import org.testng.annotations.*;

import static org.lwjgl.util.yoga.YogaNode.*;
import static org.testng.Assert.*;

public class YGDisplayTest {
    @Test
    public void test_display_none() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setFlexGrow(1f);
        root_child1.setDisplay(YogaDisplay.NONE);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_display_none_fixed_size() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(20f);
        root_child1.setHeight(20f);
        root_child1.setDisplay(YogaDisplay.NONE);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_display_none_with_margin() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMargin(YogaEdge.LEFT, 10f);
        root_child0.setMargin(YogaEdge.TOP, 10f);
        root_child0.setMargin(YogaEdge.RIGHT, 10f);
        root_child0.setMargin(YogaEdge.BOTTOM, 10f);
        root_child0.setWidth(20f);
        root_child0.setHeight(20f);
        root_child0.setDisplay(YogaDisplay.NONE);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setFlexGrow(1f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_display_none_with_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setFlexShrink(1f);
        root_child0.setFlexBasisPercent(0f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setFlexGrow(1f);
        root_child1.setFlexShrink(1f);
        root_child1.setFlexBasisPercent(0f);
        root_child1.setDisplay(YogaDisplay.NONE);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setFlexGrow(1f);
        root_child1_child0.setFlexShrink(1f);
        root_child1_child0.setFlexBasisPercent(0f);
        root_child1_child0.setWidth(20f);
        root_child1_child0.setMinWidth(0f);
        root_child1_child0.setMinHeight(0f);
        root_child1.addChildAt(root_child1_child0, 0);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setFlexGrow(1f);
        root_child2.setFlexShrink(1f);
        root_child2.setFlexBasisPercent(0f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_display_none_with_position() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setFlexGrow(1f);
        root_child1.setPosition(YogaEdge.TOP, 10f);
        root_child1.setDisplay(YogaDisplay.NONE);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1.getLayoutHeight(), 0.0f);
    }

}
