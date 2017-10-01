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

public class YGMinMaxDimensionTest {
    @Test
    public void test_max_width() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMaxWidth(50f);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_max_height() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(10f);
        root_child0.setMaxHeight(50f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(90f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_min_height() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setMinHeight(60f);
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
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(80f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(80f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(80f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(80f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_min_width() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setMinWidth(60f);
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
        assertEquals(80f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(80f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(20f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(20f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(80f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(20f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_min_max() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setWidth(100f);
        root.setMinHeight(100f);
        root.setMaxHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(60f);
        root_child0.setHeight(60f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(20f, root_child0.getLayoutY(), 0.0f);
        assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(60f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(40f, root_child0.getLayoutX(), 0.0f);
        assertEquals(20f, root_child0.getLayoutY(), 0.0f);
        assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(60f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_items_min_max() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.CENTER);
        root.setMinWidth(100f);
        root.setMaxWidth(200f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(60f);
        root_child0.setHeight(60f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(20f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(60f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(20f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(60f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(60f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_overflow_min_max() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setMinHeight(100f);
        root.setMaxHeight(110f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setWidth(50f);
        root_child2.setHeight(50f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(50f, root.getLayoutWidth(), 0.0f);
        assertEquals(110f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-20f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(30f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(80f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(50f, root.getLayoutWidth(), 0.0f);
        assertEquals(110f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-20f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(30f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(80f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_to_min() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setMinHeight(100f);
        root.setMaxHeight(500f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setFlexShrink(1f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setHeight(50f);
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
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_in_at_most_container() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.FLEX_START);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexDirection(YogaFlexDirection.ROW);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setFlexGrow(1f);
        root_child0_child0.setFlexBasis(0f);
        root_child0.addChildAt(root_child0_child0, 0);
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

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(100f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setFlexBasis(0f);
        root_child0.setHeight(100f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(0f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(0f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_within_constrained_min_max_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setMinHeight(100f);
        root.setMaxHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(0f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(0f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_within_max_width() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(200f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexDirection(YogaFlexDirection.ROW);
        root_child0.setMaxWidth(100f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setFlexGrow(1f);
        root_child0_child0.setHeight(20f);
        root_child0.addChildAt(root_child0_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(100f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_within_constrained_max_width() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(200f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexDirection(YogaFlexDirection.ROW);
        root_child0.setMaxWidth(300f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setFlexGrow(1f);
        root_child0_child0.setHeight(20f);
        root_child0.addChildAt(root_child0_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(200f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(200f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(200f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(200f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_root_ignored() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexGrow(1f);
        root.setWidth(100f);
        root.setMinHeight(100f);
        root.setMaxHeight(500f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setFlexBasis(200f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setHeight(100f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(300f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(200f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(200f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(300f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(200f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(200f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_root_minimized() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setMinHeight(100f);
        root.setMaxHeight(500f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setMinHeight(100f);
        root_child0.setMaxHeight(500f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setFlexGrow(1f);
        root_child0_child0.setFlexBasis(200f);
        root_child0.addChildAt(root_child0_child0, 0);

        YogaNode root_child0_child1 = new YogaNode(config);
        root_child0_child1.setHeight(100f);
        root_child0.addChildAt(root_child0_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(300f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(300f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(200f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child1.getLayoutX(), 0.0f);
        assertEquals(200f, root_child0_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(300f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(300f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(200f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child1.getLayoutX(), 0.0f);
        assertEquals(200f, root_child0_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_height_maximized() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(500f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setMinHeight(100f);
        root_child0.setMaxHeight(500f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setFlexGrow(1f);
        root_child0_child0.setFlexBasis(200f);
        root_child0.addChildAt(root_child0_child0, 0);

        YogaNode root_child0_child1 = new YogaNode(config);
        root_child0_child1.setHeight(100f);
        root_child0.addChildAt(root_child0_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(500f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(500f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(400f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child1.getLayoutX(), 0.0f);
        assertEquals(400f, root_child0_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(500f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(500f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(400f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child1.getLayoutX(), 0.0f);
        assertEquals(400f, root_child0_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_within_constrained_min_row() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setMinWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root.addChildAt(root_child1, 1);
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

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

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
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_within_constrained_min_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setMinHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(0f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(0f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(0f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(0f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_within_constrained_max_row() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexDirection(YogaFlexDirection.ROW);
        root_child0.setMaxWidth(100f);
        root_child0.setHeight(100f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setFlexShrink(1f);
        root_child0_child0.setFlexBasis(100f);
        root_child0.addChildAt(root_child0_child0, 0);

        YogaNode root_child0_child1 = new YogaNode(config);
        root_child0_child1.setWidth(50f);
        root_child0.addChildAt(root_child0_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(100f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_flex_grow_within_constrained_max_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setMaxHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexShrink(1f);
        root_child0.setFlexBasis(100f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setHeight(50f);
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
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_child_min_max_width_flexing() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(120f);
        root.setHeight(50f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setFlexBasis(0f);
        root_child0.setMinWidth(60f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setFlexGrow(1f);
        root_child1.setFlexBasisPercent(50f);
        root_child1.setMaxWidth(20f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(120f, root.getLayoutWidth(), 0.0f);
        assertEquals(50f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(100f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(20f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(120f, root.getLayoutWidth(), 0.0f);
        assertEquals(50f, root.getLayoutHeight(), 0.0f);

        assertEquals(20f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(20f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_min_width_overrides_width() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(50f);
        root.setMinWidth(100f);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(0f, root.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(0f, root.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_max_width_overrides_width() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(200f);
        root.setMaxWidth(100f);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(0f, root.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(0f, root.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_min_height_overrides_height() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setHeight(50f);
        root.setMinHeight(100f);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(0f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(0f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_max_height_overrides_height() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setHeight(200f);
        root.setMaxHeight(100f);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(0f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(0f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_min_max_percent_no_width_height() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.FLEX_START);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMinWidthPercent(10f);
        root_child0.setMaxWidthPercent(10f);
        root_child0.setMinHeightPercent(10f);
        root_child0.setMaxHeightPercent(10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(90f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
    }

}
