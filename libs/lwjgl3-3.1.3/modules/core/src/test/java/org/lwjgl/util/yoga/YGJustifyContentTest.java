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

public class YGJustifyContentTest {
    @Test
    public void test_justify_content_row_flex_start() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(102f);
        root.setHeight(102f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(10f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(10f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setWidth(10f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(10f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(20f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(92f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(82f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(10f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(72f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_row_flex_end() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setJustifyContent(YogaJustify.FLEX_END);
        root.setWidth(102f);
        root.setHeight(102f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(10f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(10f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setWidth(10f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(72f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(82f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(10f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(92f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(20f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(10f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_row_center() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setWidth(102f);
        root.setHeight(102f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(10f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(10f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setWidth(10f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(36f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(46f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(10f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(56f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(56f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(46f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(10f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(36f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_row_space_between() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setJustifyContent(YogaJustify.SPACE_BETWEEN);
        root.setWidth(102f);
        root.setHeight(102f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(10f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(10f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setWidth(10f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(46f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(10f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(92f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(92f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(46f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(10f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_row_space_around() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setJustifyContent(YogaJustify.SPACE_AROUND);
        root.setWidth(102f);
        root.setHeight(102f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(10f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(10f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setWidth(10f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(12f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(46f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(10f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(80f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(80f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(46f, root_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1.getLayoutY(), 0.0f);
        assertEquals(10f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(12f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(102f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_column_flex_start() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(102f);
        root.setHeight(102f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setHeight(10f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(102f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(10f, root_child1.getLayoutY(), 0.0f);
        assertEquals(102f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(10f, root_child2.getLayoutY(), 0.0f);
        assertEquals(102f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(102f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(10f, root_child1.getLayoutY(), 0.0f);
        assertEquals(102f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(0f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(10f, root_child2.getLayoutY(), 0.0f);
        assertEquals(102f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_column_flex_end() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.FLEX_END);
        root.setWidth(102f);
        root.setHeight(102f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setHeight(10f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setHeight(10f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(72f, root_child0.getLayoutY(), 0.0f);
        assertEquals(102f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(82f, root_child1.getLayoutY(), 0.0f);
        assertEquals(102f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(92f, root_child2.getLayoutY(), 0.0f);
        assertEquals(102f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(72f, root_child0.getLayoutY(), 0.0f);
        assertEquals(102f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(82f, root_child1.getLayoutY(), 0.0f);
        assertEquals(102f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(92f, root_child2.getLayoutY(), 0.0f);
        assertEquals(102f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_column_center() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setWidth(102f);
        root.setHeight(102f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setHeight(10f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setHeight(10f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(36f, root_child0.getLayoutY(), 0.0f);
        assertEquals(102f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(46f, root_child1.getLayoutY(), 0.0f);
        assertEquals(102f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(56f, root_child2.getLayoutY(), 0.0f);
        assertEquals(102f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(36f, root_child0.getLayoutY(), 0.0f);
        assertEquals(102f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(46f, root_child1.getLayoutY(), 0.0f);
        assertEquals(102f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(56f, root_child2.getLayoutY(), 0.0f);
        assertEquals(102f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_column_space_between() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.SPACE_BETWEEN);
        root.setWidth(102f);
        root.setHeight(102f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setHeight(10f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setHeight(10f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(102f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(46f, root_child1.getLayoutY(), 0.0f);
        assertEquals(102f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(92f, root_child2.getLayoutY(), 0.0f);
        assertEquals(102f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(102f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(46f, root_child1.getLayoutY(), 0.0f);
        assertEquals(102f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(92f, root_child2.getLayoutY(), 0.0f);
        assertEquals(102f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_justify_content_column_space_around() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.SPACE_AROUND);
        root.setWidth(102f);
        root.setHeight(102f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setHeight(10f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setHeight(10f);
        root.addChildAt(root_child2, 2);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(12f, root_child0.getLayoutY(), 0.0f);
        assertEquals(102f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(46f, root_child1.getLayoutY(), 0.0f);
        assertEquals(102f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(80f, root_child2.getLayoutY(), 0.0f);
        assertEquals(102f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(102f, root.getLayoutWidth(), 0.0f);
        assertEquals(102f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(12f, root_child0.getLayoutY(), 0.0f);
        assertEquals(102f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(46f, root_child1.getLayoutY(), 0.0f);
        assertEquals(102f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(80f, root_child2.getLayoutY(), 0.0f);
        assertEquals(102f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2.getLayoutHeight(), 0.0f);
    }

}
