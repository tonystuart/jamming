// Copyright 2015 Anthony F. Stuart - All rights reserved.
//
// This program and the accompanying materials are made available
// under the terms of the GNU General Public License. For other license
// options please contact the copyright owner.
//
// This program is made available on an "as is" basis, without
// warranties or conditions of any kind, either express or implied.

package com.example.afs.jamming;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public abstract class RgbColorMap extends BaseColorMap {

  private Map<Color, Composable> colorMap = new HashMap<>();

  public void add(Color color, Composable composable) {
    colorMap.put(color, composable);
  }

  @Override
  public Entry<? extends Color, Composable> findClosestEntry(int rgb) {
    int r1 = Color.getRed(rgb);
    int g1 = Color.getGreen(rgb);
    int b1 = Color.getBlue(rgb);
    int closestDistance = 0;
    Entry<Color, Composable> closestEntry = null;
    for (Entry<Color, Composable> mapEntry : colorMap.entrySet()) {
      Color mapColor = mapEntry.getKey();
      int r2 = mapColor.getRed();
      int g2 = mapColor.getGreen();
      int b2 = mapColor.getBlue();
      int distance = (int) Math.sqrt(Math.pow(r2 - r1, 2) + Math.pow(g2 - g1, 2) + Math.pow(b2 - b1, 2));
      if (closestEntry == null || distance < closestDistance) {
        closestEntry = mapEntry;
        closestDistance = distance;
      }
    }
    return closestEntry;
  }
}
