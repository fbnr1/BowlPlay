package org;

import java.util.ArrayList;

public interface IFScoreCalculator {
  int calculateScoreUntilFrame(int frameIndex, ArrayList<Frame> frames);
}

