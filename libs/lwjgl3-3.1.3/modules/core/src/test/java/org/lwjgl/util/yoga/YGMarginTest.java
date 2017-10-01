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

public class YGMarginTest {
    @Test
    public void test_margin_start() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMargin(YogaEdge.START, 10f);
        root_child0.setWidth(10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(80f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_top() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMargin(YogaEdge.TOP, 10f);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_end() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setJustifyContent(YogaJustify.FLEX_END);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMargin(YogaEdge.END, 10f);
        root_child0.setWidth(10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(80f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_bottom() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.FLEX_END);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMargin(YogaEdge.BOTTOM, 10f);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(80f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(80f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_and_flex_row() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setMargin(YogaEdge.START, 10f);
        root_child0.setMargin(YogaEdge.END, 10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(80f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(80f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_and_flex_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setMargin(YogaEdge.TOP, 10f);
        root_child0.setMargin(YogaEdge.BOTTOM, 10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(80f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(80f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_and_stretch_row() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setMargin(YogaEdge.TOP, 10f);
        root_child0.setMargin(YogaEdge.BOTTOM, 10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(80f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(80f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_and_stretch_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setMargin(YogaEdge.START, 10f);
        root_child0.setMargin(YogaEdge.END, 10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(80f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(80f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_with_sibling_row() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setMargin(YogaEdge.END, 10f);
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
        assertEquals(45f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(55f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(45f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(55f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(45f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(45f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_with_sibling_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setMargin(YogaEdge.BOTTOM, 10f);
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
        assertEquals(45f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(55f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(45f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(45f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(55f, root_child1.getLayoutY(), 0.0f);
        assertEquals(100f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(45f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_bottom() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.BOTTOM);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(150f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(150f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_top() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.TOP);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(100f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(150f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(100f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(150f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_bottom_and_top() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.TOP);
        root_child0.setMarginAuto(YogaEdge.BOTTOM);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(50f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(150f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(50f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(150f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_bottom_and_top_justify_center() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.TOP);
        root_child0.setMarginAuto(YogaEdge.BOTTOM);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(50f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(150f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child0.getLayoutX(), 0.0f);
        assertEquals(50f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child1.getLayoutX(), 0.0f);
        assertEquals(150f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_mutiple_children_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.TOP);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setMarginAuto(YogaEdge.TOP);
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
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(25f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(100f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child2.getLayoutX(), 0.0f);
        assertEquals(150f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(25f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(100f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child2.getLayoutX(), 0.0f);
        assertEquals(150f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_mutiple_children_row() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.RIGHT);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setMarginAuto(YogaEdge.RIGHT);
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
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(75f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(75f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child2.getLayoutX(), 0.0f);
        assertEquals(75f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(125f, root_child0.getLayoutX(), 0.0f);
        assertEquals(75f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(75f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(75f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_left_and_right_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.LEFT);
        root_child0.setMarginAuto(YogaEdge.RIGHT);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(75f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child1.getLayoutX(), 0.0f);
        assertEquals(75f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(100f, root_child0.getLayoutX(), 0.0f);
        assertEquals(75f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(75f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_left_and_right() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.LEFT);
        root_child0.setMarginAuto(YogaEdge.RIGHT);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_start_and_end_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.START);
        root_child0.setMarginAuto(YogaEdge.END);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(75f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child1.getLayoutX(), 0.0f);
        assertEquals(75f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(100f, root_child0.getLayoutX(), 0.0f);
        assertEquals(75f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(75f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_start_and_end() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.START);
        root_child0.setMarginAuto(YogaEdge.END);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_left_and_right_column_and_center() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.LEFT);
        root_child0.setMarginAuto(YogaEdge.RIGHT);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_left() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.LEFT);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_right() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.RIGHT);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(75f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_left_and_right_strech() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.LEFT);
        root_child0.setMarginAuto(YogaEdge.RIGHT);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(100f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_top_and_bottom_strech() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.TOP);
        root_child0.setMarginAuto(YogaEdge.BOTTOM);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(50f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(150f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child0.getLayoutX(), 0.0f);
        assertEquals(50f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child1.getLayoutX(), 0.0f);
        assertEquals(150f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_should_not_be_part_of_max_height() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(250f);
        root.setHeight(250f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMargin(YogaEdge.TOP, 20f);
        root_child0.setWidth(100f);
        root_child0.setHeight(100f);
        root_child0.setMaxHeight(100f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(250f, root.getLayoutWidth(), 0.0f);
        assertEquals(250f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(20f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(250f, root.getLayoutWidth(), 0.0f);
        assertEquals(250f, root.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child0.getLayoutX(), 0.0f);
        assertEquals(20f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_should_not_be_part_of_max_width() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(250f);
        root.setHeight(250f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMargin(YogaEdge.LEFT, 20f);
        root_child0.setWidth(100f);
        root_child0.setMaxWidth(100f);
        root_child0.setHeight(100f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(250f, root.getLayoutWidth(), 0.0f);
        assertEquals(250f, root.getLayoutHeight(), 0.0f);

        assertEquals(20f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(250f, root.getLayoutWidth(), 0.0f);
        assertEquals(250f, root.getLayoutHeight(), 0.0f);

        assertEquals(150f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_left_right_child_bigger_than_parent() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setWidth(52f);
        root.setHeight(52f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.LEFT);
        root_child0.setMarginAuto(YogaEdge.RIGHT);
        root_child0.setWidth(72f);
        root_child0.setHeight(72f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-20f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_left_child_bigger_than_parent() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setWidth(52f);
        root.setHeight(52f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.LEFT);
        root_child0.setWidth(72f);
        root_child0.setHeight(72f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-20f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_fix_left_auto_right_child_bigger_than_parent() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setWidth(52f);
        root.setHeight(52f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMargin(YogaEdge.LEFT, 10f);
        root_child0.setMarginAuto(YogaEdge.RIGHT);
        root_child0.setWidth(72f);
        root_child0.setHeight(72f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-20f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_margin_auto_left_fix_right_child_bigger_than_parent() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setWidth(52f);
        root.setHeight(52f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMarginAuto(YogaEdge.LEFT);
        root_child0.setMargin(YogaEdge.RIGHT, 10f);
        root_child0.setWidth(72f);
        root_child0.setHeight(72f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-30f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);
    }

}
