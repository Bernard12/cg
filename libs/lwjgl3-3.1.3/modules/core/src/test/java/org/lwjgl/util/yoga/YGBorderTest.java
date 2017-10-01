/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.util.yoga;

import org.testng.annotations.*;

import static org.lwjgl.util.yoga.YogaNode.*;
import static org.testng.Assert.*;

public class YGBorderTest {
    @Test
    public void test_border_no_size() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setBorder(YogaEdge.LEFT, 10f);
        root.setBorder(YogaEdge.TOP, 10f);
        root.setBorder(YogaEdge.RIGHT, 10f);
        root.setBorder(YogaEdge.BOTTOM, 10f);
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
    public void test_border_container_match_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setBorder(YogaEdge.LEFT, 10f);
        root.setBorder(YogaEdge.TOP, 10f);
        root.setBorder(YogaEdge.RIGHT, 10f);
        root.setBorder(YogaEdge.BOTTOM, 10f);

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
    public void test_border_flex_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setBorder(YogaEdge.LEFT, 10f);
        root.setBorder(YogaEdge.TOP, 10f);
        root.setBorder(YogaEdge.RIGHT, 10f);
        root.setBorder(YogaEdge.BOTTOM, 10f);
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
    public void test_border_stretch_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setBorder(YogaEdge.LEFT, 10f);
        root.setBorder(YogaEdge.TOP, 10f);
        root.setBorder(YogaEdge.RIGHT, 10f);
        root.setBorder(YogaEdge.BOTTOM, 10f);
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
    public void test_border_center_child() {
        YogaConfig config = new YogaConfig();

        YogaNode root = new YogaNode(config);
        root.setJustifyContent(YogaJustify.CENTER);
        root.setAlignItems(YogaAlign.CENTER);
        root.setBorder(YogaEdge.START, 10f);
        root.setBorder(YogaEdge.END, 20f);
        root.setBorder(YogaEdge.BOTTOM, 20f);
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

}
