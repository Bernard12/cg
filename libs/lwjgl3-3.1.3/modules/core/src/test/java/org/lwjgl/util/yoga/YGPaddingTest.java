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

public class YGPaddingTest {
    @Test
    public void test_padding_no_size() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setPadding(YogaEdge.LEFT, 10);
        root.setPadding(YogaEdge.TOP, 10);
        root.setPadding(YogaEdge.RIGHT, 10);
        root.setPadding(YogaEdge.BOTTOM, 10);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(20f, root.getLayoutWidth(), 0.0f);
        assertEquals(20f, root.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(20f, root.getLayoutWidth(), 0.0f);
        assertEquals(20f, root.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_padding_container_match_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setPadding(YogaEdge.LEFT, 10);
        root.setPadding(YogaEdge.TOP, 10);
        root.setPadding(YogaEdge.RIGHT, 10);
        root.setPadding(YogaEdge.BOTTOM, 10);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(10f);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(30f, root.getLayoutWidth(), 0.0f);
        assertEquals(30f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(30f, root.getLayoutWidth(), 0.0f);
        assertEquals(30f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_padding_flex_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setPadding(YogaEdge.LEFT, 10);
        root.setPadding(YogaEdge.TOP, 10);
        root.setPadding(YogaEdge.RIGHT, 10);
        root.setPadding(YogaEdge.BOTTOM, 10);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setFlexGrow(1f);
        root_child0.setWidth(10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(80f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(80f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(80f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_padding_stretch_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setPadding(YogaEdge.LEFT, 10);
        root.setPadding(YogaEdge.TOP, 10);
        root.setPadding(YogaEdge.RIGHT, 10);
        root.setPadding(YogaEdge.BOTTOM, 10);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(80f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(80f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_padding_center_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setAlignItems(YogaAlign.CENTER);
        root.setPadding(YogaEdge.START, 10);
        root.setPadding(YogaEdge.END, 20);
        root.setPadding(YogaEdge.BOTTOM, 20);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(10f);
        root_child0.setHeight(10f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(40f, root_child0.getLayoutX(), 0.0f);
        assertEquals(35f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(35f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_child_with_padding_align_end() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.FLEX_END);
        root.setAlignItems(YogaAlign.FLEX_END);
        root.setWidth(200f);
        root.setHeight(200f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setPadding(YogaEdge.LEFT, 20);
        root_child0.setPadding(YogaEdge.TOP, 20);
        root_child0.setPadding(YogaEdge.RIGHT, 20);
        root_child0.setPadding(YogaEdge.BOTTOM, 20);
        root_child0.setWidth(100f);
        root_child0.setHeight(100f);
        root.addChildAt(root_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(100f, root_child0.getLayoutX(), 0.0f);
        assertEquals(100f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(200f, root.getLayoutWidth(), 0.0f);
        assertEquals(200f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(100f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(100f, root_child0.getLayoutHeight(), 0.0f);
    }

}
