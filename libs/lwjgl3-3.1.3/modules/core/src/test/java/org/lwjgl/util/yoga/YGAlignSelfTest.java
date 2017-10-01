/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.util.yoga;

import org.testng.annotations.*;

import static org.lwjgl.util.yoga.YogaNode.*;
import static org.testng.Assert.*;

public class YGAlignSelfTest {
    @Test
    public void test_align_self_center() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setAlignSelf(YogaAlign.CENTER);
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
    public void test_align_self_flex_end() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setAlignSelf(YogaAlign.FLEX_END);
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
    public void test_align_self_flex_start() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setAlignSelf(YogaAlign.FLEX_START);
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
    public void test_align_self_flex_end_override_flex_start() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setAlignItems(YogaAlign.FLEX_START);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setAlignSelf(YogaAlign.FLEX_END);
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
    public void test_align_self_baseline() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setFlexDirection(YogaFlexDirection.ROW);
        root.setWidth(100f);
        root.setHeight(100f);

        YogaNode root_child0 = new YogaNode(config);
        root_child0.setAlignSelf(YogaAlign.BASELINE);
        root_child0.setWidth(50f);
        root_child0.setHeight(50f);
        root.addChildAt(root_child0, 0);

        YogaNode root_child1 = new YogaNode(config);
        root_child1.setAlignSelf(YogaAlign.BASELINE);
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

}
