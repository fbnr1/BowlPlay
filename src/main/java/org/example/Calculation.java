package org.example;

public interface Calculation {
  int pinsCurrentThrow = 0;
  int pinsNextThrow = 0;
  int pinsNextNextThrow = 0;

  int calculation(int currentScore);
}
