/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.util.yoga;

import org.testng.annotations.*;

import static org.lwjgl.util.yoga.YogaNode.*;
import static org.testng.Assert.*;

public class YGAlignItemsTest {
    @Test
    public void test_align_items_stretch() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
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

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_items_center() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.CENTER);
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

        assertEquals(45f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(45f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_items_flex_start() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.FLEX_START);
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

    @Test
    public void test_align_items_flex_end() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.FLEX_END);
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

        assertEquals(90f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(20f);
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
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(30f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(30f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(20f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(50f);
        root_child1_child0.setHeight(10f);
        root_child1.addChildAt(root_child1_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_child_multiline() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(60f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setFlexDirection(YogaFlexDirection.ROW);
        root_child1.setWrap(YogaWrap.WRAP);
        root_child1.setWidth(50f);
        root_child1.setHeight(25f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(25f);
        root_child1_child0.setHeight(20f);
        root_child1.addChildAt(root_child1_child0, 0);

        YogaNode root_child1_child1 = new YogaNode(config);
        root_child1_child1.setWidth(25f);
        root_child1_child1.setHeight(10f);
        root_child1.addChildAt(root_child1_child1, 1);

        YogaNode root_child1_child2 = new YogaNode(config);
        root_child1_child2.setWidth(25f);
        root_child1_child2.setHeight(20f);
        root_child1.addChildAt(root_child1_child2, 2);

        YogaNode root_child1_child3 = new YogaNode(config);
        root_child1_child3.setWidth(25f);
        root_child1_child3.setHeight(10f);
        root_child1.addChildAt(root_child1_child3, 3);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(60f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child1.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child2.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child2.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child3.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child3.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child3.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child3.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(60f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child1.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child1.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child2.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child2.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child3.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child3.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child3.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child3.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_child_multiline_override() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(60f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setFlexDirection(YogaFlexDirection.ROW);
        root_child1.setWrap(YogaWrap.WRAP);
        root_child1.setWidth(50f);
        root_child1.setHeight(25f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(25f);
        root_child1_child0.setHeight(20f);
        root_child1.addChildAt(root_child1_child0, 0);

        YogaNode root_child1_child1 = new YogaNode(config);
        root_child1_child1.setAlignSelf(YogaAlign.BASELINE);
        root_child1_child1.setWidth(25f);
        root_child1_child1.setHeight(10f);
        root_child1.addChildAt(root_child1_child1, 1);

        YogaNode root_child1_child2 = new YogaNode(config);
        root_child1_child2.setWidth(25f);
        root_child1_child2.setHeight(20f);
        root_child1.addChildAt(root_child1_child2, 2);

        YogaNode root_child1_child3 = new YogaNode(config);
        root_child1_child3.setAlignSelf(YogaAlign.BASELINE);
        root_child1_child3.setWidth(25f);
        root_child1_child3.setHeight(10f);
        root_child1.addChildAt(root_child1_child3, 3);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(60f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child1.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child2.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child2.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child3.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child3.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child3.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child3.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(60f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child1.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child1.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child2.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child2.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child3.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child3.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child3.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child3.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_child_multiline_no_override_on_secondline() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(60f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setFlexDirection(YogaFlexDirection.ROW);
        root_child1.setWrap(YogaWrap.WRAP);
        root_child1.setWidth(50f);
        root_child1.setHeight(25f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(25f);
        root_child1_child0.setHeight(20f);
        root_child1.addChildAt(root_child1_child0, 0);

        YogaNode root_child1_child1 = new YogaNode(config);
        root_child1_child1.setWidth(25f);
        root_child1_child1.setHeight(10f);
        root_child1.addChildAt(root_child1_child1, 1);

        YogaNode root_child1_child2 = new YogaNode(config);
        root_child1_child2.setWidth(25f);
        root_child1_child2.setHeight(20f);
        root_child1.addChildAt(root_child1_child2, 2);

        YogaNode root_child1_child3 = new YogaNode(config);
        root_child1_child3.setAlignSelf(YogaAlign.BASELINE);
        root_child1_child3.setWidth(25f);
        root_child1_child3.setHeight(10f);
        root_child1.addChildAt(root_child1_child3, 3);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(60f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child1.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child2.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child2.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child3.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child3.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child3.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child3.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(60f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(25f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child1.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child1.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child1.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child1.getLayoutHeight(), 0.0f);

        assertEquals(25f, root_child1_child2.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child2.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child2.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child3.getLayoutX(), 0.0f);
        assertEquals(20f, root_child1_child3.getLayoutY(), 0.0f);
        assertEquals(25f, root_child1_child3.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child3.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_child_top() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setPosition(YogaEdge.TOP, 10f);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(20f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(50f);
        root_child1_child0.setHeight(10f);
        root_child1.addChildAt(root_child1_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_child_top2() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setPosition(YogaEdge.TOP, 5f);
        root_child1.setWidth(50f);
        root_child1.setHeight(20f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(50f);
        root_child1_child0.setHeight(10f);
        root_child1.addChildAt(root_child1_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(45f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(45f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_double_nested_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setWidth(50f);
        root_child0_child0.setHeight(20f);
        root_child0.addChildAt(root_child0_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(20f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(50f);
        root_child1_child0.setHeight(15f);
        root_child1.addChildAt(root_child1_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(5f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(15f, root_child1_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(5f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(15f, root_child1_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(20f);
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
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_child_margin() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setMargin(YogaEdge.LEFT, 5f);
        root_child0.setMargin(YogaEdge.TOP, 5f);
        root_child0.setMargin(YogaEdge.RIGHT, 5f);
        root_child0.setMargin(YogaEdge.BOTTOM, 5f);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(20f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setMargin(YogaEdge.LEFT, 1f);
        root_child1_child0.setMargin(YogaEdge.TOP, 1f);
        root_child1_child0.setMargin(YogaEdge.RIGHT, 1f);
        root_child1_child0.setMargin(YogaEdge.BOTTOM, 1f);
        root_child1_child0.setWidth(50f);
        root_child1_child0.setHeight(10f);
        root_child1.addChildAt(root_child1_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(5f, root_child0.getLayoutX(), 0.0f);
        assertEquals(5f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(60f, root_child1.getLayoutX(), 0.0f);
        assertEquals(44f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(1f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(1f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(45f, root_child0.getLayoutX(), 0.0f);
        assertEquals(5f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(-10f, root_child1.getLayoutX(), 0.0f);
        assertEquals(44f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(-1f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(1f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_child_padding() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setPadding(YogaEdge.LEFT, 5);
        root.setPadding(YogaEdge.TOP, 5);
        root.setPadding(YogaEdge.RIGHT, 5);
        root.setPadding(YogaEdge.BOTTOM, 5);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setPadding(YogaEdge.LEFT, 5);
        root_child1.setPadding(YogaEdge.TOP, 5);
        root_child1.setPadding(YogaEdge.RIGHT, 5);
        root_child1.setPadding(YogaEdge.BOTTOM, 5);
        root_child1.setWidth(50f);
        root_child1.setHeight(20f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(50f);
        root_child1_child0.setHeight(10f);
        root_child1.addChildAt(root_child1_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(5f, root_child0.getLayoutX(), 0.0f);
        assertEquals(5f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(55f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(5f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(5f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(45f, root_child0.getLayoutX(), 0.0f);
        assertEquals(5f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(-5f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(-5f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(5f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_multiline() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWrap(YogaWrap.WRAP);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(20f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(50f);
        root_child1_child0.setHeight(10f);
        root_child1.addChildAt(root_child1_child0, 0);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setWidth(50f);
        root_child2.setHeight(20f);
        root.addChildAt(root_child2, 2);

        YogaNode root_child2_child0 = new YogaNode(config);
        root_child2_child0.setWidth(50f);
        root_child2_child0.setHeight(10f);
        root_child2.addChildAt(root_child2_child0, 0);

        YogaNode root_child3 = new YogaNode(config);
        root_child3.setWidth(50f);
        root_child3.setHeight(50f);
        root.addChildAt(root_child3, 3);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(100f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child2.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child3.getLayoutX(), 0.0f);
        assertEquals(60f, root_child3.getLayoutY(), 0.0f);
        assertEquals(50f, root_child3.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child3.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child2.getLayoutX(), 0.0f);
        assertEquals(100f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child2.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child3.getLayoutX(), 0.0f);
        assertEquals(60f, root_child3.getLayoutY(), 0.0f);
        assertEquals(50f, root_child3.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child3.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_multiline_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWrap(YogaWrap.WRAP);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(30f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(20f);
        root_child1_child0.setHeight(20f);
        root_child1.addChildAt(root_child1_child0, 0);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setWidth(40f);
        root_child2.setHeight(70f);
        root.addChildAt(root_child2, 2);

        YogaNode root_child2_child0 = new YogaNode(config);
        root_child2_child0.setWidth(10f);
        root_child2_child0.setHeight(10f);
        root_child2.addChildAt(root_child2_child0, 0);

        YogaNode root_child3 = new YogaNode(config);
        root_child3.setWidth(50f);
        root_child3.setHeight(20f);
        root.addChildAt(root_child3, 3);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(40f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(70f, root_child2.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child3.getLayoutX(), 0.0f);
        assertEquals(70f, root_child3.getLayoutY(), 0.0f);
        assertEquals(50f, root_child3.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child3.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(70f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(40f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(70f, root_child2.getLayoutHeight(), 0.0f);

        assertEquals(30f, root_child2_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child3.getLayoutX(), 0.0f);
        assertEquals(70f, root_child3.getLayoutY(), 0.0f);
        assertEquals(50f, root_child3.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child3.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_multiline_column2() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWrap(YogaWrap.WRAP);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(30f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(20f);
        root_child1_child0.setHeight(20f);
        root_child1.addChildAt(root_child1_child0, 0);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setWidth(40f);
        root_child2.setHeight(70f);
        root.addChildAt(root_child2, 2);

        YogaNode root_child2_child0 = new YogaNode(config);
        root_child2_child0.setWidth(10f);
        root_child2_child0.setHeight(10f);
        root_child2.addChildAt(root_child2_child0, 0);

        YogaNode root_child3 = new YogaNode(config);
        root_child3.setWidth(50f);
        root_child3.setHeight(20f);
        root.addChildAt(root_child3, 3);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(40f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(70f, root_child2.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child3.getLayoutX(), 0.0f);
        assertEquals(70f, root_child3.getLayoutY(), 0.0f);
        assertEquals(50f, root_child3.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child3.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(70f, root_child1.getLayoutX(), 0.0f);
        assertEquals(50f, root_child1.getLayoutY(), 0.0f);
        assertEquals(30f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child2.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2.getLayoutY(), 0.0f);
        assertEquals(40f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(70f, root_child2.getLayoutHeight(), 0.0f);

        assertEquals(30f, root_child2_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2_child0.getLayoutY(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child3.getLayoutX(), 0.0f);
        assertEquals(70f, root_child3.getLayoutY(), 0.0f);
        assertEquals(50f, root_child3.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child3.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_baseline_multiline_row_and_column() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setAlignItems(YogaAlign.BASELINE);
        root.setWrap(YogaWrap.WRAP);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setWidth(50f);
        root_child1.setHeight(50f);
        root.addChildAt(root_child1, 1);

        YogaNode root_child1_child0 = new YogaNode(config);
        root_child1_child0.setWidth(50f);
        root_child1_child0.setHeight(10f);
        root_child1.addChildAt(root_child1_child0, 0);

        YogaNode root_child2 = new YogaNode(config);
        root_child2.setWidth(50f);
        root_child2.setHeight(20f);
        root.addChildAt(root_child2, 2);

        YogaNode root_child2_child0 = new YogaNode(config);
        root_child2_child0.setWidth(50f);
        root_child2_child0.setHeight(10f);
        root_child2.addChildAt(root_child2_child0, 0);

        YogaNode root_child3 = new YogaNode(config);
        root_child3.setWidth(50f);
        root_child3.setHeight(20f);
        root.addChildAt(root_child3, 3);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2.getLayoutX(), 0.0f);
        assertEquals(100f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child2.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child3.getLayoutX(), 0.0f);
        assertEquals(90f, root_child3.getLayoutY(), 0.0f);
        assertEquals(50f, root_child3.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child3.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1.getLayoutX(), 0.0f);
        assertEquals(40f, root_child1.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1.getLayoutWidth(), 0.0f);
        assertEquals(50f, root_child1.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child1_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child1_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child1_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child1_child0.getLayoutHeight(), 0.0f);

        assertEquals(50f, root_child2.getLayoutX(), 0.0f);
        assertEquals(100f, root_child2.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child2.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child2_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child2_child0.getLayoutY(), 0.0f);
        assertEquals(50f, root_child2_child0.getLayoutWidth(), 0.0f);
        assertEquals(10f, root_child2_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child3.getLayoutX(), 0.0f);
        assertEquals(90f, root_child3.getLayoutY(), 0.0f);
        assertEquals(50f, root_child3.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child3.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_items_center_child_with_margin_bigger_than_parent() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(52f);
        root.setHeight(52f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setAlignItems(YogaAlign.CENTER);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setMargin(YogaEdge.LEFT, 10f);
        root_child0_child0.setMargin(YogaEdge.RIGHT, 10f);
        root_child0_child0.setWidth(52f);
        root_child0_child0.setHeight(52f);
        root_child0.addChildAt(root_child0_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(52f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(52f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(52f, root_child0_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(52f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(52f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(52f, root_child0_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_items_flex_end_child_with_margin_bigger_than_parent() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(52f);
        root.setHeight(52f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setAlignItems(YogaAlign.FLEX_END);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setMargin(YogaEdge.LEFT, 10f);
        root_child0_child0.setMargin(YogaEdge.RIGHT, 10f);
        root_child0_child0.setWidth(52f);
        root_child0_child0.setHeight(52f);
        root_child0.addChildAt(root_child0_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(52f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(52f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(52f, root_child0_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(52f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(10f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(52f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(52f, root_child0_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_items_center_child_without_margin_bigger_than_parent() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(52f);
        root.setHeight(52f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setAlignItems(YogaAlign.CENTER);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setWidth(72f);
        root_child0_child0.setHeight(72f);
        root_child0.addChildAt(root_child0_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_items_flex_end_child_without_margin_bigger_than_parent() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setAlignItems(YogaAlign.CENTER);
        root.setWidth(52f);
        root.setHeight(52f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setAlignItems(YogaAlign.FLEX_END);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setWidth(72f);
        root_child0_child0.setHeight(72f);
        root_child0.addChildAt(root_child0_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(0f, root.getLayoutY(), 0.0f);
        assertEquals(52f, root.getLayoutWidth(), 0.0f);
        assertEquals(52f, root.getLayoutHeight(), 0.0f);

        assertEquals(-10f, root_child0.getLayoutX(), 0.0f);
        assertEquals(-10f, root_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(72f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(72f, root_child0_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_center_should_size_based_on_content() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.CENTER);
        root.setMargin(YogaEdge.TOP, 20f);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setJustifyContent(YogaJustify.CENTER);
        root_child0.setFlexShrink(1f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setFlexGrow(1f);
        root_child0_child0.setFlexShrink(1f);
        root_child0.addChildAt(root_child0_child0, 0);

        YogaNode root_child0_child0_child0 = new YogaNode(config);
        root_child0_child0_child0.setWidth(20f);
        root_child0_child0_child0.setHeight(20f);
        root_child0_child0.addChildAt(root_child0_child0_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(20f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(40f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child0_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(20f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(40f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child0_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0_child0.getLayoutHeight(), 0.0f);
    }

    @Test
    public void test_align_strech_should_size_based_on_parent() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setMargin(YogaEdge.TOP, 20f);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setJustifyContent(YogaJustify.CENTER);
        root_child0.setFlexShrink(1f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child0_child0 = new YogaNode(config);
        root_child0_child0.setFlexGrow(1f);
        root_child0_child0.setFlexShrink(1f);
        root_child0.addChildAt(root_child0_child0, 0);

        YogaNode root_child0_child0_child0 = new YogaNode(config);
        root_child0_child0_child0.setWidth(20f);
        root_child0_child0_child0.setHeight(20f);
        root_child0_child0.addChildAt(root_child0_child0_child0, 0);
        root.setDirection(YogaDirection.LTR);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(20f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child0_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0_child0.getLayoutHeight(), 0.0f);

        root.setDirection(YogaDirection.RTL);
        root.calculateLayout(YogaConstants.UNDEFINED, YogaConstants.UNDEFINED);

        assertEquals(0f, root.getLayoutX(), 0.0f);
        assertEquals(20f, root.getLayoutY(), 0.0f);
        assertEquals(100f, root.getLayoutWidth(), 0.0f);
        assertEquals(100f, root.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0.getLayoutHeight(), 0.0f);

        assertEquals(0f, root_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0.getLayoutY(), 0.0f);
        assertEquals(100f, root_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0.getLayoutHeight(), 0.0f);

        assertEquals(80f, root_child0_child0_child0.getLayoutX(), 0.0f);
        assertEquals(0f, root_child0_child0_child0.getLayoutY(), 0.0f);
        assertEquals(20f, root_child0_child0_child0.getLayoutWidth(), 0.0f);
        assertEquals(20f, root_child0_child0_child0.getLayoutHeight(), 0.0f);
    }

}
