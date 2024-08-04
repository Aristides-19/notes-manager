package com.cavenaire.notesmanager.view.utils;

import com.formdev.flatlaf.extras.FlatSVGIcon;

import javax.swing.JLabel;

/**
 * Import an SVG Vector to a JLabel Icon. It assures no quality loss unlike JPG.
 * It is intended to be used for static icons, otherwise you must use FlatSVGIcon directly.
 */
public class SVGIcon extends JLabel {

    private final FlatSVGIcon svgIcon;

    public SVGIcon(String pathImage, int width, int height) {
        svgIcon = new FlatSVGIcon(pathImage, width, height);
        setIcon(svgIcon);
    }
}
